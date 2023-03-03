package com.mercury.bean;

public class StudentBuilder {
    private Student student;

    public StudentBuilder() {
        this.student = new Student();
    }

    public StudentBuilder withId(int id) {
        student.setId(id);
        return this;
    }

    public StudentBuilder withFirstName(String firstName) {
        student.setFirstName(firstName);
        return this;
    }

    public StudentBuilder withLastName(String lastName) {
        student.setLastName(lastName);
        return this;
    }

    public Student getStudent(){
        return student;
    }
}
