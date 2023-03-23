package pers.chris.Divide.LargestK;

import java.util.Arrays;

class Solution {

    int k;
    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.k = nums.length - k + 1;
        this.nums = nums;

        quickSort(0, this.nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[this.k - 1];
    }

    public void quickSort(int left, int right){
        if (left >= right){
            return;
        }

        int pivot = nums[left];
        int lt = left;
        int rt = right;

        while (true){
            while (lt < rt && nums[rt] >= pivot){
                rt --;
            }
            while (lt < rt && nums[lt] < pivot){
                lt ++;
            }

            if (lt < rt){
                int temp = nums[lt];
                nums[lt] = nums[rt];
                nums[rt] = temp;
            }
            else {
                break;
            }
        }

        if (lt == k){
        }
        else if (lt < k){
            quickSort(lt + 1, right);
        }
        else {
            quickSort(left, lt);
        }
    }
}
