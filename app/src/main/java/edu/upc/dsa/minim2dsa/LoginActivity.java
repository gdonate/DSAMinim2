package edu.upc.dsa.minim2dsa;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText user1;
    EditText pass;
    String user;
    String password;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user1 = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        cargarSharedPreference();
    }



    private void cargarSharedPreference(){
        SharedPreferences preferences = getSharedPreferences("credenciales",Context.MODE_PRIVATE);
         user = preferences.getString("user","error");
         password = preferences.getString("password","error");
        Intent intent = new Intent(this,MuseosActivity.class);

        if (user.equals("user")&& password.equals("dsamola")) {
            Log.i("G5",""+user);
            Log.i("G5",""+password);
            startActivity(intent);
        }



    }


    public void login(View view){


        Intent intent = new Intent(this,MuseosActivity.class);
        if (user1.getText().toString().equals("user")&&(pass.getText().toString().equals("dsamola"))) {
                Log.i("G4",""+user1.getText().toString());
                Log.i("G4",""+pass.getText().toString());
                SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("user",user1.getText().toString());
                editor.putString("password",pass.getText().toString());
                editor.commit();
                startActivity(intent);
            }


        else {
            AlertDialog alertDialog = new AlertDialog.Builder(edu.upc.dsa.minimo2entregable.LoginActivity.this).create();

            alertDialog.setMessage("No se ha encontrado al usuario");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });
            alertDialog.show();
        }



    }
}