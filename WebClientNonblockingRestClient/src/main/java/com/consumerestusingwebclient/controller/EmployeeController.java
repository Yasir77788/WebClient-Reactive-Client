package com.consumerestusingwebclient.controller;

import com.consumerestusingwebclient.model.Employee;
import com.consumerestusingwebclient.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

//    @Autowired
//    private EmployeeProxy employeeProxy;

    @Autowired
    private WebClient webClient;

    @PostMapping("/addEmployeeWebClient")
    public Mono<Response> addEmployee(@RequestBody Employee employee){
        String uri = "http://localhost:8084/employeeService/addEmployee";

        return webClient.post().uri(uri)
                .header("InvocationFrom", "WebClient")
                .body(Mono.just(employee), Employee.class)
                .retrieve()
                .bodyToMono(Response.class);
    }



//    @GetMapping("/getAllEmployees")
//    public Response getAllEmployees(){
//        return employeeProxy.getAllEmployees();
//    }




}
