package com.example.new_ergasia;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class SecondActivity_R1Directions {
  private SecondActivity_R1Directions() {
  }

  @NonNull
  public static NavDirections actionSecondFragmentToFirstFragment() {
    return new ActionOnlyNavDirections(R.id.action_SecondFragment_to_FirstFragment);
  }
}
