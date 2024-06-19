package com.example.celikProjekt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.celikProjekt.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
