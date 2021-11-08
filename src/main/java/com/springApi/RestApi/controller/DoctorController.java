package com.springApi.RestApi.controller;


import com.springApi.RestApi.Model.Doctor;
import com.springApi.RestApi.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class DoctorController {
   private final DocService docService;
    @Autowired
    public DoctorController(DocService docService) {
        this.docService = docService;

    }


    @GetMapping("/doctor")
    public ResponseEntity<List<Doctor>> getAll(){
        List<Doctor> list = docService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor> findbyid(@PathVariable("id") Long id){
        Doctor doc = docService.findById(id);
        return new ResponseEntity<>(doc,HttpStatus.OK);
    }
    @PostMapping("/doctor/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        Doctor newDoctor = docService.addDoctor(doctor);
        return new ResponseEntity<>(newDoctor,HttpStatus.OK);
    }
    @DeleteMapping("/doctor/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        docService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/doctor/update")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Doctor> update(@RequestBody Doctor doctor){
        Doctor newDoctor = docService.addDoctor(doctor);
        return new ResponseEntity<>(newDoctor,HttpStatus.OK);
    }

}
