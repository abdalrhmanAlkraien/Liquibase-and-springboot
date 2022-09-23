package com.abdalrhman.liquibase_article.repository;

import com.abdalrhman.liquibase_article.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
