package com.androchunk.multichoicedialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MultipleChoiceDialogFragment.onMultiChoiceListener {

    private TextView tvSelectedChoices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSelectedChoices = findViewById(R.id.tvSelectedChoices);

        Button btnSelectChoices = findViewById(R.id.btnSelectChoices);
        btnSelectChoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment multiChoiceDialog = new MultipleChoiceDialogFragment();
                multiChoiceDialog.setCancelable(false);
                multiChoiceDialog.show(getSupportFragmentManager(), "Multichoice Dialog");
            }
        });

    }


    @Override
    public void onPositiveButtonClicked(String[] list, ArrayList<String> selectedItemList) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Selected Choices = ");
        for (String str : selectedItemList) {
            stringBuilder.append(str + " ");
        }
        tvSelectedChoices.setText(stringBuilder);

    }

    @Override
    public void onNegativeButtonClicked() {
        tvSelectedChoices.setText("Dialog Cancel");
    }
}
