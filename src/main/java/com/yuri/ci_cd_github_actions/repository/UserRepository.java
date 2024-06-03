package com.yuri.ci_cd_github_actions.repository;

import com.yuri.ci_cd_github_actions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
