package com.grupo9.db.dto.Policy;

import com.grupo9.db.model.SubPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SavePolicyDto {
    @NotEmpty(message = "title is mandatory")
    private String title;

    @NotNull(message = "subPolicyIds is mandatory")
    private List<Long> subPolicyIds;
}
