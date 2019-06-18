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

public class CustomFragment_ViewBinding implements Unbinder {
  private CustomFragment target;

  @UiThread
  public CustomFragment_ViewBinding(CustomFragment target, View source) {
    this.target = target;

    target.mCustomWorkouts = Utils.findRequiredViewAsType(source, R.id.rcv_custom_workout, "field 'mCustomWorkouts'", RecyclerView.class);
    target.mAddCustomWorkouts = Utils.findRequiredViewAsType(source, R.id.btn_floating_custom_workout, "field 'mAddCustomWorkouts'", ImageView.class);
    target.mTapToStart = Utils.findRequiredViewAsType(source, R.id.tv_tap_to_start, "field 'mTapToStart'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CustomFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mCustomWorkouts = null;
    target.mAddCustomWorkouts = null;
    target.mTapToStart = null;
  }
}
