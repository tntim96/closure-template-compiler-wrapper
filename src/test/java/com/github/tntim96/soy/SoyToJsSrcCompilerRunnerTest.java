package com.github.tntim96.soy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class SoyToJsSrcCompilerRunnerTest {

  @Test
  public void shouldNotExitJvm() {
    try {
      SoyToJsSrcCompilerRunner.main(new String[]{});
      fail("Expected an exception to be thrown, but none was thrown.");
    } catch (Exception e) {
      System.out.println("e = " + e);
      assertEquals("com.google.template.soy.AbstractSoyCompiler$CommandLineError", e.getCause().getCause().getClass().getName());
    }
  }
}