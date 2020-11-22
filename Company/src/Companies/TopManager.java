package Companies;

public class TopManager extends Staff {

    private double companyIncome;
    private final double BONUS_LIMIT = 10000000;

    public TopManager(double income) {
        bonus = 1.5;
        companyIncome = income;
        profit = 400000 + (Math.random() * 100000);
        if (companyIncome > BONUS_LIMIT) {
            bonusSalary = fixedSalary * bonus;
        } else {
            bonusSalary = 0;
        }
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + bonusSalary;
    }

    @Override
    public String getInfo() {
        return "TopManager — зарплата складывается из фиксированной части и бонуса " +
                "в виде 150% от заработной платы, если доход компании более 10 млн рублей.";
    }
}
