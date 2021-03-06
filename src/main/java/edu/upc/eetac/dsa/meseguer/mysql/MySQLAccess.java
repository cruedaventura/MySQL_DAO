package edu.upc.eetac.dsa.meseguer.mysql;

import java.sql.*;

public class MySQLAccess
{
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception
    {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/feedback?"
                            + "user=root&password=");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from feedback.Providers");
            writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("insert into feedback.Providers (Code, Name) values(? ,?)");
      // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
      // Parameters start with 1
           preparedStatement.setString(1, "LO");
            preparedStatement.setString(2, "Lo rs");
      preparedStatement.executeUpdate();

           preparedStatement = connect
                    .prepareStatement("SELECT code, name from feedback.Providers");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

      //Remove again the insert comment
      preparedStatement = connect
      .prepareStatement("delete from feedback.Providers where Code= ? ; ");
      preparedStatement.setString(1, "LO");
      preparedStatement.executeUpdate();

            resultSet = statement
                    .executeQuery("select * from feedback.Providers");
            writeMetaData(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException
    {
        //   Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException
    {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String code = resultSet.getString("Code");
            String name = resultSet.getString("Name");
            System.out.println("Code: " + code);
            System.out.println("Name: " + name);
        }
    }


    // You need to close the resultSet
    private void close()
    {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

} 
