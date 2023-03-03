package com.mercury.basic.singleton;

// suggest for interview

// 1. class loading
// 2. class initializing

public class HolderSingleton {
    private HolderSingleton(){}

    // static inner class will be loaded when class is loading
    // but will not been initialized until this class is used (lazy init)
    private static class Holder {
        private static HolderSingleton hs = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return Holder.hs;
    }
}
