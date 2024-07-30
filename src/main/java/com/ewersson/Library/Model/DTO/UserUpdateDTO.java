package com.ewersson.Library.Model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDTO {

    private Integer id;

    @NotBlank
    @Size(min = 8, max = 60)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 8, max = 60) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 8, max = 60) String password) {
        this.password = password;
    }
}
