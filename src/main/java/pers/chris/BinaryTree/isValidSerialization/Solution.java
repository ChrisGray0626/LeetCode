package pers.chris.BinaryTree.isValidSerialization;

class Solution {
    public boolean isValidSerialization(String preorder) {
        int num = 1;

        for (int i = 0; i < preorder.length(); i ++){
            if (num == 0){
                return false;
            }

            char ch = preorder.charAt(i);
            if (ch == ','){
                continue;
            }
            else if (ch == '#'){
                num --;
            }
            else if (Character.isDigit(preorder.charAt(i))){
                num ++;
                while (Character.isDigit(preorder.charAt(i)) &&  ++ i != preorder.length()){
                }
            }

        }

        return num == 0;
    }
}
