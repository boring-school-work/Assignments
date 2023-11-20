/**
 * Entry class
 * 
 * @author David Saah
 * @version 1.0
 * @since 2023-11-20
 */
public class Entry {
    private String studentID; // key
    private double grade; // value

    /**
     * Entry constructor
     * 
     * @param studentID the student's ID
     * @param grade    the student's grade
     */
    public Entry(String studentID, double grade) {
        this.studentID = studentID;
        this.grade = grade;
    }

    /**
     * Get the student's ID
     * 
     * @return the student's ID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Get the student's grade
     * 
     * @return the student's grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Set the student's ID
     * 
     * @param studentID the student's ID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Set the student's grade
     * 
     * @param grade the student's grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }
}