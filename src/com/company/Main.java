package com.company;

import com.company.controllers.OrderController;
import com.company.controllers.ProductController;
import com.company.controllers.RestaurantController;
import com.company.controllers.UserController;
import com.company.controllers.interfaces.IOrderController;
import com.company.controllers.interfaces.IProductController;
import com.company.controllers.interfaces.IRestaurantController;
import com.company.controllers.interfaces.IUserController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.OrderRepository;
import com.company.repositories.ProductRepository;
import com.company.repositories.RestaurantRepository;
import com.company.repositories.UserRepository;
import com.company.repositories.interfaces.IOrderRepository;
import com.company.repositories.interfaces.IProductRepository;
import com.company.repositories.interfaces.IRestaurantRepository;
import com.company.repositories.interfaces.IUserRepository;

public class Main {

    public static void main(String[] args) {
        // Here you specify which DB and UserRepository to use
        // And changing DB should not affect to whole code
        IDB db = new PostgresDB("jdbc:postgresql://localhost:5432", "postgres", "123456", "application_oop");

        IUserRepository uRepo = new UserRepository(db);
        IRestaurantRepository rRepo = new RestaurantRepository(db);
        IProductRepository pRepo = new ProductRepository(db);
        IOrderRepository oRepo = new OrderRepository(db);

        IUserController uController = new UserController(uRepo);
        IRestaurantController rController = new RestaurantController(rRepo);
        IProductController pController = new ProductController(pRepo);
        IOrderController oController = new OrderController(oRepo);

        MyApplication app = new MyApplication(uController, rController, pController, oController);

        app.start();

        db.close();
    }
}
