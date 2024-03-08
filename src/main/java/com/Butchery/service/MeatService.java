package com.Butchery.service;

import com.Butchery.entity.MeatEntity;
import com.Butchery.repository.MeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeatService {
    @Autowired
    private MeatRepository meatRepository;
    public void saveOrUpdate(MeatEntity meatEntity){
        meatRepository.save(meatEntity);
    }
    public void deleteById(long id){
        meatRepository.deleteById(id);
    }
    public List<MeatEntity> selectAll(){
        return meatRepository.findAll();
    }
    public MeatEntity selectById(long id){
        return meatRepository.findById(id).orElse(null);
    }
}
