/*
 *    Copyright 2017 nsnikhil
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package datastructure.hash;

import org.jetbrains.annotations.NotNull;

//TODO
public class MyHashMap implements MapInterface<String, Integer> {

    private static final Integer CONSTANT = 101;

    MyHashMap() {

    }

    @Override
    public void put(final String key, final Integer data) {

    }

    @Override
    public Integer get(final String key) {
        return null;
    }

    @Override
    public Integer getHashCode(final String key) {
        return getHashCode(key, 0, key.length(), 0);
    }

    private Integer getHashCode(final String key, @NotNull final Integer index, final Integer size, Integer hashCode) {
        if (index.equals(size)) return hashCode;
        return key.charAt(index) * (int) Math.pow(CONSTANT, index) + getHashCode(key, index + 1, size, hashCode);
    }

    @Override
    public Integer getIndex(final Integer hashCode) {
        return Math.abs(hashCode % MapInterface.DEFAULT_HASH_TABLE_SIZE);
    }
}
