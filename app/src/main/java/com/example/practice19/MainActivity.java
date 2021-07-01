package com.example.practice19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pop-up");

        txtMenu = (TextView)findViewById(R.id.main_textView);
        // 팝업 메뉴의 정의
        PopupMenu practicePopup = new PopupMenu(MainActivity.this, txtMenu);

        /*
        // 실제 메뉴설계
        Menu practiceMenu = practicePopup.getMenu();
        practiceMenu.add(1, 0, 0, "실습1");
        practiceMenu.add(1, 1, 0, "실습2");
        SubMenu sub = practiceMenu.addSubMenu(1, 10, 0 , "SubMenu");
        sub.add(1, 2, 0, "실습3");
        */

        // XML로 설계한 메뉴를 사용
        Menu cityMenu = practicePopup.getMenu();


        // Resources menu폴더에 있는 menu_item01.xml 리소스를 사용
        // 메뉴 리소스를 메뉴로 객체화 (inflate) -> MenuInflater
        MenuInflater inflater = getMenuInflater();
        // 사용할 메뉴 객체를 지정
        inflater.inflate(R.menu.menu_item01, cityMenu);


        txtMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                practicePopup.show();
            }
        });

        practicePopup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                return false;
            }
        });
    }
}