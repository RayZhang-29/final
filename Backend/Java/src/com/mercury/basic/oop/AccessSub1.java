package com.mercury.basic.oop;

public class AccessSub1 extends AccessPar {

    @Override
    public void f5() {}

    @Override
    public void f6() {}

    @Override
    void f7() {}

    public void x(){}

//    @Override
//    private void f8() {}

    public static void main(String[] args) {
        AccessPar.f1();
        AccessPar.f2();
        AccessPar.f3();
//        AccessPar.f4();
    }
}
