// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FinishActivity_ViewBinding implements Unbinder {
  private FinishActivity target;

  @UiThread
  public FinishActivity_ViewBinding(FinishActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FinishActivity_ViewBinding(FinishActivity target, View source) {
    this.target = target;

    target.mName = Utils.findRequiredViewAsType(source, R.id.tv_workout_name, "field 'mName'", TextView.class);
    target.mNum = Utils.findRequiredViewAsType(source, R.id.tv_exercise_number, "field 'mNum'", TextView.class);
    target.mMin = Utils.findRequiredViewAsType(source, R.id.tv_minute_number, "field 'mMin'", TextView.class);
    target.mCalo = Utils.findRequiredViewAsType(source, R.id.tv_calories_number, "field 'mCalo'", TextView.class);
    target.mSave = Utils.findRequiredViewAsType(source, R.id.rl_save_layout, "field 'mSave'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FinishActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mName = null;
    target.mNum = null;
    target.mMin = null;
    target.mCalo = null;
    target.mSave = null;
  }
}
