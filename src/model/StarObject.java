package model;

import javafx.beans.property.SimpleStringProperty;

public class StarObject {

    private String objName;
    private int objDistance;

    public StarObject(String objName, int objDistance) {
        this.objName = objName;
        this.objDistance = objDistance;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public int getObjDistance() {
        return objDistance;
    }

    public void setObjDistance(int objDistance) {
        this.objDistance = objDistance;
    }
}

