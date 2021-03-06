package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Sort {
    public void swap(int[] nums, int posA, int posB) {
        int tmp = nums[posA];
        nums[posA] = nums[posB];
        nums[posB] = tmp;
    }
    /***************************************冒泡排序******************************************
     * 平均时间复杂度O(n^2)    空间复杂度O(1)    稳定    最差时间复杂度O(n^2)    最好时间复杂度O(n)   */
    public void maopaoSort(int[] nums) {
        for (int end = nums.length-1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (nums[i+1] < nums[i])
                    swap(nums, i, i+1);
            }
        }
    }
    /***************************************冒泡排序******************************************/

    /***************************************选择排序******************************************
     * 平均时间复杂度O(n^2)    空间复杂度O(1)    不稳定    最差时间复杂度O(n^2)    最好时间复杂度O(n)   */
    public void xuanzeSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min])
                    min = j;
            }
            swap(nums, i, min);
        }
    }
    /***************************************选择排序******************************************/

    /***************************************插入排序******************************************
     * 平均时间复杂度O(n^2)    空间复杂度O(1)    稳定    最差时间复杂度O(n^2)    最好时间复杂度O(n)   */
    public void charuSort(int[] array) {
        if (array.length == 0)
            return;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex])
            {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
    }
    /***************************************插入排序******************************************/

    /***************************************快速排序******************************************
     * 平均时间复杂度O(nlogn)    空间复杂度O(1)    不稳定    最差时间复杂度O(n^2)    最好时间复杂度O(nlogn)   */
    public int partition(int[] nums, int left, int right) {
        int index = (int) (Math.random() * (right-left+1) + left);
        swap(nums, index, right);
        int low = left - 1;
        for (int i = left; i < right; i++) {
            if (nums[i] <= nums[right]) {
                low++;
                if (i != low)
                    swap(nums, i, low);
            }
        }
        index = low + 1;
        swap(nums, index, right);
        return index;
    }
    //递归
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right);
            quickSort(nums, left, mid-1);
            quickSort(nums, mid+1, right);
        }
    }
    //非递归，用栈实现
    public void quickSort2(int[] nums, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        int l = 0;
        int r = 0;
        int mid = 0;
        while (!stack.empty()) {
            r = stack.pop();
            l = stack.pop();
            mid = partition(nums, l, r);
            if (l < mid - 1) {
                stack.push(l);
                stack.push(mid-1);
            }
            if (r > mid + 1) {
                stack.push(mid+1);
                stack.push(r);
            }
        }
    }

    /***************************************快速排序******************************************/

    /***************************************归并排序******************************************
     * 平均时间复杂度O(nlogn)    空间复杂度O(n)    稳定    最差时间复杂度O(nlogn)    最好时间复杂度O(nlogn)   */
    public void guibingSort(int[] nums) {
        int[] tmp = new int[nums.length];
        guibingSort(nums, 0, nums.length-1, tmp);
    }
    public void guibingSort(int[] nums, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            guibingSort(nums, left, mid, tmp);
            guibingSort(nums, mid+1, right, tmp);
            merge(nums, left, mid, right, tmp);
        }
    }
    public void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        int leftPos = left;
        int rightPos = mid + 1;
        int t = 0;
        while (leftPos <= mid && rightPos <= right) {
            if (nums[leftPos] <= nums[rightPos])
                tmp[t++] = nums[leftPos++];
            else
                tmp[t++] = nums[rightPos++];
        }
        while (leftPos <= mid)
            tmp[t++] = nums[leftPos++];
        while (rightPos <= right)
            tmp[t++] = nums[rightPos++];
        t = 0;
        while (left <= right) {
            nums[left++] = tmp[t++];
        }
    }
    /***************************************归并排序******************************************/

    /***************************************希尔排序******************************************
     * 平均时间复杂度O(nlogn)    空间复杂度O(1)    不稳定    最差时间复杂度O(n^2)    最好时间复杂度O(n)   */
    public void shellSort(int nums[]) {
        int n = nums.length;
        for (int h = n/2; h > 0 ; h/=2) {
            for (int i = h; i < nums.length; i++) {
                int j = i;
                while (j-h >= 0) {
                    if (nums[j] < nums[j-h])
                        swap(nums, j, j-h);
                    j -= h;
                }
            }
        }
    }
    /***************************************希尔排序******************************************/

    /********************************堆排序*******************************************/
    public void duiSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int heapSize = nums.length;
        buildHeap(nums, heapSize);
        while (heapSize > 0) {
            swap(nums, 0, heapSize - 1);
            heapSize--;
            heapify(nums, 0, heapSize);
        }
    }

    public void buildHeap(int[] nums, int heapSize) {
        for (int i = (heapSize - 2) / 2; i >= 0; i--) {
            heapify(nums, i, heapSize);
        }
    }

    public void heapify(int[] nums, int curNode, int heapSize) {
        int l = curNode * 2 + 1;
        int r = curNode * 2 + 2;
        int largest = curNode;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != curNode) {
            swap(nums, curNode, largest);
            heapify(nums, largest, heapSize);
        }
    }
    /********************************堆排序*******************************************/

    public static void main(String[] args) {
        Sort s = new Sort();
        int[] nums = {5,2,6,1,7,3,2};
        s.maopaoSort(nums);
        System.out.println("冒泡排序：" + Arrays.toString(nums));
        nums = new int[]{5, 2, 6, 1, 7, 3, 2};
        s.quickSort(nums, 0, nums.length-1);
        System.out.println("快速排序递归：" + Arrays.toString(nums));
        nums = new int[]{5, 2, 6, 1, 7, 3, 2};
        s.quickSort2(nums, 0, nums.length-1);
        System.out.println("快速排序非递归：" + Arrays.toString(nums));
        nums = new int[]{5, 2, 6, 1, 7, 3, 2};
        s.guibingSort(nums);
        System.out.println("归并排序：" + Arrays.toString(nums));
        nums = new int[]{5, 2, 6, 1, 7, 3, 2};
        s.xuanzeSort(nums);
        System.out.println("选择排序：" + Arrays.toString(nums));
        nums = new int[]{5, 2, 6, 1, 7, 3, 2};
        s.charuSort(nums);
        System.out.println("插入排序：" + Arrays.toString(nums));
        nums = new int[]{5, 2, 6, 1, 7, 3, 2};
        s.shellSort(nums);
        System.out.println("希尔排序：" + Arrays.toString(nums));
        nums = new int[]{5, 2, 6, 1, 7, 3, 2};
        s.duiSort(nums);
        System.out.println("堆排序：" + Arrays.toString(nums));
    }
}
