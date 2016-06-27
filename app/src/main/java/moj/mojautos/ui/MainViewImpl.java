
package moj.mojautos.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import moj.mojautos.R;
import moj.mojautos.controllers.MainController;
import moj.mojautos.injection.qualifiers.ForCompanyAddress;
import moj.mojautos.injection.qualifiers.ForCompanyTitle;

public class MainViewImpl implements MainView {
    @BindView(R.id.btn_select_car)
    Button mBtnSelectCar;

    @BindView(R.id.txt_main_buy_car)
    TextView mTxtBuyCar;

    @BindView(R.id.image_main_buy_car)
    ImageView mImgBuyCar;

    @BindViews({R.id.txt_main_buy_car, R.id.image_main_buy_car, R.id.btn_main_buy_car})
    List<View> mCarViewsList;

    @BindView(R.id.txt_main_title)
    TextView mTxtTitle;

    @BindView(R.id.txt_main_address)
    TextView mTxtAddress;

    private final MainController mController;
    private final ButterKnife.Action<View> mActionVisible;
    private final String mMojAutosAddress;
    private final String mMojAutosTitle;

    @Inject
    public MainViewImpl(MainController controller, ButterKnife.Action<View> actionVisible,
                        @ForCompanyTitle String mojAutosTitle, @ForCompanyAddress String mojAutosAddress) {
        mController = controller;
        mActionVisible = actionVisible;
        mMojAutosTitle = mojAutosTitle;
        mMojAutosAddress = mojAutosAddress;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);

        SelectCars();
        setTitleAndAddress();
    }

    private void setTitleAndAddress() {
        mTxtTitle.setText(mMojAutosTitle);
        mTxtAddress.setText(mMojAutosAddress);
    }

    // --- View Methods Below ------------------------------------------------------------------- //

    private void SelectCars() {
        mBtnSelectCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mController.OnSelectCarsClicked();
            }
        });
    }

    @Override
    public void setCarToBuy(String carTitle, int carImageResId) {
        ButterKnife.apply(mCarViewsList, mActionVisible);

        ((TextView) mCarViewsList.get(0)).setText(carTitle);
        mImgBuyCar.setImageResource(carImageResId);
    }
}
