package com.example.mywebapp.phone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repo;


    public void save(Phone phone) {
        repo.save(phone);
    }

    public List<String> getNumberByUserId(Integer id) {
        return repo.findNumberByUserId(id);
    }

    public List<String> getAnbieterByUserId(Integer id) {
        return repo.findAnbieterByUserId(id);
    }

    public List<String> getIdByUserId(Integer id) {
        return repo.findIdByUserId(id);
    }









    /*
    public Phone findPhoneByUserId(Integer UserId) {
    } */









}
