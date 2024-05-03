public class maasHesaplama {

    // Degiskenler tanimlandi.
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;
    double raiseSeniority; // maas yüzdesi
    double raiseAmount;

    //Kurucu fonksiyon tanimlanmasi
    public maasHesaplama(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    // Vergi hesaplanmasi
    public double tax() {
        if (salary < 1000) {
            return 0;
        } else {
            return salary * 0.03;
        }
    }

    //Bonus hesaplanmasi
    public double bonus() {
        if (workHours > 40) {
            return (workHours - 40) * 30;
        } else {
            return 0;
        }
    }

    //Maas artisi hesaplama
    public void raiseSalary() {
        int yearsWorked = 2021 - hireYear;
        if (yearsWorked > 9 && yearsWorked < 20) {
            raiseSeniority = 0.1;
        } else if (yearsWorked > 19) {
            raiseSeniority = 0.15;
        }

        raiseAmount = salary * raiseSeniority; //Maas artim miktari
    }

    //Bilgilerin ekrana yazdirilmasi
    @Override
    public String toString() {
        double totalSalary = salary + raiseAmount + bonus() - tax(); //Zamlı maas
        return "Adı: " + name + "\n" +
                "Maaşı: " + salary + "\n" +
                "Çalışma Saati: " + workHours + "\n" +
                "Başlangıç Yılı: " + hireYear + "\n" +
                "Vergi: " + tax() + "\n" +
                "Bonus: " + bonus() + "\n" +
                "Maaş Artışı: " + raiseAmount + "\n" +
                "Vergi ve Bonuslar ile birlikte maaş: " + totalSalary + "\n" +
                "Toplam Maaş: " + (totalSalary);
    }

    public static void main(String[] args) {
        maasHesaplama employee = new maasHesaplama("kemal", 2000.0, 45, 1985);
        employee.raiseSalary();
        System.out.println(employee);
    }
}
