package pers.chris.quicksort;

/**
 * @Description
 * @Author Chris
 * @Date 2023/3/19
 */
public class Solution {

    public static int pivot(int [] nums,int start, int end){
        // 选第一个元素为中心元素
        int temp = nums[start];
        while(start < end){
            // 从后往前找比中心元素小的元素
            while(start < end && nums[end] >= temp){
                end--;
            }
            // 将找到的元素放到前面
            nums[start] = nums[end];
            // 从前往后找比中心元素大的元素
            while(start < end && nums[start] <= temp){
                start++;
            }
            // 将找到的元素放到后面
            nums[end] = nums[start];
        }
        // 将中心元素放到中间
        nums[start] = temp;

        return start;
    }

    public static void quickSort(int [] nums, int low, int high){
        if(low < high){
            int piv = pivot(nums,low,high);
            quickSort(nums,low,piv - 1);
            quickSort(nums,piv + 1,high);
        }
    }
}
