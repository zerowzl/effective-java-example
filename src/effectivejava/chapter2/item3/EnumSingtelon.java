package effectivejava.chapter2.item3;

/**
 * 包含单个元素的枚举。
 * 枚举类默认实现 Serializable 接口，保证在序列化和反序列化时不会创建新的实例
 * 
 * @author  Dave Wang
 */
public enum EnumSingtelon {
    INSTANCE;

    public void doSomething() {
        System.out.println("do something");
    }
}
