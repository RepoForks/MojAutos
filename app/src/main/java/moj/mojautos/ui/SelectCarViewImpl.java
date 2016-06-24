package moj.mojautos.ui;

import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import moj.mojautos.controllers.SelectCarController;

public class SelectCarViewImpl implements SelectCarView {

    private final SelectCarController mController;

    @Inject
    public SelectCarViewImpl(SelectCarController controller) {
        mController = controller;
    }

    @Override
    public void init(View view) {
        ButterKnife.bind(this, view);
    }

    // --- View Methods Below ------------------------------------------------------------------- //
}