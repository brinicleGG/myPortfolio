package Companies;

public class Manager extends Staff {

    public Manager() {
        bonus = 0.05;
        profit = 115000 + Math.random() * 25000;
        bonusSalary = profit * bonus;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + bonusSalary;
    }

    @Override
    public String getInfo() {
        return "Manager — зарплата складывается из фиксированной части и бонуса" +
                " в виде 5% от заработанных для компании денег." +
                " Количество заработанных денег для компании генерируйте случайным образом" +
                " от 115 000 до 140 000 рублей.";
    }
}
