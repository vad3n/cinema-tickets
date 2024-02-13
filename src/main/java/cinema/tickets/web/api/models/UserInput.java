package cinema.tickets.web.api.models;

public class UserInput {
    public String username;
    public String password;
    public String email;

    public UserInput(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
