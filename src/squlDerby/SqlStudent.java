package squlDerby;

/**
 * Sql commands for student.
 */
public class SqlStudent {

    /**
     * @return command to create a Student table.
     */
    public static String createTable() {
        return "CREATE TABLE Student ("
                + "ID int not null primary key"
                + " GENERATED ALWAYS AS IDENTITY"
                + " (START WITH 1234, INCREMENT BY 1), "
                + "FirstName varchar(255),"
                + "LastName varchar(255),"
                + "Major varchar(255),"
                + "GradYear int"
                + ")";
    }

    /**
     * @return command to create a database URL.
     */
    public static String databaseURL() {
        return "jdbc:derby:FirstDatabase;create=true";
    }

    /**
     * @return command to add firstname, lastname, major, and grad year into the Student table.
     */
    public static String insertData() {
        return "INSERT INTO Student (FirstName, LastName, Major, GradYear) VALUES"
                + "('Don', 'Moor', 'EE', 2023),"
                + "('Jen', 'Bell', 'CS', 2022),"
                + "('Tim', 'Bush', 'CS', 2025),"
                + "('Rob', 'Cole', 'CS', 2024)";
    }

    /**
     * @return command to select all the data from the Student table.
     */
    public static String allData() {
        return "SELECT * FROM Student";
    }

    /**
     * @return command to drop the Student table.
     */
    public static String dropTable(){
        return "DROP TABLE student";
    }
}
