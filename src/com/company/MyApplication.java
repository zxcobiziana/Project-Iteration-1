package com.company;

import com.company.controllers.interfaces.IOrderController;
import com.company.controllers.interfaces.IProductController;
import com.company.controllers.interfaces.IRestaurantController;
import com.company.controllers.interfaces.IUserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final Scanner scanner = new Scanner(System.in);

    private final IUserController uController;
    private final IRestaurantController rController;
    private final IProductController pController;
    private final IOrderController oController;

    public MyApplication(IUserController uController, IRestaurantController rController, IProductController pController, IOrderController oController) {
        this.uController = uController;
        this.rController = rController;
        this.pController = pController;
        this.oController = oController;
    }

    private void mainMenu() {
        System.out.println();
        System.out.println("Welcome to My Application");
        System.out.println("Select option:");
        System.out.println("Restaurants");
        System.out.println("1. Show all restaurants");
        System.out.println("2. Create restaurant");
        System.out.println("3. Update restaurant");
        System.out.println("Products");
        System.out.println("4. Show restaurant menu");
        System.out.println("5. Create product");
        System.out.println("6. Update product");
        System.out.println("7. Delete product");
        System.out.println("Users");
        System.out.println("8. Show all users");
        System.out.println("9. Create user");
        System.out.println("Orders");
        System.out.println("10. Show all orders by restaurant id");
        System.out.println("11. Create order");
        System.out.println("12. Update order");
        System.out.println("13. Get products by order id");
        System.out.println("14. Add product to order");
        System.out.println("15. Update order product");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Enter option (1-15): ");
    }

    public void start() {
        while (true) {
            mainMenu();
            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        getAllRestaurantsMenu();
                        break;
                    case 2:
                        createRestaurantMenu();
                        break;
                    case 3:
                        updateRestaurantMenu();
                        break;
                    case 4:
                        getRestaurantProductsMenu();
                        break;
                    case 5:
                        createRestaurantProductMenu();
                        break;
                    case 6:
                        updateRestaurantProductMenu();
                        break;
                    case 7:
                        deleteRestaurantProductMenu();
                        break;
                    case 8:
                        getAllUsersMenu();
                        break;
                    case 9:
                        createUserMenu();
                        break;
                    case 10:
                        getRestaurantOrdersMenu();
                        break;
                    case 11:
                        createOrderMenu();
                        break;
                    case 12:
                        updateOrderMenu();
                        break;
                    case 13:
                        getOrderProductsMenu();
                        break;
                    case 14:
                        addOrderProductMenu();
                        break;
                    case 15:
                        updateOrderProductMenu();
                        break;
                    default:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer: " + e);
                scanner.nextLine(); // to ignore incorrect input
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");
        }
    }

    public void getAllRestaurantsMenu() {
        String response = rController.getAllRestaurants();
        System.out.println(response);
    }

    public void createRestaurantMenu() {
        System.out.println("Please enter title");
        String title = scanner.next();
        System.out.println("Please enter address");
        String address = scanner.next();
        System.out.println("Please enter worktime");
        String worktime = scanner.next();
        System.out.println("Please enter phone");
        String phone = scanner.next();
        System.out.println("Please enter is_blocked (1 | 0)");
        boolean is_blocked = scanner.next().equals("1");

        String response = rController.createRestaurant(title, address, worktime, phone, is_blocked);
        System.out.println(response);
    }

    public void updateRestaurantMenu() {
        System.out.println("Please enter id");
        String id = scanner.next();
        System.out.println("Please enter title");
        String title = scanner.next();
        System.out.println("Please enter address");
        String address = scanner.next();
        System.out.println("Please enter worktime");
        String worktime = scanner.next();
        System.out.println("Please enter phone");
        String phone = scanner.next();
        System.out.println("Please enter is_blocked (1 | 0)");
        boolean is_blocked = scanner.next().equals("1");

        String response = rController.updateRestaurant(Integer.parseInt(id), title, address, worktime, phone, is_blocked);
        System.out.println(response);
    }

    public void getRestaurantProductsMenu() {
        System.out.println("Please enter restaurant id");
        String id = scanner.next();

        String response = pController.getProductsByRestaurantId(Integer.parseInt(id));
        System.out.println(response);
    }

    public void createRestaurantProductMenu() {
        System.out.println("Please enter title");
        String title = scanner.next();
        System.out.println("Please enter description");
        String description = scanner.next();
        System.out.println("Please enter price");
        String price = scanner.next();
        System.out.println("Please enter restaurant_id");
        String restaurant_id = scanner.next();

        String response = pController.createProduct(title, description, Integer.parseInt(price), Integer.parseInt(restaurant_id));
        System.out.println(response);
    }

    public void updateRestaurantProductMenu() {
        System.out.println("Please enter id");
        String id = scanner.next();
        System.out.println("Please enter title");
        String title = scanner.next();
        System.out.println("Please enter description");
        String description = scanner.next();
        System.out.println("Please enter price");
        String price = scanner.next();
        System.out.println("Please enter restaurant_id");
        String restaurant_id = scanner.next();

        String response = pController.updateProduct(Integer.parseInt(id), title, description, Integer.parseInt(price), Integer.parseInt(restaurant_id));
        System.out.println(response);
    }

    public void deleteRestaurantProductMenu() {
        System.out.println("Please enter id");
        String id = scanner.next();

        String response = pController.deleteProduct(Integer.parseInt(id));
        System.out.println(response);
    }

    public void getAllUsersMenu() {
        String response = uController.getAllUsers();
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Please enter fullname");
        String fullName = scanner.next();
        System.out.println("Please enter login");
        String login = scanner.next();

        String response = uController.createUser(fullName, login);
        System.out.println(response);
    }

    public void getRestaurantOrdersMenu() {
        System.out.println("Please enter restaurant id");
        String id = scanner.next();

        String response = oController.getOrdersByRestaurantId(Integer.parseInt(id));
        System.out.println(response);
    }

    public void createOrderMenu() {
        System.out.println("Please enter status");
        String status = scanner.next();
        System.out.println("Please enter user_id");
        String user_id = scanner.next();
        System.out.println("Please enter restaurant_id");
        String restaurant_id = scanner.next();

        String response = oController.createOrder(status, Integer.parseInt(user_id), Integer.parseInt(restaurant_id));
        System.out.println(response);
    }

    public void updateOrderMenu() {
        System.out.println("Please enter id");
        String id = scanner.next();
        System.out.println("Please enter status");
        String status = scanner.next();
        System.out.println("Please enter user_id");
        String user_id = scanner.next();
        System.out.println("Please enter restaurant_id");
        String restaurant_id = scanner.next();

        String response = oController.updateOrder(Integer.parseInt(id), status, Integer.parseInt(user_id), Integer.parseInt(restaurant_id));
        System.out.println(response);
    }

    public void getOrderProductsMenu() {
        System.out.println("Please enter order id");
        String id = scanner.next();

        String response = oController.getProductsByOrderId(Integer.parseInt(id));
        System.out.println(response);
    }

    public void addOrderProductMenu() {
        System.out.println("Please enter order_id");
        String order_id = scanner.next();
        System.out.println("Please enter product_id");
        String product_id = scanner.next();
        System.out.println("Please enter count");
        String count = scanner.next();

        String response = oController.addOrderProduct(Integer.parseInt(order_id), Integer.parseInt(product_id), Integer.parseInt(count));
        System.out.println(response);
    }

    public void updateOrderProductMenu() {
        System.out.println("Please enter order_id");
        String order_id = scanner.next();
        System.out.println("Please enter product_id");
        String product_id = scanner.next();
        System.out.println("Please enter count");
        String count = scanner.next();

        String response = oController.modifyOrderProduct(Integer.parseInt(order_id), Integer.parseInt(product_id), Integer.parseInt(count));
        System.out.println(response);
    }
}
