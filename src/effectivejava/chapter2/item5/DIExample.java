package effectivejava.chapter2.item5;

import java.util.Objects;

/**
 * 依赖注入示例代码
 *
 * @author Dave Wang
 */
public class DIExample {

    private final Lexicon dictionary;

    /**
     * 通过构造器注入
     */
    public DIExample(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        // 验证 word 是否在 dictionary 中
        return false;
    }

    static class Lexicon {

    }
}
