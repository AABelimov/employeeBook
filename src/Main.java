public class Main {
    public static void main(String[] args) {
        EmployeeBook book1 = new EmployeeBook(11);

        book1.addEmployee("Иванов Иван Иванович", 1, 50_000.0);
        book1.addEmployee("Александров Александр Александрович", 3, 40_000.0);
        book1.addEmployee("Романов Роман Романович", 5, 50_000.0);
        book1.addEmployee("Григорьев Григорий Григорьевич", 2, 60_000.0);
        book1.addEmployee("Алексеев Алексей Алексеевич", 4, 55_000.0);
        book1.addEmployee("Андреев Андрей Андреевич", 4, 80_000.0);
        book1.addEmployee("Акакьев Акакий Акакьевич", 3, 90_000.0);
        book1.addEmployee("Валентинов Валентин Валентинович", 2, 50_000.0);
        book1.addEmployee("Денисов Денис Денисович", 5, 31_000.0);
        book1.addEmployee("Павлов Павел Павлович", 1, 100_000.0);
        book1.addEmployee("Иванов Иван Иванович", 3, 55_000.0);

        System.out.println(book1.toString());
        book1.deleteEmployee(1, "Иванов Иван Иванович");
        //book1.deleteEmployee(11, "Иванов Иван Иванович");
        System.out.println(book1.toString());
        book1.printFullNamesByDepartment();
        book1.printEmployeesWithSalaryGreaterThan(55000);
        book1.printEmployeesFromDepartment(3);

    }
}