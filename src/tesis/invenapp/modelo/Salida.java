package tesis.invenapp.modelo;

public class Salida {
  String id, descripcion, productId, cantidad, orden;

  public Salida(String descripcion, String productId, String cantidad,
      String orden) {
    super();
    this.descripcion = descripcion;
    this.productId = productId;
    this.cantidad = cantidad;
    this.orden = orden;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
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
}
