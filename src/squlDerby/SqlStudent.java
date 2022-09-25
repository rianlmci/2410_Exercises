package squlDerby;

public class SqlStudent {
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

    public static String databaseURL() {
        return "jdbc:derby:FirstDatabase;create=true";
    }

    public static String insertData() {
        return "INSERT INTO Student (FirstName, LastName, Major, GradYear) VALUES"
                + "('Don', 'Moor', 'EE', 2023),"
                + "('Jen', 'Bell', 'CS', 2022),"
                + "('Tim', 'Bush', 'CS', 2025),"
                + "('Rob', 'Cole', 'CS', 2024)";
    }

    public static String allData() {
        return "SELECT * FROM Student";
    }

    public static String dropTable(){
        return "DROP TABLE student";
    }
}
