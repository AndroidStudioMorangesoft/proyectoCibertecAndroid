package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 23/05/2018.
 */

public class SQLite_OpenHelper extends SQLiteOpenHelper {


    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);



    }

    //dse  crea la estructura de la tabla


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query ="create table Usuarios(Id integer primary key autoincrement ," +
                " Nombre text,Distrito text,Correo text,Password text);";
        sqLiteDatabase.execSQL(query);

    }


//si se desea modificar alguna tabla
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    // me perimite abrir la base de datos
    public void abrir(){
        this.getWritableDatabase();
    }

    //que me permita cerrar la base de datos
    public void cerrar(){
        this.close();

    }

//metodo que me permite insertar registros en la tabla usuario

    public void insertarRegistro(String nom, String dis,String cor,String pas){

        ContentValues valores = new ContentValues();
        //agregar valores
        valores.put("Nombre",nom);
        valores.put("Distrito",dis);
        valores.put("Correo",cor);
        valores.put("Password",pas);
        this.getWritableDatabase().insert("Usuarios",null,valores);

    }

public Cursor ConsultarUsuPas(String usu,String pas)throws SQLException{
    Cursor mcursor = null;
    mcursor = this.getReadableDatabase().query("Usuarios", new String[]{"Id",
            "Nombre","Distrito","Correo","Password"},"Correo like '"+usu+"'" +
            "and Password like '"+pas+"'",null,null,null,null);

    return mcursor;

}
















}
