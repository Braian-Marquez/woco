package com.nocountry.woco.controller;

import com.nocountry.woco.model.request.ServiceRequest;
import com.nocountry.woco.model.response.ServiceResponse;
import com.nocountry.woco.service.IServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceController {
    private final IServiceService serviceService;

    @GetMapping
    public List<ServiceResponse> getAllServices() {
        return serviceService.getAllServices();
    }
    @GetMapping("/{id}")
    public ServiceResponse getServiceById(@PathVariable int id) {
        return serviceService.getServiceById(Long.valueOf(id));
    }
    @PostMapping
    public ServiceResponse addService(@RequestBody ServiceRequest serviceRequest) {
        return serviceService.addService(serviceRequest);
    }
    @PutMapping
    public ServiceResponse updateService(@PathVariable int id,@RequestBody ServiceRequest serviceRequest) {
        return serviceService.updateService(Long.valueOf(id),serviceRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable int id) {
        serviceService.deleteService(Long.valueOf(id));
    }

    @GetMapping("/price/{price}")
    public List<ServiceResponse> getServicesByPrice(@PathVariable Double price) {
        return serviceService.getServicesByPrice(price);
    }

}
