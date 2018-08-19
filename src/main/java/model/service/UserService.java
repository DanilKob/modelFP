package model.service;

import controller.dto.RegistrationForm;
import model.dao.UserDao;
import model.dao.config.DataBaseConfiguration;
import model.entity.User;

public class UserService {

    public static void registerUser(User user){
        try(UserDao userDao = DataBaseConfiguration.factory.createUserDao()){
            userDao.create(user);
        }
    }

    public static void registerUser(RegistrationForm registrationForm){
        try(UserDao userDao = DataBaseConfiguration.factory.createUserDao()){
            User user = new User.Builder().
                    setFirstName(registrationForm.getFirstName())
                    .setLastName(registrationForm.getLastName())
                    .setMiddleName(registrationForm.getMiddleName())
                    .setLogin(registrationForm.getLogin())
                    .setPassword(registrationForm.getPassword())
                    .setRole(User.ROLE.USER)
                    .build();
            userDao.create(user);
        }
    }

    public static User login(RegistrationForm registrationForm){
        User user = null;
        try(UserDao userDao = DataBaseConfiguration.factory.createUserDao()){
            user = userDao.findByLoginPassword(registrationForm.getLogin(),registrationForm.getPassword());
        }
        return user;
    }
}
