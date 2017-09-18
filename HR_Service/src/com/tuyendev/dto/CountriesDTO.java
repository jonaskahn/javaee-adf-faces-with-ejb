package com.tuyendev.dto;

import java.io.Serializable;

import com.tuyendev.fw.BaseDTO;

import java.util.*;

public class CountriesDTO extends BaseDTO implements Serializable {

    //VARIABLES
    private RegionsDTO regionId;
    private String countryName;
    private List<LocationsDTO> locationsList;
    private String countryId;

    //GETTER-SETTER
    public RegionsDTO getRegionId() {
        return this.regionId;
    }

    public void setRegionId(RegionsDTO regionId) {
        this.regionId = regionId;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<LocationsDTO> getLocationsList() {
        return this.locationsList;
    }

    public void setLocationsList(List<LocationsDTO> locationsList) {
        this.locationsList = locationsList;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

}
