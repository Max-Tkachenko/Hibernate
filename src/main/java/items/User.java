package items;

public class User {

    public int id;
    public String name;
    public String surname;
    public int age;

    public User() {}
    public User(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
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
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(User user) {
        boolean bool;
        if(user.getId() == this.getId() && user.getName().equals(this.getName()) && user.getSurname().equals(this.getSurname())
                && user.getAge() == this.getAge()) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    @Override
    public String toString() {
        return String.format("|Id: %d|Name: %s|Surname: %s|Age: %d|", id, name, surname, age);
    }
}
