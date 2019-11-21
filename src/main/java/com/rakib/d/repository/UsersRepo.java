package com.rakib.d.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rakib.e.models.Users;
@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
}
