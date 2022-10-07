#include <iostream>
#include <vector>
#include <unordered_map>

#include "BankAccount.hh"
#include "User.hh"

class Bank {
    private:
        std::unordered_map<size_t, std::vector<User> >  users;
    public:
        void add_user(size_t id, std::string name);
        void add_bank_accout(size_t user_id, size_t account_id, double balance);
        long double get_balance(size_t user_id, size_t account_id) const;
        BankAccount &get_bank_accounts(size_t user_id, size_t account_id) const;
};

