package tesis.invenapp.modelo;

public class Producto {
  private int userId;
  private String codigo, nombre, descripcion, tipo, cantidad, orden;

  public Producto(String codigo, String nombre, String descripcion,
      String tipo, String cantidad, String orden, int userId) {
    super();
    this.codigo = codigo;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.tipo = tipo;
    this.cantidad = cantidad;
    this.orden = orden;
    this.userId = userId;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getCantidad() {
    return cantidad;
  }

  public void setCantidad(String cantidad) {
    this.cantidad = cantidad;
  }

  public String getOrden() {
    return orden;
  }

  public void setOrden(String orden) {
    this.orden = orden;
  }

  public int getUserId() {
    return userId;
  }

  public void setOrden(int userId) {
    this.userId = userId;
  }
}
