package com.grupo9.db.dto.Image;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaveImageDto {

  private String url;
  private String title;

  @NotNull(message = "product_id is mandatory")
  private Long product_id;
}
