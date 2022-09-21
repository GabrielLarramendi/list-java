package application;

import entities.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProgramWithLambda {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new LinkedList<>();

        System.out.print("Quandos trabalhadores serão cadastrados? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            while(hasId(employees, id)) {
                System.out.println("Esse ID já existe. Digite um ID válido: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            System.out.println();

            employees.add(new Employee(id, name, salary));
        }

        System.out.print("Informe o ID do trabalhador que irá receber aumento: ");
        int id = sc.nextInt();

        Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("Esse id não existe!");
        }
        else {
            System.out.println("Qual será a porcentagem de aumento? ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("Liste de trabalhadores: ");
        for (Employee e : employees) {
            System.out.println(e);
        }

        sc.close();
    }

    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
