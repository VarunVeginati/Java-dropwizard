package com.example.servicecenter.resources;

import com.example.servicecenter.dao.ServiceCenterDao;
import com.example.servicecenter.model.ServiceCenter;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/service-center")
@Produces(MediaType.APPLICATION_JSON)
public class ServiceCenterResource {
    private final ServiceCenterDao dao;

    public ServiceCenterResource(ServiceCenterDao dao) {
        this.dao = dao;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public ServiceCenter getById(@PathParam("id") Integer id) {
        return dao.findBy(id);
    }

    @GET
    @UnitOfWork
    public List<ServiceCenter> getAll() {
        return dao.findAll();
    }

    @POST
    @Path("/{id}")
    @UnitOfWork
    public ServiceCenter create(@PathParam("id") Integer id, @Valid ServiceCenter serviceCenter) {
        return dao.create(serviceCenter);
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void deleteById(@PathParam("id") Integer id) {
        dao.delete(id);
    }
}
