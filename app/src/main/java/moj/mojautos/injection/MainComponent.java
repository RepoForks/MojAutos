package moj.mojautos.injection;

import dagger.Subcomponent;
import moj.mojautos.controllers.MainActivity;

@Subcomponent (modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity activity);
}
