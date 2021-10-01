package com.selada.kebonmobile.presentation.akun.password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.selada.kebonmobile.R;
import com.selada.kebonmobile.presentation.akun.DetailAkunActivity;
import com.selada.kebonmobile.presentation.akun.nama.UbahNamaActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class UbahPasswordActivity extends AppCompatActivity {

    @OnClick(R.id.btn_changePassword)
    void onClickChangePassword() {
        finish();
        Intent intent = new Intent(UbahPasswordActivity.this, PasswordBaruActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_back)
    void onClickBack(){
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_password);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}