package com.grupo9.db.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SaveProductDto {
    @NotEmpty(message = "name is mandatory")
    private String name;
    @NotEmpty(message = "distance_to_nearest_tourist_site is mandatory")
    private String distance_to_nearest_tourist_site;
    @NotNull(message = "ranking is mandatory")
    private Double ranking;
    @NotNull(message = "score is mandatory")
    private Double score;
    @NotEmpty(message = "description_title is mandatory")
    private String description_title;
    @NotEmpty(message = "description is mandatory")
    private String description;
    @NotNull(message = "coordinates is mandatory")
    private List<Double> coordinates;
    @NotNull(message = "categoryId is mandatory")
    private Long categoryId;
    @NotNull(message = "locationId is mandatory")
    private Long locationId;
    @NotEmpty(message = "address is mandatory")
    private String address;
    @NotNull(message = "featureIds is mandatory")
    private List<Long> featureIds;
    @NotNull(message = "policiyIds is mandatory")
    private List<Long> policiyIds;
    @NotNull(message = "userId is mandatory")
    private Long userId;
}
