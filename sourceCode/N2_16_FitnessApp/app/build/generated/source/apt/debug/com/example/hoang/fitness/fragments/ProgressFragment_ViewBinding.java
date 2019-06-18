// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.fragments;

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

public class ProgressFragment_ViewBinding implements Unbinder {
  private ProgressFragment target;

  @UiThread
  public ProgressFragment_ViewBinding(ProgressFragment target, View source) {
    this.target = target;

    target.mRlCalendar = Utils.findRequiredViewAsType(source, R.id.rl_calendar_bar, "field 'mRlCalendar'", RelativeLayout.class);
    target.mRlWeight = Utils.findRequiredViewAsType(source, R.id.rl_weight_bar, "field 'mRlWeight'", RelativeLayout.class);
    target.mRlTarget = Utils.findRequiredViewAsType(source, R.id.rl_target_bar, "field 'mRlTarget'", RelativeLayout.class);
    target.mTvCalendar = Utils.findRequiredViewAsType(source, R.id.tv_calandar, "field 'mTvCalendar'", TextView.class);
    target.mTvTarget = Utils.findRequiredViewAsType(source, R.id.tv_target, "field 'mTvTarget'", TextView.class);
    target.mTvWeight = Utils.findRequiredViewAsType(source, R.id.tv_weight, "field 'mTvWeight'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProgressFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRlCalendar = null;
    target.mRlWeight = null;
    target.mRlTarget = null;
    target.mTvCalendar = null;
    target.mTvTarget = null;
    target.mTvWeight = null;
  }
}
