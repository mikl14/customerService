package org.example.customerService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ContributionType implements Serializable {
    @Id
    Long id;

    String type;

    public ContributionType() {
    }
}
