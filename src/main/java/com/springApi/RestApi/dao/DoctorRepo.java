package com.springApi.RestApi.dao;

import com.springApi.RestApi.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {

    Doctor findByName(String name);
}
