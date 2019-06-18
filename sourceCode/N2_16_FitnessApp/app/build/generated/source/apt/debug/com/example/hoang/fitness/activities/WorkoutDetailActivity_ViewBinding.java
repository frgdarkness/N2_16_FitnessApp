// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WorkoutDetailActivity_ViewBinding implements Unbinder {
  private WorkoutDetailActivity target;

  @UiThread
  public WorkoutDetailActivity_ViewBinding(WorkoutDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WorkoutDetailActivity_ViewBinding(WorkoutDetailActivity target, View source) {
    this.target = target;

    target.mImage = Utils.findRequiredViewAsType(source, R.id.img_workout, "field 'mImage'", ImageView.class);
    target.mName = Utils.findRequiredViewAsType(source, R.id.tv_workout_name, "field 'mName'", TextView.class);
    target.mDetail = Utils.findRequiredViewAsType(source, R.id.tv_workout_detail, "field 'mDetail'", TextView.class);
    target.mDes = Utils.findRequiredViewAsType(source, R.id.tv_workout_description, "field 'mDes'", TextView.class);
    target.mCount = Utils.findRequiredViewAsType(source, R.id.tv_workout_exercises_count, "field 'mCount'", TextView.class);
    target.mExercises = Utils.findRequiredViewAsType(source, R.id.rcv_exercise, "field 'mExercises'", RecyclerView.class);
    target.mStart = Utils.findRequiredViewAsType(source, R.id.btn_start_workout, "field 'mStart'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WorkoutDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImage = null;
    target.mName = null;
    target.mDetail = null;
    target.mDes = null;
    target.mCount = null;
    target.mExercises = null;
    target.mStart = null;
  }
}
