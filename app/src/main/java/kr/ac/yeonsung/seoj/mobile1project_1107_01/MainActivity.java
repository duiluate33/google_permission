package kr.ac.yeonsung.seoj.mobile1project_1107_01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] btnIds = {R.id.btn_call, R.id.btn_home, R.id.btn_gmap, R.id.btn_search, R.id.btn_sms, R.id.btn_camera};
        Button[] btns = new Button[btnIds.length]; //참조변수가 6개가 만들어짐
        for(int i=0; i<btns.length; i++){
            btns[i] = findViewById(btnIds[i]);
            btns[i].setOnClickListener(btn_listener);
        }
    }
    //리스너는 꼭 필드로 선언해야함
    View.OnClickListener btn_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //암시적(묵시적)인텐트 생성
            Intent intent = null;

            switch (view.getId()) {
                case R.id.btn_call:
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/010-1111-1111"));
                    //액션과 uri 필요함
                    break;
                case R.id.btn_home:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
                    break;
                case R.id.btn_gmap:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=37.3968813,126.9093163 &z=15"));
                    break;
                case R.id.btn_search:
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "연성대학교 컴퓨터소프트웨어과");
                    break;
                case R.id.btn_sms:
                    intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body", "반갑습니다.^^");
                    intent.setData(Uri.parse("smsto:" + Uri.encode("010-1111-1111")));
                    break;
                case R.id.btn_camera:
                    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    break;
            }
            startActivity(intent);
        }
    };
}