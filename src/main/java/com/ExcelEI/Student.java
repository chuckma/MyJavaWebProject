package com.ExcelEI;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Student implements java.io.Serializable {

    @Excel(name = "id")
    private String id;
    @Excel(name = "num")
    private String num;
    @Excel(name = "name")
    private String name;
    @Excel(name = "type")
    private String type;
    @Excel(name = "major")
    private String major;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
