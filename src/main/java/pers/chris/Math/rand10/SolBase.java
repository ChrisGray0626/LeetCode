package pers.chris.Math.rand10;

import java.util.Random;

public class SolBase {

    public int rand7() {
        Random random = new Random();

        return random.nextInt(7) + 1;
    }
}
