package com.ECE654.refactor;

public class Main {
  static class TheClass {
    public static int staticVar1 = 1;
    public static int theMethod() {
      return 1;
    }
  }

  static class TheSubclass extends TheClass {
    public static int staticVar1 = 2;
    public static int theMethod() {
      return 2;
    }
  }

  public static void main(String[] args) {
    TheClass instanceOfTheClass = new TheSubclass();
    System.out.println(instanceOfTheClass.theMethod());
    System.out.println(instanceOfTheClass.staticVar1);
  }
}