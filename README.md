playn-artemis-quickstart
=========================

Quickstart for desktop and html playn artemis-odb based jam games.

=== When to use this ===

If you want to use artemis-odb with playn, this quickstart should
help you get things set up. Just look at the commits what was changed.

=== Library Versions ===

PlayN 1.8.5 and Artemis-ODB 0.6.5-SNAPSHOT
(Versions can be changed in /build.gradle)

=== License ===

This quickstart is based on the playn official hello world example, released 
under Apache License 2.0.

[playn-samples on code.google.com](https://code.google.com/p/playn-samples/)

=== Special note on Reflection ===

GWT lacks reflection so the build process creates a reflection cache. To use
```@Wire``` make sure your components, managers and systems are placed under
the premade component, manager and system packages.

=== Details ===

A quick summary of the steps required to include artemis in playn gwt builds:

Mygame.gwt.xml
* ```<inherits name='com.artemis.backends.artemis_backends_gwt' />```
* add ```<extend-configuration-property name="artemis.reflect.include" value="playn.sample.hello.core.manager" />``` for each package with components and systems (needed for ```@Wire```)

pom.xml
* artemis pom dependencies + source.
* 2.6.0 gwt pom dependency.
* Maven plugin tweaks (required for the reflection helper for artemis-odb)
```
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>gwt-maven-plugin</artifactId>
        <version>2.6.0</version>
          <configuration>
              <enableClosureCompiler>true</enableClosureCompiler>
              <disableClassMetadata>false</disableClassMetadata>
              <disableCastChecking>true</disableCastChecking>
          </configuration>
```

Check commits on this project for step by step instructions.