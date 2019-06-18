// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import com.google.android.youtube.player.YouTubePlayerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ExerciseDescriptionActivity_ViewBinding implements Unbinder {
  private ExerciseDescriptionActivity target;

  @UiThread
  public ExerciseDescriptionActivity_ViewBinding(ExerciseDescriptionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ExerciseDescriptionActivity_ViewBinding(ExerciseDescriptionActivity target, View source) {
    this.target = target;

    target.mName = Utils.findRequiredViewAsType(source, R.id.tv_exercise_name, "field 'mName'", TextView.class);
    target.mYoutube = Utils.findRequiredViewAsType(source, R.id.youtube_player, "field 'mYoutube'", YouTubePlayerView.class);
    target.mDescriptions = Utils.findRequiredViewAsType(source, R.id.rcv_exercise_description, "field 'mDescriptions'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ExerciseDescriptionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mName = null;
    target.mYoutube = null;
    target.mDescriptions = null;
  }
}
