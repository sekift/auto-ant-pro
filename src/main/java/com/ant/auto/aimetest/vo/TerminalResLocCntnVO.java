package com.ant.auto.aimetest.vo;

/**
 * @author: yinzhang.lu
 * @date: 2020/12/09 17:45
 * @description: 接口测试VO
 */
public class TerminalResLocCntnVO {
    private Integer trmlTypeId;

    private Integer prdctTypeId;

    private Integer mid;

    private Long uid;

    private Integer resLocId;

    private Long timestamp;

    public Integer getTrmlTypeId() {
        return trmlTypeId;
    }

    public void setTrmlTypeId(Integer trmlTypeId) {
        this.trmlTypeId = trmlTypeId;
    }

    public Integer getPrdctTypeId() {
        return prdctTypeId;
    }

    public void setPrdctTypeId(Integer prdctTypeId) {
        this.prdctTypeId = prdctTypeId;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getResLocId() {
        return resLocId;
    }

    public void setResLocId(Integer resLocId) {
        this.resLocId = resLocId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TerminalResLocCntnVO{" +
                "trmlTypeId=" + trmlTypeId +
                ", prdctTypeId=" + prdctTypeId +
                ", mid=" + mid +
                ", uid=" + uid +
                ", resLocId=" + resLocId +
                ", timestamp=" + timestamp +
                '}';
    }
}
