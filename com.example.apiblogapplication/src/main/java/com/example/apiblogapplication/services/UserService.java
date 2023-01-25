package com.example.apiblogapplication.services;

import java.util.List;

import com.example.apiblogapplication.payload.UserDto;

public interface UserService {

	UserDto createUser(UserDto userdto);

	List<UserDto>  getData();

	UserDto getDataId(long id);

	UserDto updateDate(long id, UserDto userdto);

	void deleteData(long id);

}
