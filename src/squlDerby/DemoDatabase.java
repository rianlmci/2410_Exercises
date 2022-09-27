package squlDerby;

import java.sql.*;

/**
 * A demo of a derby database, sql calls, and table manipulation.
 */
public class DemoDatabase {
    // ==== TESTING AREA ==== //
    public static void main(String[] args){
        try (Connection connection = DriverManager.getConnection(SqlStudentCollege.databaseURL());
             Statement statement = connection.createStatement()){
            //STUDENT
            System.out.println("STUDENT TABLE");
            //statement.execute(SqlStudent.dropTable());
            //statement.execute(SqlStudent.createTable());
            //statement.execute(SqlStudent.insertData());
            ResultSet results = statement.executeQuery(SqlStudent.allData());
            printResults(results);

            //COLLEGE
            System.out.println();
            System.out.println("COLLEGE TABLE");
            //statement.execute(SqlCollege.dropTable());
            //statement.execute(SqlCollege.createTable());
            //statement.execute(SqlCollege.insertData());
            results = statement.executeQuery(SqlCollege.allData());
            printResults(results);
            //STUDENTCOLLEGE
            System.out.println();
            System.out.println("STUDENTCOLLEGE TABLE");
            //statement.execute(SqlStudentCollege.dropTable());
            //statement.execute(SqlStudentCollege.createTable());
            //statement.execute(SqlStudentCollege.insertData());
            results = statement.executeQuery(SqlStudentCollege.allData());
            printResults(results);
            System.out.println("RESULTS AFTER MERGE");
            results = statement.executeQuery(SqlStudentCollege.studentCollegeInfo());
            printResults(results);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");
    }


    /**
    * Prints the database information.
    * @throws SQLException for SQL related errors.
    */
    private static void printResults(ResultSet results) throws SQLException {
        /*
        * we always try to catch things that are in
        * the category of runtime exceptions. Java
        * is VERY strict about this. You HAVE to do a try catch or a throws
        */
        ResultSetMetaData metadata = results.getMetaData();
        int columnCount= metadata.getColumnCount();

        //SQL COLUMNS START AT ONE NOT 0
        //PRINTS THE HEADER LABELS
        for(int i = 0; i < columnCount; i++){
            System.out.print(metadata.getColumnLabel(i+1) + " ");
        }
        System.out.println();

        //SQL COLUMNS START AT ONE NOT 0
        //PRINTS THE RESULTS
        while(results.next()){
            for (int i = 0; i < columnCount; i++) {
              System.out.print(results.getObject(i+1) + " ");
            }
            System.out.println();
        }
    }
}
