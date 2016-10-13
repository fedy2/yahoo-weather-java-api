package com.github.fedy2.weather.data;

import com.github.fedy2.weather.binding.Constants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created on 13/10/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = Constants.YWEATHER_API_SCHEMA_URI)
public class Place {

    @XmlElement
    private String name;

    @XmlElement
    private String country;

    @XmlElement
    private String admin1;

    @XmlElement
    private String admin2;

    @XmlElement
    private String admin3;

    @XmlElement
    private String woeid;

    public Place(){}

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getAdmin1() {
        return admin1;
    }

    public String getAdmin2() {
        return admin2;
    }

    public String getAdmin3() {
        return admin3;
    }

    public String getWoeid() {
        return woeid;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Place [name=");
        builder.append(name);
        builder.append(", country=");
        builder.append(country);
        builder.append(", admin1=");
        builder.append(admin1);
        builder.append(", admin2=");
        builder.append(admin2);
        builder.append(", admin3=");
        builder.append(admin3);
        builder.append(", woeid=");
        builder.append(woeid);
        builder.append("]");
        return builder.toString();
    }
}
