package cinema.tickets.web.api.models;

public class TicketInput {
    public Integer userId;
    public Integer projectionId;

    public TicketInput(Integer userId, Integer projectionId) {
        this.userId = userId;
        this.projectionId = projectionId;
    }
}
