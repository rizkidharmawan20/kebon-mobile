package com.selada.kebonmobile.model.request;

public class Data {
    private String activity_type_code;
    private int preffered_payment_account_id;

    public String getActivity_type_code() {
        return activity_type_code;
    }

    public void setActivity_type_code(String activity_type_code) {
        this.activity_type_code = activity_type_code;
    }

    public int getPreffered_payment_account_id() {
        return preffered_payment_account_id;
    }

    public void setPreffered_payment_account_id(int preffered_payment_account_id) {
        this.preffered_payment_account_id = preffered_payment_account_id;
    }
}
