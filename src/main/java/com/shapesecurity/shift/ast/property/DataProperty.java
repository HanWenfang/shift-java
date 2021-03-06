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

package com.shapesecurity.shift.ast.property;

import com.shapesecurity.shift.ast.Expression;
import com.shapesecurity.shift.ast.types.Type;

import org.jetbrains.annotations.NotNull;

public class DataProperty extends ObjectProperty {
  @NotNull
  public final Expression value;

  public DataProperty(@NotNull PropertyName name, @NotNull Expression value) {
    super(name);
    this.value = value;
  }

  @NotNull
  @Override
  public ObjectPropertyKind getKind() {
    return ObjectPropertyKind.InitProperty;
  }

  @NotNull
  @Override
  public Type type() {
    return Type.DataProperty;
  }

  @Override
  public boolean equals(Object object) {
    return object instanceof DataProperty && this.name.equals(((DataProperty) object).name) &&
           this.value.equals(((DataProperty) object).value);
  }

  @NotNull
  public Expression getValue() {
    return this.value;
  }

  @NotNull
  public DataProperty setName(@NotNull PropertyName name) {
    return new DataProperty(name, this.value);
  }

  @NotNull
  public DataProperty setValue(@NotNull Expression value) {
    return new DataProperty(this.name, value);
  }
}
