package com.tuyendev.dto;

import java.io.Serializable;

import java.util.*;

public class JobHistoryPKDTO implements Serializable {

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
