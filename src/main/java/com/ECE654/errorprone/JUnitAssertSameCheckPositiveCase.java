/*
 * Copyright 2016 The Error Prone Authors.
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

/**
 * Positive test cases for {@link JUnitAssertSameCheck} check.
 *
 * @author bhagwani@google.com (Sumit Bhagwani)
 */
public class JUnitAssertSameCheckPositiveCase {

  public void test(Object obj) {
    // BUG: Diagnostic contains: An object is tested for reference equality to itself using JUnit
    org.junit.Assert.assertSame(obj, obj);

    // BUG: Diagnostic contains: An object is tested for reference equality to itself using JUnit
    org.junit.Assert.assertSame("message", obj, obj);

    // BUG: Diagnostic contains: An object is tested for reference equality to itself using JUnit
    junit.framework.Assert.assertSame(obj, obj);

    // BUG: Diagnostic contains: An object is tested for reference equality to itself using JUnit
    junit.framework.Assert.assertSame("message", obj, obj);
  }
}
