package com.springApi.RestApi.service;


import com.springApi.RestApi.Model.Doctor;
import com.springApi.RestApi.dao.DoctorRepo;
import com.springApi.RestApi.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocService {

    private final DoctorRepo doctorRepo;
    @Autowired
    public DocService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public List<Doctor> getAll(){
        return doctorRepo.findAll();
    }
    public Doctor findById(Long id){
        return doctorRepo.findById(id).orElseThrow(()-> new UserNotFoundException("user not Found"));

    }
    public void delete(Long id){

        doctorRepo.deleteById(id);
    }

    public Doctor addDoctor(Doctor doctor){
       return doctorRepo.save(doctor);
     }

     public Doctor updateDoctor(Doctor doctor){
        return doctorRepo.save(doctor);
     }

}
