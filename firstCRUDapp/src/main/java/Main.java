import models.Auto;
import models.User;
import org.hibernate.Hibernate;
import services.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        Методы бизнес-логики должны быть на уровне сервисов, и
        транзакционность также должна быть на уровне сервисов.
        В идеальном случае вам необходим менеджер транзакций,
        но это уже надо использовать Spring (с ним будет проще).
        В данном случае можно сделать все на уровне DAO.

        Решение, которое я предложил в рамках данного проекта -
        не идеальное. Лучшим решением будет изменение архитектуры!
        */


        UserService userService = new UserService();

        /*
        Вариант 1: использовать метод findAllUsers,
        а внутри него на уровне DAO Hibernate.initialize.
        Но такой подход мне нравиться меньше всего, так как
        ленивая инициализыция теряет смысл.

        */
        List<User> users = userService.findAllUsers();
        //User user = users.get(0);

        /*
        Вариант 2: использовать метод findUser,
        а внутри него на уровне DAO Hibernate.initialize
        */
        User user = userService.findUser(1);

        System.out.println(user);
        Auto auto = new Auto("Bugatti", "Black");
        userService.addAuto(user, auto); //вылетает тут
        userService.updateUser(user);

//        UserService userService = new UserService();
//        User user = new User("Masha",26);
//        userService.saveUser(user);
//        Auto ferrari = new Auto("Ferrari", "red");
//        ferrari.setUser(user);
//        user.addAuto(ferrari);
//        Auto ford = new Auto("Ford", "black");
//        ford.setUser(user);
//        user.addAuto(ford);
//        userService.updateUser(user);

    }
}
