package model;

public class ActivityData {
    private final String date;
    private final String comments;
    private final String status;

    public ActivityData(String date, String comments, String status) {
        this.date = date;
        this.comments = comments;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public String getComments() {
        return comments;
    }

    public String getStatus() {
        return status;
    }
}
