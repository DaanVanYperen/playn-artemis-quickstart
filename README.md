playn-artemis-quickstart
=========================

Quickstart for desktop and html playn artemis-odb based jam games.

=== When to use this ===

If you want to use artemis-odb with playn, this quickstart should
help you get things set up. Just look at the commits what was changed.

=== Library Versions ===

PlayN and Artemis-ODB 0.6.5-SNAPSHOT
(Versions can be changed in /build.gradle)

=== License ===

This quickstart is based on the playn official hello world example, released 
under Apache License 2.0.

[playn-samples on code.google.com](https://code.google.com/p/playn-samples/)

=== Special note on Reflection ===

GWT lacks reflection so the build process creates a reflection cache. To use
```@Wire``` make sure your components, managers and systems are placed under
the premade component, manager and system packages.

Artemis does not share libgdx's reflection cache, so if you get gwt reflection
related errors you might need to add classes to Libgdx's cache manually.
Artemis reflection cache errors are prefixed with artemis-odb.