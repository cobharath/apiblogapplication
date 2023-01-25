package com.example.apiblogapplication.controller;

import java.util.List;

import org.apache.el.parser.AstGreaterThanEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiblogapplication.payload.JWTAuthRequest;
import com.example.apiblogapplication.payload.JWTAuthResponse;
import com.example.apiblogapplication.payload.UserDto;
import com.example.apiblogapplication.security.CustumUserDetailsService;
import com.example.apiblogapplication.security.JWTTokenHelper;
import com.example.apiblogapplication.services.UserService;


@RestController
@RequestMapping("/user")

public class UserController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustumUserDetailsService custumUserDetailsService;
	@Autowired
	private UserService us;
	
	@Autowired
	private JWTTokenHelper jwt;
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto){

		
		
		UserDto dto = us.createUser(userdto);
		
		
		
		return new ResponseEntity<UserDto>(dto , HttpStatus.CREATED);
		
		
		
		
	}


    
	@GetMapping
	public List<UserDto> getData(){
			List<UserDto> dto = us.getData();
		return dto;
		
		
		
		
		
		
		
		
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getDataId(@PathVariable ("id")long id){
		
		UserDto dto = us.getDataId(id);
		
		return new ResponseEntity<UserDto>(dto,HttpStatus.OK); 
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateDate(@PathVariable("id") long id , @RequestBody UserDto userdto){
		
		UserDto dto = us.updateDate(id,userdto);
		return new ResponseEntity<UserDto>(dto , HttpStatus.OK);
		
		
	}

	
	@DeleteMapping("{id}")
	 
	public ResponseEntity<String> deleteData(@PathVariable ("id") long id ){
		
		us.deleteData(id);
		return new ResponseEntity<String>("deleted succesfully" , HttpStatus.OK);
		
		
	}
	
	@RequestMapping("/login")
	public ResponseEntity<JWTAuthResponse> generateToken(@RequestBody JWTAuthRequest jwtauthrequest){
		
		authenticate(jwtauthrequest.getUsername(), jwtauthrequest.getPassword());
		
		UserDetails userDetails = custumUserDetailsService.loadUserByUsername(jwtauthrequest.getUsername());
		
		String token = jwt.generateToken(userDetails);
		
		JWTAuthResponse js = new JWTAuthResponse();
		js.setToken(token);
		return new ResponseEntity<JWTAuthResponse>(js , HttpStatus.CREATED);
		
		
		
		
	}



	private void authenticate(String username, String password) {
		
		UsernamePasswordAuthenticationToken upat = new  UsernamePasswordAuthenticationToken
				(username, password);
		try {
			authenticationManager.authenticate(upat);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
