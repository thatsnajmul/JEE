<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b" %>
<%@page import="model.Employee" %>
<%@page import="dao.EmployeeDao" %>
<%@page import="java.util.*" %>


<%

List<Employee> list = EmployeeDao.viewAllEmployee();
request.setAttribute("list", list);

%>




<body style="">
    
    <h1 style="text-align: center;">Employee Data</h1>
    
    
    <div style="">
        
        
        <table border="1"; style="width:70%; font-size: 20px; margin-left: auto; margin-right: auto;" >

    <thead>
        <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Employee Email</th>
            <th>Employee Address</th>
            <th>Employee Phone</th>
            <th>Employee Action</th>
        </tr>


    </thead>

    <tbody>

        <b:forEach var="e" items="${list}">
            <tr>
                <td>${e.getEmployeeId()}</td>
                <td>${e.getEmployeeName()}</td>
                <td>${e.getEmployeeEmail()}</td>
                <td>${e.getEmployeeAddress()}</td>
                <td>${e.getEmployeePhone()}</td>
                <td>
                    <a href="#">Edit</a>
                    <a href="deleteemployee.jsp?employeeId=${e.getEmployeeId()}">Delete</a>
                </td>

            </tr>
        </b:forEach>
    </tbody>



</table> 
        
        
    </div>

<div style="font-size: 30px; color: darkcyan; text-align:center;">
    <a href="home.jsp">Home</a> <br>
    <a href="employeeform.jsp">Employee Form</a> <br>
    <a href="viewallemployee.jsp">VIew Employee Data</a>

</div>
    
    
</body>



