package tesis.invenapp.db;

import java.util.ArrayList;
import java.util.List;

import tesis.invenapp.modelo.Producto;
import tesis.invenapp.modelo.Salida;
import tesis.invenapp.modelo.Usuario;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

  // All Static variables
  // Database Version
  private static final int    DATABASE_VERSION  = 1;

  // Database Name
  private static final String DATABASE_NAME     = "invenApp";

  // tables name
  private static final String TABLE_USER        = "user";
  private static final String TABLE_PRODUCT     = "product";
  private static final String TABLE_OUTCOME     = "outcome";

  // User Table Columns names
  private static final String KEY_USER_ID       = "id";
  private static final String KEY_USER_NAME     = "name";
  private static final String KEY_COMPANY       = "company";
  private static final String KEY_EMAIL         = "email";
  private static final String KEY_ACTIVITY      = "activity";
  private static final String KEY_RUC           = "ruc";
  private static final String KEY_PASSWORD      = "password";

  // Product Table Columns names
  private static final String KEY_PRODUCT_ID    = "id";
  private static final String KEY_PRODUCT_NAME  = "name";
  private static final String KEY_DESCRIPTION   = "description";
  private static final String KEY_TYPE          = "type";
  private static final String KEY_STOCK         = "stock";
  private static final String KEY_ORDER         = "orden";
  private static final String KEY_USER          = "user_id";

  // Outcome Table Columns names
  private static final String KEY_OUTCOME_ID    = "id";
  private static final String KEY_OUTCOME_DESC  = "description";
  private static final String KEY_PRODUCT       = "product_id";
  private static final String KEY_QUANTITY      = "amount";
  private static final String KEY_OUTCOME_ORDER = "orden";

  public DbHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "(" + KEY_USER_ID
        + " INTEGER PRIMARY KEY," + KEY_USER_NAME + " TEXT," + KEY_COMPANY
        + " TEXT," + KEY_EMAIL + " TEXT," + KEY_ACTIVITY + " TEXT," + KEY_RUC
        + " INTEGER," + KEY_PASSWORD + " TEXT" + ")";
    String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT + "("
        + KEY_PRODUCT_ID + " INTEGER PRIMARY KEY," + KEY_PRODUCT_NAME
        + " TEXT," + KEY_DESCRIPTION + " TEXT," + KEY_TYPE + " TEXT,"
        + KEY_STOCK + " INTEGER," + KEY_ORDER + " TEXT," + KEY_USER
        + " INTEGER" + ")";
    String CREATE_OUTCOME_TABLE = "CREATE TABLE " + TABLE_OUTCOME + "("
        + KEY_OUTCOME_ID + " INTEGER PRIMARY KEY," + KEY_OUTCOME_DESC
        + " TEXT," + KEY_PRODUCT + " TEXT," + KEY_QUANTITY + " INTEGER,"
        + KEY_OUTCOME_ORDER + " TEXT" + ")";
    db.execSQL(CREATE_USER_TABLE);
    db.execSQL(CREATE_PRODUCT_TABLE);
    db.execSQL(CREATE_OUTCOME_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Drop older table if existed
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_OUTCOME);
    // Create tables again
    onCreate(db);
  }

  // Adding new User
  public void registerUser(Usuario user) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_USER_NAME, user.getUsername());
    values.put(KEY_COMPANY, user.getCompany());
    values.put(KEY_EMAIL, user.getEmail());
    values.put(KEY_ACTIVITY, user.getActivity());
    values.put(KEY_RUC, user.getRuc());
    values.put(KEY_PASSWORD, user.getPassword());

    // Inserting Row
    db.insert(TABLE_USER, null, values);
    db.close(); // Closing database connection
  }

  // Verify user by user and pass
  public Usuario verifyUser(Usuario user) {
    SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor = db.query(TABLE_USER, new String[] { KEY_USER_ID,
        KEY_USER_NAME }, KEY_USER_NAME + "=? and " + KEY_PASSWORD + "=?",
        new String[] { user.getUsername(), user.getPassword() }, null, null,
        null, null);
    if (cursor != null)
      cursor.moveToFirst();
    else
      return null;
    
    if(cursor.getCount()>0)
      return new Usuario(Integer.parseInt(cursor.getString(0)),
          cursor.getString(1));
    else
      return null;

    // return user
    
  }

  // Adding new Product
  public void addProduct(Producto product) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_PRODUCT_NAME, product.getNombre());
    values.put(KEY_DESCRIPTION, product.getDescripcion());
    values.put(KEY_TYPE, product.getTipo());
    values.put(KEY_STOCK, product.getCantidad());
    values.put(KEY_ORDER, product.getOrden());
    values.put(KEY_USER, product.getUserId());

    // Inserting Row
    db.insert(TABLE_PRODUCT, null, values);
    db.close(); // Closing database connection
  }

  // Getting All Contacts
  public List<Producto> getAllProducts() {
    List<Producto> productList = new ArrayList<Producto>();

    // Select All Query
    String selectQuery = "SELECT  * FROM " + TABLE_PRODUCT;

    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
      do {
        Producto producto = new Producto(cursor.getString(0),
            cursor.getString(1), cursor.getString(2), cursor.getString(3),
            cursor.getString(4), cursor.getString(5), Integer.parseInt(cursor
                .getString(6)));

        // Adding contact to list
        productList.add(producto);
      } while (cursor.moveToNext());
    }

    // return contact list
    return productList;
  }

  // Getting All Contacts
  public Cursor getAllProductsCursor() {
    // Select All Query
    String selectQuery = "SELECT  * FROM " + TABLE_PRODUCT;

    SQLiteDatabase db = this.getWritableDatabase();

    // return contact list
    return db.rawQuery(selectQuery, null);
  }

  // Adding new outcome
  public void addOutcome(Salida outcome) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_OUTCOME_DESC, outcome.getDescripcion());
    values.put(KEY_PRODUCT, outcome.getProductId());
    values.put(KEY_QUANTITY, outcome.getCantidad());
    values.put(KEY_OUTCOME_ORDER, outcome.getOrden());

    // Inserting Row
    db.insert(TABLE_OUTCOME, null, values);
    db.close(); // Closing database connection
  }

  // Updating single Product
  public int updateProdcut(Producto product) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_PRODUCT_NAME, product.getNombre());
    values.put(KEY_DESCRIPTION, product.getDescripcion());
    values.put(KEY_TYPE, product.getTipo());
    values.put(KEY_STOCK, product.getCantidad());
    values.put(KEY_ORDER, product.getOrden());
    values.put(KEY_USER, product.getUserId());

    // updating row
    return db.update(TABLE_PRODUCT, values, KEY_PRODUCT_ID + " = ?",
        new String[] { product.getCodigo() });
  }

  // Getting contacts Count
  public int getProductsCount() {
    String countQuery = "SELECT  * FROM " + TABLE_PRODUCT;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);
    cursor.close();

    // return count
    return cursor.getCount();
  }

}
