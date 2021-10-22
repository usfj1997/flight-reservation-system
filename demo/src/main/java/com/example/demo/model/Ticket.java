package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticket_id;

    @OneToOne(mappedBy = "passenger", cascade = )
}
