package application;

import entities.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new LinkedList<>();

        System.out.print("Quandos trabalhadores serão cadastrados? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
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

        Integer pos = position(employees, id);
        if (pos == null) {
            System.out.println("O ID NÃO EXISTE!");
        }
        else {
            System.out.print("Qual vai ser a porcentagem de aumento? ");
            double percentage = sc.nextDouble();
            employees.get(pos).increaseSalary(percentage);
        }

        System.out.println("Lista de funcionários: ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        sc.close();
    }

    public static Integer position(List<Employee> employees, int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}
