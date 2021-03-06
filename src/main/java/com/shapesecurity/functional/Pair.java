/*
 * Copyright 2014 Shape Security, Inc.
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

package com.shapesecurity.functional;

import com.shapesecurity.functional.data.HashCodeBuilder;

import org.jetbrains.annotations.NotNull;

public final class Pair<A, B> {
  @NotNull
  public final A a;
  @NotNull
  public final B b;

  public Pair(@NotNull A a, @NotNull B b) {
    super();
    this.a = a;
    this.b = b;
  }

  @NotNull
  public Pair<B, A> swap() {
    return new Pair<>(this.b, this.a);
  }

  @NotNull
  public <A1> Pair<A1, B> mapA(@NotNull F<A, A1> f) {
    return new Pair<>(f.apply(this.a), this.b);
  }

  @NotNull
  public <B1> Pair<A, B1> mapB(@NotNull F<B, B1> f) {
    return new Pair<>(this.a, f.apply(this.b));
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean equals(Object obj) {
    return obj == this || obj instanceof Pair &&
        ((Pair<A, B>) obj).a.equals(this.a) &&
        ((Pair<A, B>) obj).b.equals(this.b);
  }

  @Override
  public int hashCode() {
    int hash = HashCodeBuilder.put(HashCodeBuilder.init(), "Tuple2");
    hash = HashCodeBuilder.put(hash, this.a);
    return HashCodeBuilder.put(hash, this.b);
  }
}

