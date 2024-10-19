package com.martin.segundoparcial_desapps.modelo.cruds;

import android.content.Context;
import android.graphics.Path;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.martin.segundoparcial_desapps.modelo.entidades.Rol;
import com.martin.segundoparcial_desapps.modelo.entidades.Usuario;
import com.martin.segundoparcial_desapps.utils.RequestQueueSingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Optional;

public class RolCRUD {
    public static void crear(Context context, Rol rol) {
        String url = "http://192.168.100.7/mis_proyectos/control_tickets/crear_rol.php";

        // Create JSON object
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("rol", rol.getRol());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Create request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle response
                        try {
                            if (response.has("id")) {
                                int id = response.getInt("id");
                                rol.setId(id);
                                Toast.makeText(context, "Rol created with ID: " + id, Toast.LENGTH_SHORT).show();
                            } else if (response.has("error")) {
                                Toast.makeText(context, "Error: " + response.getString("error"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                        Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueueSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    public static void update(Context context, Rol rol) {
        String url = "http://192.168.100.7/mis_proyectos/control_tickets/update_rol.php";

        // Create JSON object
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("rol", rol.getRol());
            jsonObject.put("id", rol.getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Create request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle response
                        try {
                            if (response.has("success")) {
                                Toast.makeText(context, "Rol actualizado exitosamente", Toast.LENGTH_SHORT).show();
                            } else if (response.has("error")) {
                                Toast.makeText(context, "Error: " + response.getString("error"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                        Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueueSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    public static Optional<Rol> getRolById(Context context, int rolId) {
        String url = "http://192.168.100.7/mis_proyectos/control_tickets/get_rol_by_id.php";
        final Optional<Rol>[] rol = new Optional[]{Optional.empty()};

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", rolId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, url, jsonObject,
                response -> {
                    rol[0] = handleRolResponse(context, response);
                },
                error -> Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show()
        );

        RequestQueueSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);

        return rol[0];
    }

    private static Optional<Rol> handleRolResponse(Context context, JSONObject response) {
        try {
            if (response.has("id")) {
                Rol rol = new Rol(response.getInt("id"), response.getString("rol"));
                return Optional.of(rol);
            } else if (response.has("error")) {
                Toast.makeText(context, "Error: " + response.getString("error"), Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
