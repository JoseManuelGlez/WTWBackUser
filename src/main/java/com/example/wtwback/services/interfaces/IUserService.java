package com.example.wtwback.services.interfaces;

import com.example.wtwback.controllers.dtos.requests.CreateUserRequest;
import com.example.wtwback.controllers.dtos.requests.ValidateUserRequest;
import com.example.wtwback.controllers.dtos.responses.BaseResponse;

public interface IUserService {
    BaseResponse create(CreateUserRequest request);

    BaseResponse update(Long id, CreateUserRequest request);

    BaseResponse validate(ValidateUserRequest request);

    void delete(Long id);
}
