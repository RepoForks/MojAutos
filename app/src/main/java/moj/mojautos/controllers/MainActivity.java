package moj.mojautos.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import moj.mojautos.MojAutosApplication;
import moj.mojautos.R;
import moj.mojautos.injection.MainModule;
import moj.mojautos.ui.MainView;

public class MainActivity extends AppCompatActivity implements MainController {

    @Inject
    MainView mMainView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        mMainView.init(findViewById(android.R.id.content)); // Only place to really use findViewById
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
    public void selectCar() {
        Intent intent = new Intent(this, SelectCarActivity.class);
        startActivity(intent);
    }
}
