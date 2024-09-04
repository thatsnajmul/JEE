package com.thatsnajmul.MySpringBootProject.repository;

import com.thatsnajmul.MySpringBootProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

}
