package com.selada.kebonmobile.presentation.status.tab.tanaman.panen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.selada.kebonmobile.R;
import com.selada.kebonmobile.presentation.status.tab.tanaman.MenanamContinueActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KonfirmasiPanenOfflineActivity extends AppCompatActivity {

    @BindView(R.id.tv_desc)
    TextView tv_desc;

    @OnClick(R.id.btn_konfirmai)
    void onClickKonfirmasi(){
        Intent intent = new Intent(this, MenanamContinueActivity.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_panen_offline);
        ButterKnife.bind(this);

        initComponent();
    }

    private void initComponent() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}