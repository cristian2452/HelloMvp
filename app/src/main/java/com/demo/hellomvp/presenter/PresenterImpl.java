package com.demo.hellomvp.presenter;

import com.demo.hellomvp.HelloMvp;
import com.demo.hellomvp.model.MyModel;

public class PresenterImpl implements HelloMvp.Presenter {
    private HelloMvp.View mView;
    private MyModel model;

    public PresenterImpl(HelloMvp.View myView) {
        this.mView = myView;
        model = new MyModel();
        model.setMessage("Cambio de estado");
    }

    @Override
    public void updateMessage() {
        mView.showMessage(model.getMessage());
    }
}
