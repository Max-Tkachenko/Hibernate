package items;

public class Message {

    public int id;
    public int userId;
    public int chatId;
    public String date;
    public String context;

    public Message() {}
    public Message(int id, int userId, int chatId, String date, String context) {
        this.id = id;
        this.userId = userId;
        this.chatId = chatId;
        this.date = date;
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
    public int getChatId() {
        return chatId;
    }
    public void setChatId(int chatId) {
        this.chatId = chatId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }

    public boolean equals(Message message) {
        boolean bool;
        if(message.getId() == this.getId() && message.getUserId() == this.getUserId() && message.getChatId() == this.getChatId()
                && message.getDate().equals(this.getDate())) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    @Override
    public String toString() {
        return String.format("|Id: %d|UserId: %d|ChatId: %d|Date: %s|Context: %s|", id, userId, chatId, date, context);
    }
}
