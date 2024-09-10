package com.thatsnajmul.job_portal.Repository;

import com.thatsnajmul.job_portal.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer>{
    Optional<Token> findByToken(String token);
    @Query("""
select t from Token t inner join UserEntity u on t.userEntity.id = u.id
where t.userEntity.id = :userId and t.loggedOut = false
""")
    List<Token> findAllTokensByUser(Long userId);
}
