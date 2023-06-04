package effectivejava.chapter2.item2;

/**
 * 普通的构建器模式
 * 
 * @author Dave Wang
 */
public class BuilderPattern {

    private final int a1;
    private final int a2;
    private final int a3;
    private final int a4;
    private final int a5;
    private final int a6;

    public static class Builder {
        // 必填
        private final int a1;
        private final int a2;

        // 选填，默认值为0
        private int a3 = 0;
        private int a4 = 0;
        private int a5 = 0;
        private int a6 = 0;

        public Builder(int a1, int a2) {
            this.a1 = a1;
            this.a2 = a2;
        }

        public Builder a3(int a3) {
            this.a3 = a3;
            return this;
        }

        public Builder a4(int a4) {
            this.a4 = a4;
            return this;
        }

        public Builder a5(int a5) {
            this.a5 = a5;
            return this;
        }

        public Builder a6(int a6) {
            this.a6 = a6;
            return this;
        }

        public BuilderPattern build() {
            // 可以对参数进行验证
            // 可以设置默认值
            return new BuilderPattern(this);
        }
    }

    private BuilderPattern(Builder builder) {
        this.a1 = builder.a1;
        this.a2 = builder.a2;
        this.a3 = builder.a3;
        this.a4 = builder.a4;
        this.a5 = builder.a5;
        this.a6 = builder.a6;
    }

    public static void main(String[] args) {
        BuilderPattern.Builder builder = new BuilderPattern.Builder(1, 2);
        BuilderPattern pattern = builder.a3(3).build();
    }
}
