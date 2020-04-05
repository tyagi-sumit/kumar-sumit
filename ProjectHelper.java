package com.myStudy.main;

public class ProjectHelper
{

  public String truncateAInFirstTwoPositions(String str)
  {
    if (str.length() <= 2)
      return str.replaceAll("A", "");

    String firstTwoChars = str.substring(0, 2);
    String stringMinusFirstTwoChars = str.substring(2);

    return firstTwoChars.replaceAll("A", "") + stringMinusFirstTwoChars;
  }

  public boolean firstAndLastTwoCharTheSame(String str)
  {
    if (str.length() <= 1)
      return false;
    if (str.length() == 2)
      return true;

    String firstTwoChars = str.substring(0, 2);

    String lastTwoChars = str.substring(str.length() - 2);

    return firstTwoChars.equals(lastTwoChars);
  }
}
