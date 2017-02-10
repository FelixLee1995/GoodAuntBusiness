package space.ahaha.goodauntbusiness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;

import space.ahaha.goodauntbusiness.HomeFragment.HomeFragment;
import space.ahaha.goodauntbusiness.MessageFragment.MessageFragment;
import space.ahaha.goodauntbusiness.OrderFragment.OrderFragment;
import space.ahaha.goodauntbusiness.UserFragment.UserFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{

    private ArrayList<Fragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
                /*提示信息数量
        BadgeItem numberBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColor(Color.RED)
                .setText("5")
                .setHideOnSelect(true);
                */
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_action_home, "Home").setActiveColorResource(R.color.yellow))
                .addItem(new BottomNavigationItem(R.drawable.ic_action_database, "Order").setActiveColorResource(R.color.yellow))
                .addItem(new BottomNavigationItem(R.drawable.ic_action_monolog, "Message").setActiveColorResource(R.color.yellow))//.setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_action_user, "User").setActiveColorResource(R.color.yellow))
                .setFirstSelectedPosition(0)
                .setBarBackgroundColor(R.color.red)
                .initialise();
        bottomNavigationBar.setAutoHideEnabled(false);

        fragments.add(HomeFragment.newInstance("Home"));
        fragments.add(OrderFragment.newInstance("Order"));
        fragments.add(MessageFragment.newInstance("Message"));
        fragments.add(UserFragment.newInstance("User"));

        setDefaultFragment(0);
        bottomNavigationBar.setTabSelectedListener(this);
    }

    void setDefaultFragment(int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = fragments.get(position);
        if (fragment.isAdded()) {
            ft.replace(R.id.layFrame, fragment);
        } else {
            ft.add(R.id.layFrame, fragment);
        }
        ft.commit();
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.layFrame, fragment);
                } else {
                    ft.add(R.id.layFrame, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }

    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {
        //do nothing
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }
        */
        return super.onOptionsItemSelected(item);
    }
}
