package sangttph30270.poly.duan1_nhom6.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import sangttph30270.poly.duan1_nhom6.Data.DbHeper;
import sangttph30270.poly.duan1_nhom6.model.model_User;

public class Dao_User {
    DbHeper dbHeper;
    private SQLiteDatabase sqLite;
    public Dao_User(Context context){
        dbHeper = new DbHeper(context);
        sqLite = dbHeper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public ArrayList<model_User> getDataUser(String sql, String... SelectAvg){
        ArrayList<model_User> list = new ArrayList<>();
        Cursor cursor = sqLite.rawQuery("SELECT * FROM tbl_user", SelectAvg);

        while (cursor.moveToNext()){
            model_User user = new model_User();
            user.setUserId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("user_id"))));
            user.setHoTen(cursor.getString(cursor.getColumnIndex("user_hoTen")));
            user.setMatKhau(cursor.getString(cursor.getColumnIndex("user_matKhau")));
            user.setChucNang(cursor.getString(cursor.getColumnIndex("user_chucNang")));
            list.add(user);
        }
        return list;
    }
    public long insert(model_User user){
        ContentValues values = new ContentValues();
        values.put("user_hoTen", user.getHoTen());
        values.put("user_matKhau", user.getMatKhau());
        values.put("user_chucNang",user.getChucNang());

        return sqLite.insert("tbl_user", null, values);
    }
    public ArrayList<model_User> getAllDataUser(){
        String sql = "SELECT * FROM tbl_user";
        return getDataUser(sql);
    }
    public long update(model_User user){
        ContentValues values = new ContentValues();
        values.put("user_id",user.getUserId());
        values.put("user_hoTen", user.getHoTen());
        values.put("user_matKhau", user.getMatKhau());
        values.put("user_chucNang",user.getChucNang());

        return sqLite.update("tbl_user", values, "user_id = ?", new String[]{String.valueOf(user.getUserId())});
    }
    public int delete(int ID) {
        return sqLite.delete("tbl_user", "user_id = ?", new String[]{String.valueOf(ID)});
    }

}
