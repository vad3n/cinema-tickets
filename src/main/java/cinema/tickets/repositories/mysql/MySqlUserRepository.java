package cinema.tickets.repositories.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.support.TransactionTemplate;

import cinema.tickets.repositories.UserRepository;
import cinema.tickets.repositories.models.UserDAO;

public class MySqlUserRepository implements UserRepository{
    private final TransactionTemplate txTemplate;
    private final JdbcTemplate jdbc;

    public MySqlUserRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        this.txTemplate = txTemplate;
        this.jdbc = jdbc;
    }

    private UserDAO fromResultSet(ResultSet rs) throws SQLException {
        return new UserDAO(
            rs.getInt("id"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("email")
        );
    }

    @Override
    public UserDAO getUser(int id) {
        return jdbc.queryForObject(Queries.GET_USER,
                (rs, rowNum) -> fromResultSet(rs), id);
    }

    @Override
    public List<UserDAO> getUsers() {
        return jdbc.query(Queries.GET_USERS,
                (rs, rowNum) -> fromResultSet(rs));
    }

    @Override
    public UserDAO createUser(String username, String password, String email) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbc.update(con -> {
            PreparedStatement ps = con.prepareStatement(Queries.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            return ps;
        }, keyHolder);

        Integer id = Objects.requireNonNull(keyHolder.getKey()).intValue();
        return new UserDAO(id, username, password, email);
    }

    @Override
    public void deleteUser(int id) {
        txTemplate.execute(status -> {
            jdbc.update(Queries.DELETE_USER, id);
            return null;
        });
    }

    static class Queries {
        public static final String GET_USER = "SELECT * FROM users WHERE id = ?";

        public static final String GET_USERS = "SELECT * FROM users";

        public static final String INSERT_USER = "INSERT INTO users " +
                "(username, password, email) " +
                "VALUES(?, ?, ?)";

        public static final String DELETE_USER = "DELETE FROM users WHERE id = ?";
    }
}
