package com.example.bean;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class EmployeeBean {
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private Employee employee = new Employee();

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public String save() {
        employeeDAO.saveEmployee(employee);
        return "index?faces-redirect=true";
    }

    public String update() {
        employeeDAO.updateEmployee(employee);
        return "index?faces-redirect=true";
    }

    public String delete(Long id) {
        employeeDAO.deleteEmployee(id);
        return "index?faces-redirect=true";
    }

    public String edit(Long id) {
        this.employee = employeeDAO.getEmployeeById(id);
        return "edit?faces-redirect=true";
    }
}
