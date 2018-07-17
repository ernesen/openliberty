<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Calendar"%>
        <%@page import="java.util.GregorianCalendar"%>
            <%@page import="javax.naming.Context"%>
                <%@page import="javax.naming.InitialContext"%>
                    <!DOCTYPE html>
                    <html>

                    <head>
                        <meta charset="UTF-8">
                        <title>Insert title here</title>
                    </head>

                    <body>
                        <h1>Good
                            <% if (new GregorianCalendar().get(Calendar.HOUR_OF_DAY) < 12) {%>
                                <br />Morning
                                <br />
                                <% } else { %>
                                    <br />Afternoon
                                    <br />
                                    <% } %>
                        </h1>


                        <%
/* 	Context initialContext = new InitialContext();

	String jndi = "test";
	Context ic = new InitialContext();
	Object obj = ic.lookup("jdbc/mssqlserver");
	out.println("jndi is "+obj.toString());
	
	Object jndiConstant = new InitialContext().lookup("schoolOfAthens/defaultAdminUserName");
	String defaultAdmin = (String) jndiConstant;
	out.println("jndi is "+defaultAdmin);
 */%>

                    </body>

                    </html>