package cinema.tickets.core.models;

public class Movie {
    public Integer id;
    public String title;
    public String description;
    public String imageUrl;

    public Movie(Integer id, String title, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Movie {" +
                " id = " + id +
                ", title = " + title +
                ", description = " + description +
                ", imageUrl = " + imageUrl +
                "}";
    }
}
