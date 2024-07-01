<%-- 
    Document   : employeeform
    Created on : Jul 1, 2024, 3:29:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Form</title>
    </head>
    <body style="text-align: center;">
        <h1>Employee Form</h1>

        <form action="saveemployee.jsp" method="post">
            Name: <input type="text" name="name"> <br> <br>
            Email: <input type="email" name="email"> <br> <br>
            Address: <input type="text" name="address"> <br> <br>
            Cell No: <input type="text" name="phone"> <br> <br>

            <input type="submit" value="Save">

        </form>


        <div style="font-size: 30px; color: darkcyan;">
            <a href="employeeform.jsp">Employee Form</a> <br>
            <a href="viewallemployee.jsp">VIew Employee Data</a>

        </div>
    </body>
</html>
