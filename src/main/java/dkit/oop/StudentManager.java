package dkit.oop;
// StudentManager encapsulates the storage and ability
// to manipulate student objects


import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StudentManager{

    private Map<Integer,Student> studentsMap;
    // Store all students in data structure

    public StudentManager() {

        studentsMap = new HashMap<>();
        // Hardcode some values to get started
        Student s1 = new Student(1234567,"20-04-20","abcdefg", "sean@sged.com");
        studentsMap.put(1234567, s1);
        // later, load from text file "students.dat" and populate studentsMap
    }

    public Student getStudent(Integer caonumber)
    {
        Student s = studentsMap.get(caonumber);
        if(s!=null)
            return new Student(s);
        else
            return null;
    }

    public void addStudent(Student student)
    {
        if (student ==null)
            throw new IllegalArgumentException();
        this.studentsMap.put(student.getCaoNumber(), new Student (student));
    }

    public Student removeStudent(Integer caoNumber)
    {
        Student s = studentsMap.get(caoNumber);
        if (s != null)
            studentsMap.remove(caoNumber);
        else
            return null;
        return s;
    }

    public void writeToFile()
    {

    }

//    isRegistered( caoNumber)
//        students.isValid(
}
