package tesis.invenapp;

import tesis.invenapp.controller.LoginController;
import tesis.invenapp.modelo.Usuario;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {

  private ViewElements    elements;
  private LoginController controller;

  // Modelo
  Usuario                 ususario;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.iniciarsesion);
    elements = new ViewElements();
    controller = new LoginController(this);
  }

  public void login(View v) {
    if (controller.isRegistered(new Usuario(elements.getUsername(), elements
        .getPassword()))) {
      finish();
      startActivity(new Intent(this, ListadoProductos.class));
    } else {
      new AlertDialog.Builder(this)
          .setTitle("Credenciales Incorrectas")
          .setMessage(
 "No tenemos registradas estas credenciales en nuestra base de datos.")
          .setPositiveButton(android.R.string.ok,
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                  // continue with delete
                }
              }).show();
    }
  }

  private class ViewElements {
    // Vista Elements
    private EditText user, pass;
    private TextView register;

    public ViewElements() {
      user = (EditText) findViewById(R.id.usuario);
      pass = (EditText) findViewById(R.id.contrasena);
      register = (TextView) findViewById(R.id.registrarse);

      register.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
          finish();
          startActivity(new Intent(Login.this, Register.class));
        }
      });
    }

    public String getUsername() {
      return user.getText().toString();
    }

    public String getPassword() {
      return pass.getText().toString();
    }
  }
}
