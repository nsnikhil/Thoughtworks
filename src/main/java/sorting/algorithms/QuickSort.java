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

package sorting.algorithms;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Implementation of quick sort
 */
public class QuickSort implements Sorter {

    /**
     * @param ar the original array
     * @return the sorted array
     */
    @Override
    public final Integer[] sort(final Integer[] ar) {
        return quickSort(ar, 0, ar.length - 1);
    }

    /**
     * Find the position of pivot and recursively call the
     * quicksort function from start to pivot-1 and from pivot+1 to end
     * <p>
     * Eg : -> 9,8,5,2,6,4
     * <p>
     * After partition function is called we get
     * 2,4,5,9,6,8 and 1 as the pivotIndex
     * <p>
     * and call quickSort on 2 and 5,9,6,8
     * <p>
     * and for 5,9,6,8 partition is called which returns
     * 5,6,8,9 and pivotIndex of 2 and finally we get sorted
     * array as 2,4,5,6,8,9
     *
     * @param ar    the original array
     * @param start the starting index
     * @param end   the end index
     * @return the sorted array
     */
    @Nullable
    private Integer[] quickSort(final Integer[] ar, final int start, final int end) {
        if (start >= end) return null;
        final int pivot = partition(ar, start, end);
        quickSort(ar, start, pivot - 1);
        quickSort(ar, pivot + 1, end);
        return ar;
    }

    /**
     * The first index of the array is chosen as the pivotIndex
     * and the pivot is chosen to be the last value of the array
     * <p>
     * If the value at ith index is smaller than pivot value
     * swap the value at ith index and pivotIndex and increment the
     * pivotIndex and finally swap the value at pivotIndex with the pivot
     * value and you will have a array where all the elements to right of
     * index are greater and value to left are smaller than pivot.
     * <p>
     * Eg : -> 9,8,5,2,6,4
     * <p>
     * pivotIndex = start = 0;
     * pivot = ar[end] = 4;
     * <p>
     * start loop from start to end
     * the check ar[i](9) <= pivot(4) - false
     * and this goes until 2 is encountered
     * and value at ar[3] and ar[pivotIndex] are swapped
     * we get 2,8,5,9,6,4 and pivotIndex is incremented
     * and finally 8 is swapped with 4 since pivotIndex was 1
     * and it pointed to 8 and the array is 2,4,5,9,6,8.
     *
     * @param ar    the original array
     * @param start the start index
     * @param end   the end index
     * @return the index of pivot
     */
    private int partition(@NotNull final Integer[] ar, final int start, final int end) {
        //final int pivotIndex = getPivotIndex(ar,start,end,start,ar[end]);
        int pivotIndex = start;
        int temp, pivot = ar[end];
        for (int i = start; i < end; i++)
            if (ar[i] <= pivot) {
                temp = ar[i];
                ar[i] = ar[pivotIndex];
                ar[pivotIndex] = temp;
                pivotIndex++;
            }
        temp = ar[pivotIndex];
        ar[pivotIndex] = pivot;
        ar[end] = temp;
        return pivotIndex;
    }

    /*private int getPivotIndex(@NotNull final Integer[] ar, final int start, final int end, final int pivotIndex, final int pivot) {
        if (start == end) return pivotIndex;
        if (ar[start] <= pivot) {
            final int temp = ar[start];
            ar[start] = ar[pivotIndex];
            ar[pivotIndex] = temp;
            return getPivotIndex(ar, start + 1, end, pivotIndex + 1, pivot);
        } else
            return getPivotIndex(ar, start + 1, end, pivotIndex, pivot);
    }*/
}
