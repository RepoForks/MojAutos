package moj.mojautos.injection;

import dagger.Subcomponent;
import moj.mojautos.controllers.SelectCarActivity;

@Subcomponent(modules = {SelectCarModule.class})
public interface SelectCarComponent {

    void inject(SelectCarActivity activity);
}
