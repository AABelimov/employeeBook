import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees;
    private final int capacity; // Максимальное количество сотрудников в книге, задается при инициализации
    private int count = 0; // Счетчик добавленных сотрудников

    // capacity - размер книги
    public EmployeeBook(int capacity) {
        employees = new Employee[capacity];
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        EmployeeBook otherEmployeeBook = (EmployeeBook) other;
        return Arrays.equals(employees, otherEmployeeBook.getEmployees());
    }

    private Employee[] getEmployees() {
        return employees;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employees);
    }

    // базовая сложность, задание 8а (вывести в консоль список всех сотрудников со всеми данными по ним)
    // 90 символов на одну строку * количество записей в книге * 2(для каждой записи вертикальный разделитель) +
    // + 3 строки по 90 символов для шапки
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(90 * count * 2 + 270);
        builder.append("||=====|=====|===================================================|=====================||\n");
        builder.append("|| id  | Отд | ФИО                                               | Зарплата            ||\n");
        builder.append("||=====|=====|===================================================|=====================||\n");
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null) {
                builder.append(employees[i].getModifiedToString());
                builder.append('\n');
                builder.append("||-----|-----|---------------------------------------------------|---------------------||\n");
            }
        }
        return builder.toString();
    }

    // сложность - очень сложно, задание 4а (добавть нового сотрудника)
    public void addEmployee(String fullName, int department, double salary) {
        if(count < capacity){
            for(int i = 0; i < capacity; i++){
                if(employees[i] == null){
                    employees[i] = new Employee(fullName, department, salary);
                    count++;
                    break;
                }
            }
        }
    }

    // сложность - очень сложно, задание 4b (удалить сотрудника по ФИО и/или id)
    public void deleteEmployee(int id) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                count--;
            }
        }
    }

    public void deleteEmployee(String fullName) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i] = null;
                count--;
            }
        }
    }

    public void deleteEmployee(int id, String fullName) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName) && employees[i].getId() == id) {
                employees[i] = null;
                count--;
            }
        }
    }

    // базовая сложность, задание 8b (посчитать сумму затрат на зарплаты в месяц)
    public double sumSalaryInBook() {
        double sum = 0.0;
        for (Employee e : employees) {
            if (e != null) sum += e.getSalary();
        }
        return sum;
    }

    // базовая сложность, задание 8с (найти сотрудника с минимальной зарплатой)
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

    // базовая сложность, задание 8d (найти сотрудника с максимальной зарплатой)
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

    // базовая сложность, задание 8е (подсчитать среднее значение зарплат)
    public double calculateAverageSalaryInBook() {
        return sumSalaryInBook() / count;
    }

    // базовая сложность, задание 8f (вывести в консоль ФИО всех сотрудников)
    public void printFullNamesFromBook() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e.getFullName());
            }
        }
    }

    // повышенная сложность, задание 1 (проиндексировать зарплату на процент)
    public void riseSalaryInBook(double percent) {
        double newSalary;
        for (Employee e : employees) {
            if (e != null) {
                newSalary = e.getSalary() + e.getSalary() * percent * 0.01;
                e.setSalary(newSalary);
            }
        }
    }

    // повышенная сложность, задание 2а (найти сотрудника с минимальной зарплатой в отделе)
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

    // повышенная сложность, задание 2b (найти сотрудника с максимальной зарплатой в отделе)
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

    // повышенная сложность, задание 2с (найти сумму затрат на зарплату по отделу)
    public double sumSalaryInDepartment(int department) {
        double sum = 0.0;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) sum += e.getSalary();
        }
        return sum;
    }


    // повышенная сложность, задание 2d (найти среднюю зарплату по отделу)
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

    // повышенная сложность, задание 2е (проиндексировать зарплату сотрудников отдела на процент)
    public void riseSalaryInDepartment(int department, double percent) {
        double newSalary;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department){
                newSalary = e.getSalary() + e.getSalary() * percent * 0.01;
                e.setSalary(newSalary);
            }
        }
    }

    // повышенная сложность, задание 2f (напечатать всех сотрудников отдела(все данные, кромк отдела))
    public void printEmployeesFromDepartment(int department) {
        System.out.printf("Список %d отдела:\n", department);
        printHead();
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                System.out.println(e.getStringWithoutDepartment());
                System.out.println("||------|--------------------------------------------------------|---------------------||");
            }
        }
        System.out.println();
    }

    // повышенная сложность, задание 3а (вывести в консоль id, ФИО и зарплату сотрудников с зарплатой меньше указанной)
    public void printEmployeesWithSalaryLessThan(double salary) {
        System.out.printf("Сотрудники с зарплатой меньше чем %,.2f:\n", salary);
        printHead();
        for (Employee e : employees) {
            if (e != null && e.getSalary() < salary) {
                System.out.println(e.getStringWithoutDepartment());
                System.out.println("||------|--------------------------------------------------------|---------------------||");
            }
        }
        System.out.println();
    }

    // повышенная сложность, задание 3b (вывести в консоль id, ФИО и зарплату сотрудников с зарплатой большей или равной указанной)
    public void printEmployeesWithSalaryGreaterThan(double salary) {
        System.out.printf("Сотрудники с зарплатой больше или равной %,.2f:\n", salary);
        printHead();
        for (Employee e : employees) {
            if (e != null && e.getSalary() >= salary) {
                System.out.println(e.getStringWithoutDepartment());
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

    // сложность - очень сложно, задание 5а (изменить зарплату сотрудника по ФИО)
    public void changeSalary(String fullName, double newSalary) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i].setSalary(newSalary);
            }
        }
    }

    // сложность - очень сложно, задание 5b (изменить отдел сотрудника по ФИО)
    public void changeDepartment(String fullName, int newDepartment) {
        for (int i = 0; i < capacity; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i].setDepartment(newDepartment);
            }
        }
    }

    // сложность - очень сложно, задание 6 (напечатать ФИО сотрудников по отделам)
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