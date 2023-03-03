package com.mercury.bean;

import com.mercury.basic.CloneTest;

// java bean : the most basic operation unit in a Java application
// marker interface : empty, used for marking some information
public class Employee implements Cloneable {

    private int id;
    private String name;
    private boolean done;
    private Phone phone;

    // constructor : function
    // 1. same name as class name
    // 2. no return type
    // 3. public / private
    // 4. object level function
    // 5. by default, if not constructor is provided, default constructor exist
    //    if any constructor is manually provided, the no more default constructor
    // 6. new, will call constructor once the object is created, to initialize
    // 7. for each object, constructor can only be called once after its creation
    // 8. can be overloaded, cannot be overridden

    // 9. when new is calling constructor, it will call it's parent default constructor by default
    // 10. super() is by default as the 1st line of each constructor
    // 11. 1st line of each constructor is either super() or this()

    public Employee() {
        super();
        System.out.println("Creating emp");
    }

    public Employee(int id) {
        this.id = id;
        System.out.println("Creating emp: " + id);
    }

    public Employee(int id, String name, boolean done, Phone phone) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.phone = phone;
    }


    public static class MsiEmployee extends Employee {
        public MsiEmployee() {
            System.out.println("Creating MSI emp");
        }

        public MsiEmployee(int id) {
            super(1);
            System.out.println("Creating MSI emp: " + id);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        // current object, where the function is coming / calling from
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", done=" + done + '\'' +
                ", phone=" + phone +
                '}';
    }

    @Override
    public Employee clone(){
        // deep copy need to manully create each field and assign them into new Object
//        return new Employee(id, name, done, phone);

        Employee e = null;

        try {
            e = (Employee) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static void main(String[] args) {
        Employee e = new MsiEmployee(1);
        System.out.println(e);

//        Employee e1 = new Employee();
//        CloneTest ct = new CloneTest();
//
//        try {
//            e1.clone();
//            ct.clone();
//        }catch (Exception ep) {
//            ep.printStackTrace();
//        }
    }
}
