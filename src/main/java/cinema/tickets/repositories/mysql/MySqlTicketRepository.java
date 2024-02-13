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

import cinema.tickets.repositories.TicketRepository;
import cinema.tickets.repositories.models.TicketDAO;

public class MySqlTicketRepository implements TicketRepository{
    private final TransactionTemplate txTemplate;
    private final JdbcTemplate jdbc;

    public MySqlTicketRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        this.txTemplate = txTemplate;
        this.jdbc = jdbc;
    }

    private TicketDAO fromResultSet(ResultSet rs) throws SQLException {
        return new TicketDAO(
            rs.getInt("id"),
            rs.getInt("user_id"),
            rs.getInt("projection_id")
        );
    }

    @Override
    public TicketDAO getTicket(int id) {
        return jdbc.queryForObject(Queries.GET_TICKET,
                (rs, rowNum) -> fromResultSet(rs));
    }

    @Override
    public List<TicketDAO> getTickets() {
        return jdbc.query(Queries.GET_TICKETS,
                (rs, rowNum) -> fromResultSet(rs));
    }

    @Override
    public TicketDAO createTicket(int userId, int projectionId) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update(con -> {
            PreparedStatement ps = con.prepareStatement(Queries.INSERT_TICKET, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.setInt(2, projectionId);
            return ps;
        }, keyHolder);

        Integer id = Objects.requireNonNull(keyHolder.getKey()).intValue();
        return new TicketDAO(id, userId, projectionId);
    }

    @Override
    public void deleteTicket(int id) {
        txTemplate.execute(status -> {
            jdbc.update(Queries.DELETE_TICKET, id);
            return null;
        });
    }

    static class Queries {
        public static final String GET_TICKET = "SELECT * FROM tickets WHERE id = ?";

        public static final String GET_TICKETS = "SELECT * FROM tickets";

        public static final String INSERT_TICKET = "INSERT INTO tickets " +
                "(user_id, projection_id) " +
                "VALUES(?, ?)";

        public static final String DELETE_TICKET = "DELETE FROM tickets WHERE id = ?";
    }
}
