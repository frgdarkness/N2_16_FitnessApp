// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PickExerciseActivity_ViewBinding implements Unbinder {
  private PickExerciseActivity target;

  @UiThread
  public PickExerciseActivity_ViewBinding(PickExerciseActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PickExerciseActivity_ViewBinding(PickExerciseActivity target, View source) {
    this.target = target;

    target.mType = Utils.findRequiredViewAsType(source, R.id.tv_pick_exercise_type, "field 'mType'", TextView.class);
    target.mPickExercises = Utils.findRequiredViewAsType(source, R.id.rcv_pick_exercise, "field 'mPickExercises'", RecyclerView.class);
    target.mNextStep = Utils.findRequiredViewAsType(source, R.id.btn_nextstep, "field 'mNextStep'", Button.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PickExerciseActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mType = null;
    target.mPickExercises = null;
    target.mNextStep = null;
    target.mToolbar = null;
  }
}
