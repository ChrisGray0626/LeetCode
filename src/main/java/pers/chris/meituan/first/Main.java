package pers.chris.meituan.first;

import java.util.*;

/**
 * @Author Chris
 * @Date 2022/3/5 9:58 AM
 */
class Main{
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n=sc.nextInt();
            Set<Integer> numSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                numSet.add(num);
            }

            List<Integer> nums = new ArrayList<>(numSet);
            Collections.sort(nums);
            int cnt = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (i == nums.size() - 1) {
                    cnt++;
                    break;
                }
                if (nums.get(i + 1) - nums.get(i) <= 1) {
                    i++;
                }
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
