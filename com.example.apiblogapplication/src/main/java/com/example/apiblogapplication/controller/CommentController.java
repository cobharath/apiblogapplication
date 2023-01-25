package com.example.apiblogapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiblogapplication.payload.CommentDto;
import com.example.apiblogapplication.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService cs;
	
	@PostMapping("/create/{id}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentdto , @PathVariable("id")long id){
		CommentDto dto = cs.createComment(commentdto, id);
		
		return new ResponseEntity<CommentDto>(dto , HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping("{post_id}/com/{id}")


	public ResponseEntity<CommentDto> getData(@PathVariable("post_id")long postid , @PathVariable ("id")long id){
		
		
		
		
	CommentDto dto = cs.getData(postid,id);
		
		return new ResponseEntity<CommentDto>(dto , HttpStatus.OK);
		
		
		
	}
	
	@GetMapping("{post_id}")
	public List<CommentDto> byPostId(@PathVariable ("post_id") long id){
		List<CommentDto> list = cs.byPostId(id);
		
		return list;
		
		
	}

	
	@PutMapping("{post_id}/com/{id}")
	public ResponseEntity<CommentDto> updateData(@PathVariable("post_id")long postid , @PathVariable ("id")long id  , @RequestBody CommentDto commentdto) {
		
		CommentDto dto = cs.updateData(postid,id,commentdto);
		
		
		return new ResponseEntity<CommentDto>(dto , HttpStatus.OK);
		
	}
	
	@DeleteMapping("{post_id}/com/{id}")
	public ResponseEntity<String> deleteData(@PathVariable("post_id")long postid , @PathVariable ("id")long id){
		cs.deleteData(postid,id);
		
		return new ResponseEntity<String>("messege has deleted" , HttpStatus.OK);
		
		
		
	}


	
}

























