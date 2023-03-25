package com.example.wtwback.controllers;

import com.example.wtwback.controllers.dtos.requests.CreateUserRequest;
import com.example.wtwback.controllers.dtos.requests.ValidateUserRequest;
import com.example.wtwback.controllers.dtos.responses.BaseResponse;
import com.example.wtwback.limiter.annotation.RequestLimit;
import com.example.wtwback.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService service;

    @RequestLimit(value = 5)
    @PostMapping()
    public BaseResponse create(@RequestBody CreateUserRequest request) {
        return service.create(request);
    }

    @RequestLimit(value = 5)
    @PutMapping("{id}")
    public BaseResponse update(@PathVariable Long id, @RequestBody CreateUserRequest request){
        return service.update(id, request);
    }

    @RequestLimit(value = 5)
    @PostMapping("validate")
    public BaseResponse validate(@RequestBody ValidateUserRequest request){
        return service.validate(request);
    }

    @RequestLimit(value = 5)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
