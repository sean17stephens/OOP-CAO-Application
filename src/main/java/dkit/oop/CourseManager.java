package dkit.oop;


import java.util.*;

/**
 * CoursesManager
 * This software component Encapsulates the storage and management of
 * all courses available through the CAO system.
 * Only administrators would typically be allowed to update this data,
 * but other users can get a COPY of all the courses by calling getAllCourses().
 * The Web Client would need this data to display the course codes,
 * course titles and institutions to the student.
 */

public class CourseManager {

    private Map<String,Course> courseMap;
    private ArrayList<Course> courseList;
    // Store all the Course details.
    // Requires fast access given courseId.

    public CourseManager() {
        courseMap = new HashMap<>();
        // Hardcode some values to get started
        Course c1 = new Course("DK321",7,"Bsc in Software Development", "Dundalk Institute of Technology");
        courseMap.put("DK871", c1);
        // Hardcode some values to get started
        // load from text file "courses.dat" and populate coursesMap
    }

    public Course getCourse(String courseID)
    {
        Course c = courseMap.get(courseID);
        if(c!=null)
            return new Course(c);
        else
            return null;
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
        return courseList;
    }

    public void addCourse(Course course)
    {
        if (course ==null)
            throw new IllegalArgumentException();
        this.courseMap.put(course.getCourseId(), new Course (course));
    }

    public Course removeCourse(Integer courseID)
    {
        Course c = courseMap.get(courseID);
        if (c != null)
            courseMap.remove(courseID);
        else
            return null;
        return c;
    }

    // editCourse(courseId);       // not required for this iteration

}







