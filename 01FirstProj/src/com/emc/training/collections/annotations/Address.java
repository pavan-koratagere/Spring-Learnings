package com.emc.training.collections.annotations;

import java.text.MessageFormat;

import org.springframework.stereotype.Component;

@Component
public class Address
{
    private String location = "Majestic";
    private String city = "Bangalore";
    private String area = "RRNagar";
    
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
        return MessageFormat.format("Address [location={0}, city={1}]", location, city);
    }

}
