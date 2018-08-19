package controller;

import controller.dto.RegistrationForm;
import model.entity.User;
import model.service.UserService;

public class Main{
    public static void main(String[] args) {
        RegistrationForm registrationForm = new RegistrationForm.Builder().
                setFirstName("Jack").
                setLastName("Black").
                setMiddleName("Samuel").
                setLogin("JackB").
                setPassword("j5").
                build();
        UserService.registerUser(registrationForm);
        User user = UserService.login(registrationForm);
        System.out.println(user.getRole());
    }
}
