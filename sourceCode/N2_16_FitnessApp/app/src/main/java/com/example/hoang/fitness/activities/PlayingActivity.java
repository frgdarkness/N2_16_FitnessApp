package com.example.hoang.fitness.activities;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hoang.fitness.R;
import com.example.hoang.fitness.models.Exercise;
import com.example.hoang.fitness.models.Workout;
import com.example.hoang.fitness.sound.SoundManager;
import com.example.hoang.fitness.utils.JsonUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import static com.example.hoang.fitness.notification.App.CHANNEL_1_ID;
import static com.example.hoang.fitness.notification.App.CHANNEL_2_ID;

public class PlayingActivity extends AppCompatActivity implements View.OnClickListener, Runnable {
    @BindView(R.id.tv_count_time)
    TextView mTotalTime;
    @BindView(R.id.gift_view)
    GifImageView mGiftView;
    @BindView(R.id.btn_exit)
    Button mExit;
    @BindView(R.id.btn_detail)
    Button mDetail;
    @BindView(R.id.btn_volume)
    Button mVolume;
    @BindView(R.id.tv_exercise_name)
    TextView mName;
    @BindView(R.id.tv_state)
    TextView mState;
    @BindView(R.id.tv_count_down_time)
    TextView mCountDownTime;
    @BindView(R.id.btn_previous)
    Button mPrevious;
    @BindView(R.id.btn_pause)
    Button mPause;
    @BindView(R.id.btn_play)
    Button mPlay;
    @BindView(R.id.btn_next)
    Button mNext;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    int totalTime = 0;
    int readyTime = 0;
    int spanTime = 0;
    int currentPos = 0;
    boolean isFinish = false;
    boolean isPlaying = true;
    Workout workout;
    List<Exercise> list;
    private int WORKOUT_ID;
    private String TARGET_NAME;
    Thread thread;
    SoundManager soundManager;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        ButterKnife.bind(this);
//        Notification ----------------------------------------------------------------------------------------------------
//        registerReceiver(broadcastReceiver, new IntentFilter("Exercise"));
        notificationManager = NotificationManagerCompat.from(this);
        mediaSession = new MediaSessionCompat(this, "tag");
    }

    @Override
    protected void onStart() {
        super.onStart();
        soundManager = new SoundManager(this);
        soundManager.setup();
        WORKOUT_ID = getIntent().getIntExtra("WORKOUT_ID", 0);
        TARGET_NAME = getIntent().getStringExtra("TARGET_NAME");
        workout = JsonUtil.getInstance().getWorkout(this, WORKOUT_ID);
        list = JsonUtil.getInstance().getListExercise(this, workout);
        updateValue();
        updateView();
        mExit.setOnClickListener(this::onClick);
        mDetail.setOnClickListener(this::onClick);
        mVolume.setOnClickListener(this::onClick);
        mPrevious.setOnClickListener(this::onClick);
        mPause.setOnClickListener(this::onClick);
        mPlay.setOnClickListener(this::onClick);
        mNext.setOnClickListener(this::onClick);
        thread = new Thread(this::run);
        thread.start();
    }

    private void updateView() {
        int countdowntime = (readyTime > 0 ? readyTime : spanTime);
        mCountDownTime.setText("00:" + (countdowntime < 10 ? "0" + countdowntime : countdowntime));
        mTotalTime.setText((totalTime / 60 < 10 ? "0" + totalTime / 60 : totalTime / 60) + ":" + (totalTime % 60 < 10 ? "0" + totalTime % 60 : totalTime % 60));
        if (readyTime > 0) {
            mState.setText("Get Ready");
        } else {
            if (currentPos == list.size() - 1) {
                mState.setText("Next up: Workout Complete!");
            } else {
                mState.setText("Next up: " + list.get(currentPos + 1).getName());
            }
        }
        if (readyTime == 0 && spanTime == 0) {   //next
            currentPos++;
            if (currentPos == list.size()) isFinish = true;
            else updateValue();
        }
    }

    public void updateValue() {
        readyTime = workout.getExercises().get(currentPos).getGetReady();
        spanTime = workout.getExercises().get(currentPos).getTimeSpan();
//        readyTime = 3;
//        spanTime = 5;
        GifDrawable gifFromAssets = null;
        try {
            gifFromAssets = new GifDrawable(getAssets(), "exercise_gif/" + list.get(currentPos).getGifPhone());
        } catch (IOException e) {
            e.printStackTrace();
        }
        mGiftView.setImageDrawable(gifFromAssets);
        mName.setText(list.get(currentPos).getName());
        changeProgress(progressBar, currentPos);
        if (currentPos == 0) {
            soundManager.isPlaying = true;
            soundManager.get_ready.start();
            soundManager.get_ready.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 500);
                    soundManager.nextStep.start();
                    soundManager.nextStep.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                }
                            }, 500);
                            initMedia();
                        }
                    });
                }
            });
            soundManager.isPlaying = false;
        } else {
            soundManager.isPlaying = true;
            soundManager.nextStep.start();
            soundManager.nextStep.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 500);
                    initMedia();
                }
            });
            soundManager.isPlaying = false;
        }
    }

    private int getProgressValue(int i) {
        return 10000 / list.size() * i;
    }

    private void changeProgress(ProgressBar progressBar, int i) {
        progressBar.setProgress(getProgressValue(i));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_exit:
                Intent intent1 = new Intent(PlayingActivity.this,MainActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.btn_detail:
                Intent intent = new Intent(PlayingActivity.this, ExerciseDescriptionActivity.class);
                intent.putExtra("EXERCISE_ID", list.get(currentPos).getId());
                PlayingActivity.this.startActivity(intent);
                break;
            case R.id.btn_volume:
                //TODO
                break;
            case R.id.btn_previous:
                if (currentPos > 0) {
                    currentPos--;
                    updateValue();
                }
                break;
            case R.id.btn_pause:
                isPlaying = false;
                mPlay.setVisibility(View.VISIBLE);
                mPause.setVisibility(View.GONE);
                break;
            case R.id.btn_play:
                isPlaying = true;
                mPause.setVisibility(View.VISIBLE);
                mPlay.setVisibility(View.GONE);
                break;
            case R.id.btn_next:
                if (currentPos < list.size() - 1) {
                    currentPos++;
                    updateValue();
                }
                break;
        }
    }


    /*------------------Start Notification----------------------------------------------------------------------------------------*/
    private MediaSessionCompat mediaSession;
    private NotificationManagerCompat notificationManager;
    private String titleNotification = "";
    private String messageNotification = "";

