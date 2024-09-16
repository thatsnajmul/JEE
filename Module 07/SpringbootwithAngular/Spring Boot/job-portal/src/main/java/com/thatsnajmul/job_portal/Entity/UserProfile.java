package com.thatsnajmul.job_portal.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String location;

    @Lob
    private byte[] image;

    // Constructors, Getters and Setters

    public UserProfile() {}

    public UserProfile(String name, String address, String location, byte[] image) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.image = image;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }
}
