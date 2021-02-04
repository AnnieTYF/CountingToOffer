package leecode.Array;

import java.util.Random;

public class ShuffleArray {

    public int[] array;
    public int[] origin;

    public ShuffleArray(int[] nums) {
        this.array = nums;
        this.origin = nums.clone();
    }
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = array.length;
        Random random = new Random();
        for(int i = 0; i<len ; i++){
            int num = random.nextInt(len);
            int temp = array[i];
            array[i] = array[num];
            array[num] = temp;
        }
        return array;
    }
}
