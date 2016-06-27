package moj.mojautos.injection;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import moj.mojautos.controllers.SelectCarActivity;
import moj.mojautos.controllers.SelectCarController;
import moj.mojautos.injection.qualifiers.ForActivity;
import moj.mojautos.injection.scopes.PerActivity;
import moj.mojautos.model.Car;
import moj.mojautos.ui.CarAdapter;
import moj.mojautos.ui.SelectCarView;
import moj.mojautos.ui.SelectCarViewImpl;

@Module
public class SelectCarModule {

    private final SelectCarActivity mActivity;
    private final SelectCarController mController;

    public SelectCarModule(SelectCarActivity activity, SelectCarController controller) {
        mActivity = activity;
        mController = controller;
    }

    // Following provides are passed in from the constructor

    @Provides
    @PerActivity
    @ForActivity
    Context providesSelectCarActivityContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    SelectCarController providesSelectCarController() {
        return mController;
    }

    // ---- Rest of the provides below are created by Dagger ------------------------------------ //

    @Provides
    @PerActivity
    SelectCarView providesSelectCarView(SelectCarViewImpl view) {
        return view;
    }

    @Provides
    @PerActivity
    LinearLayoutManager providesLinearLayoutManager(@ForActivity Context context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    @PerActivity
    CarAdapter providesCarAdapter() {
        return new CarAdapter(new ArrayList<Car>(), mController);
    }
}
