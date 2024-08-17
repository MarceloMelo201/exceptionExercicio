package application;

import model.entities.Account;
import model.exceptions.ValueException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

            System.out.println("Digite os dados da conta");
            System.out.print("Número: ");
            int number = sc.nextInt();
            System.out.print("Conta: ");
            String holder = sc.next();
            System.out.print("Saldo inicial: ");
            double balance = sc.nextDouble();
            System.out.print("Limite de saque: ");
            double withdrawLimit = sc.nextDouble();

            Account ac = new Account(number, holder, balance, withdrawLimit);

            System.out.print("Digite o valor de saque: ");
            double amount = sc.nextDouble();

        try {
            ac.withdraw(amount);
            System.out.println(ac);
        }
        catch (ValueException e){
            System.out.println("Erro no saque: "+ e.getMessage());
        }

        sc.close();
    }
}