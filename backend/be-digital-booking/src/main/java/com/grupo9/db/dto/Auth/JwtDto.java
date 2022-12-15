package com.grupo9.db.dto.Auth;

import com.grupo9.db.model.Location;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtDto {

    private String sub;
    private Integer iat;
    private Integer exp;
    private String name;
    private String lastname;
    private Boolean isActive;
    private Location location;
    private Long userId;

    public JwtDto(String sub, Integer iat, Integer exp, String name, String lastname, Boolean isActive, Long userId) {
        this.sub = sub;
        this.iat = iat;
        this.exp = exp;
        this.name = name;
        this.lastname = lastname;
        this.isActive = isActive;
        this.userId = userId;
    }
}
