package com.grupo9.db.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class PolicyBySubPolicyId implements Serializable {

        @Column(name = "policy_id")
        private Long policyId;

        @Column(name = "subpolicy_id")
        private Long subPolicyId;


}
