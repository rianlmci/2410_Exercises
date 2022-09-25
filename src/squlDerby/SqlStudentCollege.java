package squlDerby;
/**
 * Sql commands for StudentCollege table related tasks
 * The StudentCollege table allows a many-to-many relationship by matching students to colleges
 */
public class SqlStudentCollege {
    /**
     *
     * @return
     */
    public static String createTable() {
        return "CREATE TABLE StudentCollege ("
                + "StudentId int,"
                + "CollegeId int"
                + ")";
    }

    /**
     *
     * @return
     */
    public static String databaseURL() {
        return "jdbc:derby:FirstDatabase;create=true";
    }

    /**
     *
     * @return
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

    public static String allData() {
        return "SELECT * FROM StudentCollege";
    }

    public static String dropTable(){
        return "DROP TABLE StudentCollege";
    }

    public static String studentCollegeInfo(){
        return
            "SELECT s.FirstName, s.LastName, c.Name "
                + "FROM Student s "
                + "INNER JOIN StudentCollege sc ON s.Id = sc.StudentId "
                + "INNER JOIN College c ON sc.CollegeId = c.Id ";

    }
}
