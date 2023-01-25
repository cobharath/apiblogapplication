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

import com.example.apiblogapplication.payload.PostDto;
import com.example.apiblogapplication.services.PostService;


@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService ps;
	
	
	@PostMapping("/create")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postdto){
		PostDto dto = ps.createPost(postdto);
		
		return new ResponseEntity<PostDto>(dto , HttpStatus.CREATED);
		
		
		
	}
	@GetMapping
	public List<PostDto> getData(){
		
		List<PostDto> dto = ps.getData();
		return dto;
		
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getDataId(@PathVariable ("id")long id){
		
		PostDto dto = ps.getDataId(id);
		return  new ResponseEntity<PostDto>(dto , HttpStatus.OK);
		
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updateData(@PathVariable("id") long id , @RequestBody PostDto postdto){
		
		PostDto dto = ps.updateData(id,postdto);
		
		
		
		return new ResponseEntity<PostDto>(dto , HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteData(@PathVariable("id") long id){
		
		ps.deleteData(id);
		return new ResponseEntity<String>("deleted succesfully" , HttpStatus.OK) ;
		
		
		
	}

}




























