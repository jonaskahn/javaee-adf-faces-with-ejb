package com.tuyendev.dto;

import java.io.Serializable;

import java.util.*;

public class LocationsDTO implements Serializable {

    //VARIABLES
    private String streetAddress;
    private String city;
    private Short locationId;
    private List<DepartmentsDTO> departmentsList;
    private String postalCode;
    private String stateProvince;
    private CountriesDTO countryId;

    //GETTER-SETTER
    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Short getLocationId() {
        return this.locationId;
    }

    public void setLocationId(Short locationId) {
        this.locationId = locationId;
    }

    public List<DepartmentsDTO> getDepartmentsList() {
        return this.departmentsList;
    }

    public void setDepartmentsList(List<DepartmentsDTO> departmentsList) {
        this.departmentsList = departmentsList;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStateProvince() {
        return this.stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public CountriesDTO getCountryId() {
        return this.countryId;
    }

    public void setCountryId(CountriesDTO countryId) {
        this.countryId = countryId;
    }

}
