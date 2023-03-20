package com.example.wtwback.services;

import com.example.wtwback.controllers.dtos.requests.CreateUserRequest;
import com.example.wtwback.controllers.dtos.responses.BaseResponse;
import com.example.wtwback.controllers.dtos.responses.CreateUserResponse;
import com.example.wtwback.entities.User;
import com.example.wtwback.repositories.IUserRepository;
import com.example.wtwback.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository repository;

    @Override
    public BaseResponse create(CreateUserRequest request) {
        User user = from(request);

        return BaseResponse.builder()
                .data(from(repository.save(user)))
                .message("User created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public BaseResponse update(String id, CreateUserRequest request) {
        User user = findAndEnsureExist(id);

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());
        return BaseResponse.builder()
                .data(from(repository.save(user)))
                .message("User updated correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public void delete(String id) {
        repository.delete(findAndEnsureExist(id));
    }

    private User from(CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setLastName(request.getName());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        return user;
    }

    private CreateUserResponse from(User user){
        CreateUserResponse response = new CreateUserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setLastName(user.getName());
        response.setName(user.getName());
        response.setPassword(user.getPassword());
        return response;
    }

    private User findAndEnsureExist(String id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
