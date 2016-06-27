package moj.mojautos.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import moj.mojautos.R;
import moj.mojautos.controllers.SelectCarController;
import moj.mojautos.model.Car;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private final SelectCarController mController;
    private int mCount;
    private List<Car> mDataset;

    @Inject
    public CarAdapter(List<Car> myDataset, SelectCarController controller) {
        mDataset = myDataset;
        mController = controller;
    }

    @Override
    public int getItemCount() {
        return mCount; // because we do not need to keep using mDataset.length as the size is fixed.
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_view, parent, false);
        /*
        RecyclerView.ViewHolder viewHolder = new CarViewHolder(v);
        Creates a type of the parent view to only give access to the view.
        Useful when no further information is needed other than the view when we want to click.
         */
        final CarViewHolder vh = new CarViewHolder(v);
        vh.mBtnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = vh.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mController.onBuyClicked(
                            mDataset.get(position).getCarName(),
                            mDataset.get(position).getCarResId());
                }
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        // set texts etc.
        holder.mTxtCarTitle.setText(mDataset.get(position).getCarName());
        Picasso.with(holder.mImgCar.getContext()).load(mDataset.get(position).getCarResId()).into(holder.mImgCar);
    }

    public void setData(List<Car> data) {
        mDataset = data;
        mCount = data.size();
        notifyDataSetChanged();
    }
}