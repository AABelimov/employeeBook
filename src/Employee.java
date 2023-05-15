import java.util.Objects;

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

    @Override
    public String toString() {
        return String.format("id: %d, Отдел: %d, ФИО: %s, Зарплата: %,.2f", id, department, fullName, salary);
    }

    public String getModifiedToString() {
        return String.format("|| %-4d| %2d  | %-50s| %,-20.2f||", id, department, fullName, salary);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Employee otherEmployee = (Employee) other;
        return id == otherEmployee.getId() && Objects.equals(fullName, otherEmployee.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, id);
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

    public String getStringWithoutDepartment() {
        return String.format("|| %-5d| %-55s| %,-20.2f||", id, fullName, salary);
    }
}
