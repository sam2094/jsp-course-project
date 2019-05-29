package model;

public class Schedule extends  CourseModel {
    private Student student;
    private University university;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "student=" + student +
                ", university=" + university +
                '}' + "\n";
    }
}
