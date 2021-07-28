package com.ant.auto.config;

/**
 * properties object
 *
 * @author
 * @date
 */
public interface Config {

    /**
     * 获取项
     *
     * @param name
     * @param <T>
     * @return
     */
    <T> T getItem(String name);

    /**
     * 获取项
     *
     * @param name
     * @param defaultValue
     * @param <T>
     * @return
     */
    <T> T getItem(String name, T defaultValue);

}