package pers.chris.meituan.forth;

import java.util.*;

/**
 * @Author Chris
 * @Date 2022/3/5 10:43 AM
 */
class Main{
    public static void main(String[] args){
        int n, m;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n=sc.nextInt();
            m=sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int[] idxCnt = new int[n];
            long cnt = 0;
            int[][] ops = new int[m][4];
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int l = sc.nextInt();
                int r = sc.nextInt();
                ops[i][0] = x;
                ops[i][1] = l;
                ops[i][2] = r;

                if (x == 2) {
                    int k = sc.nextInt();
                    ops[i][3] = k;
                }
            }

            for (int i = ops.length - 1; i >= 0; i--) {
                int[] op = ops[i];
                if (op[0] == 1) {
                    for (int j = op[1] - 1; j < op[2]; j++) {
                        idxCnt[j]++;
                    }
                }
                else {
                    for (int j = op[1] - 1; j < op[2]; j++) {
                        cnt += (long) idxCnt[j] * op[3];
                    }
                }
            }

            Arrays.sort(idxCnt);
            Arrays.sort(nums);
            for (int i = 0; i < n; i++) {
                cnt += (long) idxCnt[i] * nums[i];
            }
            System.out.println(cnt);
        }
    }
}
