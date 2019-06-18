// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PickExerciseAdapter$ViewHolder_ViewBinding implements Unbinder {
  private PickExerciseAdapter.ViewHolder target;

  @UiThread
  public PickExerciseAdapter$ViewHolder_ViewBinding(PickExerciseAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.mChoose = Utils.findRequiredViewAsType(source, R.id.img_choose_exercise, "field 'mChoose'", ImageView.class);
    target.mImage = Utils.findRequiredViewAsType(source, R.id.img_item_pick_exercise, "field 'mImage'", ImageView.class);
    target.mName = Utils.findRequiredViewAsType(source, R.id.tv_name_item_pick_exercise, "field 'mName'", TextView.class);
    target.mInfo = Utils.findRequiredViewAsType(source, R.id.btn_pick_exercise_info, "field 'mInfo'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PickExerciseAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mChoose = null;
    target.mImage = null;
    target.mName = null;
    target.mInfo = null;
  }
}
