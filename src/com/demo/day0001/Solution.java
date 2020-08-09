package com.demo.day0001;

import java.util.Arrays;

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("Solution.main");
        int[] sd = {4,9,9,9};
        //int[] sd21 = {4,2,6,2};
        System.out.println(Arrays.toString(plusOne(sd)));
    }

    /**
     * 方法1
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int[] ret = digits;
        int s = 0;//上一循环取商的数字，如果不为0要加到当前数字后再计算
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
            digits[i] = curr % 10;
            if(i == 0 && s > 0){
                ret = new int[digits.length + 1];
                ret[0] = s;
                return ret;
            }
        }
        return digits;
    }

    /**
     * 方法2
     * @param digits
     * @return
     */
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
