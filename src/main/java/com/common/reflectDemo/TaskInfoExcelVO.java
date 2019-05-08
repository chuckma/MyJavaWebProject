package com.common.reflectDemo;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @author Administrator
 */
public class TaskInfoExcelVO implements Serializable {



    // 买样数量
    private String amout;
    // 检测项目
    private String testContent;
    //执行标准
    private String executiveStandard;
    // 买样说明
    private String sampleDescription;
    public String getAmout() {
        return amout;
    }
    public void setAmout(String amout) {
        this.amout = amout;
    }
    public String getTestContent() {
        return testContent;
    }
    public void setTestContent(String testContent) {
        this.testContent = testContent;
    }
    public String getExecutiveStandard() {
        return executiveStandard;
    }
    public void setExecutiveStandard(String executiveStandard) {
        this.executiveStandard = executiveStandard;
    }
    public String getSampleDescription() {
        return sampleDescription;
    }
    public void setSampleDescription(String sampleDescription) {
        this.sampleDescription = sampleDescription;
    }

    @Override
    public String toString() {
        return "TaskInfoExcelVO{" +
                "amout='" + amout + '\'' +
                ", testContent='" + testContent + '\'' +
                ", executiveStandard='" + executiveStandard + '\'' +
                ", sampleDescription='" + sampleDescription + '\'' +
                '}';
    }
}
