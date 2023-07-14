package sangttph30270.poly.duan1_nhom6.Admin_Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sangttph30270.poly.duan1_nhom6.R;


public class DanhSach_Fragment extends Fragment {



    public DanhSach_Fragment() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_danh_sach_, container, false);
    }
}