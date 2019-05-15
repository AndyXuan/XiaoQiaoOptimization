package me.xdd.self.networkmodule.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author xuandong on 2019/5/15
 */
public class BaseBean {

    private int code;

    private String message;

    @SerializedName("token")
    private String userToken;


}
