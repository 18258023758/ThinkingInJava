/**
 * @author zhangbj
 * @version 1.0
 * @Type IdCardvalidate
 * @Desc
 * @data 2017/5/4
 */

public class IdCardvalidate {

    private String value1,value2,value3,value4;

    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return "IdCardvalidate{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", value4='" + value4 + '\'' +
                ", source=" + source +
                ", i=" + i +
                ", f=" + f +
                '}';
    }

    public static void main(String[] args) {
        IdCardvalidate idCardvalidate = new IdCardvalidate();
        System.out.println(idCardvalidate);
    }

}

class WaterSource{
    private String s;

    WaterSource(){
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    public String toString() {
        return s;
    }
}