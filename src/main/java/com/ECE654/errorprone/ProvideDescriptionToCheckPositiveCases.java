/*
 * Copyright 2019 The Error Prone Authors.
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

import static com.ECE654.errorprone.ProvideDescriptionToCheckPositiveCases.MyStringSubject.myStrings;

import com.google.common.truth.CustomSubjectBuilder;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.StringSubject;
import com.google.common.truth.Subject;

/** @author cpovirk@google.com (Chris Povirk) */
public class ProvideDescriptionToCheckPositiveCases {
  static final class FooSubject extends Subject<FooSubject, Foo> {
    private final Foo actual;

    private FooSubject(FailureMetadata metadata, Foo actual) {
      super(metadata, actual);
      this.actual = actual;
    }

    void hasString(String expected) {
      // BUG: Diagnostic contains: check("string()").that(actual.string()).isEqualTo(expected)
      check().that(actual.string()).isEqualTo(expected);
    }

    void hasStringThisCheck(String expected) {
      // BUG: Diagnostic contains: this.check("string()").that(actual.string()).isEqualTo(
      this.check().that(actual.string()).isEqualTo(expected);
    }

    void hasStringWithMessage(String expected) {
      // BUG: Diagnostic contains:
      // check("string()").withMessage("abc").that(actual.string()).isEqualTo(expected)
      check().withMessage("abc").that(actual.string()).isEqualTo(expected);
    }

    void hasStringAbout(String expected) {
      // BUG: Diagnostic contains:
      // check("string()").about(myStrings()).that(actual.string()).isEqualTo(expected)
      check().about(myStrings()).that(actual.string()).isEqualTo(expected);
    }

    void hasStringWithMessageAbout(String expected) {
      // BUG: Diagnostic contains: check("string()")
      check().withMessage("abc").about(myStrings()).that(actual.string()).isEqualTo(expected);
    }

    void hasOtherFooInteger(int expected) {
      // BUG: Diagnostic contains:
      // check("otherFoo().integer()").that(actual.otherFoo().integer()).isEqualTo(expected)
      check().that(actual.otherFoo().integer()).isEqualTo(expected);
    }

    FooSubject hasOtherFooUsingFactory() {
      // BUG: Diagnostic contains:
      // check("otherFoo()").about(foos()).that(actual.otherFoo())
      return check().about(foos()).that(actual.otherFoo());
    }
  }

  static final class MyStringSubject extends StringSubject {
    private MyStringSubject(FailureMetadata metadata, String string) {
      super(metadata, string);
    }

    static Factory<StringSubject, String> myStrings() {
      return MyStringSubject::new;
    }
  }

  static final class FooCustomSubjectBuilder extends CustomSubjectBuilder {
    FooCustomSubjectBuilder(FailureMetadata metadata) {
      super(metadata);
    }

    FooSubject that(Foo actual) {
      return new FooSubject(metadata(), actual);
    }
  }

  static CustomSubjectBuilder.Factory<FooCustomSubjectBuilder> foos() {
    return FooCustomSubjectBuilder::new;
  }

  private static final class Foo {
    final String string;
    final int integer;

    Foo(String string, int integer) {
      this.string = string;
      this.integer = integer;
    }

    String string() {
      return string;
    }

    int integer() {
      return integer;
    }

    Foo otherFoo() {
      return this;
    }
  }
}
