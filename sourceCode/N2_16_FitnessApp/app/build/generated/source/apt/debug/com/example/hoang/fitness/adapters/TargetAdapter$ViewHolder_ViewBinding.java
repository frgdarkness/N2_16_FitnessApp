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

public class TargetAdapter$ViewHolder_ViewBinding implements Unbinder {
  private TargetAdapter.ViewHolder target;

  @UiThread
  public TargetAdapter$ViewHolder_ViewBinding(TargetAdapter.ViewHolder target, View source) {
    this.target = target;

    target.mName = Utils.findRequiredViewAsType(source, R.id.tv_name_target, "field 'mName'", TextView.class);
    target.mDetail1 = Utils.findRequiredViewAsType(source, R.id.tv_detail1_target, "field 'mDetail1'", TextView.class);
    target.mDetail2 = Utils.findRequiredViewAsType(source, R.id.tv_detail2_target, "field 'mDetail2'", TextView.class);
    target.mState = Utils.findRequiredViewAsType(source, R.id.tv_state, "field 'mState'", TextView.class);
    target.mLayout = Utils.findRequiredViewAsType(source, R.id.rl_item_custom_workout, "field 'mLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TargetAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mName = null;
    target.mDetail1 = null;
    target.mDetail2 = null;
    target.mState = null;
    target.mLayout = null;
  }
}
