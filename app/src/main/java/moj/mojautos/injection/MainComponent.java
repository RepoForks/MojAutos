package moj.mojautos.injection;

import dagger.Subcomponent;
import moj.mojautos.controllers.MainActivity;
import moj.mojautos.injection.scopes.PerActivity;

@PerActivity
@Subcomponent (modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity activity);
}
