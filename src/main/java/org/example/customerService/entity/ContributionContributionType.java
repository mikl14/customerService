package org.example.customerService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class ContributionContributionType implements Serializable {
    @Id
    @ManyToOne(targetEntity = Contribution.class)
    @JoinColumn(name = "id_contribution")
    private long idContribution;
    @ManyToOne(targetEntity = ContributionType.class)
    @JoinColumn(name = "id_contribution_type")
    private long idContributionType;

    public ContributionContributionType() {
    }
}
