package com.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private int tid;
    @CreationTimestamp
    private LocalDate borrowedDate;
    private LocalDate returnedDate;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    @ManyToOne
    @JoinColumn(name="bookId")
    private Book book;
    private float amount;
    private String status;
    @OneToOne
    @JoinColumn(name="penalty_id")
    private Penalty penalty;
}
