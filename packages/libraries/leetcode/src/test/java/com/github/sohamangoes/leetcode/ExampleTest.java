package com.github.sohamangoes.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExampleTest {

  private final Example example = new Example();

  @Nested
  class MagicNumbersTest {

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

  @Nested
  class PrimeNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void zeroAndOneAreNotPrimes(int n) {
      assertThat(example.isPrime(n)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-12, -2})
    void negativeIntegersAreNotPrimes(int n) {
      assertThat(example.isPrime(n)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17})
    void isPrime(int n) {
      assertThat(example.isPrime(n)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15})
    void isNotPrime(int n) {
      assertThat(example.isPrime(n)).isFalse();
    }
  }
}
