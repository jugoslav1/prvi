package model;

public class User {
    private String username, password,
            name, surname;
    private char sex;
    private int grad_id;

    public User() {
    }

    public User(String username, String password, String name, String surname, char sex, int grad_id) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.grad_id = grad_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getGrad_id() {
        return grad_id;
    }

    public void setGrad_id(int grad_id) {
        this.grad_id = grad_id;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", name=" + name + ", surname=" + surname + ", sex=" + sex + ", grad_id=" + grad_id + '}';
    }
    
    
    
}
