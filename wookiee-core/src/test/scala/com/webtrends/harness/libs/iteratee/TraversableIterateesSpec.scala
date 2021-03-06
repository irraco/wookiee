/*
 *  Copyright (c) 2016 Webtrends (http://www.webtrends.com)
 *  See the LICENCE.txt file distributed with this work for additional
 *  information regarding copyright ownership.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.webtrends.harness.libs.iteratee

import org.specs2.mutable._

object TraversableIterateesSpec extends Specification
    with IterateeSpecification with ExecutionSpecification {

  "Traversable.splitOnceAt" should {

    "yield input while predicate is satisfied" in {
      mustExecute(1) { splitEC =>
        val e = Traversable.splitOnceAt[String, Char] { c => c != 'e' }(
          implicitly[String => scala.collection.TraversableLike[Char, String]],
          splitEC)
        mustTransformTo("hello", "there")("h")(e)
      }
    }

  }
}
