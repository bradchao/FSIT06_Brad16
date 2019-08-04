package tw.org.iii.appps.brad16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {
    private String pic, content;
    private ImageView img;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        pic = getIntent().getStringExtra("pic");
        content = getIntent().getStringExtra("content");

        img = findViewById(R.id.img);
        tvContent = findViewById(R.id.content);
        tvContent.setText(content);

    }
}
