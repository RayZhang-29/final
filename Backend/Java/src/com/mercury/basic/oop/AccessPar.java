package com.mercury.basic.oop;

public class AccessPar {

    // static function cannot be overridden

    // to call a function

    // public function can be called from anywhere
    // protected function can be called from same package, or sub classes
    // package function can only be called from same package
    // private function can only be called within same class
    public static void f1() {}
    protected static void f2() {}
    static void f3() {}
    private static void f4() {}

    // to override a function

    // public function can be overridden from anywhere
    // protected function can be overridden from anywhere
    // package function can only be overridden from same package
    // private function cannot be overridden
    public void f5() {}
    protected void f6() {}
    void f7() {}
    private void f8() {}
}
