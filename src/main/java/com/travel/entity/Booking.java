package com.travel.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String email;
    private String destination;
    private double price;
    private LocalDate travelDate;

    // ✅ ADD THIS FIELD
    @Column(nullable = false)
    private int seatsBooked = 1;   // default value

    // ✅ RELATION WITH USER
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    
    
    
    public Booking() {
		super();
	}

	public Booking(Long id, String customerName, String email, String destination, double price, LocalDate travelDate,
			int seatsBooked, User user) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.email = email;
		this.destination = destination;
		this.price = price;
		this.travelDate = travelDate;
		this.seatsBooked = seatsBooked;
		this.user = user;
	}

	// getters & setters

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	@Override
	public String toString() {
		return "id=" + id + ", customerName=" + customerName + ", email=" + email + ", destination="
				+ destination + ", price=" + price + ", travelDate=" + travelDate + ", seatsBooked=" + seatsBooked
				+ ", user=" + user ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
    
    
}
