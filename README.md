# Package Sync Demo

This Maven project demonstrates the conventional package‑to‑directory mapping in Java.

## Build

```bash
mvn package
```

## Run

You can run the compiled class directly:

```bash
mvn exec:java
```

Or, after packaging:

```bash
java -cp target/package-sync-demo-1.0-SNAPSHOT.jar com.google.template.soy.App
```

## Directory Structure

```
package-sync-demo/
├── pom.xml
└── src
    └── main
        └── java
            └── com
                └── example
                    └── app
                        └── App.java
```
