package tesis.invenapp;

import tesis.invenapp.controller.IngresoController;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Salida extends Activity {

  private ViewElements      elements;
  private IngresoController controller;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.salida);
  }

  public void goToListado(View v) {
    finish();
    startActivity(new Intent(this, ListadoProductos.class));
  }

  private class ViewElements {
    // Vista Elements
    private EditText codigo, producto, descripcion, cantidad, factura;

    public ViewElements() {
      codigo = (EditText) findViewById(R.id.codigo);
      producto = (EditText) findViewById(R.id.producto);
      descripcion = (EditText) findViewById(R.id.descripcion);
      cantidad = (EditText) findViewById(R.id.salen);
      factura = (EditText) findViewById(R.id.factura);
    }

    public String getCodigo() {
      return codigo.getText().toString();
    }

    public String getProducto() {
      return producto.getText().toString();
    }

    public String getDescripcion() {
      return descripcion.getText().toString();
    }

    public String getCantidad() {
      return cantidad.getText().toString();
    }

    public String getFactura() {
      return factura.getText().toString();
    }
  }
}
