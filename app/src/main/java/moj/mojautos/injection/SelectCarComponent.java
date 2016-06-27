package moj.mojautos.injection;

import dagger.Subcomponent;
import moj.mojautos.controllers.SelectCarActivity;
import moj.mojautos.injection.scopes.PerActivity;

@PerActivity
@Subcomponent(modules = {SelectCarModule.class})
public interface SelectCarComponent {

    void inject(SelectCarActivity activity);
}
