// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WorkoutsFragment_ViewBinding implements Unbinder {
  private WorkoutsFragment target;

  @UiThread
  public WorkoutsFragment_ViewBinding(WorkoutsFragment target, View source) {
    this.target = target;

    target.mWorkOut = Utils.findRequiredViewAsType(source, R.id.rcv_workout, "field 'mWorkOut'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WorkoutsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mWorkOut = null;
  }
}
