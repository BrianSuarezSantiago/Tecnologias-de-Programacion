import tp.practicas.*;

class College {
    private static OfferedCourses offeredCourses = new OfferedCourses();
    private static EnrolledStudents enrolledStudents = new EnrolledStudents();
    
    private static void init(OfferedCourses offeredCourses, EnrolledStudents enrolledStudents) {
        offeredCourses.addCourse(new Course(100, "Mathematic"));
        offeredCourses.addCourse(new Course(101, "Language"));
        offeredCourses.addCourse(new Course(102, "History"));
        offeredCourses.addCourse(new Course(103, "Geography"));
        offeredCourses.addCourse(new Course(104, "Physics"));
        offeredCourses.addCourse(new Course(108, "Biology"));
        offeredCourses.addCourse(new Course(110, "Chemistry"));
        offeredCourses.addCourse(new Course(111, "Earth Science"));
        Student s1 = new Student(4, "Fulano");
        s1.enrollCourse(offeredCourses.getCourse(100));
        s1.enrollCourse(offeredCourses.getCourse(101));
        enrolledStudents.addStudent(s1);
        Student s2 = new Student(2, "Mengano");
        s2.enrollCourse(offeredCourses.getCourse(101));
        s2.enrollCourse(offeredCourses.getCourse(103));
        enrolledStudents.addStudent(s2);
        enrolledStudents.addStudent(new Student(3, "Zutano"));
    }

    public static void main (String[] args) {
        init(offeredCourses, enrolledStudents);
        System.out.println(enrolledStudents.getStudent(4));
        System.out.println(enrolledStudents.getStudent(2));
        System.out.println(enrolledStudents.getStudentsOrderByName());
        System.out.println(enrolledStudents.getStudentsOrderById());
        System.out.println(enrolledStudents.getStudentsByCourse(100));
        System.out.println(enrolledStudents.getStudentsByCourse(101));
        System.out.println(enrolledStudents.getStudentsByCourse(103));
        System.out.println(enrolledStudents.getStudentsByCourse(1));
    }
}

/* A continuación se muestra la salida esperada de la ejecución del main
4-Fulano[(100)Mathematic, (101)Language]
2-Mengano[(101)Language, (103)Geography]
[4-Fulano[(100)Mathematic, (101)Language], 2-Mengano[(101)Language, (103)Geography], 3-Zutano[]]
[2-Mengano[(101)Language, (103)Geography], 3-Zutano[], 4-Fulano[(100)Mathematic, (101)Language]]
[4-Fulano[(100)Mathematic, (101)Language]]
[2-Mengano[(101)Language, (103)Geography], 4-Fulano[(100)Mathematic, (101)Language]]
[2-Mengano[(101)Language, (103)Geography]]
[]
*/
