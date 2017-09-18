package com.tuyendev.dto;

import java.io.Serializable;

import com.tuyendev.fw.BaseDTO;

import java.math.BigDecimal;

import java.util.*;

public class RegionsDTO extends BaseDTO implements Serializable {

    //VARIABLES
    private BigDecimal regionId;
    private String regionName;
    private List<CountriesDTO> countriesList;

    //GETTER-SETTER
    public BigDecimal getRegionId() {
        return this.regionId;
    }

    public void setRegionId(BigDecimal regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public List<CountriesDTO> getCountriesList() {
        return this.countriesList;
    }

    public void setCountriesList(List<CountriesDTO> countriesList) {
        this.countriesList = countriesList;
    }

}
