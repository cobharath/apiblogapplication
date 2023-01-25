package com.example.apiblogapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiblogapplication.entity.Comment;
import com.example.apiblogapplication.payload.CommentDto;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findBypost_id(long id);

}
