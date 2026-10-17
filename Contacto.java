package hn.uth.pm1ea0199.model;
/** Modelo independiente de las pantallas y de SQLite. */
public class Contacto {
 public long id;
 public String pais, nombre, telefono, nota, imagen;
 public Contacto(long id,String pais,String nombre,String telefono,String nota,String imagen) {
  this.id=id;this.pais=pais;this.nombre=nombre;this.telefono=telefono;this.nota=nota;this.imagen=imagen;
 }
 @Override public String toString(){return nombre+"\n"+pais+" · "+telefono;}
}
