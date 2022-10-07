#include "../BankAccount.hh"

class DebitAccount : public BankAccount {
    private:
    public:
        virtual void deposit(long double amount) = 0;
        void withdraw(long double amount);
};

class PaymentAccount : public DebitAccount {
    private:
    public:
        PaymentAccount(size_t id, long double balance);
        void deposit(long double amount);
};

class SavingsAccount : public DebitAccount {
    private:
    public:
        SavingsAccount(size_t id, long double balance);
        void deposit(long double amount);
};

