package com.mercury.basic.oop;

public class PolyTest {


    public static class House {

        public House() {
            win();
        }

        public void roof() {
            System.out.println("Par roof");
        }

        private void win() {
            System.out.println("Par win");
        }

        public void door() {
            System.out.println("Par door");
        }
    }

    public static class MyHouse extends House {

        public MyHouse() {
//            super();
            win();
        }

//        @Override
        public void win() {
            System.out.println("Sub win");
        }

        public void tree() {
            System.out.println("Sub tree");
        }

        public int tree(int x) {
            return 1;
        }
    }

    public static void main(String[] args) {
        MyHouse mh = new MyHouse();
//        mh.roof();
//        mh.win();
//        mh.tree();
//        System.out.println("-----------------");
//
//        House h = new MyHouse();
//        h.roof();
//        // calling the sub win()
//        // cause it's object level function, coming from the object
//        h.win();
////        h.tree();
//        System.out.println("------------------");
//
//        // downcasting, need to make sure:
//        // 1. object need to be available for that type
//        // 2. need to mention the type
//        MyHouse mh2 = (MyHouse) h;
//        mh2.roof();
//        mh2.win();
//        mh2.tree();
//
//        A a = new A();
//        B b = (B)a;
//
//        System.out.println(123);
//        System.out.println("abc");


    }

    public static class A{

    }

    public static class B extends A{

    }
}
