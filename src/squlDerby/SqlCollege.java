package squlDerby;

/**
 * Sql commands for college.
 */
public class SqlCollege {
        public static String createTable() {
            return "CREATE TABLE College ("
                    + "ID int not null primary key"
                    + " GENERATED ALWAYS AS IDENTITY"
                    + " (START WITH 123, INCREMENT BY 1),"
                    + "School varchar(255),"
                    + "City varchar(255)"
                    + ")";
        }

        public static String databaseURL() {
            return "jdbc:derby:FirstDatabase;create=true";
        }

        public static String insertData() {
            return "INSERT INTO College (School, City) VALUES"
                    + "('SLCC', 'SLC'),"
                    + "('UofU', 'SLC'),"
                    + "('Duke', 'Durham'),"
                    + "('Yale', 'New Haven'),"
                    + "('UCLA', 'LA')"
                    ;
        }

        public static String allData() {
            return "SELECT * FROM College";
        }

        public static String dropTable(){
            return "DROP TABLE College";
        }
    }
