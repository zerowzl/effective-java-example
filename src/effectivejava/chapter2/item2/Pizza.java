package effectivejava.chapter2.item2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * 具有类层次结构的构建器模式
 * 
 * @author Dave Wang
 */
public abstract class Pizza {

    public enum Topping {
        HAM, MUSHROON, ONION, PEPPEER, SAUSAGE
    }

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();
        
        // 子类返回自己的类型
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }

}
