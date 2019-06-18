// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ExerciseAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ExerciseAdapter.ViewHolder target;

  @UiThread
  public ExerciseAdapter$ViewHolder_ViewBinding(ExerciseAdapter.ViewHolder target, View source) {
    this.target = target;

    target.mImage = Utils.findRequiredViewAsType(source, R.id.img_item_exercise, "field 'mImage'", ImageView.class);
    target.mName = Utils.findRequiredViewAsType(source, R.id.tv_name_item_exercise, "field 'mName'", TextView.class);
    target.mLayout = Utils.findRequiredViewAsType(source, R.id.rl_item_exercise, "field 'mLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ExerciseAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImage = null;
    target.mName = null;
    target.mLayout = null;
  }
}
