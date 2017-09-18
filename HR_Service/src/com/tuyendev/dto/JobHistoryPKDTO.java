package com.tuyendev.dto;

import java.io.Serializable;

import com.tuyendev.fw.BaseDTO;

import java.util.*;

public class JobHistoryPKDTO extends BaseDTO implements Serializable {

    //VARIABLES
    private Date startDate;

    //GETTER-SETTER
    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
