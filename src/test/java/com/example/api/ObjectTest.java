package com.example.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

public class ObjectTest {

  @Data
  @AllArgsConstructor
  static class Sample {
    private int age;
    private String name;

    @Override
    public String toString() {
      return "age -> " + age + " name -> " + name;
    }
  }

  private Sample sample;
  private Sample sample_;

  @Test
  public void test() {
    this.sample = new Sample(12, String.valueOf("yamada"));
    set();
    System.out.println("1 main : " + sample.toString());
    System.out.println("1 sub : " + sample_.toString());
    this.sample = null;
    System.out.println("2 sub : " + sample_.toString());
    this.sample = new Sample(21, String.valueOf("suzuki"));
    System.out.println("3 main : " + sample.toString());
    System.out.println("3 sub : " + sample_.toString());
  }

  public void set() {
    this.sample_ = this.sample;
  }
}
