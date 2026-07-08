package pratices.challenges.localclasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record Employee(String firstName, String lastName, String hireDate) { }

public class Main{

    public static void main(String[] args) {

        Employee e1 = new Employee("Gustavo" , "Silva", "01/02/2015");
        Employee e2 = new Employee("Ana" , "Souza", "05/08/2000");
        Employee e3 = new Employee("Pedro" , "Rocha", "11/02/2011");
        Employee e4 = new Employee("Lara" , "Croft", "05/03/2013");
        Employee e5 = new Employee("The" , "Rock", "23/07/2020");


        List<Employee> list = new ArrayList<>(Arrays.asList(e1 ,e2, e3, e4, e5));

        printOrderedList(list, "name");
        System.out.println();
        printOrderedList(list, "year");
    }

   public static void printOrderedList(List<Employee> employeeList, String sortField){

        int currentYear = LocalDate.now().getYear();

        class MyEmployee{

            Employee containedEmployee;
            int yearsWorked;
            String fullName;

            public MyEmployee(Employee containedEmployee){

                this.containedEmployee = containedEmployee;

                yearsWorked = currentYear - Integer.parseInt(
                        containedEmployee.hireDate().split("/")[2]);

                fullName = String.join(" ",
                        containedEmployee.firstName(),
                        containedEmployee.lastName());
            }

            @Override
            public String toString() {
                return "%s foi funcionário por %d anos".formatted(
                        fullName, yearsWorked);
            }
        }

        List<MyEmployee> list = new ArrayList<>();
        for(Employee employee : employeeList){
            list.add(new MyEmployee(employee));
        }

        var comparator = new Comparator<MyEmployee>(){

            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {

                if (sortField.equals("name")){
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        list.sort(comparator);
        for (MyEmployee myEmployee : list){
            System.out.println(myEmployee);
        }
   }
}
