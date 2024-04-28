package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("Dinara", "Khalitowa", (byte) 24));
        usersList.add(new User("Marya", "Starikova", (byte) 39));
        usersList.add(new User("Irina", "Levashova", (byte) 25));
        usersList.add(new User("Kamilla", "Karamova", (byte) 11));

        userService.createUsersTable();
        for (User user : usersList) {
            userService.saveUser(user.getName(),user.getLastName(),user.getAge());
            System.out.println("User с именем: " + user.getName() + "добавлен в базу данных");
        }
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
