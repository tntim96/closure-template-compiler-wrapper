# Closure Template Compiler Wrapper

[![Build Status](https://github.com/tntim96/closure-template-compiler-wrapper/workflows/Java-CI/badge.svg)](https://github.com/tntim96/closure-template-compiler-wrapper/actions?query=workflow%3A%22Java-CI%22)

This `SoyParseInfoGeneratorRunner` uses reflection to call `SoyParseInfoGenerator` to skip the `System.exit` call.
The same has been done with `SoyToJsSrcCompilerRunner` for `SoyToJsSrcCompiler` to skip the `System.exit` call.

In Java 17 it was possible to override the security manage to ignore the system exit call, but in Java 21 this is no longer possible.

All command line options are passed to the `SoyParseInfoGenerator` or `SoyToJsSrcCompiler` class.

References:
* https://github.com/google/closure-templates/blob/master/java/src/com/google/template/soy/SoyParseInfoGenerator.java
* https://github.com/google/closure-templates/blob/master/documentation/codelabs/helloworlds/helloworld_java.md#using-soyparseinfogenerator

### Update POM version
`mvn versions:set -DnewVersion=2.0.20`

### Release
`mvn -DperformRelease=true clean deploy`
