package com.github.sohamangoes.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExampleTest {

  private final Example example = new Example();

  @Test
  void zeroIsNotMagic() {
    assertThat(example.isMagic(0)).isFalse();
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9})
  void twoThroughNineAreNotMagic(int n) {
    assertThat(example.isMagic(n)).isFalse();
  }

  @ParameterizedTest
  @ValueSource(ints = {10, 100, 1000, 10000})
  void multiplesOfTenAreMagicNumbers(int n) {
    assertThat(example.isMagic(n)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {22222, 334, 991, 5500, 5554})
  void isMagicNumber(int n) {
    assertThat(example.isMagic(n)).isTrue();
  }
}
