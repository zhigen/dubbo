package com.zglu.api;

public interface TestService2 {

    default String test(int milliseconds) {
        return "testDefault";
    }
}
