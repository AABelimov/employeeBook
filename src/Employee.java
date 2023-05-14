public class Employee {
    private final String fullName;
    private int department;
    private double salary;
    private final int id;
    static int nextId = 1;
    public Employee(String fullName, int department, double salary){
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = nextId++;
    }
//....................Доделать
    @Override
    public String toString() {
        return String.format("id: %d, Отдел: %d, ФИО: %s, Зарплата: %,.2f", id, department, fullName, salary);
    }

    public String getModifiedToString() {
        return String.format("|| %-5d| %2d | %-50s| %,-20.2f||", id, department, fullName, salary);
    }

    @Override
    public boolean equals(Object other) {
        if(other.getClass() != this.getClass()) return false;
        Employee otherEmployee = (Employee) other;
        return otherEmployee.getId() == id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
//////////доделать...............
    public String getInfoWithoutDepartment() {
        //return id + ": " + fullName + " - " + salary;
        return String.format("|| %-5d| %-55s| %,-20.2f||", id, fullName, salary);
    }
}
