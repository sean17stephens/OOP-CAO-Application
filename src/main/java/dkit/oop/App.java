package dkit.oop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Notes:
 *  Synchronisation of multiple reads and writes to file is not considered here.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "CAO Online - CA4" );
        new App() .start();
    }

    private void start() {

        // load students
        StudentManager studentManager = new StudentManager();

        // load courses
        CourseManager courseManager= new CourseManager();

        // load manager to provide functionality to allow a student
        // to login and add/update their course selections
        // This CourseChoicesManager component depends on the
        // StudentManager and the CourseManager,
        // so we 'inject' or pass-in these objects.
        //
        CourseChoicesManager mgr = new CourseChoicesManager(studentManager, courseManager);

        //STORING CHOICES FOR STUDENT
        ArrayList<String> list = new ArrayList<>();
        list.add("DK821");
        list.add("DN150");
        list.add("TUD350");
        //add/update students choices
        mgr.updateChoices(1234567, list);
        //get the students current choices
        List<String> currentChoicesList = mgr.getStudentChoices(1234567);
        //display the students choice. iterate over currentChoicesList
        // mgr.getCourseDetails();



        // display a menu to do things
        // manual testing of mgr public interface

//        if ( mgr.login(22224444, "xxxx","bbbb") )
//        {
//            Student student = mgr.getStudentDetails(22224444);
//
//            System.out.println("Student: " + student);
//        }
//        else
//            System.out.println("Not logged in - try again");


        //mgr.saveToFile();

    }
}
