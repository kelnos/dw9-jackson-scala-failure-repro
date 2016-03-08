This project skeleton demonstrates an issue with `@JsonCreator` when
jackson-module-scala 2.6.x (up to and including 2.6.5) is used with
Dropwizard 0.9.x.

# Steps

Simply run:

```
mvn package
java -jar dw9-jackson-scala-failure-repro-server/target/dw9-jackson-scala-failure-repro-server-0.1.0-SNAPSHOT.jar server dw9-jackson-scala-failure-repro-server.yaml
```

Almost immediatey you should see printed:

```
dw9-jackson-scala-failure-repro-server.yaml has an error:
  * Failed to parse configuration; Could not find creator property with name 'duration' (in class io.dropwizard.util.Duration)
 at [Source: N/A; line: -1, column: -1]
```

... and the server will exit.

Removing the `bootstrap.addBundle(new ScalaBundle)` line from
`DW9TestService.scala` will allow the service to start properly.
