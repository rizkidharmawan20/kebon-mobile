
package com.selada.kebonmobile.model.response.socket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MsgScode {

    @SerializedName("code")
    @Expose
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
