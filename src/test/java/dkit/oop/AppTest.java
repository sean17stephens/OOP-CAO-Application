//Sean Stephens D00211442

package dkit.oop;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public void testStudentClone ()
    {
        Student s1 = new Student(1234567,"20-04-12","asdfhe", "sean@shejd.com");

        Student s2 = new Student(s1); //clone

        assert (s1 != s2);

        assert(s1.equals(s2));

        s2.setCaoNumber(6475838);

        assert(!s1.equals(s2));
    }

    public void testCourseClone ()
    {
        Course c1 = new Course("DK321",7,"Bsc in Software Development", "Dundalk Institute of Technology");

        Course c5 = new Course(c1);

        assert (c1 != c5);

        assert(!c1.equals(c5));

        c5.setInstitution("Carlow Institute of Technology");

        assert(!c1.equals(c5));
    }


}
