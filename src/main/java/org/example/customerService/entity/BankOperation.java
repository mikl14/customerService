package org.example.customerService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class BankOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    Long id;
    @JsonProperty("sum")
    BigDecimal sum;
    @JsonProperty("type")
    String type;
    @JsonProperty("date")
    @JsonFormat(pattern = "yyyy-MM-dd")
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
