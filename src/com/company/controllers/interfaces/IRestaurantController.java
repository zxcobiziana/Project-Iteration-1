package com.company.controllers.interfaces;

public interface IRestaurantController {
    String createRestaurant(String title, String address, String worktime, String phone, boolean is_blocked);

    String getRestaurant(int id);

    String getAllRestaurants();

    String updateRestaurant(int id, String title, String address, String worktime, String phone, boolean is_blocked);
}
