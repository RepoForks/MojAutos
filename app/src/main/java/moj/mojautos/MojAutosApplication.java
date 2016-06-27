package moj.mojautos;

import android.app.Application;

import moj.mojautos.injection.DaggerMojAutosApplicationComponent;
import moj.mojautos.injection.MojAutosApplicationComponent;
import moj.mojautos.injection.MojAutosApplicationModule;

public class MojAutosApplication extends Application {

    private static MojAutosApplication sApp; // Static copy of the Application context.

    private MojAutosApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sApp = this;

        /**
         * The component is made up from Modules
         */
        mComponent = DaggerMojAutosApplicationComponent.builder()
                .mojAutosApplicationModule(new MojAutosApplicationModule(this)) // Can add more modules using . operator
                .build();

        mComponent.inject(this);
    }

    public static MojAutosApplication getApp() {
        return sApp;
    }

    public MojAutosApplicationComponent getComponent() {
        return mComponent;
    }

}