package com.example.servicecenter.dao;

import com.example.servicecenter.model.ServiceCenter;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import javax.ws.rs.NotFoundException;
import java.util.List;

public class ServiceCenterDao extends AbstractDAO<ServiceCenter> {
    public ServiceCenterDao(SessionFactory factory) {
        super(factory);
    }

    public ServiceCenter findBy(Integer id) {
        ServiceCenter serviceCenter = get(id);
        if(serviceCenter == null) {
            throw new NotFoundException("service center not found");
        } else return serviceCenter;
    }

    public List<ServiceCenter> findAll() {
        return list(namedTypedQuery("com.example.servicecenter.model.ServiceCenter.findAll"));
    }

    public ServiceCenter create(ServiceCenter serviceCenter) {
        return persist(serviceCenter);
    }

    public void delete(Integer id) {
        currentSession().delete(get(id));
    }
}
