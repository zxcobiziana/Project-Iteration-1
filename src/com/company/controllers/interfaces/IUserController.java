package com.company.controllers.interfaces;

public interface IUserController {
    String createUser(String fullname, String login);
    String getUser(int id);
    String getAllUsers();
}
