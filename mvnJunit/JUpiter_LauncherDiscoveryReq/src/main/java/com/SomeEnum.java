package com;

public enum SomeEnum {
    FOR(50); // 5_00_000_000
    private final int count;

    SomeEnum(int count) {
        this.count = count;
    }

    public int getNum() {
        return count;
    }
}