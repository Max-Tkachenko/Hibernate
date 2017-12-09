package items;

public class News {

    public int id;
    public int chatId;
    public String dateOfCreating;
    public String context;

    public News() { }
    public News(int id, int chatId, String dateOfCreating, String context) {
        this.id = id;
        this.chatId = chatId;
        this.dateOfCreating = dateOfCreating;
        this.context = context;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getChatId() {
        return chatId;
    }
    public void setChatId(int chatI) {
        this.chatId = chatI;
    }
    public String getDateOfCreating() {
        return dateOfCreating;
    }
    public void setDateOfCreating(String dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }

    public boolean equals(News news) {
        boolean bool;
        if(news.getId() == this.getId() && news.getChatId() == this.getChatId() && news.getDateOfCreating().equals(this.getDateOfCreating())
                && news.getContext().equals(this.getContext())) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    @Override
    public String toString() {
        return String.format("|Id: %d|ChatId: %d|DateOfCreating: %s|Context: %s|", id, chatId, dateOfCreating, context);
    }
}
