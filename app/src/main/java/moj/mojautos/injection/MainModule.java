package moj.mojautos.injection;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import javax.inject.Singleton;

import butterknife.ButterKnife;
import dagger.Module;
import dagger.Provides;
import moj.mojautos.controllers.MainActivity;
import moj.mojautos.controllers.MainController;
import moj.mojautos.injection.qualifiers.ForActivity;
import moj.mojautos.injection.scopes.PerActivity;
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
    @PerActivity
    @ForActivity
    Context providesMainActivityContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    MainController providesMainController() {
        return mController;
    }

    // Rest of the provides below are created by Dagger

    @Provides
    @PerActivity
    MainView providesMainView(MainViewImpl view) {
        return view;
    }

    @Provides
    @PerActivity
    ButterKnife.Action<View> providesActionVisible (){
        return new ButterKnife.Action<View>() {
            @Override
            public void apply(@NonNull View view, int index) {
                view.setVisibility(View.VISIBLE);
            }
        };
    }
}
