<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="model.Student" %>
<%@page import="dao.StudentDao" %>
<%@page import="java.util.*" %>


<%
    List<Student> list= StudentDao.viewAllStudent();
    request.setAttribute("list", list);

%>

<jsp:include page="header.jsp"></jsp:include>

<h1 class="text-center mt-5">All Student Data</h1>

<table class="container table-striped mb-5 mt-5" >
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

        <c:forEach var="s" items="${list}">
            <tr>
                <td>${s.getId()}</td>
                <td>${s.getName()}</td>
                <td>${s.getEmail()}</td>
                <td>${s.getAddress()}</td>
                <td>${s.getPhone()}</td>
                <td>
                    <a href="updatestudentform.jsp?id=${s.getId()}">Edit</a>
                    <a href="deletestudent.jsp?id=${s.getId()}">Delete</a>
                </td>
            </tr>

        </c:forEach>

    </tbody>   

</table>

<jsp:include page="footer.jsp"></jsp:include>