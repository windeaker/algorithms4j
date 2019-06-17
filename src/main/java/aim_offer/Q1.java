package aim_offer;

/**
 * @author windeaker
 * <p>
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Q1 {
    public static boolean Find(int target, int[][] array) {
        int rowSize = array.length;
        if (rowSize==0){
            return false;
        }
        int colSize = array[0].length;
        if (colSize==0){
            return false;
        }
        int min = array[0][0];
        int max = array[rowSize - 1][colSize - 1];
        if (target > max || target < min) {
            return false;
        }
        if (target == min || target == max) {
            return true;
        }
        int row = 0, column = 0, nextRow = row + 1, nextCol = column + 1;
        int rowVal, colVal, rowDiff, colDiff;
//        int rowLimit=rowSize,colLimit=colSize;
        boolean exist = false;
        while (true) {
            if (exist) {
                break;
            }
            if (nextRow < rowSize && nextCol < colSize) {
                rowVal = array[nextRow][column];
                colVal = array[row][nextCol];
                rowDiff = target - rowVal;
                colDiff = target - colVal;
                if (rowDiff == 0 || colDiff == 0) {
                    exist = true;
                    break;
                }else if (rowDiff>0&&colDiff>0){
                    if (rowDiff < colDiff) {
                        row++;
                        nextRow++;
                    } else {
                        column++;
                        nextCol++;
                    }
                }else{
                    if (rowDiff > colDiff) {
                        row++;
                        nextRow++;
                    } else {
                        column++;
                        nextCol++;
                    }
                }
            } else if (nextRow >= rowSize && nextCol < colSize) {
                colDiff = Math.abs(target - array[rowSize - 1][nextCol]);
                if (colDiff == 0) {
                    exist = true;
                    break;
                } else {
                    column++;
                    nextCol++;
                }
            } else if (nextRow < rowSize && nextCol >= colSize) {
                rowDiff = Math.abs(target - array[nextRow][colSize - 1]);
                if (rowDiff == 0) {
                    exist = true;
                    break;
                } else {
                    row++;
                    nextRow++;
                }
            } else if (nextRow >= rowSize && nextRow >= colSize) {
                break;
            }
        }
        return exist;
    }

    public static void main(String[] args) {
        int target = 7;
//        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int[][] array = {};
        System.out.println(Q1.Find(target, array));
    }
}
