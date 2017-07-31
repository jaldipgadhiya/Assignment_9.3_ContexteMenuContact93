package contextemenucontact93.android.acadgild.com.contextemenucontact93;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import adapter.CustomAdapter;
import bean.CustomHandler;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<CustomHandler> model= new ArrayList<>();
    HashMap<String,String> hmap = new HashMap<String,String>();

    private static final int MENU_ID_01 = 100;
    private static final int MENU_ID_02 = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_details_list_view);
        list= (ListView)findViewById(R.id.phoneList);

        hmap.put("9434343434","ABC");
        hmap.put("8434344366","DEF");
        hmap.put("7845668977","GHI");
        hmap.put("9898456776","JKL");
        hmap.put("8855674356","MNO");
        hmap.put("8007343245","PQR");
        hmap.put("9898532678","STU");
        hmap.put("9543434546","VWX");
        hmap.put("9766947651","YZA");
        hmap.put("9428421976","BCD");
        hmap.put("9725936431","EFG");
        hmap.put("9428230421","HIJ");
        System.out.println("1");

        for(Map.Entry m:hmap.entrySet()){
            CustomHandler handler= new CustomHandler();
            handler.setName(m.getValue().toString());
            handler.setPhoneNo(m.getKey().toString());
            model.add(handler);
        }

        CustomAdapter adapter= new CustomAdapter(this, model);
        list.setAdapter(adapter);
        registerForContextMenu(list);
    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu 9.3");
        menu.add(0, MENU_ID_01, 2, "Send SMS");
        menu.add(0, MENU_ID_02, 1, "Call");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;


        if(item.getItemId()==MENU_ID_01 && item.getGroupId()==0){
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:" + Uri.encode(model.get(index).getPhoneNo())));
            startActivity(intent);
        }
        else if(item.getItemId()==MENU_ID_02 && item.getGroupId()==0){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+model.get(index).getPhoneNo()));
            startActivity(intent);
        }
        else{
            return false;
        }
        return true;
    }
}
