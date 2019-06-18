// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.adapters;

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

public class CustomWorkoutAdapter$ViewHolder_ViewBinding implements Unbinder {
  private CustomWorkoutAdapter.ViewHolder target;

  @UiThread
  public CustomWorkoutAdapter$ViewHolder_ViewBinding(CustomWorkoutAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.mName = Utils.findRequiredViewAsType(source, R.id.tv_name_item_custom_workout, "field 'mName'", TextView.class);
    target.mDetail = Utils.findRequiredViewAsType(source, R.id.tv_detail_custom_workout, "field 'mDetail'", TextView.class);
    target.mLayout = Utils.findRequiredViewAsType(source, R.id.rl_item_custom_workout, "field 'mLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CustomWorkoutAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mName = null;
    target.mDetail = null;
    target.mLayout = null;
  }
}
