package com.tuyendev.fw;

import java.io.Serializable;

public class BaseDTO implements Serializable{
    
    private boolean selected;

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }


}
