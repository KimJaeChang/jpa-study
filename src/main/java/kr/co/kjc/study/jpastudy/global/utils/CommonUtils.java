package kr.co.kjc.study.jpastudy.global.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CommonUtils {

  public static String getCurrentClassName() {
    return Thread.currentThread().getStackTrace()[3].getClassName();
  }

  public static String getCurrentMethodName() {
    return Thread.currentThread().getStackTrace()[3].getMethodName();
  }

}
