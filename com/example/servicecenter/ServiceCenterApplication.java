package com.example.servicecenter;

import com.example.servicecenter.configuration.ServiceCenterConfiguration;
import com.example.servicecenter.dao.ServiceCenterDao;
import com.example.servicecenter.model.ServiceCenter;
import com.example.servicecenter.resources.ServiceCenterResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ServiceCenterApplication extends Application<ServiceCenterConfiguration> {
    public static void main(String[] args) throws Exception{
        new ServiceCenterApplication().run(args);
    }

    private final HibernateBundle<ServiceCenterConfiguration> hibernate = new HibernateBundle<ServiceCenterConfiguration>(ServiceCenter.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(ServiceCenterConfiguration configuration) {
            return configuration.getFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<ServiceCenterConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(ServiceCenterConfiguration configuration, Environment environment) {
        final ServiceCenterDao dao = new ServiceCenterDao(hibernate.getSessionFactory());
        environment.jersey().register(new ServiceCenterResource(dao));
    }
}
