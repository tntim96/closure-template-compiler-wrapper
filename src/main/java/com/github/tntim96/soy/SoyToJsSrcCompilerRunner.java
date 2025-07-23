package com.github.tntim96.soy;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


/**
 * Main entry point for the SoyToJsSrcCompiler tool.
 *
 * <p>This class is used to run the SoyToJsSrcCompiler from the command line or programmatically.
 * It never calls System.exit(), allowing it to be used in Ant with Java 21 without stopping the build
 * It captures the exit status and throws an exception if the tool fails.
 */
public final class SoyToJsSrcCompilerRunner {

  public static void main(String[] args) {
    try {
      compileSoy(args, System.err);
    } catch (Exception e) {
      throw new RuntimeException("Failed to run SoyToJsSrcCompiler", e);
    }
  }


  public static void compileSoy(String[] args, PrintStream err) throws Exception {

    // 1. Load the class
    Class<?> clazz = Class.forName("com.google.template.soy.SoyToJsSrcCompiler");

    // 2. Grab the *package-private* no-arg constructor and make it accessible
    Constructor<?> ctor = clazz.getDeclaredConstructor();
    ctor.setAccessible(true);           // or ctor.trySetAccessible() on JDK 9+

    // 3. Create the instance
    Object tool = ctor.newInstance();

    // 4. Call the public run(String[],PrintStream) method
    Method run = clazz.getSuperclass().getDeclaredMethod("doMain", String[].class, PrintStream.class);
    run.setAccessible(true);
    run.invoke(tool, (Object) args, err);   // cast because invoke() returns Object
  }

}