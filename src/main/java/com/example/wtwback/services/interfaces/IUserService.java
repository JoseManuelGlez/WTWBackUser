package com.example.wtwback.services.interfaces;

import com.example.wtwback.controllers.dtos.requests.CreateUserRequest;
import com.example.wtwback.controllers.dtos.responses.BaseResponse;
import org.springframework.stereotype.Service;

public interface IUserService {
    BaseResponse create(CreateUserRequest request);

    BaseResponse update(Long id, CreateUserRequest request);

    void delete(Long id);
}
