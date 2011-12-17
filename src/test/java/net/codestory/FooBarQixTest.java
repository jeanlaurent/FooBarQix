package net.codestory;

import static org.fest.assertions.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class FooBarQixTest {
  private FooBarQix fbq;

  @Before
  public void setup() {
    fbq = new FooBarQix();
  }

  @Test
  public void givenOne_ShouldReturnOne() {
    assertThat(fbq.from(1)).isEqualTo("1");
  }

  @Test
  public void givenTwo_ShouldReturnTwo() {
    assertThat(fbq.from(2)).isEqualTo("2");
  }

  @Test
  public void givenThree_ShouldReturnFooFoo() {
    assertThat(fbq.from(3)).isEqualTo("FooFoo");
  }

  @Test
  public void givenFour_ShouldReturnFour() {
    assertThat(fbq.from(4)).isEqualTo("4");
  }

  @Test
  public void givenFive_ShouldReturnBarBar() {
    assertThat(fbq.from(5)).isEqualTo("BarBar");
  }

  @Test
  public void givenTen_ShouldReturnFoo() {
    assertThat(fbq.from(10)).isEqualTo("Bar");
  }

  @Test
  public void given15_ShouldReturnFooBar() {
    assertThat(fbq.from(15)).isEqualTo("FooBarBar");
  }

  @Test
  public void given53_ShouldReturnFooBar() {
    assertThat(fbq.from(53)).isEqualTo("BarFoo");
  }

  @Test
  public void given21_ShouldReturnFooQix() {
    assertThat(fbq.from(21)).isEqualTo("FooQix");
  }

  @Test
  public void given51_ShouldReturnFooBar() {
    assertThat(fbq.from(51)).isEqualTo("FooBar");
  }

  @Test
  public void given7_ShouldReturnQix() {
    assertThat(fbq.from(7)).isEqualTo("QixQix");
  }

  @Test
  public void given33_shouldReturnFooFooFoo() {
    assertThat(fbq.from(33)).isEqualTo("FooFooFoo");
  }

  @Test
  public void given35_shouldReturnFooFooFoo() {
    assertThat(fbq.from(35)).isEqualTo("BarQixFooBar");
  }

  @Test
  public void givenAFullFile_CheckAllValuesAreGood() throws IOException {
    String solution = Resources.toString(Resources.getResource("solution.txt"), Charsets.UTF_8);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    fbq.run(new PrintStream(baos));
    String result = baos.toString("UTF-8");
    assertThat(result).isEqualTo(solution);
  }

}
