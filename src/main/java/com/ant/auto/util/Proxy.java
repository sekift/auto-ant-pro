/*
 * developer spirit_demon  at 2015.
 */

package com.ant.auto.util;

import java.io.Serializable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Proxy implements Delayed, Serializable {
	private static final long serialVersionUID = -6951864941257516031L;
	
	public final static int ERROR_403 = 403;
    public final static int ERROR_404 = 404;
    public final static int ERROR_502 = 502;  // banned by website
    public final static int ERROR_500 = 500;  // the proxy itself failed
    public final static int SUCCESS = 200;

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    private String httpHost;
    private int port = 0;

    private int reuseTimeInterval = 1500;// ms
    private Long canReuseTime = 0L;
    private Long lastBorrowTime = System.currentTimeMillis();
    private Long responseTime = 0L;

    private int failedNum = 0;
    private int successNum = 0;
    private int borrowNum = 0;

    private int stateCode = 0;

    public Proxy(String httpHost, int port) {
        this.httpHost = httpHost;
        this.port = port;
        this.canReuseTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(reuseTimeInterval, TimeUnit.MILLISECONDS);
    }

    Proxy(String httpHost, int port, int reuseInterval) {
        this.httpHost = httpHost;
        this.port = port;
        this.canReuseTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(reuseInterval, TimeUnit.MILLISECONDS);
    }

    public int getSuccessNum() {
        return successNum;
    }

    public void successNumIncrement(int increment) {
        this.successNum += increment;
    }

    public Long getLastUseTime() {
        return lastBorrowTime;
    }

    public void setLastBorrowTime(Long lastBorrowTime) {
        this.lastBorrowTime = lastBorrowTime;
    }

    public void recordResponse() {
        this.responseTime = (System.currentTimeMillis() - lastBorrowTime + responseTime) / 2;
        this.lastBorrowTime = System.currentTimeMillis();
    }

    public void fail(int failedErrorType) {
        this.failedNum++;
    }

    public void setFailedNum(int failedNum) {
        this.failedNum = failedNum;
    }

    public int getFailedNum() {
        return failedNum;
    }

    public int getReuseTimeInterval() {
        return reuseTimeInterval;
    }

    public void setReuseTimeInterval(int reuseTimeInterval) {
        this.reuseTimeInterval = reuseTimeInterval;
        this.canReuseTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(reuseTimeInterval, TimeUnit.MILLISECONDS);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(canReuseTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Proxy that = (Proxy) o;
        return canReuseTime > that.canReuseTime ? 1 : (canReuseTime < that.canReuseTime ? -1 : 0);

    }

    public void borrowNumIncrement(int increment) {
        this.borrowNum += increment;
    }

    public int getBorrowNum() {
        return borrowNum;
    }

    @Override
    public String toString() {
        return "Proxy{" +
                "httpHost=" + httpHost +
                ", port=" + port +
                ", reuseTimeInterval=" + reuseTimeInterval +
                ", canReuseTime=" + canReuseTime +
                ", lastBorrowTime=" + lastBorrowTime +
                ", responseTime=" + responseTime +
                ", failedNum=" + failedNum +
                ", successNum=" + successNum +
                ", borrowNum=" + borrowNum +
                '}';
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHttpHost() {
        return httpHost;
    }

    public void setHttpHost(String httpHost) {
        this.httpHost = httpHost;
    }

}