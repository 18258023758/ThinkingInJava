/**
 * @author zhangbj
 * @version 1.0
 * @Type Solution
 * @Desc
 * @data 2017/10/30
 */

public class Solution {

    public void sortIntegers(int[] A) {
        // write your code here
        for (int index = A.length; index >0 ;index--){
            for (int jndex = 0;jndex <index -1;jndex++){
                if (A[jndex] > A[jndex+1]){
                    int tmp = A[jndex];
                    A[jndex] = A[jndex+1];
                    A[jndex+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {3, 2, 1, 4, 5};
        solution.sortIntegers(a);

    }
}
