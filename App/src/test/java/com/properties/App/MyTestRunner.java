package com.properties.App;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MyTestRunner {
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(Datacontroller.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
    AppApplicationTests a=new AppApplicationTests();
    try {
		a.getByBotIntIdTest();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
