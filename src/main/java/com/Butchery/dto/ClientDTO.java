package com.Butchery.dto;

import com.Butchery.entity.ClientEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @Getter @Setter @ToString
public class ClientDTO {
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String surname;
    @NotNull
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
    public ClientEntity toClientEntity(){
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setUsername(username);
        clientEntity.setPassword(password);
        clientEntity.setName(name);
        clientEntity.setSurname(surname);
        clientEntity.setAdmin(admin);
        return clientEntity;
    }
}
