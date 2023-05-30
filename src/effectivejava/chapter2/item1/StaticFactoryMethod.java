package effectivejava.chapter2.item1;

/**
 * 第 1 条：用静态工厂方法代替构造器
 * 
 * @author Dave Wang
 */
public class StaticFactoryMethod {

    private StaticFactoryMethod() {
    }

    /**
     * Creates and returns a new instance of the StaticFactoryMethod class.
     *
     * @return  a new instance of the StaticFactoryMethod class
     */
    public static StaticFactoryMethod getInstance() {
        return new StaticFactoryMethod();
    }

}