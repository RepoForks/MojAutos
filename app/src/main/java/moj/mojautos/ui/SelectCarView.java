package moj.mojautos.ui;

import android.view.View;

import java.util.List;

import moj.mojautos.model.Car;

public interface SelectCarView {

    void init(View view);
    void showCarList(List<Car> carList);
}
