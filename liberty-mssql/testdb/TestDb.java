package testdb;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;

@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
  
  @Resource(name = "jdbc/mssqlserver")
  private DataSource ds1;
  private Connection con = null;
  private static final long serialVersionUID = 1L;
  
  public TestDb() {
    super();
  }
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
                                       throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<H1>Hello World Liberty</H1>\n");
    try {
       con = ds1.getConnection();
       Statement stmt = null;
       stmt = con.createStatement();
       // create a table
       stmt.executeUpdate("create table cities (name varchar(50) not null primary key, population int, county varchar(30))");
       // insert a test record
       stmt.executeUpdate("insert into cities values ('myHomeCity', 106769, 'myHomeCounty')");
       // select a record
       ResultSet result = stmt.executeQuery("select county from cities where name='myHomeCity'");
       result.next();
       // display the county information for the city.
       out.println("The county for myHomeCity is " + result.getString(1));
       // drop the table to clean up and to be able to rerun the test.
       stmt.executeUpdate("drop table cities");
       } 
    catch (SQLException e) {
       e.printStackTrace();
       } 
    finally {
       if (con != null){
           try{
              con.close();
              }
           catch (SQLException e) {
             e.printStackTrace();
             } 
           }
       }
    }
}