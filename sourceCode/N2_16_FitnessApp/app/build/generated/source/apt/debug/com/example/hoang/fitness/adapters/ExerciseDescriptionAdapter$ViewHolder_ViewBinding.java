// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ExerciseDescriptionAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ExerciseDescriptionAdapter.ViewHolder target;

  @UiThread
  public ExerciseDescriptionAdapter$ViewHolder_ViewBinding(
      ExerciseDescriptionAdapter.ViewHolder target, View source) {
    this.target = target;

    target.mSTT = Utils.findRequiredViewAsType(source, R.id.tv_stt, "field 'mSTT'", TextView.class);
    target.mDescription = Utils.findRequiredViewAsType(source, R.id.tv_exercise_item_description, "field 'mDescription'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ExerciseDescriptionAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSTT = null;
    target.mDescription = null;
  }
}
