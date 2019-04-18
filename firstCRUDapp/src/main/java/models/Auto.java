package models;


import javax.persistence.*;

@Entity
@Table(name = "f_autos")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auto_id;

    @Column(name = "auto_model")
    private String model;

    @Column(name = "auto_color")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "a_user_id") //a_user_id is foreign key
    private User user;

    public Auto(){}

    public Auto(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return auto_id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public User getUser() {
        return user;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return color + " " + model;
    }
}
