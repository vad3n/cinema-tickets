package cinema.tickets.web.api.models;

public class MovieInput {
    public String title;
    public String description;
    public String imageUrl;

    public MovieInput(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
