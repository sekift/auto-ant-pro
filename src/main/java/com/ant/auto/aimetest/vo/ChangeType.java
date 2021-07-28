package com.ant.auto.aimetest.vo;

/**
 * @author sekift
 */
public class ChangeType {

    public static String getTrmlTypeName(int id) {
        switch (id) {
            case 1:
                return "硬件终端";
            case 2:
                return "软件终端";
            default:
                return "未知类型" + id;
        }
    }

    public static String getPrdctTypeName(int id) {
        switch (id) {
            case 2:
                return "minik";
            case 8:
                return "minishow";
            case 9:
                return "minikTV";
            case 1681:
                return "E舞+";
            case 3:
                return "咪哒app";
            case 4:
                return "公众号";
            default:
                return "未知类型" + id;
        }
    }
}
