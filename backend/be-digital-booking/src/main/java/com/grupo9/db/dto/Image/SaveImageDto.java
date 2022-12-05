package com.grupo9.db.dto.Image;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaveImageDto {

  @NotEmpty(message = "url is mandatory")
  private String url;
  @NotEmpty(message = "title is mandatory")
  private String title;
  private Long product_id;
}
