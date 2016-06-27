package moj.mojautos.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import javax.inject.Inject;

import moj.mojautos.MojAutosApplication;
import moj.mojautos.R;
import moj.mojautos.injection.MainModule;
import moj.mojautos.ui.MainView;

public class MainActivity extends AppCompatActivity implements MainController {

    final static int INTENT_REQUEST_CODE = 1;

    final static String CAR_TITLE_EXTRA = "CAR_TITLE_EXTRA";
    final static String CAR_IMAGE_RES_ID_EXTRA = "CAR_IMAGE_RES_ID_EXTRA";

    @Inject
    MainView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        mView.init(findViewById(android.R.id.content)); // Only place to really use findViewById
    }

    private void initComponent() {
        MojAutosApplication
                .getApp()
                .getComponent()
                .plus(new MainModule(this, this))
                .inject(this);
    }

    // --- Overridden controller methods below -------------------------------------------------- //

    @Override
    public void OnSelectCarsClicked() {
        Intent intent = new Intent(this, SelectCarActivity.class);
        startActivityForResult(intent, INTENT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Log.d("Activity Result", data.getStringExtra(CAR_TITLE_EXTRA));

        if (resultCode == Activity.RESULT_OK) {
            String carTitle = data.getStringExtra(CAR_TITLE_EXTRA);
            int carImageResId = data.getIntExtra(CAR_IMAGE_RES_ID_EXTRA, 0);
            // Use TextUtils as it has a null checker
            if (!TextUtils.isEmpty(carTitle)) {
                mView.setCarToBuy(carTitle, carImageResId);
            }
        }
    }
}
