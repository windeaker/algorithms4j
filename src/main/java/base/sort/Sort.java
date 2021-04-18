package base.sort;

/**
 * 八大内部排序算法
 * 直接插入排序
 * 插入排序-->
 * 希尔排序
 * 冒泡排序
 * 交换排序-->
 * 快速排序
 * 内部排序-->
 * 简单选择排序
 * 选择排序-->
 * 堆排序
 * 基尔排序
 * 归并排序
 *
 * @author windeaker
 * @version 1.0
 */
public class Sort {
    /**
     * 直接插入排序 时间复杂度O(n^2) 空间复杂度O(1)
     *
     * @param comparables
     */
    public static void insertSort(Comparable[] comparables) {
        int length = comparables.length;
        Comparable temp;
        int next;
        for (int current = 2; current < length; current++) {
            int cursor = current;
            while (cursor > 0) {
                next = cursor - 1;
                if (less(comparables[cursor], comparables[next])) {
                    temp = comparables[cursor];
                    comparables[cursor] = comparables[next];
                    comparables[next] = temp;
                }
                cursor--;
            }
        }
        temp = null;
    }

    /**
     * 希尔排序 时间复杂度O(nlogn)(以二为底) 空间复杂度O(1)
     *
     * @param comparables
     */
    public static void shellSort(Comparable[] comparables) {
        int length = comparables.length;
        boolean isOddNum = (length % 2) == 0;
        Comparable temp;
        for (int increment = length / 2; increment > 0; ) {
            for (int current = 0; current < increment; current++) {
                int cursor = current;
                for (int next = cursor + increment; next < length; ) {
                    if (more(comparables[cursor], comparables[next])) {
                        temp = comparables[cursor];
                        comparables[cursor] = comparables[next];
                        comparables[next] = temp;
                    }
                    cursor = next;
                    next = cursor + increment;
                }
            }
            increment = increment / 2;
            //确保最后一次增量为1
            if (increment == 2 && isOddNum) {
                increment = 1;
            }
        }
    }

    /**
     * 冒泡排序 时间复杂度O(n^2) 空间复杂度O(1)
     *
     * @param comparables
     */
    public static void bubbleSort(Comparable[] comparables) {
        int length = comparables.length;
        Comparable temp;
        for (int i = length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (more(comparables[j - 1], comparables[j])) {
                    temp = comparables[j];
                    comparables[j] = comparables[j - 1];
                    comparables[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序 时间复杂度O(nlogn)(以二为底) 空间复杂度O(logn)(以二为底)
     *
     * @param comparables
     */
    public static void quickSort(Comparable[] comparables) {
        partQuickSort(comparables, 0, comparables.length - 1);
    }

    /**
     * 指定范围的数组进行快速排序
     *
     * @param comparables 要排序的数组
     * @param start       排序起始点
     * @param end         排序结束点
     */
    private static void partQuickSort(Comparable[] comparables, int start, int end) {
        if (start < 0 || end < 0) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        if (end > start) {
            return;
        }
        /**
         * 枢轴坐标
         */
        int pivot = start;
        int left = start, right = end;
        /**
         * 枢轴值
         */
        Comparable pivotVal = comparables[pivot];
        while (left != right) {
            while (left < right && lessOrEqual(pivotVal, comparables[right])) {
                right--;
            }
            if (left < right) {
                comparables[left] = comparables[right];
                left++;
            }
            while (left < right && moreOrEqual(pivotVal, comparables[left])) {
                left++;
            }
            if (left < right) {
                comparables[right] = comparables[left];
                right--;
            }
        }
        comparables[left] = pivotVal;
        partQuickSort(comparables, start, left - 1);
        partQuickSort(comparables, left + 1, end);
    }

    /**
     * 简单选择排序 时间复杂度O(n^2) 空间复杂度O(1)
     */
    public static void simpleSelectSort(Comparable[] comparables) {
        int length = comparables.length;
        int minIndex;
        Comparable minVal;
        for (int i = 0; i < length; i++) {
            minVal = comparables[i];
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (more(minVal, comparables[j])) {
                    minVal = comparables[j];
                    minIndex = j;
                }
            }
            comparables[minIndex] = comparables[i];
            comparables[i] = minVal;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{49, 38, 65, 97, 76, 13, 27, 49};
//        insertSort(a);
//        shellSort(a);
//        bubbleSort(a);
//        quickSort(a);
        simpleSelectSort(a);
        println(a);
    }

    private static boolean more(Comparable comparator, Comparable beenCompared) {
        return comparator.compareTo(beenCompared) > 0;
    }

    private static boolean less(Comparable comparator, Comparable beenCompared) {
        return comparator.compareTo(beenCompared) < 0;
    }

    private static boolean moreOrEqual(Comparable comparator, Comparable beenCompared) {
        return comparator.compareTo(beenCompared) >= 0;
    }

    private static boolean lessOrEqual(Comparable comparator, Comparable beenCompared) {
        return comparator.compareTo(beenCompared) <= 0;
    }

    public static void println(Comparable[] array) {
        StringBuilder builder = new StringBuilder();
        for (Comparable elem : array) {
            builder.append(elem);
            builder.append(" ");
        }
        System.out.println(builder.toString());
    }
}
