public class EmployeeBook {
    private final Employee[] employees;
    private final int capacity;
    private int count = 0;

    public EmployeeBook(int capacity) {
        employees = new Employee[capacity];
        this.capacity = capacity;
    }
    //========================================Вспомогательные методы==================================================//


    //================================================================================================================//

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(90 * capacity + 270);//90 * capacity
        builder.append("||=====================================================================================||\n");
        builder.append("|| id   |Отд.| ФИО                                               | Зарплата            ||\n");
        builder.append("||=====================================================================================||\n");
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null) {
                builder.append(employees[i].getModifiedToString());
                builder.append('\n');
                builder.append("||-------------------------------------------------------------------------------------||\n");
            }
        }
        return builder.toString();
    }

    public void addEmployee(String fullName, int department, double salary) {
        if(count < capacity){
            for(int i = 0; i < capacity; i++){
                if(employees[i] == null){
                    employees[i] = new Employee(fullName, department, salary);
                    count++;
                    break;
                }
            }
        } else System.out.println("Книга переполнена");//Исправить, сделать здесь ошибку
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    public void deleteEmployee(String fullName) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i] = null;
            }
        }
    }

    public void deleteEmployee(int id, String fullName) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName) && employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    public double sumSalaryInBook() {
        double sum = 0.0;
        for (Employee e : employees) {
            if (e != null) sum += e.getSalary();
        }
        return sum;
    }

    public Employee getEmployeeWithMinSalaryInBook() {
        double min = employees[0].getSalary();
        Employee poorEmployee = employees[0];
        for (Employee e : employees) {
            if (e != null && e.getSalary() < min){
                min = e.getSalary();
                poorEmployee = e;
            }
        }
        return poorEmployee;
    }

    public Employee getEmployeeWithMaxSalaryInBook() {
        double max = employees[0].getSalary();
        Employee richEmployee = employees[0];
        for (Employee e : employees) {
            if (e != null && e.getSalary() > max){
                max = e.getSalary();
                richEmployee = e;
            }
        }
        return richEmployee;
    }

    public double calculateAverageSalaryInBook() {
        return sumSalaryInBook() / count;
    }

    public void printFullNamesFromBook() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e.getFullName());
            }
        }
    }

    public void riseSalaryInBook(double percent) {
        double newSalary;
        for (Employee e : employees) {
            if (e != null) {
                newSalary = e.getSalary() + e.getSalary() * percent * 0.01;
                e.setSalary(newSalary);
            }
        }
    }

    public Employee getEmployeeWithMinSalaryInDepartment(int department) {
        double min = Double.MAX_VALUE;
        Employee poorEmployee = null;
        for (Employee e : employees) {
            if (e != null && e.getSalary() < min && e.getDepartment() == department){
                min = e.getSalary();
                poorEmployee = e;
            }
        }
        return poorEmployee;
    }

    public Employee getEmployeeWithMaxSalaryInDepartment(int department) {
        double max = Double.MIN_VALUE;
        Employee richEmployee = null;
        for (Employee e : employees) {
            if (e != null && e.getSalary() > max && e.getDepartment() == department){
                max = e.getSalary();
                richEmployee = e;
            }
        }
        return richEmployee;
    }

    public double sumSalaryInDepartment(int department) {
        double sum = 0.0;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) sum += e.getSalary();
        }
        return sum;
    }

    public double calculateAverageSalaryInDepartment(int department) {
        int count = 0;
        double sum = 0.0;

        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                sum += e.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    public void riseSalaryInDepartment(int department, double percent) {
        double newSalary = 0.0;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department){
                newSalary = e.getSalary() + e.getSalary() * percent * 0.01;
                e.setSalary(newSalary);
            }
        }
    }
/////////////доделать
    public void printEmployeesFromDepartment(int department) {
        System.out.printf("Список %d отдела:\n", department);
        printHead();
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                System.out.println(e.getInfoWithoutDepartment()); //переименовать функцию getinfowithoutdepartment
                System.out.println("||------|--------------------------------------------------------|---------------------||");
            }
        }
        System.out.println();
    }

    public void printEmployeesWithSalaryLessThan(double salary) {
        System.out.printf("Работники с зарплатой меньше чем %,.2f:\n", salary);
        printHead();
        for (Employee e : employees) {
            if (e != null && e.getSalary() < salary) {
                System.out.println(e.getInfoWithoutDepartment());
                System.out.println("||------|--------------------------------------------------------|---------------------||");
            }
        }
        System.out.println();
    }

    public void printEmployeesWithSalaryGreaterThan(double salary) {
        System.out.printf("Работники с зарплатой больше или равной %,.2f:\n", salary);
        printHead();
        for (Employee e : employees) {
            if (e != null && e.getSalary() >= salary) {
                System.out.println(e.getInfoWithoutDepartment());
                System.out.println("||------|--------------------------------------------------------|---------------------||");
            }
        }
        System.out.println();
    }

    private void printHead() {
        System.out.println("||======|========================================================|=====================||");
        System.out.println("|| id   | ФИО                                                    | Зарплата            ||");
        System.out.println("||======|========================================================|=====================||");
    }

    public void changeSalary(int id, double newSalary) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i].setSalary(newSalary);
            }
        }
    }

    public void changeSalary(String fullName, double newSalary) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i].setSalary(newSalary);
            }
        }
    }

    public void changeSalary(int id, String fullName, double newSalary) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName) && employees[i].getId() == id) {
                employees[i].setSalary(newSalary);
            }
        }
    }

    public void changeDepartment(int id, int newDepartment) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i].setDepartment(newDepartment);
            }
        }
    }

    public void changeDepartment(String fullName, int newDepartment) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i].setDepartment(newDepartment);
            }
        }
    }

    public void changeDepartment(int id, String fullName, int newDepartment) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getId() == id && employees[i].getFullName().equals(fullName)) {
                employees[i].setDepartment(newDepartment);
            }
        }
    }

    public void printFullNamesByDepartment() {
        for (int i = 1; i <= 5; i++) {
            System.out.printf("Сотрудники %d отдела:\n", i);
            printFullNameFromDepartment(i);
            System.out.println();
        }
    }

    private void printFullNameFromDepartment(int department) {
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                System.out.println(e.getFullName());
            }
        }
    }
}
