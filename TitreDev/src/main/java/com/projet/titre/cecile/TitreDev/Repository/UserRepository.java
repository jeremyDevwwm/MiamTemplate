package com.projet.titre.cecile.TitreDev.Repository;

import com.projet.titre.cecile.TitreDev.Entities.UserMiam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserMiam, Long> {

    UserMiam findByLogin(String username);

    @Modifying
    @Query(value = "UPDATE UserMiam u SET u.mdp= ?1 WHERE u.id= ?2")
    void updateUserPass(String userM, long id);
}
