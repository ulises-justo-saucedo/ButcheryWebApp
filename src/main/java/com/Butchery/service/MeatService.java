package com.Butchery.service;

import com.Butchery.repository.MeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeatService {
    @Autowired
    private MeatRepository meatRepository;
}
