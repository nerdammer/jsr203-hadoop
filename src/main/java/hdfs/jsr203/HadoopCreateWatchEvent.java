/*
 * Copyright 2016 Damien Carol <damien.carol@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package hdfs.jsr203;

import java.nio.file.WatchEvent;
import java.util.Objects;

import javax.annotation.Nullable;

/**
 * Implementation for {@link WatchEvent}.
 */
public class HadoopCreateWatchEvent<T> implements WatchEvent<T> {

  private final Kind<T> kind;
  private final int count;

  private final T context;

  public HadoopCreateWatchEvent(Kind<T> kind, int count, T context) {
    this.kind = kind;
    this.count = count;
    this.context = context;
  }

  @Override
  public Kind<T> kind() {
    return kind;
  }

  @Override
  public int count() {
    return count;
  }

  @Nullable
  @Override
  public T context() {
    return context;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof HadoopCreateWatchEvent) {
      HadoopCreateWatchEvent<?> other = (HadoopCreateWatchEvent<?>) obj;
      return kind().equals(other.kind())
          && count() == other.count()
          && Objects.equals(context(), other.context());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind(), count(), context());
  }

  @Override
  public String toString() {
    return new StringBuilder().append(this.getClass().getName())
        .append(", kind" + kind())
        .append(", count" + count())
        .append(", context" + context())
        .toString();
  }
}
