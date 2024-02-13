package cinema.tickets.repositories.models;

public class UserDAO {
    public Integer id;
    public String username;
    public String password;
    public String email;

    public UserDAO(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDAO {" +
                " id = " + id +
                ", username = " + username +
                ", password = " + password +
                ", email = " + email +
                "}";
    }
}
