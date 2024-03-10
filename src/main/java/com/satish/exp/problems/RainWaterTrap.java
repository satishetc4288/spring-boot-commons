package com.satish.exp.problems;

public class RainWaterTrap {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int units = findWaterUnits(arr);
        System.out.println("units: " + units);
    }
    private static int findWaterUnits(int arr[]){
        int units =0;
        for(int i=1; i<arr.length-2;i++){
            int left=arr[i];
            for(int j=0; j<i; j++){
                left = Math.max(left,arr[j]);
            }

            int right=arr[i];
            for(int j=i+1; j<arr.length; j++){
                right = Math.max(right,arr[j]);
            }
            units = units + (Math.min(left,right)-arr[i]);
        }
        return units;
    }
}
