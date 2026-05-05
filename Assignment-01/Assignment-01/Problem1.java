import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        int n = s.length();
        String doubled = s + s;

        int[] freq = new int[26];
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < doubled.length(); right++) {
            int idx = doubled.charAt(right) - 'a';
            
            // Add current character
            freq[idx]++;
            currentSum += (idx + 1);

            // If duplicate OR window size > n → shrink window
            while (freq[idx] > 1 || (right - left + 1) > n) {
                int leftIdx = doubled.charAt(left) - 'a';
                freq[leftIdx]--;
                currentSum -= (leftIdx + 1);
                left++;
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}
