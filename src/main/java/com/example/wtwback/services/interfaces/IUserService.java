package com.example.wtwback.services.interfaces;

import com.example.wtwback.controllers.dtos.requests.CreateUserRequest;
import com.example.wtwback.controllers.dtos.responses.BaseResponse;

public interface IUserService {
    BaseResponse create(CreateUserRequest request);

    BaseResponse update(String id, CreateUserRequest request);

    void delete(String id);
}
