package net.codestory;

import java.io.PrintStream;
import java.util.Map;

import com.google.common.collect.ImmutableSortedMap;

public class FooBarQix {
  private Map<Character, String> keywords = ImmutableSortedMap.of('3', "Foo", '5', "Bar",
                                                                  '7', "Qix");

  public String from(int number) {
    StringBuilder builder = new StringBuilder();
    String numberAsString = String.valueOf(number);

    checkDivisors(number, builder);
    checkDigits(numberAsString, builder);

    if (isDivisibleOrDigits(builder)) {
      return builder.toString();
    }
    return numberAsString;
  }

  private boolean isDivisibleOrDigits(StringBuilder buffer) {
    return buffer.length() != 0;
  }

  private void checkDigits(String numberAsString, StringBuilder buffer) {
    for (char c : numberAsString.toCharArray()) {
      if (keywords.containsKey(c)) {
        buffer.append(keywords.get(c));
      }
    }
  }

  private void checkDivisors(int number, StringBuilder buffer) {
    for (Character key : keywords.keySet()) {
      if (isDivisible(number, Character.getNumericValue(key))) {
        buffer.append(keywords.get(key));
      }
    }
  }

  private boolean isDivisible(int number, int divisor) {
    return number % divisor == 0;
  }

  public void run(PrintStream printStream) {
    for (int i = 1; i <= 100; i++) {
      printStream.println(from(i));
    }
  }

}
