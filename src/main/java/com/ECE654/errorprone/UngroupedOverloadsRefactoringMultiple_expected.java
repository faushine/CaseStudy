/*
 * Copyright 2017 The Error Prone Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ECE654.errorprone;

/** @author hanuszczak@google.com (Łukasz Hanuszczak) */
class UngroupedOverloadsRefactoringMultiple {

  public void foo() {}

  public void foo(int x) {}

  public void foo(int x, int y) {}

  public void foo(int x, int y, int z) {}

  private static class foo {}

  public void bar() {}

  public static final String BAZ = "baz";

  public void quux() {}

  public void quux(int x) {}

  public void quux(int x, int y) {}

  public void quux(int x, int y, int z) {}

  public static final int X = 0;
  public static final int Y = 1;

  private int quux;

  public void norf() {}

  public void thud() {}
}
