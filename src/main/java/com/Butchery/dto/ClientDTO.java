package com.Butchery.dto;

import com.Butchery.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @Getter @Setter @ToString
public class ClientDTO {
    private String username;
    private String password;
    private String name;
    private String surname;
    private boolean admin;
    public ClientEntity toClientEntity(long id){
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(id);
        clientEntity.setUsername(username);
        clientEntity.setPassword(password);
        clientEntity.setName(name);
        clientEntity.setSurname(surname);
        clientEntity.setAdmin(admin);
        return clientEntity;
    }
}
