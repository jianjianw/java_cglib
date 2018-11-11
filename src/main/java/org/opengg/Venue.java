package org.opengg;

import java.io.Serializable;
/**
 * 内景馆 venue_type 1
 * 门店 venue_type 2
 * author:wang lei
 * date : 2018-11-04
 * */
public class Venue implements Serializable {
    private static final long serialVersionUID = -1302559071626317704L;

    private Integer id;

    private Integer baseId;

    private String venueName;

    private Short venueType;

    private String venuePhone;

    private String respo;

    private String address;

    private Short venueStatus;

    private Integer companyId;

    private Integer priority;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName == null ? null : venueName.trim();
    }

    public Short getVenueType() {
        return venueType;
    }

    public void setVenueType(Short venueType) {
        this.venueType = venueType;
    }

    public String getVenuePhone() {
        return venuePhone;
    }

    public void setVenuePhone(String venuePhone) {
        this.venuePhone = venuePhone == null ? null : venuePhone.trim();
    }

    public String getRespo() {
        return respo;
    }

    public void setRespo(String respo) {
        this.respo = respo == null ? null : respo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Short getVenueStatus() {
        return venueStatus;
    }

    public void setVenueStatus(Short venueStatus) {
        this.venueStatus = venueStatus;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}