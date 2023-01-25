package com.example.apiblogapplication.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiblogapplication.entity.Post;
import com.example.apiblogapplication.exception.ResourceNotFoundException;
import com.example.apiblogapplication.payload.PostDto;
import com.example.apiblogapplication.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository pr;

	@Autowired
	private ModelMapper modelmap;
	
	@Override
	public PostDto createPost(PostDto postdto) {
		
		Post post = modelmap.map(postdto, Post.class);
		Post save = pr.save(post);
		
		PostDto dto = modelmap.map(save, PostDto.class);
		return dto;
	}

	@Override
	public List<PostDto> getData() {
		List<Post> list = pr.findAll();
		
		List<PostDto> dto = list.stream().map(x-> modelmap.map(list, PostDto.class)).collect(Collectors.toList());
		
		return dto;
	}

	@Override
	public PostDto getDataId(long id) {
		
		Post post = pr.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
		
		PostDto dto = modelmap.map(post, PostDto.class);
		
		return dto;
	}

	@Override
	public PostDto updateData(long id, PostDto postdto) {
		
		Post post = pr.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
		
		Post map = modelmap.map(postdto, Post.class);
		Post save = pr.save(map);
		
		PostDto dto = modelmap.map(save, PostDto.class);

		
		return dto;
	}

	@Override
	public void deleteData(long id) {
		
		Post post = pr.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
		
		
pr.delete(post);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
