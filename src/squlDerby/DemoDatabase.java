package squlDerby;

import java.sql.*;

public class DemoDatabase {
    //REFACTOR CODE TO HAVE ALL SQL STATEMENTS TO THEIR OWN CLASS

    // ==== TESTING AREA ==== //
    public static void main(String[] args){
        /*OLD
        //https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/Connection.html
        //https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DriverManager.html

        //v trying with resources, it can try *multiple* things with autocloseable at once
        //https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/Statement.html
        //execute() tells db what to multiple runs do multiple things, executeQuery() asks the DB a question;
        //FOR STUDENT
        try (Connection connection = DriverManager.getConnection(SqlStudent.databaseURL());
             Statement statement = connection.createStatement()){
            //statement.execute(sqlStudent.dropTable());
            //statement.execute(sqlStudent.createTable());
            //statement.execute(sqlStudent.insertData());
            ResultSet results = statement.executeQuery(SqlStudent.allData());
            printResults(results);
            //System.out.println("Column count: "+ metadata.getColumnCount());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        //FOR COLLEGE
        try (Connection connection = DriverManager.getConnection(SqlCollege.databaseURL());
             Statement statement = connection.createStatement()){
            //statement.execute(SqlCollege.dropTable());
            //statement.execute(SqlCollege.createTable());
            //statement.execute(SqlCollege.insertData());
            ResultSet results = statement.executeQuery(SqlCollege.allData());
            printResults(results);
            //System.out.println("Column count: "+ metadata.getColumnCount());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        //FOR STUDENTCOLLEGE
        try (Connection connection = DriverManager.getConnection(SqlStudentCollege.databaseURL());
             Statement statement = connection.createStatement()){
            statement.execute(SqlStudentCollege.dropTable());
            statement.execute(SqlStudentCollege.createTable());
            statement.execute(SqlStudentCollege.insertData());
            ResultSet results = statement.executeQuery(SqlStudentCollege.allData());
            printResults(results);
            results = statement.executeQuery(SqlStudentCollege.studentCollegeInfo());
            printResults(results);
            //System.out.println("Column count: "+ metadata.getColumnCount());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         */
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


    /*
    * Demo how to access the header dynamically
    * Still need columns need to be straight
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
