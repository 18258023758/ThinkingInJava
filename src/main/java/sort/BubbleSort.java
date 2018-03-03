package sort;

import java.util.Arrays;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc 冒泡算法
 * @date 2018/2/28
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] a){
        int length = a.length;

        for (int i=0;i<length-1;i++){
            for (int j=0;j<length-1-j;j++){
                if (a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    System.out.println(Arrays.toString(a));
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int A[] = { 6, 5, 3, 1, 8, 7, 2, 4 };
        System.out.println("********"+Arrays.toString(bubbleSort(A)));
    }
}
