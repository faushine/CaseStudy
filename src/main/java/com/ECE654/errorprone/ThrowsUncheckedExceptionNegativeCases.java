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

import java.io.FileNotFoundException;
import java.io.IOException;

/** @author yulissa@google.com (Yulissa Arroyo-Paredes) */
public class ThrowsUncheckedExceptionNegativeCases {
  public void doSomething() {
    throw new IllegalArgumentException("thrown");
  }

  public void doMore() throws IOException {
    throw new FileNotFoundException("thrown");
  }
}
