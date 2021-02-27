package dkit.oop;
// StudentManager encapsulates the storage and ability
// to manipulate student objects


import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManager{

    private Map<Integer,Student> studentsMap;
    private ArrayList<Student> studentList;
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

    public void loadStudentsFromFile()
    {
        try(Scanner studentFile = new Scanner(new BufferedReader(new FileReader("students.txt"))))
        {
            String input;
            while(studentFile.hasNextLine())
            {
                input = studentFile.nextLine();
                String[] data = input.split(",");
                String caoNumber = data[0];
                String dateOfBirth = data[1];
                String password = data[2];
                String email = data[3];

                Student readInStudent = new Course( caoNumber, dateOfBirth, password, email);
                this.studentList.add(readInStudent);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void writeToStudentFile()
    {
        try(BufferedWriter studentFile = new BufferedWriter(new FileWriter("students.txt")))
        {
            for(Student student : studentList)
            {
                studentFile.write(student.getCaoNumber() + ", " + student.getDayOfBirth() + ", " + student.getPassword() + ", " + student.getEmail());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

//    isRegistered( caoNumber)
//        students.isValid(
}
