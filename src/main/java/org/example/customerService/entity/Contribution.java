package org.example.customerService.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "bank_contribution")
public class Contribution implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "bank_user")
    User bankUser;

    String productCode,contributionAccount,returnCode,period;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate payPeriod,openDate,closedDate;
    Long sum;
    int persent;

    public Contribution(String productCode, String contributionAccount, String returnCode, String period, LocalDate payPeriod, LocalDate openDate, LocalDate closedDate, ContributionType type, Long sum, int persent) {
        this.productCode = productCode;
        this.contributionAccount = contributionAccount;
        this.returnCode = returnCode;
        this.period = period;
        this.payPeriod = payPeriod;
        this.openDate = openDate;
        this.closedDate = closedDate;
        this.sum = sum;
        this.persent = persent;
    }

    public Contribution() {
    }
}
