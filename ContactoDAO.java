package hn.uth.pm1ea0199.dao;
import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;
import java.util.ArrayList;
import hn.uth.pm1ea0199.model.Contacto;
/** DAO: concentra todas las operaciones SQL. */
public class ContactoDAO extends SQLiteOpenHelper {
 public ContactoDAO(Context c){super(c,"agenda.db",null,1);}
 @Override public void onCreate(SQLiteDatabase d){d.execSQL("CREATE TABLE contactos(id INTEGER PRIMARY KEY AUTOINCREMENT,pais TEXT NOT NULL,nombre TEXT NOT NULL,telefono TEXT NOT NULL,nota TEXT NOT NULL,imagen TEXT NOT NULL)");}
 @Override public void onUpgrade(SQLiteDatabase d,int oldV,int newV){throw new IllegalStateException("Falta implementar la migración");}
 private ContentValues valores(Contacto c){ContentValues v=new ContentValues();v.put("pais",c.pais);v.put("nombre",c.nombre);v.put("telefono",c.telefono);v.put("nota",c.nota);v.put("imagen",c.imagen);return v;}
 public long guardar(Contacto c){return getWritableDatabase().insertOrThrow("contactos",null,valores(c));}
 public boolean actualizar(Contacto c){return getWritableDatabase().update("contactos",valores(c),"id=?",new String[]{""+c.id})==1;}
 public boolean eliminar(long id){return getWritableDatabase().delete("contactos","id=?",new String[]{""+id})==1;}
 private Contacto leer(Cursor x){return new Contacto(x.getLong(0),x.getString(1),x.getString(2),x.getString(3),x.getString(4),x.getString(5));}
 public ArrayList<Contacto> listar(){ArrayList<Contacto> a=new ArrayList<>();try(Cursor x=getReadableDatabase().rawQuery("SELECT id,pais,nombre,telefono,nota,imagen FROM contactos ORDER BY nombre COLLATE NOCASE",null)){while(x.moveToNext())a.add(leer(x));}return a;}
 public Contacto buscar(long id){try(Cursor x=getReadableDatabase().rawQuery("SELECT id,pais,nombre,telefono,nota,imagen FROM contactos WHERE id=?",new String[]{""+id})){return x.moveToFirst()?leer(x):null;}}
}
