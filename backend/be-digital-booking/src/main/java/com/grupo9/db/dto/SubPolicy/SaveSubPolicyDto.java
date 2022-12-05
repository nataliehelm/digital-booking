package com.grupo9.db.dto.SubPolicy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class SaveSubPolicyDto {

    @NotEmpty(message = "description is mandatory")
    private String description;
    @NotNull(message = "product_id is mandatory")
    private Long product_id;
    private Long policy_id;

}
