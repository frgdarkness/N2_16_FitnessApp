// Generated code from Butter Knife. Do not modify!
package com.example.hoang.fitness.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.hoang.fitness.R;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CalendarFragment_ViewBinding implements Unbinder {
  private CalendarFragment target;

  @UiThread
  public CalendarFragment_ViewBinding(CalendarFragment target, View source) {
    this.target = target;

    target.mWorkoutNum = Utils.findRequiredViewAsType(source, R.id.tv_workout_number, "field 'mWorkoutNum'", TextView.class);
    target.mMinutesNum = Utils.findRequiredViewAsType(source, R.id.tv_minute_number, "field 'mMinutesNum'", TextView.class);
    target.mCaloriesNum = Utils.findRequiredViewAsType(source, R.id.tv_calories_number, "field 'mCaloriesNum'", TextView.class);
    target.mCurStreakNum = Utils.findRequiredViewAsType(source, R.id.tv_curlink_number, "field 'mCurStreakNum'", TextView.class);
    target.mBestStreakNum = Utils.findRequiredViewAsType(source, R.id.tv_bestlink_number, "field 'mBestStreakNum'", TextView.class);
    target.mCalendar = Utils.findRequiredViewAsType(source, R.id.calendarView, "field 'mCalendar'", MaterialCalendarView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CalendarFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mWorkoutNum = null;
    target.mMinutesNum = null;
    target.mCaloriesNum = null;
    target.mCurStreakNum = null;
    target.mBestStreakNum = null;
    target.mCalendar = null;
  }
}
