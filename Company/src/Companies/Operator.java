package Companies;

public class Operator extends Staff {

    public Operator() {
        profit = 90000;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary;
    }

    @Override
    public String getInfo() {
        return "Operator — зарплата складывается только из фиксированной части.";
    }
}
