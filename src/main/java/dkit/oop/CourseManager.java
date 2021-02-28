//Sean Stephens D00211442

package dkit.oop;


import java.io.*;
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
        Course c2 = new Course("SIT587",8,"Bsc in Accounting", "Sligo Institute of Technology");
        Course c3 = new Course("CIT879",7,"Bsc in Building Surveying", "Carlow Institute of Technology");
        Course c4 = new Course("DK546",8,"Bsc in Civil Engineering", "Dundalk Institute of Technology");
        courseMap.put("DK871", c1);
        courseMap.put("SIT385", c2);
        courseMap.put("CIT039", c3);
        courseMap.put("DK231", c4);
        //loadCoursesFromFile();
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
        writeToCourseFile();
    }

    public Course removeCourse(String courseID)
    {
        Course c = courseMap.get(courseID);
        if (c != null)
            courseMap.remove(courseID);
        else
            return null;
        return c;
    }

    public void printAllCourses()
    {
        for(Map.Entry c : courseMap.entrySet())
        {
            System.out.println(c.getValue());
        }
    }

    public void loadCoursesFromFile()
    {
        try(Scanner courseFile = new Scanner(new BufferedReader(new FileReader("courses.dat"))))
        {
            String input;
            while(courseFile.hasNextLine())
            {
                input = courseFile.nextLine();
                String[] data = input.split(",");
                String courseID = data[0];
                Integer level = Integer.parseInt(data[1]);
                String title = data[2];
                String institution = data[3];

                Course readInCourse = new Course( courseID, level, title, institution);
                this.courseList.add(readInCourse);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void writeToCourseFile()
    {
        try(BufferedWriter courseFile = new BufferedWriter(new FileWriter("courses.dat")))
        {
            for(Course course : courseList)
            {
                courseFile.write(course.getCourseId() + ", " + course.getLevel() + ", " + course.getTitle() + ", " + course.getInstitution());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    // editCourse(courseId);       // not required for this iteration

}







