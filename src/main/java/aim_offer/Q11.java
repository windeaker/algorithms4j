package aim_offer;

/**
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Q11 {
    public int NumberOf1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n=n >>> 1;
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        new Q11().NumberOf1(10);
    }
}
