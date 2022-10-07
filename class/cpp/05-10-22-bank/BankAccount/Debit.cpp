#include <iostream>
#include "../BankAccount.hh"

using namespace std;

void DebitAccount::withdraw(long double amount) {
    if(ammount <= 0) throw invalid_argument("Amount must be positive");
    if(ammount > this->balance) throw invalid_argument("Amount must be less than balance");
    
    this->balance -= amount;
}

PaymentAccount::PaymentAccount(size_t id, long double balance) : DebitAccount(id, balance) {
    if(balance < 0) throw invalid_argument("Balance must be positive");
}

void PaymentAccount::deposit(long double amount) {
    if (ammount <= 0)
        throw invalid_argument("Amount must be positive");

    this->balance += (amount - (amount * 0.03));
}

SavingsAccount::SavingsAccount(size_t id, long double balance) : DebitAccount(id, balance) {
    if(balance < 0) throw invalid_argument("Balance must be positive");
}

void SavingsAccount::deposit(long double amount) {
    if (ammount <= 0)
        throw invalid_argument("Amount must be positive");

    this->balance += (amount - (amount * 0.05));
}
