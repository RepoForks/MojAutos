package moj.mojautos.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import moj.mojautos.controllers.MainActivity;
import moj.mojautos.controllers.MainController;
import moj.mojautos.injection.qualifiers.ForActivity;
import moj.mojautos.ui.MainView;
import moj.mojautos.ui.MainViewImpl;

@Module
public class MainModule {

    private final MainActivity mActivity;
    private final MainController mController;

    public MainModule(MainActivity activity, MainController controller) {
        mActivity = activity;
        mController = controller;
    }

    // Following provides are passed in from the constructor

    @Provides
    @Singleton
    @ForActivity
    Context providesMainActivityContext() {
        return mActivity;
    }

    @Provides
    @Singleton
    MainController providesMainController() {
        return mController;
    }

    // Rest of the provides below are created by Dagger

    @Provides
    @Singleton
    MainView providesMainView (MainViewImpl view) {
        return view;
    }
}
