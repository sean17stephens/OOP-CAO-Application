package dkit.oop;

public class Course {

    private String courseId;   // e.g. DK821
    private Integer level;      // e.g. 7, 8, 9, 10
    private String title;      // e.g. BSc in Computing in Software Development
    private String institution; // Dundalk Institute of Technology

    // Copy Constructor
    // Accepts a Course object as an argument and copies all the field values
    // into a new Course object. Returns the new cloned object.
    // (add here)



    // Constructor
    public Course(String courseId, Integer level,String title, String institution) {
        this.courseId = courseId;
        this.level = level;
        this.title = title;
        this.institution = institution;
    }

    public Course(Course course) {
        this.courseId = course.courseId;
        this.level = course.level;
        this.title = course.title;
        this.institution = course.institution;
    }



    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public String getInstitution() {
        return institution;
    }
    public void setInstitution(String institution) {
        this.institution = institution;
    }
    public String getTitle() { return title;  }
    public void setTitle(String title) { this.title = title; }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", level='" + level + '\'' +
                ", institution='" + institution + '\'' +
                '}';
    }
}
