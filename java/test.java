import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n====== 员工管理系统 ======");
            System.out.println("1. 添加员工");
            System.out.println("2. 查询员工");
            System.out.println("3. 显示全部员工");
            System.out.println("4. 修改员工工资");
            System.out.println("5. 删除员工");
            System.out.println("6. 按姓名查询员工");
            System.out.println("0. 退出系统");
            System.out.print("请选择操作：");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("请输入有效的数字！");
                continue;
            }

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    findEmployee();
                    break;
                case 3:
                    showEmployees();
                    break;
                case 4:
                    updateSalary();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    searchByName();
                    break;
                case 0:
                    System.out.println("系统已退出！");
                    sc.close();
                    return;
                default:
                    System.out.println("无效选项，请重新输入！");
            }
        }
    }

    // 添加员工
    public static void addEmployee() {
        try {
            System.out.print("请输入员工编号：");
            int id = Integer.parseInt(sc.nextLine());

            if (findById(id) != null) {
                System.out.println("该员工编号已存在！");
                return;
            }

            System.out.print("请输入员工姓名：");
            String name = sc.nextLine();

            System.out.print("请输入员工年龄：");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("请输入员工工资：");
            double salary = Double.parseDouble(sc.nextLine());

            if (id <= 0 || age <= 0 || salary < 0 || name.isBlank()) {
                System.out.println("输入数据不合法！");
                return;
            }

            Employee employee = new Employee(id, name, age, salary);
            employees.add(employee);

            System.out.println("员工添加成功！");

        } catch (NumberFormatException e) {
            System.out.println("输入格式错误，请重新操作！");
        }
    }

    // 根据编号查询员工
    public static void findEmployee() {
        System.out.print("请输入要查询的员工编号：");

        try {
            int id = Integer.parseInt(sc.nextLine());
            Employee employee = findById(id);

            if (employee == null) {
                System.out.println("没有找到该员工！");
            } else {
                System.out.println(employee);
            }

        } catch (NumberFormatException e) {
            System.out.println("员工编号必须是整数！");
        }
    }

    // 显示所有员工
    public static void showEmployees() {
        if (employees.isEmpty()) {
            System.out.println("当前没有员工！");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // 修改员工工资
    public static void updateSalary() {
        System.out.print("请输入员工编号：");

        try {
            int id = Integer.parseInt(sc.nextLine());
            Employee employee = findById(id);

            if (employee == null) {
                System.out.println("没有找到该员工！");
                return;
            }

            System.out.print("请输入新的工资：");
            double salary = Double.parseDouble(sc.nextLine());

            if (salary < 0) {
                System.out.println("工资不能为负数！");
                return;
            }

            employee.setSalary(salary);
            System.out.println("工资修改成功！");

        } catch (NumberFormatException e) {
            System.out.println("输入格式错误！");
        }
    }

    // 删除员工
    public static void deleteEmployee() {
        System.out.print("请输入要删除的员工编号：");

        try {
            int id = Integer.parseInt(sc.nextLine());
            Employee employee = findById(id);

            if (employee == null) {
                System.out.println("没有找到该员工！");
                return;
            }

            employees.remove(employee);
            System.out.println("员工删除成功！");

        } catch (NumberFormatException e) {
            System.out.println("员工编号必须是整数！");
        }
    }

    // 根据编号查找员工对象
    public static Employee findById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }
    public static void searchByName(){
        System.out.println("请输入员工名字或姓名中的部分字符：");
        String keyword = sc.nextLine();

        List<Employee> result=employees.stream().filter(emp ->emp.getName().contains(keyword) ).collect(Collectors.toList());
        if (result.isEmpty()){
            System.out.println("没有找到匹配的员工");
        }else {
            result.forEach(System.out::println);
        }

            }
}

