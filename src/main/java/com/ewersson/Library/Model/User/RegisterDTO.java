package com.ewersson.Library.Model.User;

public record RegisterDTO(String login,UserRole role, String password) {
}
