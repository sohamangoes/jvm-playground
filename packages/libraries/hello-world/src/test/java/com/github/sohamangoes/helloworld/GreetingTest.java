package com.github.sohamangoes.helloworld;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GreetingTest {

  private final Greeting greeting = new Greeting();

  @Test
  void shouldReturnHelloWorld() {
    var hello = greeting.sayHello();
    assertThat(hello).isEqualTo("Hello World!");
  }

  @Test
  void shouldSayHelloToName() {
    var hello = greeting.sayHello("Bruce Wayne");
    assertThat(hello).isEqualTo("Hello Bruce Wayne!");
  }
}
