package moj.mojautos.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import moj.mojautos.controllers.SelectCarActivity;
import moj.mojautos.controllers.SelectCarController;
import moj.mojautos.injection.qualifiers.ForActivity;
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
    @Singleton
    @ForActivity
    Context providesSelectCarActivityContext() {
        return mActivity;
    }

    @Provides
    @Singleton
    SelectCarController providesSelectCarController() {
        return mController;
    }

    // Rest of the provides below are created by Dagger

    @Provides
    @Singleton
    SelectCarView providesSelectCarView(SelectCarViewImpl view) {
        return view;
    }
}
