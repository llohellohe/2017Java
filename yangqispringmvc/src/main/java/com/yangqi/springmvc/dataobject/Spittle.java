package com.yangqi.springmvc.dataobject;

import java.util.Date;

/**
 * Created by yangqi on 25/01/2017.
 */
public class Spittle {
    private final Long   id=1l;
    private final String message;
    private final Date   time;
    private       Double latitude;
    private       Double longitude;


    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spittle spittle = (Spittle) o;

        if (id != null ? !id.equals(spittle.id) : spittle.id != null) return false;
        if (message != null ? !message.equals(spittle.message) : spittle.message != null) return false;
        if (time != null ? !time.equals(spittle.time) : spittle.time != null) return false;
        if (latitude != null ? !latitude.equals(spittle.latitude) : spittle.latitude != null) return false;
        return longitude != null ? longitude.equals(spittle.longitude) : spittle.longitude == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Spittle{" +
               "id=" + id +
               ", message='" + message + '\'' +
               ", time=" + time +
               ", latitude=" + latitude +
               ", longitude=" + longitude +
               '}';
    }
}
