package com.emc.training.spring.hibernate.annotations;

import java.text.MessageFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_tbl")
public class Address
{
    @Id
    @Column(name = "address_id")
    private int addressId;

    @Column
    private String location;

    @Column
    private String city;

    public Address(int addressId, String location, String city)
    {
        super();
        this.addressId = addressId;
        this.location = location;
        this.city = city;
    }

    public Address()
    {
        super();
    }

    public int getAddressId()
    {
        return addressId;
    }

    public void setAddressId(int addressId)
    {
        this.addressId = addressId;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return MessageFormat.format("Address [addressId={0}, location={1}, city={2}]", addressId, location, city);
    }

}
