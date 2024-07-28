package com.ewersson.Library.Repository;

import com.ewersson.Library.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
