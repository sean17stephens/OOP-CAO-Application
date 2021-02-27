//Sean Stephens D00211442

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
    HashMap<String,Course> courseMap = new HashMap<>();

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

    public List<Course> getAllCourses()
    {
        List<Course> courseListCopy = new ArrayList<>();

        //carMap.entrySet();
        for (Map.Entry<String, Course> entry : courseMap.entrySet())
        {
            Course c = entry.getValue(); // get the car from the entry set
            courseListCopy.add(new Course(c));
        }

        Set<String> keySet = courseMap.keySet();
        for (String courseID: keySet)
        {
            Course c = courseMap.get(courseID);
            courseListCopy.add(new Course(c));
        }
        return courseListCopy;
    }
//
//    boolean login() {
//    }


}
