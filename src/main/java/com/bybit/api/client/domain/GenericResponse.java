package com.bybit.api.client.domain;

import com.bybit.api.client.constant.BybitApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericResponse<T> {
    @JsonProperty("retCode")
    private int retCode;

    @JsonProperty("retMsg")
    private String retMsg;

    @JsonProperty("result")
    private T result;

    @JsonProperty("retExtInfo")
    private Object retExtInfo;

    @JsonProperty("time")
    private long time;

    // Getters and setters

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getResult() {
        return result != null ? result : (T) "";
    }


    public void setResult(T result) {
        this.result = result;
    }

    public Object getRetExtInfo() {
        return retExtInfo;
    }

    public void setRetExtInfo(Object retExtInfo) {
        this.retExtInfo = retExtInfo;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return  new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("retCode",retCode)
                .append("retMsg",retMsg)
                .append("result",result)
                .append("retExtInfo",retExtInfo)
                .append("time",time)
                .toString();
    }
}
