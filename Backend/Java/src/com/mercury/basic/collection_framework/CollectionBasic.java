package com.mercury.basic.collection_framework;

import com.mercury.basic.HelloWorld;
import com.mercury.bean.CreditCard;
import com.mercury.bean.Employee;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionBasic<E, T> {

    public CollectionBasic() {
        this(1);
    }

    public CollectionBasic(int x) {
        super();
    }


    public T bar(List<? super T> t) {
        return null;
    }

    public static void main(String[] args) {
        // Array class
        // fixed type, fixed size
        // not thread safe
        // performance : good
        int[] nums = {1, 2, 0, 4};

        List<String> list = new ArrayList<String>();
        list.add("abc");

        List list2 = list;
        list2.add(1);

        System.out.println(list);

        int x = 1;
        Integer y = 1;  // boxing, auto-boxing

        int z = new Integer(2); // unboxing, auto-unboxing

        // ArrayList resizing rate : 1.5
        // not thread safe
        // performance : good
        // remove element will not shrink the internal elementData[]

        // vector:
        // all public function are sync, so thread safe
        // performance : bad
        // new Vector() directly start capacity from 10, new ArrayList() starts from 0
        // default resizing rate is : 2, or with a fixed resizing amount - capacity increment
        List v = new Vector(10, 5);
        v.add(1);

        new CollectionBasic();

        Stack s = new Stack();

        List<String> ll = new LinkedList();
        ll.add("a");

        // by a given index
        // remove the element from LinkedList - O(n)
        // remove the element from ArrayList - O(n)
        // not thread safe
        // performance : good

        Object o = new Object();
        System.out.println(o);

        // map :
        // 1. key-value pairs
        // 2. V get(k)
        // 3. key needs to be unique
        //    - different map can define unique in different way

        // unique in HashMap vs in TreeMap are different

        // HashMap :
        // V get(k) as O(1) as possible
        // thread not safe
        // performance : good
        // allows null key && null value
        HashMap hm = new HashMap();

        hm.put(null, 1);
        hm.put("a", null);
        System.out.println(hm);

        // Hashtable :
        // thread safe, sync all public functions
        // performance bad
        // initial capacity : 11
        // not allow null key nor null value
        Map ht = new Hashtable();
//        ht.put(null, 1);
//        ht.put("a", null);

        System.out.println(ht);

        // thread safe, and performance good
        // performance much better than HT, not as good as HM
        ConcurrentHashMap chm = new ConcurrentHashMap();

        // sorted
        // insertion ordered

        // not thread safe, performance good
        LinkedHashMap lhm = new LinkedHashMap();
        lhm.get("a");

        // sort by the key
        TreeMap tm = new TreeMap();
        tm.put(new CreditCard("123", "DEF", "56789"), "aaa");
        tm.put(new CreditCard("456", "ABC", "23456"), "aaa");
        tm.put(new CreditCard("789", "XYZ", "11223"), "aaa");

        System.out.println(tm);

//        Comparator c = new EmployeeComparator();

        // anonymous class / implementation
        Comparator<Employee> c = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getId() - o2.getId();
            }
        };

        TreeMap tm2 = new TreeMap();
//        tm2.put(new Employee(1), "aaa");
//        tm2.put(new Employee(5), "aaa");
//        tm2.put(new CreditCard("789", "XYZ", "11223"), "aaa");

        CreditCard cc1 = new CreditCard("789", "XYZ", "11223");
        CreditCard cc2 = new CreditCard("789", "XYZ", "11223");

        tm2.put(cc1, "aaa");
        tm2.put(cc2, "aaa");

        System.out.println(tm2);

        EmployeeComparator ec1 = new EmployeeComparator();
        EmployeeComparator ec2 = new EmployeeComparator();

        System.out.println("************");

        List al = new ArrayList<Integer>() {
            @Override
            public boolean add(Integer i) {
                System.out.println("Adding " + i + " into my Arraylist");
                return true;
            }
        };
        al.add(1);
        al.add(2);

        System.out.println(al);

        Set<Integer> hs = new HashSet();
        hs.add(1);
        hs.add(2);
    }

    public static class EmployeeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            // return positive : e1 > e2
            return e1.getId() - e2.getId();
        }
    }
}
