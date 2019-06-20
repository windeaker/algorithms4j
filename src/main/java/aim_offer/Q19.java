package aim_offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Q19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        if (row == 0 && col == 0) {
            return res;
        }
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (left <= right && top <= bottom) {
            //上：从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            //右：从上到下
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            //下：从右到左
            if (top != bottom) {
                //防止单行情况
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
            }
            //左：从下到上
            if (left != right) {
                //防止单列情况
                for (int i = bottom - 1; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[8];
        System.out.println(a[0]);
    }
}
