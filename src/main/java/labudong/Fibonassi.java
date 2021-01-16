package labudong;

import java.time.Duration;
import java.time.Instant;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/8/20
 */
public class Fibonassi {

    public static long a(long n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return a(n - 1) + a(n - 2);
        }
    }

    public static long b(int n) {
        long[] arr = new long[n + 1];
        System.out.println(arr[n]);
        arr[2] = arr[1] = 1;
        int i = 3;
        while (i <= n) {
            arr[i] = arr[i - 1] + arr[i - 2];
            i++;
        }
        return arr[n];
    }

    public static long c(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }
        long pre = 1, befpre = 1;
        int i = 3;
        while (i <= n) {
            long sum = pre + befpre;
            befpre = pre;
            pre = sum;
            i++;
        }
        return pre;
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println("a:"+a(50));
        Instant end1 = Instant.now();
        System.out.println("a time:" + Duration.between(start, end1).toMillis());
        System.out.println("b:"+b(500000));
        Instant end2 = Instant.now();
        System.out.println("b time:" + Duration.between(end1, end2).toMillis());
        System.out.println("c:" + c(500000));
        Instant end3 = Instant.now();
        System.out.println("c time:" + Duration.between(end2, end3).toMillis());
    }
}
