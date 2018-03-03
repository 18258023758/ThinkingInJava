package sort;

import java.util.Arrays;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc 希尔排序 不稳定排序 （分割为多块的直接插入排序）
 * @date 2018/2/28
 */
public class ShellSort {

    public static void shellSort(int[] a){
        int length = a.length;
        int div = length/2;
        while (div >=1) {
            shellInsertSort(a, div);
            div /= 2;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void shellInsertSort(int[] a,int div){
        int length = a.length;
        for (int i=div;i<length;i++){
            if (a[i]<a[i-div]){
                int tmp = a[i];
                int j;
                for (j=i-div;j>=0&& tmp<a[j];j-=div){
                    a[j+div] = a[j];
                }
                a[j+div] = tmp;
            }

        }
    }

    public static void main(String[] args) {
        int a[] = {3,1,5,7,2,4,9,6,10,8};
        shellSort(a);
    }
}
