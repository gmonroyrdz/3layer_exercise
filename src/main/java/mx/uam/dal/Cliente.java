package mx.uam.dal;

public class Cliente {
    private int id;
    private String username;
    private String name;
    private String lastname;
    private String age;
    
    public Cliente() {
    }

    public Cliente(int id, String username, String name, String lastname, String age) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }
    public Cliente(String username, String name, String lastname, String age) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
                String sep = "\n";
                str.append("ID:");
                str.append(id);
                str.append(sep);
                str.append("USERNAME:");
                str.append(username);
                str.append(sep);
                str.append("NAME:");
                str.append(name);
                str.append(sep);
                str.append("LASTNAME:");
                str.append(lastname);
                str.append(sep);
                str.append("AGE:");
                str.append(age);
                str.append(sep);
        return str.toString();
    }
}
