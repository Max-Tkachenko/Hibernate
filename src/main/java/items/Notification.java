package items;

public class Notification {

    public int id;
    public int userId;
    public String context;

    public Notification() { }
    public Notification(int id, int userId, String context) {
        this.id = id;
        this.userId = userId;
        this.context = context;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }

    public boolean equals(Notification note) {
        boolean bool;
        if(note.getId() == this.getId() && note.getUserId() == this.getUserId() && note.getContext().equals(this.getContext())) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    @Override
    public String toString() {
        return String.format("|Id: %d|UserId: %d|Context: %s|", id, userId, context);
    }
}
