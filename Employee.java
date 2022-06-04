package system;


public class Employee {
    private String name ;
    private int id ;
    private double salary ;
    private String currency = "EGP" ;

    public Employee() {
        Bank_System.stuff.add(this);
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        Bank_System.stuff.add(this);
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
       String result =  "name=" + name + "\n id=" + id + "\n salary=" + salary + " " + currency + "\n" ;
        return result;
    }   
}
