<%-- 
    Document   : employeeform
    Created on : Jul 2, 2024, 3:37:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Form</title>
    </head>
    <body style="text-align: center; font-size: 20px;">
        <h1>Employee Form</h1>

        <form action="../save/saveemployee.jsp" method="post">
            Name: <input type="text" name="employeeName"> <br> <br>
            Email: <input type="email" name="employeeEmail"> <br> <br>
            Address: <input type="text" name="employeeAddress"> <br> <br>
            Cell No: <input type="text" name="employeePhone"> <br> <br>

            <input type="submit" value="Save">

        </form>


        <div style="font-size: 30px; color: darkcyan;">
            
            
            <a href="../home.jsp">Home</a> <br>
            <a href="employeeform.jsp">Employee Form</a> <br>
            <a href="../view/viewallemployee.jsp">VIew Employee Data</a>

        </div>
    </body>
</html>
