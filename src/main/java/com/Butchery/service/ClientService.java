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
    private void saveOrUpdate(ClientEntity clientEntity){
        clientRepository.save(clientEntity);
    }
    private void deleteById(long id){
        clientRepository.deleteById(id);
    }
    private List<ClientEntity> selectAll(){
        return clientRepository.findAll();
    }
    private ClientEntity selectById(long id){
        return clientRepository.findById(id).orElse(null);
    }
}
