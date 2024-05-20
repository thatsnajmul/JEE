
package teacher;


public class Teacher extends exampleofgeneric.ExampleOfGeneric{
    private int id;
    private String name;
    private String email;
    private String salary;
    private String address;

    public Teacher() {
    }

    public Teacher(int id, String name, String email, String salary, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + ", address=" + address + '}';
    }
    
    
    
    
}
