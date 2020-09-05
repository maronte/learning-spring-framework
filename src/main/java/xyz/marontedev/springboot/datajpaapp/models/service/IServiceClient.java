package xyz.marontedev.springboot.datajpaapp.models.service;

import xyz.marontedev.springboot.datajpaapp.models.entity.Client;

import java.util.List;

public interface IServiceClient {
    public List<Client> findAll();
    public void save(Client client);
    public Client findOne(Long id);
    public void delete(Long id);
}
