package sangttph30270.poly.duan1_nhom6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {


    private EditText Login_edt_matKhau, Login_edt_taiKhoan;
private Button Login_btnDangNhap,Login_btnDangky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Login_edt_matKhau = findViewById(R.id.Login_edt_matKhau);
        Login_edt_taiKhoan = findViewById(R.id.Login_edt_taiKhoan);
        Login_btnDangNhap = findViewById(R.id.Login_btnDangNhap);
        Login_btnDangky = findViewById(R.id.Login_btnDangKy);

        Login_btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Login_btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,register.class);
                startActivity(intent);
            }
        });

    }




}