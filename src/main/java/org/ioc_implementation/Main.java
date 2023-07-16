package org.ioc_implementation;

public class Main {
    public static void main(String[] args) {
        IocContainer container = new IocContainer();
        container.register(TestForContianer.class,TestForContianerImpl.class);
        TestForContianer testForContianer = container.getInstance(TestForContianer.class);
        testForContianer.test();
    }
}