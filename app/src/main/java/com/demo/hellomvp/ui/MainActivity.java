package com.demo.hellomvp.ui;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.demo.hellomvp.HelloMvp;
import com.demo.hellomvp.R;
import com.demo.hellomvp.presenter.PresenterImpl;

public class MainActivity extends AppCompatActivity implements HelloMvp.View {
    private TextView tvHello;
    private HelloMvp.Presenter presenter;
    private ProgressBar loading;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding
        presenter = new PresenterImpl(this);

        handler = new Handler();
        final Button btnUpgrade = findViewById(R.id.btn_upgrade);
        tvHello = findViewById(R.id.tv_hello);
        loading = findViewById(R.id.progressBar);
        loading.setVisibility(View.INVISIBLE);

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
    public void showMessage(final String newMessage) {
        loading.setVisibility(View.VISIBLE);

        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    loading.setVisibility(View.GONE);
                                    tvHello.setText(newMessage);
                                }
                            },2000);

    }
}
