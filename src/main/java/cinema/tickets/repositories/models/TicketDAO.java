package cinema.tickets.repositories.models;

public class TicketDAO {
    public Integer id;
    public Integer userId;
    public Integer projectionId;

    public TicketDAO(Integer id, Integer userId, Integer projectionId) {
        this.id = id;
        this.userId = userId;
        this.projectionId = projectionId;
    }

    @Override
    public String toString() {
        return "TicketDAO {" +
                " id = " + id +
                ", userId = " + userId +
                ", projectionId = " + projectionId +
                "}";
    }
}