package com.example.restdemo.service.impl;

import com.example.restdemo.model.CloudVendor;
import com.example.restdemo.repository.CloudVendorRepository;
import com.example.restdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }


    @Override
    public String createCloudVendor(CloudVendor cloudvendor) {
        // more business logic
        cloudVendorRepository.save(cloudvendor);
        return "success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudvendor) {
        //more business logic
        cloudVendorRepository.save(cloudvendor);
        return "success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        // more business logic
        cloudVendorRepository.deleteById(cloudVendorId);
        return "success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        return cloudVendorRepository.findById(cloudVendorId).get();
    }
    @Override
    public List<CloudVendor> getAllCloudVendor() {
        //more business logic
        return cloudVendorRepository.findAll();
    }
}
