// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import pl.droidsonroids.gif.GifImageView;

public class PlayingActivity_ViewBinding implements Unbinder {
  private PlayingActivity target;

  @UiThread
  public PlayingActivity_ViewBinding(PlayingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PlayingActivity_ViewBinding(PlayingActivity target, View source) {
    this.target = target;

    target.mTotalTime = Utils.findRequiredViewAsType(source, R.id.tv_count_time, "field 'mTotalTime'", TextView.class);
    target.mGiftView = Utils.findRequiredViewAsType(source, R.id.gift_view, "field 'mGiftView'", GifImageView.class);
    target.mExit = Utils.findRequiredViewAsType(source, R.id.btn_exit, "field 'mExit'", Button.class);
    target.mDetail = Utils.findRequiredViewAsType(source, R.id.btn_detail, "field 'mDetail'", Button.class);
    target.mVolume = Utils.findRequiredViewAsType(source, R.id.btn_volume, "field 'mVolume'", Button.class);
    target.mName = Utils.findRequiredViewAsType(source, R.id.tv_exercise_name, "field 'mName'", TextView.class);
    target.mState = Utils.findRequiredViewAsType(source, R.id.tv_state, "field 'mState'", TextView.class);
    target.mCountDownTime = Utils.findRequiredViewAsType(source, R.id.tv_count_down_time, "field 'mCountDownTime'", TextView.class);
    target.mPrevious = Utils.findRequiredViewAsType(source, R.id.btn_previous, "field 'mPrevious'", Button.class);
    target.mPause = Utils.findRequiredViewAsType(source, R.id.btn_pause, "field 'mPause'", Button.class);
    target.mPlay = Utils.findRequiredViewAsType(source, R.id.btn_play, "field 'mPlay'", Button.class);
    target.mNext = Utils.findRequiredViewAsType(source, R.id.btn_next, "field 'mNext'", Button.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlayingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTotalTime = null;
    target.mGiftView = null;
    target.mExit = null;
    target.mDetail = null;
    target.mVolume = null;
    target.mName = null;
    target.mState = null;
    target.mCountDownTime = null;
    target.mPrevious = null;
    target.mPause = null;
    target.mPlay = null;
    target.mNext = null;
    target.progressBar = null;
  }
}
