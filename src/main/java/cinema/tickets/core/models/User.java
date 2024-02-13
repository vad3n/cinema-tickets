package cinema.tickets.core.models;

public class User {
    public Integer id;
    public String username;
    public String password;
    public String email;

    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User {" +
                " id = " + id +
                ", username = " + username +
                ", password = " + password +
                ", email = " + email +
                "}";
    }
}
