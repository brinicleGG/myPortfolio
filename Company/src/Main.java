import Companies.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Company abibas = new Company();

        ArrayList<Staff> operators = new ArrayList<>();
        ArrayList<Staff> managers = new ArrayList<>();
        ArrayList<Staff> topManagers = new ArrayList<>();

        for (int i = 0; i < 180; i++) {
            operators.add(new Operator());
        }

        for (int i = 0; i < 80; i++) {
            managers.add(new Manager());
        }

        for (int i = 0; i < 10; i++) {
            topManagers.add(new TopManager(abibas.getIncome()));
        }

        abibas.hireAll(operators);
        abibas.hireAll(managers);
        abibas.hireAll(topManagers);

        System.out.println("Колличество сотрудников " + abibas.staff.size());
        System.out.println();

        System.out.println("15 самых высоких зарплат в компании.");
        for (Staff staff : abibas.getTopSalaryStaff(15)) {
            System.out.println(staff.getMonthSalary());
        }
        System.out.println();

        System.out.println("30 самых низких зарплат в компании.");
        for (Staff staff : abibas.getLowestSalaryStaff(30)) {
            System.out.println(staff.getMonthSalary());
        }
        System.out.println();

        System.out.println("Увольняем 50% сотрудников.");
        for (int i = abibas.staff.size() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                abibas.staff.remove(i);
            }
        }
        System.out.println();

        System.out.println("Колличество сотрудников " + abibas.staff.size());
        System.out.println();


        System.out.println("15 самых высоких зарплат в компании.");
        for (Staff staff : abibas.getTopSalaryStaff(15)) {
            System.out.println(staff.getMonthSalary());
        }
        System.out.println();

        System.out.println("30 самых низких зарплат в компании.");
        for (Staff staff : abibas.getLowestSalaryStaff(30)) {
            System.out.println(staff.getMonthSalary());
        }
    }
}
