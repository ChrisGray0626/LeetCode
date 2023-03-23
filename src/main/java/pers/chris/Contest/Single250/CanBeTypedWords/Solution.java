package pers.chris.Contest.Single250.CanBeTypedWords;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenCh = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i ++) {
            brokenCh.add(brokenLetters.charAt(i));
        }
        String[] texts = text.split(" ");
        int cnt = texts.length;
        for (String s: texts) {
            for (int i = 0; i < s.length(); i ++) {
                if (brokenCh.contains(s.charAt(i))) {
                    cnt --;
                    break;
                }
            }
        }
        return cnt;
    }
}
