package moj.mojautos.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import moj.mojautos.R;

public class CarViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_car_view_title)
    TextView mTxtCarTitle;

    @BindView(R.id.btn_car_view_buy)
    Button mBtnBuy;

    @BindView(R.id.image_car_view)
    ImageView mImgCar;

    public CarViewHolder(View v) {
        super(v);
        ButterKnife.bind(this, v);
    }
}
