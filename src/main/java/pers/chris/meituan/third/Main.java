package pers.chris.meituan.third;

import java.util.*;

/**
 * @Author Chris
 * @Date 2022/3/5 11:28 AM
 */
class Main{
    public static void main(String[] args){
        int n, m;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n=sc.nextInt();
            m=sc.nextInt();

            int[] op = new int[m];
            for (int i = 0; i < m; i++) {
                op[i] = sc.nextInt() - 'x';
            }
            int[] pos = new int[m];
            for (int i = 0; i < m; i++) {
                pos[i] = sc.nextInt();
            }
            List<Integer> xPos = new ArrayList<>();
            List<Integer> yPos = new ArrayList<>();
            List<Integer> zPos = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if (op[i] == 0) {
                    xPos.add(pos[i]);
                }
                if (op[i] == 1) {
                    yPos.add(pos[i]);
                }
                if (op[i] == 2) {
                    zPos.add(pos[i]);
                }
            }

            Collections.sort(xPos);
            Collections.sort(yPos);
            Collections.sort(zPos);
            int xDiff = 0;
            int yDiff = 0;
            int zDiff = 0;
            for (int i = 0; i < xPos.size() - 1; i++) {
                xDiff = Math.max(xDiff, xPos.get(i + 1) - xPos.get(i));
            }
            for (int i = 0; i < yPos.size() - 1; i++) {
                yDiff = Math.max(yDiff, yPos.get(i + 1) - yPos.get(i));
            }
            for (int i = 0; i < zPos.size() - 1; i++) {
                zDiff = Math.max(zDiff, zPos.get(i + 1) - zPos.get(i));
            }
            System.out.println(xDiff * yDiff * zDiff);
        }
    }
}

