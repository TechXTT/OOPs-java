#pragma once
#include <iostream>
#include <vector>
#include "BankAccount.hh"

class User {
    private:
        size_t id;
        std::string name;
        std::vector<BankAccount> accounts;
    public:
        User();
        User(std::string name);
        User(size_t id, std::string name);
        size_t getId();
        std::string getName();
};