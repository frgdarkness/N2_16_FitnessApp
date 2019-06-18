// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WorkoutAdapter$ViewHolder_ViewBinding implements Unbinder {
  private WorkoutAdapter.ViewHolder target;

  @UiThread
  public WorkoutAdapter$ViewHolder_ViewBinding(WorkoutAdapter.ViewHolder target, View source) {
    this.target = target;

    target.mName = Utils.findRequiredViewAsType(source, R.id.tv_workout_name, "field 'mName'", TextView.class);
    target.mDetail = Utils.findRequiredViewAsType(source, R.id.tv_workout_detail, "field 'mDetail'", TextView.class);
    target.mImage = Utils.findRequiredViewAsType(source, R.id.img_workout, "field 'mImage'", ImageView.class);
    target.mLayout = Utils.findRequiredViewAsType(source, R.id.fr_item_workout, "field 'mLayout'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WorkoutAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mName = null;
    target.mDetail = null;
    target.mImage = null;
    target.mLayout = null;
  }
}
