import java.util.HashMap;
import java.util.Scanner;
import javax.swing.Spring;
public class test2 {
    public static void main(String[] args) {
        Employee emp = new  Employee(1001, "张三", 22, 8000);
        System.out.println(emp.getId());
        HashMap<Integer,String> employees = new HashMap<>();
        employees = new HashMap<>();
        employees.put(101, "张三");
        employees.put(102, "李四");
        // employees.remove(101);
        // System.out.print(employees.get(102));
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的年龄");
        int age = sc.nextInt();
        System.out.println("请输入你的名字");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("你的年龄是：" + age);
        System.out.println("你的名字是：" + name);
        employees.put(103, "王五");
        // employees.remove(102);
        for(Integer i : employees.keySet()){
            System.out.println(employees.get(i));
        }
        if (employees.containsKey(101)) {
            System.out.println("员工已存在");
            
        }
        else{
            employees.put(101,"张三"); 
            System.out.println("添加成功");
        }
        System.out.println(employees.containsKey(102));
        System.out.println(employees);
        System.out.println(employees.size());
        
    }
    
}
  