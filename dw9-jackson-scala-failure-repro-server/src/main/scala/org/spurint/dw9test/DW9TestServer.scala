package org.spurint.dw9test

import io.dropwizard.Application
import io.dropwizard.setup.{Bootstrap, Environment}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import io.dropwizard.Bundle

class ScalaBundle extends Bundle {
  override def initialize(bootstrap: Bootstrap[_]): Unit = {
    bootstrap.getObjectMapper.registerModule(DefaultScalaModule)
  }

  override def run(environment: Environment): Unit = ()
}

class DW9TestConfig extends io.dropwizard.Configuration

object DW9TestService extends App {
  new DW9TestService().run(args: _*)
}

class DW9TestService extends Application[DW9TestConfig] {
  override def getName: String = "dw9test"

  override def initialize(bootstrap: Bootstrap[DW9TestConfig]): Unit = {
    bootstrap.addBundle(new ScalaBundle)
  }

  override def run(config: DW9TestConfig, environment: Environment): Unit = ()
}
