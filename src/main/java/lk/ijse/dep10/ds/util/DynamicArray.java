package lk.ijse.dep10.ds.util;

import java.util.Arrays;

public class DynamicArray {

    private int[] nums = new int[0];

    public void add(String value) {

        int[] tempArray = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            tempArray[i] = nums[i];
        }
        tempArray[nums.length] = Integer.parseInt(value);
        nums = tempArray;

    }

    public void clear() {
        int[] tempArray = new int[0];
        nums = tempArray;
    }

    public int size() {
        return nums.length;
    }

    public void remove(int index) {
        int[] tempArray = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < index) {
                tempArray[i] = nums[i];
            } else if (i > index) {
                tempArray[i - 1] = nums[i];
            }
        }
        nums = tempArray;
    }

    public String get(int index) {
        for (int i = 0; i < nums.length; i++) {
            if(i==index) return ""+nums[i];
        }
        return "Number not here";
    }

    public boolean contains(String input) {
        int num = Integer.parseInt(input);
        for (int i = 0; i < nums.length;) {
            if(num==nums[i++]) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(nums);
    }
}
