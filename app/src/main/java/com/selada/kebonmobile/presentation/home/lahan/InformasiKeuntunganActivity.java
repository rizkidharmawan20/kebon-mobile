package com.selada.kebonmobile.presentation.home.lahan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.selada.kebonmobile.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InformasiKeuntunganActivity extends AppCompatActivity {

    @OnClick(R.id.btn_kembali)
    void onClickKembali(){
        onBackPressed();
    }

    @OnClick(R.id.btn_back)
    void onClickBack(){
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_keuntungan);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}