package sangttph30270.poly.duan1_nhom6.Admin_Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import sangttph30270.poly.duan1_nhom6.DAO.Dao_Coffe;
import sangttph30270.poly.duan1_nhom6.R;
import sangttph30270.poly.duan1_nhom6.model.model_Coffe;


public class DanhSach_Fragment extends Fragment {
    private ArrayList<model_Coffe> list;
    public DanhSach_Fragment() {

    }


    public static DanhSach_Fragment newInstance(String param1, String param2) {
        DanhSach_Fragment fragment = new DanhSach_Fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      return inflater.inflate(R.layout.fragment_danh_sach_, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    RecyclerView recy_coffeAdmin = view.findViewById(R.id.Rc_Admin_DanhSach);
    Button btn_add = view.findViewById(R.id.btn_Admin_AddCoffe);
        Dao_Coffe dao_coffe = new Dao_Coffe(getContext());




        super.onViewCreated(view, savedInstanceState);
    }
}