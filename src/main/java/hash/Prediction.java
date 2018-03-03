package hash;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/13
 */
public class Prediction {

    private boolean shadow = Math.random()>0.5;

    @Override
    public String toString() {
        return this.shadow?"Six More":"Spring Coming";
    }
}
