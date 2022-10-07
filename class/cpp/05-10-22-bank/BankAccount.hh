#pragma once
#include <iostream>

class BankAccount {
    private: 
        size_t id;
        long double balance;
    public:
        BankAccount(size_t id, long double balance);

        size_t getId();
        long double getBalance();

        virtual void deposit(long double amount) = 0;
        virtual void withdraw(long double amount) = 0;
};