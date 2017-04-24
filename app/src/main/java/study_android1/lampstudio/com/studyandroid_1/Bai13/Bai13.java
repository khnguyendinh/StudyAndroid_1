package study_android1.lampstudio.com.studyandroid_1.Bai13;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import study_android1.lampstudio.com.studyandroid_1.R;

public class Bai13 extends Activity {
    public static final int ID_ABOUT =1;
    public static final int ID_SETTING =2;
    public static final int ID_SEARCH =3;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai13);
        textView = (TextView) findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopUpMenu(view);
            }
        });
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.option_menu,menu);
        menu.add(Menu.NONE,ID_ABOUT,Menu.NONE,"About");
        menu.add(Menu.NONE,ID_SEARCH,Menu.NONE,"Search");
        menu.add(Menu.NONE,ID_SETTING,Menu.NONE,"Setting");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.copy:
                Toast.makeText(Bai13.this,"sao chep",Toast.LENGTH_LONG).show();
                break;
            case R.id.delete:
                Toast.makeText(Bai13.this,"Xoa",Toast.LENGTH_LONG).show();
                break;
            case R.id.forward:
                Toast.makeText(Bai13.this,"chuyen tiep",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case ID_ABOUT:
//            case R.id.item_about:
                Toast.makeText(Bai13.this,"About",Toast.LENGTH_LONG).show();
                break;
            case R.id.item_search:
                Toast.makeText(Bai13.this,"Search",Toast.LENGTH_LONG).show();
                break;
            case R.id.item_setting:
                Toast.makeText(Bai13.this,"Setting",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }
    private void showPopUpMenu(View view){
        PopupMenu popupMenu = new PopupMenu(Bai13.this,view);
        Menu menu = popupMenu.getMenu();
        getMenuInflater().inflate(R.menu.option_menu,menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_about:
                        Toast.makeText(Bai13.this,"about",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.item_search:
                        Toast.makeText(Bai13.this,"search",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.item_setting:
                        Toast.makeText(Bai13.this,"setting",Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}
