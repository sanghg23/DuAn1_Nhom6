package sangttph30270.poly.duan1_nhom6.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHeper extends SQLiteOpenHelper {
    private static final String DB_NAME = "data";
    private static final int DB_VERSION = 1;

    public DbHeper(@Nullable Context context) {
        super(context,"DBhepper_Name" , null, DB_VERSION);
    }

    public static final String TABLE_USER_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_user (" +
            "user_id TEXT PRIMARY KEY , " +
            "user_hoTen TEXT NOT NULL," +
            "user_matKhau TEXT NOT NULL," +
            "user_chucNang TEXT" +
            ")";
    public static final String TABLE_NGUOI_DUNG_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_nguoiDung (" +
            "nguoiDung_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nguoiDung_ten TEXT NOT NULL," +
            "nguoiDung_email TEXT NOT NULL," +
            "nguoiDung_soDienThoai TEXT NOT NULL," +
            "nguoiDung_noiDung TEXT NOT NULL" +
            ")";
    public static final String TABLE_SUA_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_coffee (" +
            "coffee_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "coffee_img TEXT NOT NULL, " +
            "coffee_tenCoffee TEXT NOT NULL, " +
            "coffee_moTa TEXT NOT NULL, " +
            "coffee_gia REAL NOT NULL" +
            ")";
    public static final String TABLE_GIOHANG_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_gioHang (" +
            "gioHang_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "gioHang_id INTEGER REFERENCES tbl_sua(sua_id), " +
            "gioHang_soLuong INTEGER NOT NULL, " +
            "gioHang_tongTien REAL NOT NULL" +
            ")";
    public static final String TABLE_HOADON_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_hoaDon (" +
            "hoaDon_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "hoaDon_id INTEGER REFERENCES tbl_gioHang(gioHang_id), " +
            "hoaDon_diaChi TEXT NOT NULL, " +
            "hoaDon_thoiGian TEXT NOT NULL, " +
            "hoaDon_comment TEXT NOT NULL" +
            ")";



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USER_CREATE);
        db.execSQL(TABLE_NGUOI_DUNG_CREATE);
        db.execSQL(TABLE_SUA_CREATE);
        db.execSQL(TABLE_GIOHANG_CREATE);
        db.execSQL(TABLE_HOADON_CREATE);
        db.execSQL("INSERT INTO tbl_user VALUES ('admin', '123123', 'admin'),('user','123123', 'user')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS tbl_user");
            db.execSQL("DROP TABLE IF EXISTS tbl_nguoiDung");
            db.execSQL("DROP TABLE IF EXISTS tbl_coffee");
            db.execSQL("DROP TABLE IF EXISTS tbl_gioHang");
            db.execSQL("DROP TABLE IF EXISTS tbl_hoaDon");
            onCreate(db);
        }
    }
}
