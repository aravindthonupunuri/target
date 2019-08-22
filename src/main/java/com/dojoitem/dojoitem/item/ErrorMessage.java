package com.dojoitem.dojoitem.item;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class ErrorMessage {

    private String errormessage;
    private int errorcode;
    private String documentation;

    public ErrorMessage(String errormessage, int errorcode, String documentation) {
        this.errormessage = errormessage;
        this.errorcode = errorcode;
        this.documentation = documentation;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }
}