//    BroadcastReceiver broadcastReceiver =  new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//            System.out.println("\n\nCurPos " + currentPos + " ");
//            if(intent.getStringExtra("prev").equals("prev")) {
//                System.out.println("prev " + cnt++);
//                currentPos = intent.getIntExtra("currentPos", 0);
//                prevExercise();
//            }
//            else if(intent.getStringExtra("pause").equals("pause")) {
//                System.out.println("pause " + cnt++);
//                currentPos = intent.getIntExtra("currentPos", 0);
//                pauseExercise();
//            }
//            else if(intent.getStringExtra("next").equals("next")) {
//                currentPos = intent.getIntExtra("currentPos", 0);
//                System.out.println("next " + cnt++);
//                nextExercise();
//            }
//
////            Bundle b = intent.getExtras();
////
////            String message = b.getString("message");
////
////            Log.e("newmesage", "" + message);
//        }
//    };

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("\n\nCurPos " + currentPos + " ");
//        if(intent.getAction().equals("Exercise")) {
        System.out.println("\n\naaaaaaaaaaaaaaaaaaaaaaaa\n\n");

        String action = intent.getAction();

        switch(action) {
            case "prev":
                currentPos = intent.getIntExtra("prev", 0);
                readyTime = intent.getIntExtra("readyTime", 0);
                spanTime = intent.getIntExtra("spanTime",0);
                isFinish = intent.getIntExtra("isFinish", 0) == 1 ? true : false;
                isPlaying = intent.getIntExtra("isPlaying", 1) == 1? true : false;

                prevExercise();
                break;
            case "pause":
                currentPos = intent.getIntExtra("pause", 0);
                readyTime = intent.getIntExtra("readyTime", 0);
                spanTime = intent.getIntExtra("spanTime",0);
                isFinish = intent.getIntExtra("isFinish", 0) == 1 ? true : false;
                isPlaying = intent.getIntExtra("isPlaying", 1) == 1? true : false;
                pauseExercise();
                break;

            case "next":
                currentPos = intent.getIntExtra("next", 0);
                readyTime = intent.getIntExtra("readyTime", 0);
                spanTime = intent.getIntExtra("spanTime",0);
                isFinish = intent.getIntExtra("isFinish", 0) == 1 ? true : false;
                isPlaying = intent.getIntExtra("isPlaying", 1) == 1? true : false;
                nextExercise();
                break;

            default:
                System.out.println("\n\n\nDefault new intent on ");
                break;
        }

