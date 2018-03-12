import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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


    // 评测题目: 请实现以下shell脚本的功能   (题目中awk表示取第三列)
// cat /home/admin/logs/webx.log | grep "login" | awk '{print $3}' | sort | uniq -c | sort -k 2r
// ------------------
    // 902 login lilei www.taobao.com
    // 220 login hmm s.taobao.com
    // 499 visit  cde i.taobao.com
    // 879 login  lilei s.taobao.com
// ------------------
// 输出
//     2 lilei
//     1 hmm
// ————————-


    public static void main(String[] args) throws IOException {
        String path = "F:\\webx.log";
        String findWord = "login";
        Integer printNumber = 3;
        Set<String> set;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            set= new TreeSet<String>();
            String s;
            while ((s = reader.readLine())!=null){
                if (s.indexOf(findWord)!=-1){
                    String[] strings = s.split("\\s+");
                    set.add(strings[printNumber -1]);
                }
            }
            int index = set.size();
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(index-- +" "+iterator.next());
            }
        }
    }


}
