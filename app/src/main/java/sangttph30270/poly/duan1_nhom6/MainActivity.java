package sangttph30270.poly.duan1_nhom6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

import sangttph30270.poly.duan1_nhom6.Admin_Fragment.DanhSach_Fragment;
import sangttph30270.poly.duan1_nhom6.Admin_Fragment.DonHang_Fragment;
import sangttph30270.poly.duan1_nhom6.Admin_Fragment.PhanHoi_Admin_Fragment;
import sangttph30270.poly.duan1_nhom6.Admin_Fragment.TaiKhoan_Admin_Fragment;
import sangttph30270.poly.duan1_nhom6.Admin_Fragment.ThongKe_Fragment;
import sangttph30270.poly.duan1_nhom6.User_Fragment.GioHang_Fragment;
import sangttph30270.poly.duan1_nhom6.User_Fragment.Home_Fragment;
import sangttph30270.poly.duan1_nhom6.User_Fragment.LichSu_Fragment;
import sangttph30270.poly.duan1_nhom6.User_Fragment.PhanHoi_User_Fragment;
import sangttph30270.poly.duan1_nhom6.User_Fragment.TaiKhoan_User_Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationBarView view = findViewById(R.id.bottom_navi);
        view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.admin_DanhSach) {
                    menu(new DanhSach_Fragment());
                } else if (item.getItemId() == R.id.admin_PhanHoi) {
                    menu(new PhanHoi_Admin_Fragment());
                } else if (item.getItemId() == R.id.admin_DonHang) {
                    menu(new DonHang_Fragment());
                } else if (item.getItemId() == R.id.admin_ThongKe) {
                    menu(new ThongKe_Fragment());
                } else if (item.getItemId() == R.id.admin_TaiKhoan) {
                    menu(new TaiKhoan_Admin_Fragment());
                } else {
                    return false;
                }
                return true;

            }
        });
        menu(new DonHang_Fragment());
    }
    public void menu(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_content, fragment);
        fragmentTransaction.commit();
    }
}