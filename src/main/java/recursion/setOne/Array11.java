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

package recursion.setOne;

import org.jetbrains.annotations.NotNull;
import util.ArrayUtil;
import util.GenericUtil;

import java.io.IOException;

/**
 * Given an array of ints, compute recursively the number of times that the value 11 appears in the array.
 * We'll use the convention of considering only the part of the array that begins at the given index.
 * In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
 * <p>
 * array11([1, 2, 11], 0) → 1
 * array11([11, 11], 0) → 2
 * array11([1, 2, 3, 4], 0) → 0
 */
public final class Array11 {

    public static void main(String... args) throws IOException {
        System.out.println(ArrayUtil.ARRAY_INPUT_SIZE + " and " + ArrayUtil.ARRAY_ELEMENTS_INPUTS + " and " + GenericUtil.INTEGER_INPUT_INDEX);
        System.out.println(new Array11().array11(ArrayUtil.takeArrayInput(), GenericUtil.takeIntegerInput()));
    }

    /**
     * Recursion continues till index less than array length
     * and if at a given index 11 is found add 1 else recurse
     *
     * @param nums  the array
     * @param index the starting index
     * @return quantity of 11 in array
     */
    private int array11(@NotNull final Integer[] nums, final Integer index) {
        if (index >= nums.length) return 0;
        if (nums[index] == 11) return 1 + array11(nums, index + 1);
        return array11(nums, index + 1);
    }
}