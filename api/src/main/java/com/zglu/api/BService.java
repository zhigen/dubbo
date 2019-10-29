package com.zglu.api;

public interface BService {

    default String test(int milliseconds) {
        return "Service2 test(int) 默认方法";
    }
}
