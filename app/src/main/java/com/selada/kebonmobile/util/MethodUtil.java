package com.selada.kebonmobile.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.google.gson.Gson;
import com.selada.kebonmobile.R;
import com.selada.kebonmobile.model.response.GeneralInformation;
import com.selada.kebonmobile.model.response.errormsg.ErrorResponse;
import com.selada.kebonmobile.presentation.akun.history.InvoiceHistoryActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

import okhttp3.ResponseBody;

/**
 * Created by Dhimas on 9/29/17.
 */

public class MethodUtil extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        MethodUtil.context = getApplicationContext();
    }

    public static Dialog showDialog(Context context, int layout, String title) {
        Dialog dialog = new Dialog(Objects.requireNonNull(context));
        //set content
        dialog.setContentView(layout);
        dialog.setTitle(title);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context, R.color.very_light_pink)));
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.show();
        dialog.getWindow().setAttributes(lp);

        return dialog;
    }

    public static String toCurrencyNumber(int nominal){
        NumberFormat formatter = new DecimalFormat("#,###");
        return formatter.format(nominal);
    }

    public static ProgressDialog getLoadingBar(Context context, String msg) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(msg);
        progressDialog.show();
        return progressDialog;
    }

    public static int safeLongToInt(long l) {
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
            throw new IllegalArgumentException
                    (l + " cannot be cast to int without changing its value.");
        }
        return (int) l;
    }

    public static Dialog getDialogCart(int layout, Context context) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(layout);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogThemes;
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.show();
        dialog.getWindow().setAttributes(lp);
        return dialog;
    }

    public static Dialog getDialogFilter(int layout, Context context) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(layout);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogThemesFilter;
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.show();
        dialog.getWindow().setAttributes(lp);
        return dialog;
    }

    public static void toggleTransitionSlideEnd(ViewGroup parent, View layout, boolean isShow) {
        Transition transition = new Explode();
        transition.setDuration(300);
        transition.addTarget(layout);

        TransitionManager.beginDelayedTransition(parent, transition);
        layout.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public static void toggleTransitionSlideBottom(ViewGroup parent, View layout, boolean isShow) {
        Transition transition = new Explode();
        transition.setDuration(300);
        transition.addTarget(layout);

        TransitionManager.beginDelayedTransition(parent, transition);
        layout.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public static void toggleTransitionExplode(ViewGroup parent, View layout, boolean isShow) {
        Transition transition = new ChangeTransform();
        transition.setDuration(100);
        transition.addTarget(layout);

        TransitionManager.beginDelayedTransition(parent, transition);
        layout.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public static void toggleTransitionSlideStart(ViewGroup parent, View layout, boolean isShow) {
        Transition transition = new Explode();
        transition.setDuration(300);
        transition.addTarget(layout);

        TransitionManager.beginDelayedTransition(parent, transition);
        layout.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

//    public static String toCurrencyFormat(final String value) {
//
//        if (!TextUtils.isEmpty(value)) {
//            String formattedPrice = value.replaceAll("[^\\d]", "");
//
//            String reverseValue = new StringBuilder(formattedPrice).reverse().toString();
//            StringBuilder finalValue = new StringBuilder();
//            for (int i = 1; i <= reverseValue.length(); i++) {
//                char val = reverseValue.charAt(i - 1);
//                finalValue.append(val);
//                if (i % 3 == 0 && i != reverseValue.length() && i > 0) {
//                    finalValue.append(".");
//                }
//            }
//
//            return finalValue.reverse().toString();
//        }
//
//        return StringUtils.EMPTY;
//    }

//    public static String toDateFormat(final String value) {
//        if (!TextUtils.isEmpty(value)) {
//            String formattedPrice = value.replaceAll("[^\\d]", "");
//
//            String reverseValue = new StringBuilder(formattedPrice).reverse().toString();
//            StringBuilder finalValue = new StringBuilder();
//            for (int i = 1; i <= reverseValue.length(); i++) {
//                char val = reverseValue.charAt(i - 1);
//                finalValue.append(val);
//                if (i % 2 == 0 && i != reverseValue.length() && i > 0) {
//                    finalValue.append("/");
//                }
//            }
//
//            return finalValue.reverse().toString();
//        }
//
//        return StringUtils.EMPTY;
//    }

    public static String strToDateFormat(final String value) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat fromUser = new SimpleDateFormat("yyyyMM");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat myFormat = new SimpleDateFormat("MMM yy");

        try {
            return myFormat.format(fromUser.parse(value));
        } catch (ParseException e) {
            e.printStackTrace();
            return value;
        }
    }

    public static String formatTokenNumber(final String number) {
        String cleanString = number.replace(" ", "");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cleanString.length(); i++) {
            if (i % 4 == 0 && i != 0) {
                result.append("-");
            }

            result.append(cleanString.charAt(i));
        }

        return result.toString();
    }

    public static String formatCardNumber(final String number) {
        String cleanString = number.replace(" ", "");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cleanString.length(); i++) {
            if (i % 4 == 0 && i != 0) {
                result.append(" ");
            }

            result.append(cleanString.charAt(i));
        }

        return result.toString();
    }

    public static String[] formatDateAndTime(String dateTime) {
        String[] tempDateTime = new String[2];
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
            Date date = simpleDateFormat.parse(dateTime);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", new Locale("id", "ID"));
            @SuppressLint("SimpleDateFormat") SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            tempDateTime[0] = dateFormat.format(date);
            tempDateTime[1] = timeFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tempDateTime;
    }

    public static String formatDateCreditcard(String date) {
        String cleanDate = date.trim();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cleanDate.length(); i++) {
            if (i % 2 == 0 && i != 0) {
                result.append("/");
            }
            result.append(cleanDate.charAt(i));
        }
        return result.toString();

    }

    public static String getResponseError(String json) throws JSONException {
        JSONObject jObjError = new JSONObject(json);
        return jObjError.getString("error");
    }

    public static SpannableString formatStrikeString(String text) {
        SpannableString string = new SpannableString(text);
        string.setSpan(new StrikethroughSpan(), 0, string.length(), 0);
        return string;
    }

    public static String getErrorBody(String errorBody) {
        try {
            JSONObject jObjError = new JSONObject(Objects.requireNonNull(errorBody));
            return jObjError.getString("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void getDialogWarning(ResponseBody response, Activity activity){
        Gson gson = new Gson();
        ErrorResponse message = gson.fromJson(Objects.requireNonNull(response).charStream(),ErrorResponse.class);
        String errorMessage = message.getData().getMessage();
        Dialog dialog = MethodUtil.getDialogCart(R.layout.dialog_warning, activity);
        TextView desc = dialog.findViewById(R.id.tv_desc);
        desc.setText(errorMessage);
        ImageView btn_close = dialog.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(view -> {
            dialog.dismiss();
        });
    }

    public static void getDialogWarningCatch(Activity activity){
        String errorMessage = "Terjadi kesalahan\nMohon hubungi customer service";
        Dialog dialog = MethodUtil.getDialogCart(R.layout.dialog_warning, activity);
        TextView desc = dialog.findViewById(R.id.tv_desc);
        desc.setText(errorMessage);
        ImageView btn_close = dialog.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(view -> {
            dialog.dismiss();
        });
    }

    public static String getUrlCsData(){
        String msg = "Halo, Kebon";
        String phone = "6281321436661";
        try {
            for (GeneralInformation information: PreferenceManager.getLoginResponse().getGeneralInformation()){
                if (information.getCode().equals("kebon_general_cs_whatsapp_message_template")){
                    msg = information.getValue();
                }

                if (information.getCode().equals("kebon_official_cs_whatsapp_number")){
                    phone = information.getValue();
                    phone = "62" + phone.substring(1);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        String url = "https://api.whatsapp.com/send?phone=" + phone;
        try {
            url = "https://api.whatsapp.com/send?phone="+phone+"&text=" + URLEncoder.encode(msg, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getPhoneCs(){
        String msg = "Halo, Kebon";
        String phone = "6281321436661";
        try {
            for (GeneralInformation information: PreferenceManager.getLoginResponse().getGeneralInformation()){
                if (information.getCode().equals("kebon_official_cs_whatsapp_number")){
                    phone = information.getValue();
                    phone = "62" + phone.substring(1);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return phone;
    }

    public static String getTemplateMsgCs(){
        String msg = "Halo, Kebon";
        try {
            for (GeneralInformation information: PreferenceManager.getLoginResponse().getGeneralInformation()){
                if (information.getCode().equals("kebon_general_cs_whatsapp_message_template")){
                    msg = information.getValue();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }
}
