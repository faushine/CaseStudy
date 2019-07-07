/*
 * Copyright 2013 The Error Prone Authors.
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

/** @author scottjohnson@google.com (Scott Johnson) */
public class WrongParameterPackagePositiveCases {

  public void testParameter(WrongParameterPackageNegativeCases.Integer x) {}

  public void testParameter(Integer x, Integer y) {}

  public void testParameter2(java.lang.Integer x, Integer y) {}

  public void testParameter3(Integer x, Integer y) {}

  /** Test overrides */
  public static class Subclass extends WrongParameterPackagePositiveCases {

    // BUG: Diagnostic contains: public void
    // testParameter(com.ECE654.errorprone.WrongParameterPackageNegativeCases.Integer x) {}
    public void testParameter(Integer x) {}

    // BUG: Diagnostic contains: public void
    // testParameter(com.ECE654.errorprone.WrongParameterPackagePositiveCases.Integer x, com.ECE654.errorprone.WrongParameterPackagePositiveCases.Integer y) {}
    public void testParameter(WrongParameterPackageNegativeCases.Integer x, Integer y) {}

    // BUG: Diagnostic contains: public void testParameter2(java.lang.Integer x,
    // com.ECE654.errorprone.WrongParameterPackagePositiveCases.Integer y) {}
    public void testParameter2(WrongParameterPackageNegativeCases.Integer x, java.lang.Integer y) {}

    // BUG: Diagnostic contains: public void
    // testParameter3(com.ECE654.errorprone.WrongParameterPackagePositiveCases.Integer x, com.ECE654.errorprone.WrongParameterPackagePositiveCases.Integer y) {}
    public void testParameter3(java.lang.Integer x, java.lang.Integer y) {}

    /** Ambiguous Integer class */
    public static class Integer {}
  }

  /** Ambiguous Integer class */
  public static class Integer {}
}
