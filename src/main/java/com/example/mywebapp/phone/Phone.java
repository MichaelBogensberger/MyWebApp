package com.example.mywebapp.phone;

import com.example.mywebapp.user.User;

import javax.persistence.*;

@Entity
@Table(name= "phone")
public class Phone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private Long number;

    @Column(length=50)
    private String anbieter;


    @ManyToOne()
    @JoinColumn(name="OWNER_ID")
    private User owner;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getAnbieter() {
        return anbieter;
    }

    public void setAnbieter(String anbieter) {
        this.anbieter = anbieter;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


}
