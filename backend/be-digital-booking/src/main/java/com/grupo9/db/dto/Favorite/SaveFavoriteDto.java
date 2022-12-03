package com.grupo9.db.dto.Favorite;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SaveFavoriteDto {
    @NotNull(message = "product_id is mandatory")
    private Long product_id;
    @NotNull(message = "user_id is mandatory")
    private Long user_id;
}
