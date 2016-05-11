# concord-jvm

**Java client libraries for Concord**

## Building

This repository is organized as an sbt multiproject. The first project is
the concord client library and the second consists only of code generated
by the swift tool that the client library depends on. Before building you
must run the build_thrift script from the root of the concord project:
```
~/../concord/ $ ./configure.py --thrift
```

This will populate the rawapi directory with the necessary generated code.
Run sbt from the root of this project directory to compile and assemble into
two fat jars.
```
~/../concord/client/jvm/ $ sbt assemble
```

After running the ``assemble`` command any build projects will be located in
the ``target`` directory of their respecitve subprojects.
