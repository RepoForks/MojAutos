package moj.mojautos.ui;

import android.view.View;

public interface MainView {

    void init (View view);
    void setCarToBuy(String carTitle, int carImageResId);
}
