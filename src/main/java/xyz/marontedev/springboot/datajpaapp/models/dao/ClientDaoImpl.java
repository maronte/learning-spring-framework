package xyz.marontedev.springboot.datajpaapp.models.dao;

import org.springframework.stereotype.Repository;
import xyz.marontedev.springboot.datajpaapp.models.entity.Client;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClientDaoImpl implements IClientDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> findAll() {
        return em.createQuery("SELECT c FROM Client c").getResultList();
    }

    @Override
    public void save(Client client) {
        if (client.getId() != null && client.getId() > 0){
            em.merge(client);
        }
        else {
            em.persist(client);
        }
    }

    @Override
    public Client findOne(Long id) {
        return em.find(Client.class, id);
    }

    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }

}