package com.emc.training.simple.xml;

import java.text.MessageFormat;

public class Address
{
    private String location;
    private String city;

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
