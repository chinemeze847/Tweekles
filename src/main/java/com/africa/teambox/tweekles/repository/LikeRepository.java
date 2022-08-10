package com.africa.teambox.tweekles.repository;

import com.africa.teambox.tweekles.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface LikeRepository extends JpaRepository<Like, UUID> {

}


