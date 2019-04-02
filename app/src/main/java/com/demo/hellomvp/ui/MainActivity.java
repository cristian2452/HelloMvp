package com.demo.hellomvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.demo.hellomvp.HelloMvp;
import com.demo.hellomvp.R;
import com.demo.hellomvp.presenter.PresenterImpl;

public class MainActivity extends AppCompatActivity implements HelloMvp.View {
    private TextView tvHello;
    private HelloMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding
        presenter = new PresenterImpl(this);

        final Button btnUpgrade = findViewById(R.id.btn_upgrade);
        tvHello = findViewById(R.id.tv_hello);

        btnUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenter != null) {
                    presenter.updateMessage();
                }
            }
        });
    }

    @Override
    public void showMessage(String newMessage) {
        tvHello.setText(newMessage);
    }
}
