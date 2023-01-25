package com.example.apiblogapplication.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiblogapplication.entity.Role;
import com.example.apiblogapplication.entity.User;
import com.example.apiblogapplication.exception.ResourceNotFoundException;
import com.example.apiblogapplication.payload.UserDto;
import com.example.apiblogapplication.repository.RoleRepository;
import com.example.apiblogapplication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private RoleRepository rr;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	@Autowired
	private ModelMapper modelmap; 

	@Override
	public UserDto createUser(UserDto userdto) {
		
		
		
		User user = modelmap.map(userdto, User.class);
		
		Role role = rr.findById(1L).get();
		user.getRoles().add(role);
		
		User save = ur.save(user);
		UserDto dto = modelmap.map(save, UserDto.class);
		
		
		
		return dto;
	}

	
	
	@Override
	public List<UserDto> getData() {
		
		List<User> user = ur.findAll();
		
		List<UserDto> dto = user.stream().map(x-> modelmap.map(user, UserDto.class)).collect(Collectors.toList());
		
		return dto;
	}



	@Override
	public UserDto getDataId(long id) {
		User user = ur.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		
		UserDto dto = modelmap.map(user, UserDto.class);
		return dto;
	}



	@Override
	public UserDto updateDate(long id, UserDto userdto) {
		
		User user = ur.findById(id).orElseThrow(()-> new ResourceNotFoundException("USer", "id", id));
		
		User map = modelmap.map(userdto, User.class);
		 UserDto dto = modelmap.map(map, UserDto.class);
		
		
		return dto;
	}



	@Override
	public void deleteData(long id) {
		User user = ur.findById(id).orElseThrow(()-> new ResourceNotFoundException("USer", "id", id));
  ur.delete(user);
		
	}
	

}
