package Companies;

import java.util.*;

public class Company {

    public ArrayList<Staff> staff = new ArrayList<>(); // ?
    private double income;
    private double expense;
    //private double netProfit;

    public Company() {
        income = 10000001;
    }

    public void hire(Staff staff) { // найм одного сотрудника
        this.staff.add(staff);
    }

    public void hireAll(List<Staff> staff) { // найм списка сотрудников
            this.staff.addAll(staff);
    }

    public void fire(int index) { // увольнение сотрудника
        staff.remove(index);
    }

    public double getIncome() { // получение значения дохода компании
        /*for (int i = 0; i < staff.size(); i++) {
            income += staff.get(i).profit;
            //expense += staff.get(i).getMonthSalary();
        }
        //netProfit = income - expense;*/
        return income;
    }

    public void setIncome(double amount) {
        income = amount;
    }


    public List<Staff> getTopSalaryStaff(int count) {
        if (count < 0 || count >= staff.size()) {
            System.out.println("Указано неверное количество сотрудников");
            return null;
        } else {
            Collections.sort(staff);
            ArrayList<Staff> topSalaryStaff = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                topSalaryStaff.add(staff.get(i));
            }
            return topSalaryStaff;
        }
    }

    public ArrayList<Staff> getLowestSalaryStaff(int count) {
        if (count < 0 || count >= staff.size()) {
            System.out.println("Указано неверное количество сотрудников");
            return null;
        } else {
            Collections.sort(staff);
            ArrayList<Staff> lowestSalaryStaff = new ArrayList<>();
            for (int i = staff.size() - 1; i >= 0 && count > 0; i--, count--) {
                lowestSalaryStaff.add(staff.get(i));
            }
            return lowestSalaryStaff;
        }
    }
}
