<%-- 
    Document   : employeeform
    Created on : Jul 2, 2024, 3:37:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.Employee" %>
<%@page import="dao.EmployeeDao" %>


<%

    String employeeId = request.getParameter("employeeId");
    Employee e = EmployeeDao.getById(Integer.parseInt(employeeId));

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Update Form</title>
    </head>
    <body style="text-align: center; font-size: 20px;">
        <h1>Employee Update Form</h1>

        <form action="updateemployee.jsp" method="post">
            <input type="hidden" name="employeeId" value="<%=e.getEmployeeId()%>">
            
            Name: <input type="text" name="employeeName" value="<%=e.getEmployeeName()%>"> <br> <br>
            Email: <input type="email" name="employeeEmail" value="<%=e.getEmployeeEmail()%>"> <br> <br>
            Address: <input type="text" name="employeeAddress" value="<%=e.getEmployeeAddress()%>"> <br> <br>
            Cell No: <input type="text" name="employeePhone" value="<%=e.getEmployeePhone()%>"> <br> <br>

            <input type="submit" value="Save">

        </form>


        <div style="font-size: 30px; color: darkcyan;">
            
            
            <a href="../home.jsp">Home</a> <br>
            <a href="../reg/employeeform.jsp">Employee Form</a> <br>
            <a href="../view/viewallemployee.jsp">VIew Employee Data</a>

        </div>
    </body>
</html>
