package moj.mojautos.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import moj.mojautos.MojAutosApplication;
import moj.mojautos.R;
import moj.mojautos.injection.qualifiers.ForApplication;
import moj.mojautos.injection.qualifiers.ForCompanyAddress;
import moj.mojautos.injection.qualifiers.ForCompanyTitle;
import moj.mojautos.injection.scopes.PerApplication;

@Module
public class MojAutosApplicationModule {

    private final MojAutosApplication mApplication;

    public MojAutosApplicationModule(MojAutosApplication application) {
        mApplication = application;
    }

    @Provides
    @PerApplication
    @ForApplication
    Context providesApplicationContext (){
        return mApplication;
    }

    @Provides
    @PerApplication
    @ForCompanyTitle
    String providesStrCompanyName() {
        return mApplication.getResources().getString(R.string.moj_autos_title);
    }

    @Provides
    @PerApplication
    @ForCompanyAddress
    String providesStrCompanyAddress() {
        return mApplication.getResources().getString(R.string.moj_autos_address);
    }
}
