package moj.mojautos.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import moj.mojautos.R;
import moj.mojautos.controllers.SelectCarController;
import moj.mojautos.model.Car;

public class SelectCarViewImpl implements SelectCarView {

    SelectCarController mController;

    @BindView(R.id.select_car_recycler_view)
    RecyclerView mRecyclerView;

    // Only inject these if at root level (activity etc.)
    LinearLayoutManager mLayoutManager;
    CarAdapter mAdapter;

    @Inject
    SelectCarViewImpl(SelectCarController controller, CarAdapter adapter, LinearLayoutManager layoutManager) {
        mController = controller;
        mAdapter = adapter;
        mLayoutManager = layoutManager;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
        initRecyclerView();
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