package tesis.invenapp;

import java.util.ArrayList;

import tesis.invenapp.controller.ListadoController;
import tesis.invenapp.modelo.Producto;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListadoProductos extends Activity {

  private ViewElements      elements;
  private ListadoController controller;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.listado);
    controller = new ListadoController(this);
    elements = new ViewElements();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu items for use in the action bar
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menuprincipal, menu);
    return super.onCreateOptionsMenu(menu);
  }

  public boolean goToIngreso(MenuItem item) {
    startActivity(new Intent(this, Ingreso.class));
    return true;
  }

  public boolean goToSalida(MenuItem item) {
    startActivity(new Intent(this, Salida.class));
    return true;
  }

  public boolean goToModificar(MenuItem item) {
    startActivity(new Intent(this, Modificar.class));
    return true;
  }

  public boolean goToEstadisticas(MenuItem item) {
    startActivity(new Intent(this, Estadisticas.class));
    return true;
  }

  public boolean goToSugerencias(MenuItem item) {
    startActivity(new Intent(this, Sugerencias.class));
    return true;
  }

  private class ViewElements {
    // Vista Elements
    private ListView listView;

    public ViewElements() {
      listView = (ListView) findViewById(R.id.list);
      ArrayList<Producto> productList = (ArrayList<Producto>) controller
          .getListProduct();
      Producto[] productArray = new Producto[productList.size()];
      productList.toArray(productArray);
      listView.setAdapter(new ListadoAdapter(ListadoProductos.this,
          productArray));
      listView.setOnItemClickListener(new ListadoItemClickListener());
    }
  }

  private class ListadoAdapter extends ArrayAdapter<Producto> {
    private final Context    context;
    private final Producto[] values;

    public ListadoAdapter(Context context, Producto[] values) {
      super(context, R.layout.product_row, values);
      this.context = context;
      this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      LayoutInflater inflater = (LayoutInflater) context
          .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      View rowView = inflater.inflate(R.layout.product_row, parent, false);
      TextView cantidad = (TextView) rowView.findViewById(R.id.cantidad);
      TextView nombre = (TextView) rowView.findViewById(R.id.productolista);
      cantidad.setText(values[position].getCantidad());
      nombre.setText(values[position].getNombre());

      return rowView;
    }
  }

  private class ListadoItemClickListener implements
      ListView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
        long id) {
      Intent Modify=new Intent(ListadoProductos.this, Modificar.class);
      startActivity(Modify);
    }
  }
}
