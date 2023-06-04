package effectivejava.chapter2.item3;

/**
 * 公有静态工厂
 * 
 * @author  Dave Wang
 */
public class StaticFactoryMethod {
    
    private static final StaticFactoryMethod INSTANCE = new StaticFactoryMethod();

    private StaticFactoryMethod() {
        if (INSTANCE != null) {
            throw new IllegalArgumentException("instance is not null");
        }
    }

    public static StaticFactoryMethod getInstance() {
        return INSTANCE;
    }

    private Object readResovle() {
        return INSTANCE;
    }


}
