package com.example.douglas.demopersistence;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import static android.content.SharedPreferences.*;

public class LoginActivity extends AppCompatActivity {
    EditText etUsuario;
    EditText etSenha;
    SharedPreferences sp;
    CheckBox cbContinuar;
    Editor e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getPreferences(MODE_PRIVATE);
        setContentView(R.layout.activity_login);


        String user, pass;
        user = sp.getString("usuario", "");
        pass = sp.getString("senha", "");
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etSenha = (EditText) findViewById(R.id.etSenha);
        cbContinuar = (CheckBox) findViewById(R.id.cbContinuar);
        etUsuario.setText(user);
        etSenha.setText(pass);
        boolean conectado = sp.getBoolean("conectado", false);
        cbContinuar.setChecked(conectado);

    }

    public void login(View view) {

        String usuario, senha;
        usuario = etUsuario.getText().toString();
        senha = etSenha.getText().toString();
        e = sp.edit();
        if (cbContinuar.isChecked()) {

            e.putString("usuario", usuario);
            e.putString("senha", senha);
            e.putBoolean("conectado", true);
            Toast.makeText(this,"Usuário: "+usuario,Toast.LENGTH_SHORT).show();
        } else {
            e.putString("usuario", "");
            e.putString("senha", "");
            e.putBoolean("conectado", false);
        }

        e.apply();

    }
}
