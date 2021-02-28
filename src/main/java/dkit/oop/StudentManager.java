//Sean Stephens D00211442

package dkit.oop;
// StudentManager encapsulates the storage and ability
// to manipulate student objects


import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class StudentManager{

    private Map<Integer,Student> studentsMap;
    private ArrayList<Student> studentList;
    // Store all students in data structure

    public StudentManager() {

        studentsMap = new HashMap<>();
        // Hardcode some values to get started
        Student s1 = new Student(1234567,"20-04-20","abcdefg", "sean@sged.com");
        Student s2 = new Student(6849204,"10-02-02","123456789", "eugene@gmail.com");
        Student s3 = new Student(2905836,"15-06-00","password", "paddy@outlook.com");
        Student s4 = new Student(8754629,"26-01-01","letmein", "ryan@yahoo.com");
        studentsMap.put(1244967, s1);
        loadStudentsFromFile();
        // later, load from text file "students.dat" and populate studentsMap
    }

    public Student getStudent(Integer caoNumber)
    {
        Student s = studentsMap.get(caoNumber);
        if(s!=null)
            return new Student(s);
        else
            return null;
    }

    public List<Student> getAllStudents()
    {
        List<Student> studentListCopy = new ArrayList<>();

        //carMap.entrySet();
        for (Map.Entry<Integer, Student> entry : studentsMap.entrySet())
        {
            Student s = entry.getValue(); // get the car from the entry set
            studentListCopy.add(new Student(s));
        }

        Set<Integer> keySet = studentsMap.keySet();
        for (Integer caoNumber: keySet)
        {
            Student s = studentsMap.get(caoNumber);
            studentListCopy.add(new Student(s));
        }
        return studentList;
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
        try(Scanner studentFile = new Scanner(new BufferedReader(new FileReader("students.dat"))))
        {
            String input;
            while(studentFile.hasNextLine())
            {
                input = studentFile.nextLine();
                String[] data = input.split(",");
                Integer caoNumber = Integer.parseInt(data[0]);
                String dateOfBirth = data[1];
                String password = data[2];
                String email = data[3];

                Student readInStudent = new Student( caoNumber, dateOfBirth, password, email);
                this.studentList.add(readInStudent);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void writeToStudentFile()
    {
        try(BufferedWriter studentFile = new BufferedWriter(new FileWriter("students.dat")))
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
