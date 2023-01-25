package com.example.apiblogapplication.services;

import java.util.List;

import com.example.apiblogapplication.payload.PostDto;

public interface PostService  {

	PostDto createPost(PostDto postdto);

	List<PostDto> getData();

	PostDto getDataId(long id);

	PostDto updateData(long id, PostDto postdto);

	void deleteData(long id);

}
