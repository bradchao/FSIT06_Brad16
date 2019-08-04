package tw.org.iii.appps.brad16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter adapter;
    private String[] from = {"title", "type"};
    private int[] to = {R.id.item_title, R.id.item_type};
    private LinkedList<HashMap<String,String>> data = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        initListView();

        fetchRemoteData();
    }

    private void initListView(){
        adapter = new SimpleAdapter(this,data,R.layout.item,from,to);
        listView.setAdapter(adapter);
    }

    private void fetchRemoteData(){
        new Thread(){
            @Override
            public void run() {
                try{
                    URL url = new URL("http://data.coa.gov.tw/Service/OpenData/RuralTravelData.aspx");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();

                    BufferedReader reader =
                            new BufferedReader(
                                    new InputStreamReader(conn.getInputStream()));
                    String line = null; StringBuffer sb = new StringBuffer();
                    while ( (line = reader.readLine()) != null){
                        sb.append(line);
                    }
                    reader.close();
                    Log.v("brad", sb.toString());
                }catch (Exception e){
                    Log.v("brad", e.toString());
                }
            }
        }.start();
    }







}
