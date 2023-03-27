package com.example.wtwback.controllers;

import com.example.wtwback.controllers.dtos.requests.CreateEsp32Request;
import com.example.wtwback.controllers.dtos.requests.CreateMonitoringInformationRequest;
import com.example.wtwback.controllers.dtos.requests.CreateUserRequest;
import com.example.wtwback.controllers.dtos.requests.ValidateUserRequest;
import com.example.wtwback.controllers.dtos.responses.BaseResponse;
import com.example.wtwback.limiter.annotation.RequestLimit;
import com.example.wtwback.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

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

    @PostMapping("esp32")
    public BaseResponse createEsp(@RequestBody CreateEsp32Request request){
        String apiUrl = "http://esp32api.wateringtheworld.click/esp32";
        return restTemplate.postForObject(apiUrl, request, BaseResponse.class);
    }

    @PutMapping("esp32/{id}")
    public ResponseEntity<Void> updateEsp(@PathVariable Long id, @RequestBody CreateUserRequest request){
        String apiUrl = "http://esp32api.wateringtheworld.click/esp32/" + id;
        restTemplate.put(apiUrl, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("esp32/{id}")
    public BaseResponse getEsp(@PathVariable Long id){
        String apiUrl = "http://esp32api.wateringtheworld.click/esp32/" + id;
        return restTemplate.getForObject(apiUrl, BaseResponse.class, id);
    }

    @GetMapping("esp32/{key}")
    public BaseResponse getEspByKey(@PathVariable String key){
        String apiUrl = "http://esp32api.wateringtheworld.click/esp32/user/" + key;
        return restTemplate.getForObject(apiUrl, BaseResponse.class, key);
    }

    @PostMapping("monitoring-information")
    public BaseResponse createEsp(@RequestBody CreateMonitoringInformationRequest request){
        String apiUrl = "http://monitoringinformationapi.wateringtheworld.click/monitoring-information";
        return restTemplate.postForObject(apiUrl, request, BaseResponse.class);
    }

    @GetMapping("monitoring-information/{id}")
    public BaseResponse getMonitoringIformation(@PathVariable Long id){
        String apiUrl = "http://monitoringinformationapi.wateringtheworld.click/monitoring-information/" + id;
        return restTemplate.getForObject(apiUrl, BaseResponse.class, id);
    }

    @PostMapping("monitoring-information")
    public BaseResponse createLocalInformation(@RequestBody CreateMonitoringInformationRequest request){
        String apiUrl = "http://monitoringinformationapi.wateringtheworld.click/monitoring-information/upload_local_information";
        return restTemplate.postForObject(apiUrl, request, BaseResponse.class);
    }
}
