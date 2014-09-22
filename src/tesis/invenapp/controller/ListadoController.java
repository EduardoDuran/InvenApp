package tesis.invenapp.controller;

import tesis.invenapp.ListadoProductos;
import tesis.invenapp.db.DbHelper;
import android.database.Cursor;

public class ListadoController {

  DbHelper db;

  public ListadoController(ListadoProductos listadoProductos) {
    db = new DbHelper(listadoProductos);
  }

  public Cursor getCursorList() {
    return db.getAllProductsCursor();
  }
}
