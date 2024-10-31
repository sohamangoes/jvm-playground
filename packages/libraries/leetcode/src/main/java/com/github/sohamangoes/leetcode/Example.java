package com.github.sohamangoes.leetcode;

public class Example {

  public boolean isMagic(int n) {

    if (n == 0 || (n > 1 && n <= 9)) {
      return false;
    }

    if (n == 1) {
      return true;
    }

    return isMagic(sumOfDigits(n));
  }

  private int sumOfDigits(int n) {
    int sum = 0;
    while (n > 0) {
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }
}
