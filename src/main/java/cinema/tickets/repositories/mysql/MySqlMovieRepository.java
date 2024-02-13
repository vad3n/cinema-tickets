package cinema.tickets.repositories.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import cinema.tickets.repositories.MovieRepository;
import cinema.tickets.repositories.models.MovieDAO;

public class MySqlMovieRepository implements MovieRepository{
    private final TransactionTemplate txTemplate;
    private final JdbcTemplate jdbc;

    public MySqlMovieRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        this.txTemplate = txTemplate;
        this.jdbc = jdbc;
    }

    private MovieDAO fromResultSet(ResultSet rs) throws SQLException {
        return new MovieDAO(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("image_url")
        );
    }

    @Override
    public MovieDAO getMovie(int id) {
        return jdbc.queryForObject(GET_MOVIE,
                (rs, rowNum) -> fromResultSet(rs), id);        
    }

    @Override
    public List<MovieDAO> getMovies() {
        return jdbc.query(GET_MOVIES,
                (rs, rowNum) -> fromResultSet);
    }

    @Override
    public MovieDAO createMovie(String title, String description, String imageUrl) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update(con -> {
            PreparedStatement ps = con.prapareStatement(INSERT_MOVIE, Statement.RETURN_GENERATED_KEYS);
            ps.getString(1, title),
            ps.getString(2, description),
            ps.getString(3, imageUrl);
            return ps;
        }, keyHolder);

        Integer id = Objects.requireNonNull(keyHolder.getKey()).initValue();
        return new MovieDAO(id, title, description, imageUrl);
    }

    @Override
    public MovieDAO updateMovie(int id, String title, String description, String imageUrl) {
        jdbc.update(UPDATE_MOVIE, title, description, imageUrl, id);

        return getMovie(id);
    }

    @Override
    public void deleteMovie(int id) {
        txTemplate.execute(status -> {
            jdbc.update(DELETE_MOVIE, id);
            return null;
        })
    }
    
    static class Queries {
        public static final String GET_MOVIE = "SELECT * FROM movies WHERE id = ?";

        public static final String GET_MOVIES = "SELECT * FROM movies";

        public static final String INSERT_MOVIE = "INSERT INTO movies " +
                "(title, description, image_url) " +
                "VALUES(?, ?, ?)";
        
        public static final String UPDATE_MOVIE = "UPDATE " +
                "movies " +
                "SET title = ?, " +
                "description = ?, " +
                "image_url = ? " +
                "WHERE id = ?";

        public static final String DELETE_MOVIE = "DELETE FROM movies WHERE id = ?";
    }
}
