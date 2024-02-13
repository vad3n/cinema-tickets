package cinema.tickets.repositories.models;

public class MovieDAO {
    public Integer id;
    public String title;
    public String description;
    public String imageUrl;

    public MovieDAO(Integer id, String title, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "MovieDAO {" +
                " id = " + id +
                ", title = " + title +
                ", description = " + description +
                ", imageUrl = " + imageUrl +
                "}";
    }
}
