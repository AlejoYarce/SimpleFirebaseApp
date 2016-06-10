package com.alejoyarce.simplefirebase.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.alejoyarce.simplefirebase.R;
import com.alejoyarce.simplefirebase.utils.Utils;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.txtTitleToRemember)
    EditText txtTitleToRemember;

    @Bind(R.id.txtDescToRemember)
    EditText txtDescToRemember;

    @Bind(R.id.btnSendValue)
    Button btnSendValue;

    private Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Firebase.setAndroidContext(this);
    }

    @OnClick(R.id.btnSendValue)
    public void onClick() {
        String titleToRemember = txtTitleToRemember.getText().toString();
        String descToRemember = txtDescToRemember.getText().toString();

        firebase = new Firebase(Utils.FIREBASE_URL).child(Utils.FIREBASE_CHILD_NOTES + "/" + titleToRemember.replace(" ", "_"));

        firebase.setValue(descToRemember);
        txtTitleToRemember.setText("");
        txtDescToRemember.setText("");
    }
}
