package tesis.invenapp;

import tesis.invenapp.Ingreso.ViewElements;
import tesis.invenapp.controller.IngresoController;
import android.app.Activity;
import android.os.Bundle;

public class Modificar extends Activity {

  private ViewElements      elements;
  private IngresoController controller;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ingreso);
  }
}
