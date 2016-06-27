
package moj.mojautos.ui;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import moj.mojautos.R;
import moj.mojautos.controllers.MainController;

public class MainViewImpl implements MainView {

    @BindView(R.id.btn_select_car)
    Button btnSelectCar;

    private final MainController mController;

    @Inject
    public MainViewImpl(MainController controller) {
        mController = controller;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);

        SelectCars();
    }

    // --- View Methods Below ------------------------------------------------------------------- //

    private void SelectCars() {
        btnSelectCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mController.selectCar();
            }
        });
    }
}
