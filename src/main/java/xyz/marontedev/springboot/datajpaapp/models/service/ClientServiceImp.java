package xyz.marontedev.springboot.datajpaapp.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.marontedev.springboot.datajpaapp.models.dao.ClientDaoImpl;
import xyz.marontedev.springboot.datajpaapp.models.entity.Client;
import xyz.marontedev.springboot.datajpaapp.models.service.IServiceClient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ClientServiceImp implements IServiceClient {
    @Autowired
    private ClientDaoImpl clientDao;

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    @Transactional
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findOne(Long id) {
        return clientDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientDao.delete(id);
    }
}
