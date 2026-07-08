package pratices.challenges.storesystem;

import pratices.challenges.storesystem.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Rafa", 2015),
                new Employee(10005, "Gustavo", 2021),
                new Employee(10022, "Joana", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Lucas", 2018)
        ));

        employees.sort(new Employee.EmployeeComparator<>("yearStarted")
                .reversed());

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("Membros da Loja:");
        List<StoreEmployee> storeEmployees = getStoreEmployees();

        for (StoreEmployee employee : storeEmployees) {
            System.out.println(employee);
        }
    }

    private static List<StoreEmployee> getStoreEmployees() {
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Maria", 2019,
                        "Target"),
                new StoreEmployee(10515, "João", 2021,
                        "Walmart"),
                new StoreEmployee(10105, "Tomas", 2020,
                        "Macys"),
                new StoreEmployee(10215, "Marcio", 2018,
                        "Walmart"),
                new StoreEmployee(10322, "Bruno", 2016,
                        "Target")));

        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);
        return storeEmployees;
    }
}
