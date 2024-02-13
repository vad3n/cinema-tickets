package cinema.tickets.core.models;

public class Ticket {
    public Integer id;
    public Integer userId;
    public Integer projectionId;

    public Ticket(Integer id, Integer userId, Integer projectionId) {
        this.id = id;
        this.userId = userId;
        this.projectionId = projectionId;
    }

    @Override
    public String toString() {
        return "Ticket {" +
                " id = " + id +
                ", userId = " + userId +
                ", projectionId = " + projectionId +
                "}";
    }
}
