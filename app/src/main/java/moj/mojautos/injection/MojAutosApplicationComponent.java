package moj.mojautos.injection;

import dagger.Component;
import moj.mojautos.MojAutosApplication;

@Component (modules = {MojAutosApplicationModule.class})
public interface MojAutosApplicationComponent {

    void inject (MojAutosApplication application);

    MainComponent plus (MainModule module); // to add more modules, just add as a new argument.
    SelectCarComponent plus (SelectCarModule module);
}
