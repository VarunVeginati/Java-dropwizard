package com.example.servicecenter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_center")
@NamedQueries({
        @NamedQuery(name = "com.example.servicecenter.model.ServiceCenter.findAll",
        query = "select s from ServiceCenter s")
})
//https://dzone.com/articles/getting-started-with-dropwizard-connecting-to-a-da
// refer this for named query
public class ServiceCenter {
    @Id
    @Column(name = "service_center_id")
    private Integer serviceCenterId;
    @Column(name = "address")
    private String address;
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Column(name = "open_on_saturday")
    private Boolean openOnSaturday;

    public ServiceCenter() {
    }

    @JsonProperty
    public Integer getServiceCenterId() {
        return this.serviceCenterId;
    }

    @JsonProperty
    public String getAddress() {
        return this.address;
    }

    @JsonProperty
    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    @JsonProperty
    public Boolean getOpenOnSaturday() {
        return this.openOnSaturday;
    }
}
