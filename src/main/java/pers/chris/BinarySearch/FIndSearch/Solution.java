package pers.chris.BinarySearch.FIndSearch;

class Solution {
    public int findString(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;

        while (left <= right){
            int mid = ( left + right ) / 2;

            while (mid <= right && words[mid].equals("")){
                mid ++;
            }

            if (mid > right){
                mid = ( left + right ) / 2 - 1;
            }

            while (mid >= left && words[mid].equals("")){
                mid --;
            }

            if (mid < left){
                return -1;
            }

            int cmp = words[mid].compareTo(s);
            if (cmp == 0){
                return mid;
            }
            else if (cmp < 0){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
