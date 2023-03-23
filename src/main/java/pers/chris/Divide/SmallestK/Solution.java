package pers.chris.Divide.SmallestK;

import java.util.Arrays;

class Solution {

    int k;
    int[] arr;

    public int[] smallestK(int[] arr, int k) {
        this.k = k;
        this.arr = arr;

        quickSort(0, arr.length - 1);

        int[] res = Arrays.copyOfRange(arr, 0 , k);

        return res;
    }

    public void quickSort(int left, int right){
        if (left >= right){
            return;
        }

        int pivot = arr[left];
        int lt = left;
        int rt = right;

        while (true){
            while (lt < rt && arr[rt] >= pivot){
                rt --;
            }
            while (lt < rt && arr[lt] < pivot){
                lt ++;
            }

            if (lt < rt){
                int temp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = temp;
            }
            else {
                break;
            }
        }

        if (lt == k - 1){
            return;
        }
        else if (lt < k){
            quickSort(lt + 1, right);
        }
        else {
            quickSort(left, lt);
        }
    }
}
