package lab.entity;

public class User {

    private Long id;
    private String phone;
    private String address;
    private String name;


    public User(Long id, String name, String address, String phone) {
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.name = name;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User{" + "id:" + id + ", phone:'" + phone + ", address:'" + address + ", name:'" + name + '}';
    }
}