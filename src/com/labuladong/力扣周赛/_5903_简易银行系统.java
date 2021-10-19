package com.labuladong.力扣周赛;

public class _5903_简易银行系统 {


}

class Bank {

    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean withdraw(int bank, long money) {
        if (validBank(bank) && balance[bank - 1] >= money) {
            balance[bank - 1] -= money;
            return true;
        }
        return false;
    }

    public boolean transfer(int bank1, int bank2,long money) {
        if (validBank(bank1) && validBank(bank2) && balance[bank1 - 1] >= money) {
            balance[bank2 - 1] += money;
            balance[bank1 - 1] -= money;
            return true;
        }
        return false;
    }

    public boolean deposit(int bank1, long money) {
        if (validBank(bank1)) {
            balance[bank1 - 1] += money;
            return true;
        }
        return false;
    }

    private boolean validBank(int bank) {
        return bank >= 0 && bank <= balance.length;
    }
}
