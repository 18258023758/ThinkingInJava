package chapter4;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zhangbj
 * @version 1.0
 * @Type VampireNumber
 * @Desc 吸血鬼数字练习
 * @data 2017/4/17
 */

public class VampireNumber {

    private static Map<Integer,String> vamMap = new HashMap<Integer, String>();

    public static Map getVampire(Integer digit){
        int from ;
        int to;
        int count = 0;
        int multDigit = (int) Math.pow(10,digit / 2 - 1);
        int fromDigit = (int) Math.pow(10,digit -1);
        int toDigit1 = (int) Math.pow(10,digit);
        int toDigit2 = (int) Math.pow(10,digit / 2);

       /* for (int index = multDigit;index < 10 * multDigit;index ++){
            *//*from = Math.max(1000 / i, i + 1);
            to = Math.min(10000 / i, 100);*//*
            from = Math.max(fromDigit / index,index + 1);
            to = Math.min(toDigit1 / index,toDigit2);
            for (int jndex = from; jndex < to;jndex++){

                int max = index * jndex;

                if (max % 100 == 0)
                    continue;

                char[] charsMax = String.valueOf(max).toCharArray();
                char[] charsMult = ArrayUtils.addAll(String.valueOf(index).toCharArray(),String.valueOf(jndex).toCharArray());

                Arrays.sort(charsMax);
                Arrays.sort(charsMult);

                if (Arrays.equals(charsMax,charsMult)){
                    count++;
                    vamMap.put(max,index + " x " + jndex + " = " + max);
                    //System.out.println("第" + count + "组吸血鬼数字为 ：" + index + " x " + jndex + " = " + max);
                }
            }
        }*/
        return vamMap;
    }

    public static Map<Integer, String> getVamMap() {
        return vamMap;
    }

    public static void setVamMap(Map<Integer, String> vamMap) {
        VampireNumber.vamMap = vamMap;
    }

    public static void main(String[] args) {
        Iterator<Map.Entry<Integer,String>> iterator = VampireNumber.getVampire(6).entrySet().iterator();
        int cou = 0;
        while (iterator.hasNext()){
            cou++;
            System.out.println("第" + cou + "组吸血鬼数字为 ：" + iterator.next().getValue());
        }

    }
}
