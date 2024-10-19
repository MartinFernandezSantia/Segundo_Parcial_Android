package com.martin.segundoparcial_desapps.utils;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.martin.segundoparcial_desapps.modelo.cruds.RolCRUD;
import com.martin.segundoparcial_desapps.modelo.entidades.Rol;
import com.martin.segundoparcial_desapps.modelo.entidades.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Optional;

public class Auth {
    public static void login(Context context, Usuario usuario) {
        String url = "http://192.168.100.7/mis_proyectos/control_tickets/login.php";

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nroId", usuario.getNroId());
            jsonObject.put("password", usuario.getPassword());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, url, jsonObject,
                response -> handleLoginResponse(context, usuario, response),
                error -> Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show()
        );

        RequestQueueSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    private static void handleLoginResponse(Context context, Usuario usuario, JSONObject response) {
        try {
            if (response.has("id")) {
                usuario.setId(response.getInt("id"));
                int rolId = response.getInt("rol");

                // Fetch the role
                Optional<Rol> rol = RolCRUD.getRolById(context, rolId);
                usuario.setRol(rol.get());
                Toast.makeText(context, "Bienvenido/a", Toast.LENGTH_SHORT).show();
            } else if (response.has("error")) {
                Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
