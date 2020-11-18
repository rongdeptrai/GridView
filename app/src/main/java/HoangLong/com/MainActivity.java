package HoangLong.com;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int idd=-1;
    ArrayList<LS> lsArrayList;
    GridView gridView;
    final Context context = this;
    Adapter adapter;
    List<LS> arrayList= new ArrayList<LS>();
    TextView tt,ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tt=findViewById(R.id.tx);
        ds=findViewById(R.id.ds);
        lsArrayList= new ArrayList<LS>();
        lsArrayList.add(new LS("VinMart","Chuỗi siêu thị uy tín, sản phẩm đa dạng, vận chuyển siêu tốc",R.drawable.vinmart));
        lsArrayList.add(new LS("MeiJi","Nhãn hiệu sữa bán chạy số một Nhật Bản",R.drawable.meiji));
        lsArrayList.add(new LS("Bác Tôm","Thực phẩm sạch, đặt sản vùng miền",R.drawable.bactom));
        lsArrayList.add(new LS("F6 Fruit","Nhà bán lẽ trái cây nhập khẩu uy tín",R.drawable.f6));
        lsArrayList.add(new LS("Nông Sản Dũng Hà","Bring Natural to your Home",R.drawable.dungha));
        lsArrayList.add(new LS("Thực phẩm Quốc Huy","Gạo ngon cho mọi gia đình",R.drawable.f6));
        lsArrayList.add(new LS("Hoàng Đông Food","Nhà phân phối bán lẻ thực phẩm sạch",R.drawable.hoangdong));
        adapter =new Adapter(this,R.layout.row,lsArrayList);
        gridView=findViewById(R.id.gridview);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                    Bundle bundle= new Bundle();
                    String a= tt.getText().toString();
                    String b=ds.getText().toString();
                    bundle.putString("username",a);
                    bundle.putString("pass",b);
                    intent.putExtra("Du Lieu",bundle);
                    startActivity(intent);;
                }
            }
        });
        registerForContextMenu(gridView);
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                idd=position;
                return false;
            }

        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select The Action");
    }
    @Override
    public boolean onContextItemSelected(final MenuItem item){
        if(item.getItemId()==R.id.them) {
            // get prompts.xml view
            LayoutInflater li = LayoutInflater.from(context);
            View promptsView = li.inflate(R.layout.activity_edit, null);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(promptsView);

            final EditText tit = (EditText) promptsView
                    .findViewById(R.id.tt);
            final EditText des = (EditText) promptsView
                    .findViewById(R.id.ds);
            // set dialog message
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // get user input and set it to result
                                    // edit text
                                    LS ls= new LS(tit.getText().toString(),des.getText().toString(),R.drawable.vinmart);
                                    lsArrayList.add(ls);
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(MainActivity.this,"Add Item success",Toast.LENGTH_LONG).show();
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();

        }
        else if(item.getItemId()==R.id.sua){
// get prompts.xml view
            LayoutInflater li = LayoutInflater.from(context);
            View promptsView = li.inflate(R.layout.activity_edit, null);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(promptsView);

            final EditText tit = (EditText) promptsView
                    .findViewById(R.id.tt);
            final EditText des = (EditText) promptsView
                    .findViewById(R.id.ds);
            // set dialog message
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // get user input and set it to result
                                    // edit text
                                    LS sua= new LS(tit.getText().toString(),des.getText().toString(),R.drawable.avata);
                                    lsArrayList.set(idd,sua);
                                    idd=0;
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(MainActivity.this,"Changed success",Toast.LENGTH_LONG).show();
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();

        }
        else if(item.getItemId()==R.id.xoa){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);
            // set dialog message
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("Delete",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // get user input and set it to result
                                    // edit text
                                    lsArrayList.remove(idd);
                                    idd=-1;
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(MainActivity.this,"Delete success",Toast.LENGTH_LONG).show();
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }
        else{
            return false;
        }
        return true;
    }



}