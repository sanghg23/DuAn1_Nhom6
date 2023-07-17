package sangttph30270.poly.duan1_nhom6.Adapter.Adapter_Admin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sangttph30270.poly.duan1_nhom6.DAO.Dao_Coffe;
import sangttph30270.poly.duan1_nhom6.R;
import sangttph30270.poly.duan1_nhom6.model.model_Coffe;

public class Adapter_Coffe extends RecyclerView.Adapter<Adapter_Coffe.ViewHolder> {
    private ArrayList<model_Coffe> list;
    private Context context;

    public Adapter_Coffe(ArrayList<model_Coffe> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setData(ArrayList<model_Coffe> lst) {
        this.list = lst;
        notifyDataSetChanged();
    }

//    private void openGallery(Activity activity) {
//        ImagePicker.Companion.with(activity)
//                .galleryOnly()
//                .start(REQUEST_SELECT_IMAGE);
//    }

    // Định nghĩa requestCode
//    private static final int REQUEST_SELECT_IMAGE = 200;
//
//    // Xử lý kết quả khi người dùng chọn ảnh
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_SELECT_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
//            // Lấy đường dẫn của ảnh đã chọn từ Intent
//            String imagePath = ImagePicker.Companion.getFilePath(data);
//            if (imagePath != null) {
//                // Lưu đường dẫn ảnh đã chọn vào biến selectedImagePath
//                 =imagePath;
//                // Cập nhật dữ liệu hoặc hiển thị ảnh đã chọn trong ViewHolder tương ứng
//                // Ví dụ:
//                // mDataSet.get(getAdapterPosition()).setImagePath(selectedImagePath);
//                // notifyItemChanged(getAdapterPosition());
//            } else {
//                Toast.makeText(context, "Failed to get image", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_coffee_admin_danhsach, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tenCoffe.setText(list.get(position).getTenCoffe());
        holder.moTa.setText(list.get(position).getMoTa());
        holder.Gia.setText(list.get(position).getGia());
        holder.anhCoffe.setText(list.get(position).getAnh());
        holder.xoaCoffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDele(position);
            }
        });


    }

    public void showDele(int id) {
        AlertDialog.Builder dialogDL = new AlertDialog.Builder(context);
        dialogDL.setMessage("Bạn có muốn xóa không?");
        dialogDL.setNegativeButton("KHÔNG", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDL.setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Dao_Coffe dao = new Dao_Coffe(context);
                if (dao.delete(id) > 0) {
                    Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    list = dao.getAllData();
                    setData(list);
                } else {
                    Toast.makeText(context, "Xóa Thất Bại", Toast.LENGTH_SHORT).show();

                }
                dialog.dismiss();

            }
        });
        dialogDL.show();
    }

    public void showUpdate(model_Coffe cf, int id){
        Dialog dialog = new Dialog(context);
        Dao_Coffe dao_coffe = new Dao_Coffe(context);
        dialog.setContentView(R.layout.dialog_add_themcoffe_admin);
        EditText tenCF,motaCF,giaCF;
        Button btnDialogAddCancel, btnDialogAddSubmit;

        tenCF = dialog.findViewById(R.id.dialog_add_tenCoffe);
        motaCF = dialog.findViewById(R.id.dialog_add_moTaCoffe);
        giaCF = dialog.findViewById(R.id.dialog_add_GiaCoffe);

        tenCF.setText(list.get(id).getTenCoffe());
        motaCF.setText(list.get(id).getMoTa());
        giaCF.setText(list.get(id).getGia());


        btnDialogAddCancel = dialog.findViewById(R.id.btn_dialog_admin_add);
        btnDialogAddSubmit = dialog.findViewById(R.id.btn_dialog_admin_cancle);

        btnDialogAddCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnDialogAddSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dao_Coffe daoCoffe = new Dao_Coffe(context);
                String ten = tenCF.getText().toString();
                String mota = motaCF.getText().toString();
                String gia = giaCF.getText().toString();

                if (ten.trim().equals("")) {
                    Toast.makeText(context, "ko dc de trong", Toast.LENGTH_SHORT).show();
                }
                else {
                    cf.setTenCoffe(tenCF.getText().toString());
                    cf.setMoTa(motaCF.getText().toString());
                    cf.setGia(giaCF.getText().toString());
                }
                if (daoCoffe.update(cf) > 0) {
                    Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_LONG).show();
                    list = dao_coffe.getAllData();
                    setData(list);
                    dialog.dismiss();
                } else {
                    Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_LONG).show();
                }
            }
        });
        dialog.show();
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tenCoffe, anhCoffe, moTa, Gia;
        Button suaCoffe, xoaCoffe;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tenCoffe = itemView.findViewById(R.id.tv_itemAdmin_coffe_coffeName);
            anhCoffe = itemView.findViewById(R.id.tv_itemAdmin_coffe_coffeImg);
            moTa = itemView.findViewById(R.id.tv_itemAdmin_coffe_coffeMota);
            Gia = itemView.findViewById(R.id.tv_itemAdmin_coffe_coffeGia);
            suaCoffe = itemView.findViewById(R.id.btn_itemAdmin_coffe_coffe_Update);
            xoaCoffe = itemView.findViewById(R.id.btn_itemAdmin_coffe_coffe_Delete);
        }
    }
}
