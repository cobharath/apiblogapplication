package com.example.apiblogapplication.services;

import java.util.List;

import com.example.apiblogapplication.payload.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentdto , long id);

	CommentDto getData(long postid, long id);

	List<CommentDto> byPostId(long id);

	CommentDto updateData(long postid, long id, CommentDto commentdto);

	void deleteData(long postid, long id);

}
