package dkit.oop;

// Stores all student CAO choices.
// Allows student to make course choices, save them and update them later.
//
// emphasis on speed of access when multiple users are accessing this at same time
//
// This component would interact with a Network component that would, in turn, send
// data over the internet to a web client.
//
// Clone all received and returned objects - encapsulation

import java.util.*;

public class CourseChoicesManager {

    // reference to constructor injected studentManager
    private StudentManager studentManager;

    // reference to constructor injected courseManager
    private CourseManager courseManager;

    // Store all the Course details -  fast access

    // caoNumber, course selection list - for fast access


    // CourseChoicesManager DEPENDS on both the StudentManager and CourseManager to access
    // student details and course details.  So, we receive a reference to each via
    // the constructor.
    // This is called "Dependency Injection", meaning that we
    // inject (or pass in) objects that this class requires to do its job.
    //
    HashMap<Integer,List<String>> selectedChoices = new HashMap<>();
    HashMap<Integer,List<String>> courseDetails = new HashMap<>();

    CourseChoicesManager(StudentManager studentManager, CourseManager courseManager) {
        this.studentManager = studentManager;
        this.courseManager = courseManager;
        List<Course> courseList = this.courseManager.getAllCourses();
        Student studentsMap = this.studentManager.getStudent(1234567);
    }

//    public Student getStudentDetails() {
//    }
//
      public List<String> getCourseDetails(String courseID) {
        return courseDetails.get(courseID);
      }
//
      public List<String> getStudentChoices(int caoNumber) {
        return selectedChoices.get(caoNumber);
      }

      void updateChoices(int caoNumber, List<String> choices) {
        selectedChoices.put(caoNumber, choices);
      }
//
//    public  getAllCourses() {
//    }
//
//    boolean login() {
//    }


}
