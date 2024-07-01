<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
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
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Action</th>
        </tr>


    </thead>

    <tbody>

        <a:forEach var="e" items="${list}">

            <tr>
                <td>${e.getId()}</td>
                <td>${e.getName()}</td>
                <td>${e.getEmail()}</td>
                <td>${e.getAddress()}</td>
                <td>${e.getPhone()}</td>
                <td>
                    <a href="#">Edit</a>
                    <a href="deleteemployee.jsp?id=${e.getId()}">Delete</a>
                </td>

            </tr>
        </a:forEach>
    </tbody>



</table> 
        
        
    </div>

<div style="font-size: 30px; color: darkcyan; text-align:center;">
    <a href="home.jsp">Home</a> <br>
    <a href="employeeform.jsp">Employee Form</a> <br>
    <a href="viewallemployee.jsp">VIew Employee Data</a>

</div>
    
    
</body>


