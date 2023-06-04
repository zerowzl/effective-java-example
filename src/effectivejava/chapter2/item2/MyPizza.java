package effectivejava.chapter2.item2;

import java.util.Objects;

import static effectivejava.chapter2.item2.Pizza.Topping.*;

/**
 * 具有类层次结构的构建器模式
 * 
 * @author Dave Wang
 */
public class MyPizza extends Pizza {

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public MyPizza build() {
            return new MyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }

    private MyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    public static void main(String[] args) {
        MyPizza pizza = new MyPizza.Builder(Size.LARGE)
                .addTopping(HAM).addTopping(ONION).build();
    }
}
