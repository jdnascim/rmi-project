# rmi-project

rmiregistry &

== Server ==

```javac -d build/classes/java/main src/run/Server.java src/dao/operations.java src/bean/user.java src/dao/read.java src/dao/utils.java src/dao/OperationsInterface.java src/dao/write.java```

``java -classpath build/classes/java/main/ run.Server```


== Client ==

```javac -d build/classes/java/main/ src/run/Client.java src/dao/operations.java src/dao/OperationsInterface.java src/bean/user.java src/dao/read.java src/dao/utils.java src/dao/write.java src/dao/Commands.java src/dao/CommandManager.java src/dao/ParsedCommand.java ```

```java -classpath build/classes/java/main/ run.Client```

