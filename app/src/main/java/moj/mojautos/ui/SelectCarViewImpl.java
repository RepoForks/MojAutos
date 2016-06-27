package moj.mojautos.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import moj.mojautos.R;
import moj.mojautos.controllers.SelectCarController;
import moj.mojautos.injection.qualifiers.ForCompanyAddress;
import moj.mojautos.injection.qualifiers.ForCompanyTitle;
import moj.mojautos.model.Car;

public class SelectCarViewImpl implements SelectCarView {


    @BindView(R.id.select_car_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.txt_select_car_title)
    TextView mTxtTitle;

    @BindView(R.id.txt_select_car_address)
    TextView mTxtAddress;

    // Only inject these if at root level (activity etc.)
    SelectCarController mController;
    CarAdapter mAdapter;
    LinearLayoutManager mLayoutManager;
    private final String mMojAutosAddress;
    private final String mMojAutosTitle;

    @Inject
    SelectCarViewImpl(SelectCarController controller, CarAdapter adapter, LinearLayoutManager layoutManager,
                      @ForCompanyTitle String mojAutosTitle, @ForCompanyAddress String mojAutosAddress) {
        mController = controller;
        mAdapter = adapter;
        mLayoutManager = layoutManager;
        mMojAutosTitle = mojAutosTitle;
        mMojAutosAddress = mojAutosAddress;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
        initRecyclerView();
        setTitleAndAddress();
    }

    private void setTitleAndAddress() {
        mTxtTitle.setText(mMojAutosTitle);
        mTxtAddress.setText(mMojAutosAddress);
    }

    // --- View Methods Below ------------------------------------------------------------------- //

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showCarList(List<Car> carList) {
        mAdapter.setData(carList);
    }

}