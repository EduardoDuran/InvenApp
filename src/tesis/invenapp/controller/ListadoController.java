package tesis.invenapp.controller;

import java.util.List;

import tesis.invenapp.ListadoProductos;
import tesis.invenapp.db.DbHelper;
import tesis.invenapp.modelo.Producto;

public class ListadoController {

  DbHelper db;

  public ListadoController(ListadoProductos listadoProductos) {
    db = new DbHelper(listadoProductos);
  }

  public List<Producto> getListProduct() {
    return db.getAllProducts();
  }
}
