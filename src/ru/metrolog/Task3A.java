package ru.metrolog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.System.*;

public class Task3A {
    ArrayList<Student> studentArray;

    /* Task3A-1 */
    public void printStudentList() {
        initStudentArray();

        out.println("\nList of Phisics Department:");
        for (Student student : studentArray) {
            if (student.department == Department.OfPhysic) {
                out.println(student.toString());
            }
        }

        out.println("\nList of Computer Science Department 3 course:");
        for (Student student : studentArray) {
            if ( (student.department == Department.OfComputerScience) &&
                    (student.course == 3 ) ) {
                out.println(student.toString());
            }
        }

        out.println("\nList of students have born before 1990:");
        for (Student student : studentArray) {
            if (student.birthday.get(Calendar.YEAR) < 1990) {
                out.println(student.toString() + ", " + student.birthday.get(Calendar.YEAR));
            }
        }
    }

    private void initStudentArray() {

        studentArray = new ArrayList<>();

        Student student = new Student("Ivanov", "Boris", "Nikolaevich");
        student.setBirthday(new GregorianCalendar(1990, 05, 21));
        student.setDepartment(Department.OfComputerScience);
        student.setGroup(12);
        student.setCourse(3);
        studentArray.add(student);

        student = new Student("Kuznetsov", "Oleg", "Petrovich");
        student.setBirthday(new GregorianCalendar(1989, 05, 21));
        student.setDepartment(Department.OfComputerScience);
        student.setGroup(12);
        student.setCourse(3);
        studentArray.add(student);

        student = new Student("Knuth", "Donald", "Edwards");
        student.setBirthday(new GregorianCalendar(1987, 05, 21));
        student.setDepartment(Department.OfComputerScience);
        student.setGroup(11);
        student.setCourse(3);
        studentArray.add(student);

        student = new Student("Landau", "Lev", "Davidovich");
        student.setBirthday(new GregorianCalendar(1990, 05, 21));
        student.setDepartment(Department.OfPhysic);
        student.setGroup(12);
        student.setCourse(3);
        studentArray.add(student);

        student = new Student("Saharov", "Andrey", "Dmitrievich");
        student.setBirthday(new GregorianCalendar(1990, 05, 21));
        student.setDepartment(Department.OfPhysic);
        student.setGroup(12);
        student.setCourse(3);
        studentArray.add(student);

        student = new Student("Chebushev", "Pafnutii", "Lvovich");
        student.setBirthday(new GregorianCalendar(1990, 05, 21));
        student.setDepartment(Department.OfMath);
        student.setGroup(11);
        student.setCourse(3);
        studentArray.add(student);

        student = new Student("Markov", "Alexandr", "Andreevich");
        student.setBirthday(new GregorianCalendar(1990, 05, 21));
        student.setDepartment(Department.OfMath);
        student.setGroup(11);
        student.setCourse(4);
        studentArray.add(student);

        student = new Student("Ventsel", "Elena", "Sergeevna");
        student.setBirthday(new GregorianCalendar(1990, 05, 21));
        student.setDepartment(Department.OfMath);
        student.setGroup(12);
        student.setCourse(4);
        studentArray.add(student);

    }

}

enum Department {OfMath, OfPhysic, OfComputerScience}

class Student {

    static int counter;

    int id;
    String lastName;
    String name;
    String fathersName;

    Calendar birthday;
    String address;
    String phone;
    Department department;
    int course;
    int group;

    public Student(String lastName, String name, String fathersName) {
       this.id = counter++;
       this.lastName = lastName;
       this.name = name;
       this.fathersName = fathersName;
    }

    public void setBirthday(GregorianCalendar birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return new String("Student Id:" + this.id + "; Last name: " + this.lastName);
    }
}