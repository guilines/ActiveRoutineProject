package com.guilines.responses;

import java.util.Objects;

public class GenericResponse {
    private boolean isResponseOk = true;
    private String errorMsg = "";
    private Object data;


    public GenericResponse() {
    }

    public GenericResponse(boolean isResponseOk, String errorMsg, Object data) {
        this.isResponseOk = isResponseOk;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public boolean isIsResponseOk() {
        return this.isResponseOk;
    }

    public boolean getIsResponseOk() {
        return this.isResponseOk;
    }

    public void setIsResponseOk(boolean isResponseOk) {
        this.isResponseOk = isResponseOk;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public GenericResponse isResponseOk(boolean isResponseOk) {
        this.isResponseOk = isResponseOk;
        return this;
    }

    public GenericResponse errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public GenericResponse data(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GenericResponse)) {
            return false;
        }
        GenericResponse genericResponse = (GenericResponse) o;
        return isResponseOk == genericResponse.isResponseOk && Objects.equals(errorMsg, genericResponse.errorMsg) && Objects.equals(data, genericResponse.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isResponseOk, errorMsg, data);
    }

    @Override
    public String toString() {
        return "{" +
            " isResponseOk='" + isIsResponseOk() + "'" +
            ", errorMsg='" + getErrorMsg() + "'" +
            ", data='" + getData() + "'" +
            "}";
    }

}