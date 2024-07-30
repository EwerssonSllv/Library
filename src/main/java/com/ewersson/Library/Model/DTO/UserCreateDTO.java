package com.ewersson.Library.Model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateDTO {

    @NotBlank
    @Size(min = 3, max = 100)
    private String username;

    @NotBlank
    @Size(min = 3, max = 15)
    private String password;

    public @NotBlank @Size(min = 3, max = 100) String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank @Size(min = 3, max = 100) String username) {
        this.username = username;
    }

    public @NotBlank @Size(min = 3, max = 15) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 3, max = 15) String password) {
        this.password = password;
    }
}
