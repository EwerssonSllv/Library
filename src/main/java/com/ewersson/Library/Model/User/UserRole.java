package com.ewersson.Library.Model.User;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public enum UserRole {

    ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER");

    private Integer code;
    private String description;

    UserRole(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static UserRole toEnum(Integer code) {
        if (Objects.isNull(code))
            return null;

        for (UserRole x : UserRole.values()) {
            if (code.equals(x.getCode()))
                return x;
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }

    public Integer getCode() {
        return code;
    }
}
