package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id", nullable = false)
    private int ticket_id;

    @Column(name = "from_place", nullable = false, length = 100)
    private String from_place;

    @Column(name = "to_place", nullable = false, length = 100)
    private String to_place;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "flight_number", nullable = false)
    private String flight_number;

    @Column(name = "seat_number", nullable = false)
    private int seat_number;

    public String getFrom_place() {
        return from_place;
    }

    public void setFrom_place(String from_place) {
        this.from_place = from_place;
    }

    public String getTo_place() {
        return to_place;
    }

    public void setTo_place(String to_place) {
        this.to_place = to_place;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }
}
