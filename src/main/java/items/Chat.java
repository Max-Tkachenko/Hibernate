package items;

public class Chat {

    public int id;
    public String name;
    public String dateOfCreating;

    public Chat() { }
    public Chat(int id, String name, String dateOfCreating) {
        this.id = id;
        this.name = name;
        this.dateOfCreating = dateOfCreating;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDateOfCreating() {
        return dateOfCreating;
    }
    public void setDateOfCreating(String dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
    }

    public boolean equals(Chat chat) {
        boolean bool;
        if(chat.getId() == this.getId() && chat.getName().equals(this.getName()) && chat.getDateOfCreating().equals(this.getDateOfCreating())) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    @Override
    public String toString() {
        return String.format("|Id: %d|Name: %s|DateOfCreating: %s|", id, name, dateOfCreating);
    }
}
