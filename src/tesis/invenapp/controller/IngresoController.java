package tesis.invenapp.controller;

import tesis.invenapp.Ingreso;
import tesis.invenapp.Ingreso.ViewElements;
import tesis.invenapp.db.DbHelper;
import tesis.invenapp.modelo.Producto;
import android.content.Context;
import android.content.SharedPreferences;

public class IngresoController {
  DbHelper db;
  Context  contexto;
  int      userId;

  public IngresoController(Ingreso ingreso) {
    super();
    contexto = ingreso;
    db = new DbHelper(ingreso);
  }

  public void saveProduct(Producto product) {
    product.setUserId(userId);
    db.addProduct(product);
  }

  public boolean isValidForm(ViewElements elements) {
    if (elements.getCantidad().isEmpty() || elements.getProducto().isEmpty())
      return false;
    SharedPreferences pref = contexto.getApplicationContext()
        .getSharedPreferences("InvenApp", 0);
    userId = pref.getInt("userId", 0); // getting Integer
    return true;
  }
}
