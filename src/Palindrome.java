/*
Given an integer x, return true if x is a palindrome, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

public class Palindrome {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char arr[] = s.toCharArray();
        if(x<0 || (x%10==0 && x!=0)) return false;
        int i=0; int j=arr.length-1;
        while(i<j){
            if(arr[i]!=arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindromeEff(int x) {
        if (x < 0) {
            return false;
        }
        int original = x;
        int reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        int a = 1;
//        System.out.println(isPalindrome(a));
        System.out.println(isPalindromeEff(a));
    }
}
