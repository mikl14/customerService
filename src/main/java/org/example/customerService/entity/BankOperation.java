package org.example.customerService.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class BankOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    BigDecimal sum;
    String type;
    LocalDate date;

    @ManyToOne(targetEntity = BankAccount.class)
    @JoinColumn(name = "bank_account")
    BankAccount bankAccount;
    public BankOperation(BigDecimal sum, String type, LocalDate date) {
        this.sum = sum;
        this.type = type;
        this.date = date;
    }

    public BankOperation() {
    }
}
