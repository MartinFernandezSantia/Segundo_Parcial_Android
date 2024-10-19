package com.martin.segundoparcial_desapps.vista;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.toolbox.Volley;
import com.martin.segundoparcial_desapps.R;
import com.martin.segundoparcial_desapps.modelo.cruds.RolCRUD;

import com.android.volley.RequestQueue;
import com.martin.segundoparcial_desapps.modelo.entidades.Usuario;
import com.martin.segundoparcial_desapps.utils.Auth;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;

    private EditText nroIdET;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

        nroIdET = findViewById(R.id.nroId);
        password = findViewById(R.id.password);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void btnClick(View view) {
        int nro_id = Integer.valueOf(nroIdET.getText().toString());
        String contraseña = password.getText().toString();

        Usuario usuario = new Usuario();
        usuario.setPassword(contraseña);
        usuario.setNroId(nro_id);

        Auth.login(this, usuario);
//        RolCRUD.getById(this, 1);
    }

}