package moj.mojautos.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import moj.mojautos.MojAutosApplication;
import moj.mojautos.R;
import moj.mojautos.injection.MainModule;
import moj.mojautos.injection.SelectCarModule;
import moj.mojautos.model.Car;
import moj.mojautos.ui.MainView;
import moj.mojautos.ui.SelectCarView;

public class SelectCarActivity extends AppCompatActivity implements SelectCarController {

    @Inject
    SelectCarView mSelectCarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_car);

        initComponent();
        mSelectCarView.init(findViewById(android.R.id.content)); // Only place to really use findViewById

         mSelectCarView.showCarList(createListOfCars());
    }

    private void initComponent() {
        MojAutosApplication
                .getApp()
                .getComponent()
                .plus(new SelectCarModule(this, this))
                .inject(this);
    }

    // --- Overridden controller methods below -------------------------------------------------- //

    private List<Car> createListOfCars() {
        List<Car> carList = new ArrayList<>();

        Car c1 = new Car();
        c1.setCarName("Bently");
        c1.setCarResId(R.drawable.bently);

        Car c2 = new Car();
        c2.setCarName("BMW");
        c2.setCarResId(R.drawable.bmw);

        Car c3 = new Car();
        c3.setCarName("Tesla");
        c3.setCarResId(R.drawable.tesla);

        Car c4 = new Car();
        c4.setCarName("Mercedes");
        c4.setCarResId(R.drawable.merc);

        carList.add(c1);
        carList.add(c2);
        carList.add(c3);
        carList.add(c4);

        return carList;
    }

    @Override
    public void buyCar() {

    }
}
