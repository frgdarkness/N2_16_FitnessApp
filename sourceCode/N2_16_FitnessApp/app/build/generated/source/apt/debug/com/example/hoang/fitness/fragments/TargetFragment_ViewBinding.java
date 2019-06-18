// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TargetFragment_ViewBinding implements Unbinder {
  private TargetFragment target;

  @UiThread
  public TargetFragment_ViewBinding(TargetFragment target, View source) {
    this.target = target;

    target.mTargets = Utils.findRequiredViewAsType(source, R.id.rcv_target, "field 'mTargets'", RecyclerView.class);
    target.mAddTarget = Utils.findRequiredViewAsType(source, R.id.btn_floating_target, "field 'mAddTarget'", ImageView.class);
    target.mTapToStart = Utils.findRequiredViewAsType(source, R.id.tv_tap_to_start, "field 'mTapToStart'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TargetFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTargets = null;
    target.mAddTarget = null;
    target.mTapToStart = null;
  }
}