/*            if(intent.getStringExtra("prev").equals("prev")) {
                System.out.println("prev " + cnt++);
                currentPos = intent.getIntExtra("prev", 0);
                prevExercise();
            }
            else if(intent.getStringExtra("pause").equals("pause")) {
                System.out.println("pause " + cnt++);
                currentPos = intent.getIntExtra("pause", 0);
                pauseExercise();
            }
            else if(intent.getStringExtra("next").equals("next")) {
                currentPos = intent.getIntExtra("next", 0);
                System.out.println("next " + cnt++);
                nextExercise();
            }*/
//        }
    }

    public void nextExercise(){
        if (currentPos < list.size() - 1) {
            currentPos++;
            updateValue();
//            ----------------------------------------------------------------------------------------------------
            updateView();
        }
    }

    public void prevExercise(){
        if (currentPos > 0) {
            currentPos--;
//            ----------------------------------------------------------------------------------------------------
            updateView();
        }
    }

    public void pauseExercise(){
        isPlaying = false;
        mPlay.setVisibility(View.VISIBLE);
        mPause.setVisibility(View.GONE);
//            ----------------------------------------------------------------------------------------------------
        updateView();
    }


//    int totalTime = 0;
//    int readyTime = 0;
//    int spanTime = 0;
//    int currentPos = 0;
//    boolean isFinish = false;
//    boolean isPlaying = true;


    public void sendOnChannel1(){
        String title = titleNotification;
        String message = messageNotification;

        Intent activityIntent = new Intent(PlayingActivity.this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);


        Intent prev = new Intent(PlayingActivity.this, PlayingActivity.class);
        prev.setAction("prev");
//        Intent prev = new Intent("prev");
        prev.putExtra("currentPos", currentPos);
        prev.putExtra("prev", "prev");
        prev.putExtra("readyTime", readyTime);
        prev.putExtra("spanTime", spanTime);
        prev.putExtra("isFinish", isFinish == true ? 1: 0);
        prev.putExtra("isPlaying", isPlaying == true ? 1: 0);


        Intent pause = new Intent(PlayingActivity.this, PlayingActivity.class);
        pause.setAction("pause");
//        Intent pause = new Intent("pause");
        pause.putExtra("currentPos", currentPos);
        pause.putExtra("pause","pause");
        pause.putExtra("readyTime", readyTime);
        pause.putExtra("spanTime", spanTime);
        pause.putExtra("isFinish", isFinish == true ? 1: 0);
        pause.putExtra("isPlaying", isPlaying == true ? 1: 0);


        Intent next = new Intent(PlayingActivity.this, PlayingActivity.class);
        next.setAction("next");
//        Intent next = new Intent("next");
        next.putExtra("currentPos", currentPos);
        next.putExtra("next", "next");
        next.putExtra("readyTime", readyTime);
        next.putExtra("spanTime", spanTime);
        next.putExtra("isFinish", isFinish == true ? 1: 0);
        next.putExtra("isPlaying", isPlaying == true ? 1: 0);

        PendingIntent prevIntent = PendingIntent.getActivity(this, 0, prev, 0);
        PendingIntent pauseIntent = PendingIntent.getActivity(this, 0, pause, 0);
        PendingIntent nextIntent = PendingIntent.getActivity(this, 0, next, 0);



//        Lay gif tu bai tap hien tai
        InputStream bitmap = null;
        try {
            bitmap = getAssets().open("exercise_gif/" + list.get(currentPos).getGifPhone());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Bitmap picture = BitmapFactory.decodeStream(bitmap);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_training_right)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(picture)
                .addAction(R.drawable.ic_training_left, "Previous", prevIntent)
                .addAction(R.drawable.ic_training_play, "Pause", pauseIntent)
                .addAction(R.drawable.ic_training_right, "Next", nextIntent)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(picture)
                        .bigLargeIcon(null))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();

        notificationManager.notify(1, notification);
    }

    public void sendOnChannel2() {
        String title = titleNotification;
        String message = messageNotification;

//        Lay gif tu bai tap hien tai
        InputStream bitmap = null;
        try {
            bitmap = getAssets().open("exercise_gif/" + list.get(currentPos).getGifPhone());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Bitmap artwork = BitmapFactory.decodeStream(bitmap);

//        Bitmap artwork = BitmapFactory.decodeResource(getResources(), R.drawable.lotti);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(artwork)
//                .addAction(R.drawable.ic_training_suspend, "Dislike", null)
                .addAction(R.drawable.ic_training_left, "Previous", null)
                .addAction(R.drawable.ic_training_suspend, "Pause", null)
                .addAction(R.drawable.ic_training_right, "Next", null)
//                .addAction(R.drawable.ic_training_left, "Like", null)
                .setStyle(new android.support.v4.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(1, 2, 3)
                        .setMediaSession(mediaSession.getSessionToken()))
                .setSubText("Sub Text")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManager.notify(2, notification);
    }


    /**
     * lay ra ten cua bai tap
     * list.get(currentPos + 1).getName());
     * */

    /*------------------End Notification-----------------------------------------------------------------------------------------------------*/


    @Override
    public void run() {
        try {
            while (!isFinish) {
                totalTime++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (currentPos < list.size()) {
//                          set notification ------------------------------------------------------------------------------------------
                            updateView();
                            titleNotification = list.get(currentPos).getName();
                            sendOnChannel1();
                        }
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isPlaying) {
                    if (readyTime > 0) {
                        readyTime--;
                    } else {
                        spanTime--;
                    }
                    if (readyTime == 3 || spanTime == 3) {
                        soundManager.three.start();
                    } else if (readyTime == 2 || spanTime == 2) {
                        soundManager.two.start();
                    } else if (readyTime == 1 || spanTime == 1) {
                        soundManager.one.start();
                    } else if (readyTime > 0 || spanTime > 0) {
                        if (spanTime > 0) {
                            if (spanTime == workout.getExercises().get(currentPos).getTimeSpan() / 2) {
                                soundManager.halfwaythere.start();
                            } else if (readyTime == 0 && spanTime == workout.getExercises().get(currentPos).getTimeSpan()) {
                                soundManager.begin.start();
                            } else if (readyTime == 0 && spanTime == workout.getExercises().get(currentPos).getTimeSpan()-1) {
                                soundManager.ding.start();
                            } else if (readyTime == 0 && spanTime == workout.getExercises().get(currentPos).getTimeSpan()-2) {
                                initMedia();
                            }
                        }
                        if (!soundManager.isPlaying) soundManager.start(soundManager.countdown);
                    }
                }
            }
            soundManager.congratulations.start();
            changeProgress(progressBar, 10000);
            Intent intent = new Intent(PlayingActivity.this, FinishActivity.class);
            intent.putExtra("WORKOUT_ID", WORKOUT_ID);
            intent.putExtra("TARGET_NAME",TARGET_NAME);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }

    private void initMedia(){
        String sound = list.get(currentPos).getSound();
        sound = sound.substring(0, sound.indexOf("."));
        Resources resources = getResources();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getPackageName());
        stringBuilder.append(":raw/");
        stringBuilder.append(sound);
        int identifier = resources.getIdentifier(stringBuilder.toString(), null, null);
        mediaPlayer = MediaPlayer.create(this,identifier);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        });
    }

    private void releaseMedia(){
        if (mediaPlayer.isPlaying()){
             mediaPlayer.stop();
        }
        mediaPlayer.release();
    }

    @Override
    protected void onDestroy() {
        try {
            soundManager.releaseAll();
            if (mediaPlayer!=null) releaseMedia();
            Thread.currentThread().interrupt();
        } catch (Exception e){

        }

        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
    }
}
