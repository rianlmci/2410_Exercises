package squlDerby;

/**
 * Sql commands for college.
 */
public class SqlCollege {

    /**
     * @return command to create a College table.
     */
    public static String createTable() {
        return "CREATE TABLE College ("
                + "ID int not null primary key"
                + " GENERATED ALWAYS AS IDENTITY"
                + " (START WITH 123, INCREMENT BY 1),"
                + "School varchar(255),"
                + "City varchar(255)"
                + ")";
    }

    /**
     * @return command to create a database URL.
     */
    public static String databaseURL() {
        return "jdbc:derby:FirstDatabase;create=true";
    }

    /**
     * @return command to add school and city into the College table.
     */
    public static String insertData() {
        return "INSERT INTO College (School, City) VALUES"
                + "('SLCC', 'SLC'),"
                + "('UofU', 'SLC'),"
                + "('Duke', 'Durham'),"
                + "('Yale', 'New Haven'),"
                + "('UCLA', 'LA')";
    }

    /**
     * @return command to select all the data from the College table.
     */
    public static String allData() { return "SELECT * FROM College"; }

    /**
     * @return command to drop the College table.
     */
    public static String dropTable(){ return "DROP TABLE College"; }
}
