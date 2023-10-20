package pers.chris.Math.categorizeBox;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/20
 */
class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = isBulky(length, width, height);
        boolean isHeavy = isHeavy(mass);

        if (isBulky && isHeavy) {
            return "Both";
        }
        else if (isBulky) {
            return "Bulky";
        }
        else if (isHeavy) {
            return "Heavy";
        }
        else {
            return "Neither";
        }
    }

    private boolean isBulky(int length, int width, int height) {
        return length >= 1e4 || width >= 1e4 || height >= 1e4 || ((long) length * width * height) >= 1e9;
    }

    private boolean isHeavy(int mass) {
        return mass  >=100;
    }
}
