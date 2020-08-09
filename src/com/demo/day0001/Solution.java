package com.demo.day0001;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Solution.main");
        int[] sd = {4,9,9,9};
        //int[] sd21 = {4,2,6,2};
        System.out.println(Arrays.toString(plusOne2(sd)));
    }

    public static int[] plusOne(int[] digits) {
        int[] ret = digits;
        int s = 0;//上一循环取商的数字，如果不为0要加到当前数字后再计算
        int y = 0;//
        for(int i=digits.length-1,len = digits.length-1;i>=0;i--){
            //获取当前循环数字
            int curr=digits[i];
            //只有最后一位加1
            if(i == len){
                curr += 1;
            }
            //上一循环取商的数字，如果不为0要加到当前数字后再计算
            if(s > 0){
                curr += s;
            }
            //curr 加一除10取商
            s = curr / 10;
            y = curr % 10;
            digits[i] = y;
            if(i == 0 && s > 0){
                ret = new int[digits.length + 1];
                ret[0] = s;
                return ret;
            }
        }
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        // 从末尾开始循环
        for (int i = digits.length - 1; i >= 0; i--) {
            // 先 +1
            digits[i]++;
            // 取余数， 10 的余数为 0
            digits[i] = digits[i] % 10;
            // 判断余数是否为 0 ，如果为 0 则再循环一次，产生了进位，不为 0 则可以直接返回
            if (digits[i] != 0) return digits;
        }
        // 如果在上面的循环未返回，则整体产生进位，类似于 9 ， 99 ， 999 ， 9999 这种数组
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int lengthOfLastWord2(String s) {
        int count=0;
        boolean b=false;
        for (int i=s.length()-1;i>=0;i--){
            if (s.charAt(i) != ' '){
                b = true;
                count ++;
            }
            if (b && s.charAt(i) == ' '){
                break;
            }
        }

        return count;
    }
}
