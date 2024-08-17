package model.entities;

import model.exceptions.ValueException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(){}

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withdraw(Double amount) throws ValueException {
        validadeWithdraw(amount);
        this.balance -= amount;
    }

    //Sugestão da resposta do professor
    private void validadeWithdraw(double amount){
        if(amount > balance){
            throw new ValueException("Sem saldo.");
        }
        if(amount > withdrawLimit){
            throw new ValueException("Montante maior do que o limite de saque.");
        }
    }

    @Override
    public String toString() {
        return "Novo saldo: "
                +balance;
    }
}
