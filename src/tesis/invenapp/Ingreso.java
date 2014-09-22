package tesis.invenapp;

import tesis.invenapp.controller.IngresoController;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Ingreso extends Activity {

  private ViewElements      elements;
  private IngresoController controller;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ingreso);
    elements = new ViewElements();
  }

  public void goToListado(View v) {
    finish();
    startActivity(new Intent(this, ListadoProductos.class));
  }

  private class ViewElements {
    // Vista Elements
    private EditText codigo, producto, descripcion, tipo, cantidad,
        ordencompra;

    public ViewElements() {
      codigo = (EditText) findViewById(R.id.codigo);
      producto = (EditText) findViewById(R.id.producto);
      descripcion = (EditText) findViewById(R.id.descripcion);
      tipo = (EditText) findViewById(R.id.tipo);
      cantidad = (EditText) findViewById(R.id.cantidad);
      ordencompra = (EditText) findViewById(R.id.Ordencompra);
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

    public String getTipo() {
      return tipo.getText().toString();
    }

    public String getCantidad() {
      return cantidad.getText().toString();
    }

    public String getOrdenCompra() {
      return ordencompra.getText().toString();
    }
  }
}
