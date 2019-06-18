// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailTargetActivity_ViewBinding implements Unbinder {
  private DetailTargetActivity target;

  @UiThread
  public DetailTargetActivity_ViewBinding(DetailTargetActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailTargetActivity_ViewBinding(DetailTargetActivity target, View source) {
    this.target = target;

    target.mName = Utils.findRequiredViewAsType(source, R.id.tv_target_name, "field 'mName'", TextView.class);
    target.mTime = Utils.findRequiredViewAsType(source, R.id.tv_target_time, "field 'mTime'", TextView.class);
    target.mDay = Utils.findRequiredViewAsType(source, R.id.tv_day_number, "field 'mDay'", TextView.class);
    target.mMin = Utils.findRequiredViewAsType(source, R.id.tv_minute_number, "field 'mMin'", TextView.class);
    target.mCalo = Utils.findRequiredViewAsType(source, R.id.tv_calories_number, "field 'mCalo'", TextView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    target.mState = Utils.findRequiredViewAsType(source, R.id.tv_state, "field 'mState'", TextView.class);
    target.mSave = Utils.findRequiredViewAsType(source, R.id.rl_save_layout, "field 'mSave'", RelativeLayout.class);
    target.mHuy = Utils.findRequiredViewAsType(source, R.id.rl_huy_layout, "field 'mHuy'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailTargetActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mName = null;
    target.mTime = null;
    target.mDay = null;
    target.mMin = null;
    target.mCalo = null;
    target.progressBar = null;
    target.mState = null;
    target.mSave = null;
    target.mHuy = null;
  }
}
