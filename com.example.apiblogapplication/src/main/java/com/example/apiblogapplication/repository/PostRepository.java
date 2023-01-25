package com.example.apiblogapplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiblogapplication.entity.Post;

public interface PostRepository extends JpaRepository<Post ,Long> {

}
