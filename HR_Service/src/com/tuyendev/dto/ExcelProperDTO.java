package com.tuyendev.dto;

import com.tuyendev.fw.BaseDTO;

public class ExcelProperDTO extends BaseDTO {
    
    long id;
    String name;
    String refName;
    
    public ExcelProperDTO(){}
    
    public ExcelProperDTO(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public ExcelProperDTO(long id, String name, String refName) {
        super();
        this.id = id;
        this.name = name;
        this.refName = refName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public String getRefName() {
        return refName;
    }
}
