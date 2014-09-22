package tesis.invenapp;

import tesis.invenapp.controller.ListadoController;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;

public class ListadoProductos extends Activity {

  private ViewElements      elements;
  private ListadoController controller;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.listado);
    elements = new ViewElements();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu items for use in the action bar
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menuprincipal, menu);
    return super.onCreateOptionsMenu(menu);
  }

  public void goToIngreso(View v) {
    startActivity(new Intent(this, Ingreso.class));
  }

  public void goToSalida(View v) {
    startActivity(new Intent(this, Salida.class));
  }

  public void goToModificar(View v) {
    startActivity(new Intent(this, Modificar.class));
  }

  public void goToEstadisticas(View v) {
    startActivity(new Intent(this, Estadisticas.class));
  }

  public void goToSugerencias(View v) {
    startActivity(new Intent(this, Sugerencias.class));
  }

  private class ViewElements {
    // Vista Elements
    private ListView listView;

    public ViewElements() {
      listView = (ListView) findViewById(R.id.list);
      // Defined Array values to show in ListView
      String[] values = new String[] { "Aretes", "Anillos", "Alligators",
          "Brazaletes", "Bolsos", "Bañador", "Cinturon 102", "Cinturon 103",
          "Cinturon 104", "Cinturon 105", "Correa", "Dige", "Estampas",
          "Frosting", "Guantes", "Hanger", "Indicadores", "Cinturon 105" };

    }
  }
}