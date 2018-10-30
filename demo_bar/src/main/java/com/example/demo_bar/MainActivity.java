package com.example.demo_bar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;

//这里我直接在BaseActivity中调用 supportRequestWindowFeature(Window.FEATURE_NO_TITLE)去掉了默认的导航栏
// （注意，我的BaseActivity是继承了AppCompatActivity的,
// 如果是继承Activity就应该调用requestWindowFeature(Window.FEATURE_NO_TITLE)）；
public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, BottomNavigationBar.OnTabSelectedListener {


    private CheckBox mode_fixed;
    private CheckBox mode_shifting;
    private CheckBox bs_static;
    private CheckBox bs_ripple;
    private CheckBox show_text;
    private CheckBox items_3;
    private CheckBox items_4;
    private CheckBox items_5;
    private CheckBox auto_hide_badge;
    private Button toggle_hide;
    private Button toggle_badge;
    private BottomNavigationBar bottom_bar;
    //是否显示tab的文字
    private Boolean isShowTabText = true;
    private BadgeItem badgeItem;
    private ShapeBadgeItem shapeBadgeItem;
    private ShapeBadgeItem shapeBadgeItem1;
    private  int lastSelectedPosition=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //自动对齐 ctrl+alt+l
        mode_fixed = (CheckBox) findViewById(R.id.mode_fixed);
        mode_shifting = (CheckBox) findViewById(R.id.mode_shifting);
        bs_static = (CheckBox) findViewById(R.id.bs_static);
        bs_ripple = (CheckBox) findViewById(R.id.bs_ripple);
        show_text = (CheckBox) findViewById(R.id.show_text);
        items_3 = (CheckBox) findViewById(R.id.items_3);
        items_4 = (CheckBox) findViewById(R.id.items_4);
        items_5 = (CheckBox) findViewById(R.id.items_5);
        auto_hide_badge = (CheckBox) findViewById(R.id.auto_hide_badge);
        toggle_hide = (Button) findViewById(R.id.toggle_hide);
        toggle_badge = (Button) findViewById(R.id.toggle_badge);
        bottom_bar = (BottomNavigationBar) findViewById(R.id.bottom_bar);
        mode_fixed.setOnCheckedChangeListener(this);
        mode_shifting.setOnCheckedChangeListener(this);
        bs_static.setOnCheckedChangeListener(this);
        bs_ripple.setOnCheckedChangeListener(this);
        show_text.setOnCheckedChangeListener(this);
        items_3.setOnCheckedChangeListener(this);
        items_4.setOnCheckedChangeListener(this);
        items_5.setOnCheckedChangeListener(this);
        auto_hide_badge.setOnCheckedChangeListener(this);
        toggle_hide.setOnClickListener(this);
        toggle_badge.setOnClickListener(this);
        bottom_bar.setTabSelectedListener(this);
        refresh();
    }

    private void refresh() {
        bottom_bar.clearAll();
        //1.设置角标
        badgeItem = new BadgeItem().setBackgroundColor(R.color.reds).setBorderWidth(4).setText("2").setHideOnSelect(true).setHideOnSelect(auto_hide_badge.isChecked());
        shapeBadgeItem = new ShapeBadgeItem().
                setBackgroundColorResource(R.color.bule)
                .setDimen(8)
                .setShape(ShapeBadgeItem.CIRCLE)
                .setMargins(0, 2, 4, 0)  // left, top, right, bottom
                .setHideOnSelect(auto_hide_badge.isChecked());
        shapeBadgeItem1 = new ShapeBadgeItem()
                //.setBorderWidth(8)
                .setBackgroundColorResource(R.color.black)
                .setDimen(8) // the size to badge in dp
                .setShape(ShapeBadgeItem.SQUARE) // Choose between ShapeBadgeItem.CIRCLE or ShapeBadgeItem.SQUARE
                .setMargins(0, 2, 4, 0) // left, top, right, bottom
                .setHideOnSelect(auto_hide_badge.isChecked());
        //给BottomNavigationBar设置模式
        if (mode_fixed.isChecked()){
            bottom_bar.setMode(BottomNavigationBar.MODE_FIXED);
        } else if (mode_shifting.isChecked()){
            bottom_bar.setMode(BottomNavigationBar.MODE_SHIFTING);
        }
        if (bs_static.isChecked()){
            bottom_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        }else if (bs_ripple.isChecked()){
            bottom_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        }

        if (items_3.isChecked()){
            if (isShowTabText){
                bottom_bar.addItem(new BottomNavigationItem(R.drawable.ic_location_on_white_24dp,"location").setActiveColorResource(R.color.blue).setTextBadgeItem(badgeItem))
                        .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp,"book").setActiveColorResource(R.color.grey))
                        .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp,"dashboard").setActiveColorResource(R.color.brown)).setFirstSelectedPosition(lastSelectedPosition).initialise();
            }else{
                bottom_bar.addItem(new BottomNavigationItem(R.drawable.ic_location_on_white_24dp).setActiveColorResource(R.color.blue).setTextBadgeItem(badgeItem))
                        .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp).setActiveColorResource(R.color.grey))
                        .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp).setActiveColorResource(R.color.brown)).setFirstSelectedPosition(lastSelectedPosition).initialise();
            }
        }else if (items_4.isChecked()){
            if (isShowTabText){
                bottom_bar.addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp,"favorite").setActiveColorResource(R.color.colorPrimary).setTextBadgeItem(badgeItem))
                        .addItem(new BottomNavigationItem(R.drawable.ic_find_replace_white_24dp,"find").setActiveColorResource(R.color.colorPrimaryDark))
                        .addItem(new BottomNavigationItem(R.drawable.ic_location_on_white_24dp,"home").setActiveColorResource(R.color.colorAccent))
                        .addItem(new BottomNavigationItem(R.drawable.ic_launch_white_24dp,"launch").setActiveColorResource(R.color.brown)).setFirstSelectedPosition(lastSelectedPosition).initialise();
            }else {
                bottom_bar.addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp).setActiveColorResource(R.color.colorPrimary).setTextBadgeItem(badgeItem))
                        .addItem(new BottomNavigationItem(R.drawable.ic_find_replace_white_24dp).setActiveColorResource(R.color.colorPrimaryDark))
                        .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp).setActiveColorResource(R.color.colorAccent))
                        .addItem(new BottomNavigationItem(R.drawable.ic_launch_white_24dp).setActiveColorResource(R.color.brown)).setFirstSelectedPosition(lastSelectedPosition).initialise();
            }
        }else if (items_5.isChecked()){
           if (isShowTabText){
               bottom_bar.addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp,"favorite").setActiveColorResource(R.color.colorPrimaryDark).setTextBadgeItem(badgeItem))
                       .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp,"music").setActiveColorResource(R.color.blue))
                       .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp,"home").setActiveColorResource(R.color.teal))
                       .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp,"tv").setActiveColorResource(R.color.brown))
                       .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp,"videgame").setActiveColorResource(R.color.reds)).setFirstSelectedPosition(lastSelectedPosition).initialise();
           }else{
               bottom_bar.addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp).setActiveColorResource(R.color.colorPrimaryDark).setTextBadgeItem(badgeItem))
                       .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp).setActiveColorResource(R.color.blue))
                       .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp).setActiveColorResource(R.color.teal))
                       .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp).setActiveColorResource(R.color.brown))
                       .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp).setActiveColorResource(R.color.reds)).setFirstSelectedPosition(lastSelectedPosition).initialise();
           }

        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.mode_fixed:
                mode_shifting.setChecked(!isChecked);
                break;
            case R.id.mode_shifting:
                mode_fixed.setChecked(!isChecked);
                break;
            case R.id.bs_static:
                bs_ripple.setChecked(!isChecked);
                break;
            case R.id.bs_ripple:
                bs_static.setChecked(!isChecked);
                break;
            case R.id.show_text:
                isShowTabText = isChecked;
                break;
            case R.id.items_3:
                if (isChecked)
                    items_4.setChecked(false);
                    items_5.setChecked(false);
                break;
            case R.id.items_4:
                if (isChecked)
                    items_3.setChecked(false);
                    items_5.setChecked(false);
                break;
            case R.id.items_5:
                items_3.setChecked(false);
                items_4.setChecked(false);
                break;
        }
        if (!items_5.isChecked() && !items_3.isChecked() && !items_4.isChecked()) {
            buttonView.setChecked(true);
        }
        refresh();
    }

    @Override
    public void onClick(View v) {
      if (v.getId()==R.id.toggle_hide){
          if (bottom_bar !=null){
              //隐藏
              bottom_bar.toggle();
          }else  if (v.getId() ==R.id.toggle_badge){
             if (badgeItem !=null){
                 badgeItem.toggle();
             }
          }
      }
    }

    @Override
    public void onTabSelected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
