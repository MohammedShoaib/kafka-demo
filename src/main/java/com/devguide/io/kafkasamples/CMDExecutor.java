package com.devguide.io.kafkasamples;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * Author: akhil
 * Created on : 5/7/18
 */

@ShellComponent
public class CMDExecutor {

  @ShellMethod("Run the service")
  public void runOrder(@ShellOption String type) {

    switch (type) {
      case "boot" : runBootOrder(); break;
      case "notBoot": runNonBootOrder(); break;
      default: System.out.println("invalid server argument: web/order");
    }
  }

  private void runBootOrder() {
  }

  private void runNonBootOrder() {
  }
}
