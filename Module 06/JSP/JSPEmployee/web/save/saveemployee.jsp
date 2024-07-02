<jsp:useBean class="model.Employee" id="e"/>
<%@page  import="dao.EmployeeDao" %>
<jsp:setProperty name="e" property="*" />


<%
int i=EmployeeDao.saveEmployee(e);

    if(i>0){
        response.sendRedirect("../msg/success.jsp");
    }
    else{
    response.sendRedirect("../msg/error.jsp");
    }



%>


<a href="../reg/employeeform.jsp">Employee Form</a>
<a href="../view/viewallemployee.jsp">VIew Employee Data</a>