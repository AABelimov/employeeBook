public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook(10);

        book.addEmployee("Иванов Иван Иванович", 1, 50_000.0);
        book.addEmployee("Александров Александр Александрович", 3, 40_000.0);
        book.addEmployee("Романов Роман Романович", 5, 50_000.0);
        book.addEmployee("Григорьев Григорий Григорьевич", 2, 60_000.0);
        book.addEmployee("Алексеев Алексей Алексеевич", 4, 30_000.0);
        book.addEmployee("Андреев Андрей Андреевич", 4, 80_000.0);
        book.addEmployee("Акакьев Акакий Акакьевич", 3, 90_000.0);
        book.addEmployee("Валентинов Валентин Валентинович", 2, 50_000.0);
        book.addEmployee("Денисов Денис Денисович", 5, 31_000.0);
        book.addEmployee("Павлов Павел Павлович", 1, 100_000.0);

        System.out.println(book);
        System.out.printf("Сумма затрат на зарплаты: %,.2f\n", book.sumSalaryInBook());
        System.out.println();
        System.out.println("Сотрудник с минимальной зарплатой:\n" + book.getEmployeeWithMinSalaryInBook().toString() + '\n');
        System.out.println("Сотрудник с максимальной зарплатой:\n" + book.getEmployeeWithMaxSalaryInBook().toString() + '\n');
        System.out.printf("Средняя зарплата: %,.2f\n", book.calculateAverageSalaryInBook());
        System.out.println();
        System.out.println("ФИО сотрудников:");
        book.printFullNamesFromBook();
        System.out.println();
        System.out.println(book);
        book.riseSalaryInBook(10);
        System.out.println(book);
        System.out.printf("Сотрудник с минимальной зарплатой в %d отделе:\n%s\n", 1, book.getEmployeeWithMinSalaryInDepartment(1));
        System.out.println();
        System.out.printf("Сотрудник с максимальной зарплатой в %d отделе:\n%s\n", 1, book.getEmployeeWithMaxSalaryInDepartment(1));
        System.out.println();
        System.out.printf("Сумма затрат на зарплату по %d отделу: %,.2f\n", 1, book.sumSalaryInDepartment(1));
        System.out.println();
        System.out.printf("Средняя зарплата по %d отделу: %,.2f\n", 1, book.calculateAverageSalaryInDepartment(1));
        System.out.println();
        book.riseSalaryInDepartment(1, 10);
        book.printEmployeesFromDepartment(1);
        book.printEmployeesWithSalaryLessThan(65_000);
        book.printEmployeesWithSalaryGreaterThan(70_000);
        book.deleteEmployee(9);
        System.out.println(book);
        book.changeSalary("Павлов Павел Павлович", 101_000);
        book.changeDepartment("Павлов Павел Павлович", 4);
        System.out.println(book);
        book.printFullNamesByDepartment();
    }
}