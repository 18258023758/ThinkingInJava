/**
 * @author zhangbj
 * @version 1.0
 * @Type Rectangle
 * @Desc
 * @data 2017/10/30
 */

public class Rectangle {
    private int width;

    private int height;

    public Rectangle(int width,int height){
        this.width = width;
        this.height = height;
    }

    public int getArea(){
        return width * height;
    }
}
