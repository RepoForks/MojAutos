package moj.mojautos.ui;

import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import moj.mojautos.controllers.MainController;

public class MainViewImpl implements MainView {

    private final MainController mController;

    @Inject
    public MainViewImpl(MainController controller) {
        mController = controller;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
    }

    // --- View Methods Below ------------------------------------------------------------------- //
}
