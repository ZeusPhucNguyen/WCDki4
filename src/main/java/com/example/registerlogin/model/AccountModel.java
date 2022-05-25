package com.example.registerlogin.model;

public interface AccountModel {
    Account save(Account obj);

    List<Account> findAll();

    Account findById(int id);
    Account findByUsername(String username);
    Account findByEmail(String email);
    Account update(int id, Account updateObj);

    boolean delete(int id);
}
