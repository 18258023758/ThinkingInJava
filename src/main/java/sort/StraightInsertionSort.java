package sort;

import java.util.Arrays;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc 插入排序--直接插入排序 时间复杂度O(n²) 算法稳定
 * @date 2018/2/28
 */
public class StraightInsertionSort {

    public static void straightInsertionSort(int[] a){
        int size = a.length;
        //遍历
        for (int i =1;i<size;i++){
            //定义临时变量存储当前元素
            int tmp = a[i];
            //循环外定义变量，方便将值放置
            int j;
            //循环原数组tmp下标次数，tmp值与（假定）有序数组中各元素比较
            for (j = i;j>0&&tmp<a[j-1];j--){
                //若满足条件，将（假定）有序部分后移
                a[j] = a[j-1];
            }
            //将值插入该位置
            a[j] = tmp;
            System.out.println(Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int a[] = {3,1,5,7,2,4,9,6,10,8};
        straightInsertionSort(a);
    }
}
