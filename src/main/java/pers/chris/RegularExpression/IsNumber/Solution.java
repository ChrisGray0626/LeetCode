package pers.chris.RegularExpression.IsNumber;

import java.util.regex.Pattern;

class Solution {
    public boolean isNumber(String s) {
        String pattern = "[+-]?(\\d+(\\.\\d*)?|(\\.\\d+))([eE][+-]?\\d+)?";
//        ([+-]?(\\d+(\\.\\d*)?|(\\.\\d+)))([eE][+-]?\\d+)?
        return Pattern.matches(pattern, s);
    }
}
