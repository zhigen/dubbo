package com.zglu.api;

public class BServiceMock implements BService {

    @Override
    public String test(int milliseconds) {
        return "Service2Mock test(int)";
    }
}
