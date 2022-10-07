#include <iostream>
#include <vector>
#include <unordered_map>

#include "BankAccount.hh"
#include "User.hh"
#include "Bank.hh"

using namespace std;

void Bank::add_user(size_t id, std::string name) {
    this->users.contains(id) ? throw invalid_argument("User already exists") : users[id].push_back(User(name));
}

void Bank::add_bank_accout(size_t user_id, size_t account_id, double balance) {

}

long double Bank::get_balance(size_t user_id, size_t account_id) const {

}

BankAccount &Bank::get_bank_accounts(size_t user_id, size_t account_id) const {

}