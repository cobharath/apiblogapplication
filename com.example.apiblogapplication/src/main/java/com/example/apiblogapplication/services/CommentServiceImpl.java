package com.example.apiblogapplication.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiblogapplication.entity.Comment;
import com.example.apiblogapplication.entity.Post;
import com.example.apiblogapplication.exception.ResourceNotFoundException;
import com.example.apiblogapplication.payload.CommentDto;
import com.example.apiblogapplication.repository.CommentRepository;
import com.example.apiblogapplication.repository.PostRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	
	
	@Autowired
	private PostRepository  pr;
	
	@Autowired
	private ModelMapper mm;
	@Autowired
	private  CommentRepository  cr ;

	@Override
	public CommentDto createComment(CommentDto commentdto , long id) {
		Post post = pr.findById(id).orElseThrow(()-> new ResourceNotFoundException("post", "id", id));

		Comment comment = mm.map(commentdto, Comment.class);
		
		comment.setPost(post);
		
		Comment save = cr.save(comment);
		CommentDto dto = mm.map(save, CommentDto.class);
		
		
		return dto;
	}

	@Override
	public CommentDto getData(long postid, long id) {
		
		Post post = pr.findById(postid).orElseThrow(()-> new ResourceNotFoundException("post", "id", postid));
		Comment comment = cr.findById(id).orElseThrow(()-> new ResourceNotFoundException("comment", "id", id));
		
		
		CommentDto dto = mm.map(comment, CommentDto.class);
		
		
		
		
		
		
		return dto;
	}

	@Override
	public List<CommentDto> byPostId(long id) {
		
		List<Comment> list = cr.findBypost_id(id);
		
	
		List<CommentDto> collect = list.stream().map(x-> mapToDto(x)).collect(Collectors.toList());
		return collect;

	}
		
		
	private CommentDto mapToDto(Comment x) {
		
		

		return 		mm.map(x, CommentDto.class);

	}


	

	@Override
	public CommentDto updateData(long postid, long id, CommentDto commentdto) {
		Post post = pr.findById(postid).orElseThrow(()-> new ResourceNotFoundException("post", "id", postid));
		Comment comment = cr.findById(id).orElseThrow(()-> new ResourceNotFoundException("comment", "id", id));
		
		 
		Comment map = mm.map(commentdto,Comment.class );
		
		Comment save = cr.save(map);
		CommentDto dto = mm.map(save, CommentDto.class);
		
		
		
		
		return dto;
	}

	@Override
	public void deleteData(long postid, long id) {
		
		Post post = pr.findById(postid).orElseThrow(()-> new ResourceNotFoundException("post", "id", postid));
		Comment comment = cr.findById(id).orElseThrow(()-> new ResourceNotFoundException("comment", "id", id));
		
		cr.delete(comment);
	}
	
	
	
	
	

}
