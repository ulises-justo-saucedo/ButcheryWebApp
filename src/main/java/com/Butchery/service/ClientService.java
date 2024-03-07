package com.Butchery.service;

import com.Butchery.entity.ClientEntity;
import com.Butchery.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public void saveOrUpdate(ClientEntity clientEntity){
        clientRepository.save(clientEntity);
    }
    public void deleteById(long id){
        clientRepository.deleteById(id);
    }
    public List<ClientEntity> selectAll(){
        return clientRepository.findAll();
    }
    public ClientEntity selectById(long id){
        return clientRepository.findById(id).orElse(null);
    }
}
