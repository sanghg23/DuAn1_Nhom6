package sangttph30270.poly.duan1_nhom6.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import sangttph30270.poly.duan1_nhom6.Data.DbHeper;
import sangttph30270.poly.duan1_nhom6.model.model_Coffe;

public class Dao_Coffe {
    DbHeper dbHelper;
    private SQLiteDatabase sqLite;

    public Dao_Coffe(Context context) {
        dbHelper = new DbHeper(context);
        sqLite = dbHelper.getWritableDatabase();
    }


    @SuppressLint("Range")
    public ArrayList<model_Coffe> getDataCoffe(String sql, String... SelectAvg){
        ArrayList<model_Coffe> list = new ArrayList<>();
        Cursor cursor = sqLite.rawQuery("SELECT * FROM tbl_coffee", SelectAvg);
        while (cursor.moveToNext()){
            model_Coffe cf = new model_Coffe();
            cf.setCoffeId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("coffee_id"))));
            cf.setAnh(cursor.getString(cursor.getColumnIndex("coffee_img")));
            cf.setTenCoffe(cursor.getString(cursor.getColumnIndex("coffee_tenCoffee")));
            cf.setMoTa(cursor.getString(cursor.getColumnIndex("coffee_moTa")));
            cf.setGia(cursor.getString(cursor.getColumnIndex("coffee_gia")));
            list.add(cf);
        }
        return list;
    }

    public long insert(model_Coffe cf){
        ContentValues values = new ContentValues();
        values.put("coffee_img", cf.getAnh());
        values.put("coffee_tenCoffee", cf.getTenCoffe());
        values.put("coffee_moTa", cf.getMoTa());
        values.put("coffee_gia", cf.getGia());
        return sqLite.insert("tbl_coffee", null, values);
    }
    public long update(model_Coffe cf){
        ContentValues values = new ContentValues();
        values.put("coffee_img", cf.getAnh());
        values.put("coffee_tenCoffee", cf.getTenCoffe());
        values.put("coffee_moTa", cf.getMoTa());
        values.put("coffee_gia", cf.getGia());
        return sqLite.update("tbl_coffee", values, "coffee_id = ?", new String[]{String.valueOf(cf.getCoffeId())});
    }
    public int delete(int ID) {
        return sqLite.delete("tbl_coffee", "coffee_id = ?", new String[]{String.valueOf(ID)});
    }
    public ArrayList<model_Coffe> getAllData() {
        String sql = "SELECT * FROM tbl_loaiSach";
        return getDataCoffe(sql);
    }
}
