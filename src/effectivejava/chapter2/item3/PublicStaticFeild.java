package effectivejava.chapter2.item3;

import java.io.Serializable;

/**
 * 公有静态成员变量
 * 
 * @author  Dave Wang
 */
public class PublicStaticFeild implements Serializable {
    public static final PublicStaticFeild INSTANCE = new PublicStaticFeild();

    private PublicStaticFeild() {
        if (INSTANCE != null) {
            throw new IllegalArgumentException("instance is not null");
        }
    }

    private Object readResovle() {
        return INSTANCE;
    }

}
