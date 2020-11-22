package Companies;

import java.util.List;

public abstract class Staff implements Employee, Comparable<Staff> {

    protected double fixedSalary;
    protected double bonus;
    protected double bonusSalary;
    protected double profit;

    public Staff() {
        fixedSalary = 70000;
    }

    public double getMonthSalary() {
        return 0;
    }

    public String getInfo() {
        return null;
    }

    @Override
    public int compareTo(Staff o) {
        if (getMonthSalary() < o.getMonthSalary()) {
            return 1;
        }
        if (getMonthSalary() > o.getMonthSalary()) {
            return -1;
        }
        return 0;
    }
}
