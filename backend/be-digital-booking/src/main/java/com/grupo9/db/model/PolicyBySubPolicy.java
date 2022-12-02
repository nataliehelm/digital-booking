package com.grupo9.db.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "policyBySubPolicy")
public class PolicyBySubPolicy {


    @EmbeddedId
    private PolicyBySubPolicyId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("policyId")
    private Policy policy;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("subPolicyId")
    private SubPolicy subPolicy;

}
