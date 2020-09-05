package xyz.marontedev.springboot.datajpaapp.models.dao;

import xyz.marontedev.springboot.datajpaapp.models.entity.Client;

import java.util.List;

public interface IClientDao {
    public List<Client> findAll();
    public void save(Client client);
    public Client findOne(Long id);
    public void delete(Long id);
}
