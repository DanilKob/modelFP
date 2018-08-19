package controller.dto;

public class RegistrationForm {
    private String firstName;
    private String lastName;
    private String middleName;

    private String login;
    private String password;


    public static class Builder{
        private RegistrationForm registrationForm = new RegistrationForm();

        public Builder setFirstName(String firstName) {
            registrationForm.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName) {
            registrationForm.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            registrationForm.middleName = middleName;
            return this;
        }

        public Builder setLogin(String login) {
            registrationForm.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            registrationForm.password = password;
            return this;
        }

        public RegistrationForm build(){
            return registrationForm;
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
