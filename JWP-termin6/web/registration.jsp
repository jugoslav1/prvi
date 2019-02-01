<%-- 
    Document   : registration
    Created on : Nov 26, 2018, 2:48:10 PM
    Author     : Grupa1
--%>

<%@page import="database.DBQueries"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.City"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% ArrayList<City> cities = DBQueries.getAllCities();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registration form!</h1>
        <form ACTION="RegistrationServlet" METHOD="POST">
            
          USERNAME: 
          <input type="text" name="username"> <br/>    
          PASSWORD: 
          <input type="password" name="password"> <br/>
          NAME: 
          <input type="text" name="name"> <br/> 
          SURNAME: 
          <input type="text" name="surname"> <br/>
          CITY:
          <select name="city">
            <% for(int i =0; i<cities.size(); i++){ %>  
                <%=cities.get(i)%>
            <% } %>
          </select><br/>
          SEX: <br/>
          <input type="radio" checked name="pol" value="f"> FEMALE <br/>
          <input type="radio" name="pol" value="m"> MALE <br/>
          <HR>
          <input type="checkbox" name="cb" id="iagree"> I AGREE 
           <input type="submit" name="submit" 
                  value="submit" id="submit" disabled> 
            
        </form>
     <script type="text/javascript"  src="js/design.js"> </script>
    </body>
</html>
