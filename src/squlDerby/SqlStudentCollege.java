package squlDerby;
/**
 * Sql commands for StudentCollege table related tasks
 * The StudentCollege table allows a many-to-many relationship by matching students to colleges
 */
public class SqlStudentCollege {
    /**
     * @return command to create a StudentCollege table.
     */
    public static String createTable() {
        return "CREATE TABLE StudentCollege ("
                + "StudentId int,"
                + "CollegeId int"
                + ")";
    }

    /**
     * @return command to create a database URL.
     */
    public static String databaseURL() {
        return "jdbc:derby:FirstDatabase;create=true";
    }

    /**
     * @return command to add student id and college id into a table.
     */
    public static String insertData() {
        return "INSERT INTO StudentCollege (StudentId, CollegeId) VALUES"
                + "(1234, 126),"
                + "(1235, 123),"
                + "(1235, 124),"
                + "(1236, 127),"
                + "(1237, 125)"
                ;
    }
    /**
     * @return command to select all the data from the StudentCollege table.
     */
    public static String allData() {
        return "SELECT * FROM StudentCollege";
    }

    /**
     * @return command to drop the StudentCollege table.
     */
    public static String dropTable(){
        return "DROP TABLE StudentCollege";
    }

    /**
     * @return inner join command for joining information from student table and college table together.
     */
    public static String studentCollegeInfo(){
        return
            "SELECT s.FirstName, s.LastName, c.School "
                + "FROM Student s "
                + "INNER JOIN StudentCollege sc ON s.Id = sc.StudentId "
                + "INNER JOIN College c ON sc.CollegeId = c.Id ";

    }
}
