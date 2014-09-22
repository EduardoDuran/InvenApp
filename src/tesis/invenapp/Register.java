package tesis.invenapp;

import java.util.ArrayList;
import java.util.List;

import tesis.invenapp.controller.RegisterController;
import tesis.invenapp.modelo.Usuario;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends Activity {
  private ViewElements       elements;
  private RegisterController controller;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.registrarse);
    elements = new ViewElements();
    controller = new RegisterController(this);
  }

  public void registe(View v) {
    if (controller.isValidForm(elements)) {
		list.add("Servicios Computacionales");
		list.add("Repuestos");
		list.add("Retail");
		list.add("Ropa");
		list.add("Fabrica");
		list.add("Taller");
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                  // continue with delete
                }
              }).show();
    }
  }

  public class ViewElements {
    // Vista Elements
    private Spinner act, act2;
    private EditText username, company, email, pass, confirm;

    public ViewElements() {
      act = (Spinner) findViewById(R.id.actividad1);
	
      username = (EditText) findViewById(R.id.nomusuario);
      company = (EditText) findViewById(R.id.nomempresa);
      email = (EditText) findViewById(R.id.correo);
      pass = (EditText) findViewById(R.id.contrasena);
      confirm = (EditText) findViewById(R.id.repitecontrasena);

      addItemsOnSpinner2();
      addListenerOnSpinnerItemSelection();
    }

    public void addItemsOnSpinner2() {
      List<String> list = new ArrayList<String>();
      list.add("list 1");
      list.add("list 2");
      list.add("list 3");
      ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
          Register.this, android.R.layout.simple_spinner_item, list);
      dataAdapter
          .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      act.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
      act.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public class CustomOnItemSelectedListener implements OnItemSelectedListener {

      public void onItemSelected(AdapterView<?> parent, View view, int pos,
          long id) {
        Toast.makeText(
            parent.getContext(),
            "OnItemSelectedListener : "
                + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT)
            .show();
      }

      @Override
      public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
      }

    }

    public String getUsername() {
      return username.getText().toString();
    }

    public String getCompany() {
      return company.getText().toString();
    }

    public String getEmail() {
      return email.getText().toString();
    }

    public String getPassword() {
      return pass.getText().toString();
    }

    public String getConfirmPassword() {
      return confirm.getText().toString();
    }

    public String getActivity() {
      return act.getSelectedItem().toString();
    }

    public String getRuc() {
      return act2.getSelectedItem().toString();
    }
  }
}
