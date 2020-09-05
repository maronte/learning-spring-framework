package xyz.marontedev.springboot.datajpaapp.models.dao;

import org.springframework.data.repository.CrudRepository;
import xyz.marontedev.springboot.datajpaapp.models.entity.Client;

import java.util.List;

public interface IClientDao extends CrudRepository<Client, Long> {

}
