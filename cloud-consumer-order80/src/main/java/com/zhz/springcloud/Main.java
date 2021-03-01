package com.zhz.springcloud;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4,8,45,12,6,78,1};
        int[] ints = twoSum(arr, 6);
//        int[] ints1 = twoSum1(arr, 6);

//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }
//        for (int i = 0; i < ints1.length; i++) {
//            System.out.println(ints1[i]);
//        } =4 3 2 1

        maopao(arr);
    }

    public static void maopao(int [] arr){

       for (int i = 0;i<arr.length-1;i++){
           for (int j = 0;j<arr.length-i-1;j++){
               int temp = 0;
               if (arr[j]>arr[j+1]){
                   temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
           }
       }

        Arrays.stream(arr).forEach(System.out::println);


    }

    public static int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    public static int[] twoSum1(int[] nums, int target) {
        int a[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return a;
    }

}
