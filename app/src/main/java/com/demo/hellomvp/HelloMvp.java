package com.demo.hellomvp;

public interface HelloMvp {
    interface Presenter {
        void updateMessage();
    }

    interface View {
        void showMessage(String newMessage);
    }
}
