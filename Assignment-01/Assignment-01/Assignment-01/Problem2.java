import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long k = sc.nextLong();

        // Check feasibility
        long remainder = arr[0] % k;
        for (int i = 1; i < n; i++) {
            if (arr[i] % k != remainder) {
                System.out.println(-1);
                return;
            }
        }

        // Sort array
        Arrays.sort(arr);

        // Choose median
        long median = arr[n / 2];

        long operations = 0;

        for (int i = 0; i < n; i++) {
            operations += Math.abs(arr[i] - median) / k;
        }

        System.out.println(operations);
    }
}
