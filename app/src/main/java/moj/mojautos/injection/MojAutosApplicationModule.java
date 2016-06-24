package moj.mojautos.injection;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import moj.mojautos.MojAutosApplication;
import moj.mojautos.injection.qualifiers.ForApplication;
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
}
