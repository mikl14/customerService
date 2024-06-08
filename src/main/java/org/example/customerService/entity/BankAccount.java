package org.example.customerService.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long sum;

    @OneToMany(mappedBy = "bankAccount", targetEntity = BankOperation.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<BankOperation> operations = new ArrayList<>();

    public BankAccount(Long sum, List<BankOperation> operations) {
        this.sum = sum;
        this.operations = operations;
    }

    public BankAccount() {
    }

    public void refill(Long value)
    {
        sum = sum + value;
    }

    public void takeOff(Long value)
    {
        sum = sum - value;
    }

    public Long getSum() {
        return sum;
    }

    public List<BankOperation> getOperations() {
        return operations;
    }
}
