import models.Auto;
import models.User;
import org.hibernate.Hibernate;
import services.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        UserService userService = new UserService();
//
//        User user = userService.findUser(7);
//        System.out.println(user);
//        Auto auto = new Auto("Bugatti", "Black");
//        userService.addAuto(user, auto);
//        userService.updateUser(user);
        UserService userService = new UserService();
        User user = new User("Masha",26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
    }
}
