package com.satish.exp.problems;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr ={ -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(findSum(arr));
    }

    private static int findSum(int[] arr){
        int max_sum = Integer.MIN_VALUE;
        int initiate = 0;
        for(int i=0; i<arr.length; i++){
            initiate = initiate + arr[i];
            if(initiate > max_sum)
                max_sum=initiate;
            if(initiate<0)
                initiate=0;
        }
        return max_sum;
    }
}
