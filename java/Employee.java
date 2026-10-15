import javax.swing.*;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    public Employee(int id,String name,int age,double salary) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.salary = salary;
        
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
    @Override
    public String toString(){
        return "员工编号" + id + ",姓名"+ name + ",年龄"+ age  + ",工资"+ salary;
    }

}
