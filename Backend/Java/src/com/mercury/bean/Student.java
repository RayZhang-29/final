package com.mercury.bean;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;
import java.util.Random;

// deserialization using Externalizable requires default constructor
public class Student implements Externalizable {
    private int id;
    transient private String firstName;
    private String lastName;

    public Student() {
        System.out.println("Creating student");
    }

    public Student(int id, String firstName, String lastName) {
        System.out.println("Creating student with info");
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // hashCode :
    // return the same value if 2 objects looks the same
    // return different value if 2 objects looks different

//    @Override
//    public int hashCode() {
//        return id * 7 + firstName.hashCode() * 11 + lastName.hashCode() * 17;
//    }

    // equals:
    // return true if 2 objects looks the same
    // return false if 2 objects looks different

//    @Override
//    public boolean equals(Object o) {
//
////        if(!(o instanceof Student)) {
////            return false;
////        }
//
//        if(o == null)
//            return false;
//
//        if(o.getClass() != this.getClass())
//            return false;
//
//        Student input = (Student)o;
//
//        if(id != input.id)
//            return false;
//
////        if(this.firstName.equals(input.firstName))
//
//        return true;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    // below 2 functions provided by Externalizable interface can be used to
    // customize the logic of serialization && deserialization

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(firstName);
        out.writeObject(lastName);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.id = in.readInt();
        this.lastName = (String)in.readObject();
        this.firstName = (String)in.readObject();
    }
}
