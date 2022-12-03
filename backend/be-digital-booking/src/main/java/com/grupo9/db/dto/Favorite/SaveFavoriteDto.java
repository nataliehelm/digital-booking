package com.grupo9.db.dto.Favorite;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SaveFavoriteDto {

    private Long productId;
    private Long userId;

}
