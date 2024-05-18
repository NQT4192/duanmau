package fpoly.thangnqph44861.duanmau;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import fpoly.thangnqph44861.duanmau.Fragments.DoiMatKhauFragment;
import fpoly.thangnqph44861.duanmau.Fragments.QuanLyLoaiSachFragment;
import fpoly.thangnqph44861.duanmau.Fragments.QuanLySachFragment;
import fpoly.thangnqph44861.duanmau.Fragments.QuanLyThanhVienFragment;
import fpoly.thangnqph44861.duanmau.Fragments.ThemThanhVienFragment;

public class MainActivity extends AppCompatActivity {
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView naviView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        naviView = findViewById(R.id.naviView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close
        );
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);


        naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if (item.getItemId() == R.id.imnu_QLls) {
                    setFragment(new QuanLyLoaiSachFragment(), "Quản Lý loai sach");
                }
                if (item.getItemId() == R.id.imnu_QLs) {
                    setFragment(new QuanLySachFragment(), "Quản Lý Sách");
                }
                if (item.getItemId() == R.id.imnu_QLtv) {
                    setFragment(new QuanLyThanhVienFragment(), "Quản lý Thành Viên");
                }

                if (item.getItemId() == R.id.inmu_add_user){
                    setFragment(new ThemThanhVienFragment() , "Thêm thành viên");
                }
                if (item.getItemId() == R.id.inmu_change_pass){
                    setFragment(new DoiMatKhauFragment(),"Đổi mật khẩu");
                }
                if (item.getItemId()==R.id.imnu_logout){
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }
                drawerLayout.close();
                return true;
            }
        });
    }

    //hàm set fragment (dùng nhiều lần)
    public void setFragment(Fragment fragment, String toolbarTitle) {
        getSupportActionBar().setTitle(toolbarTitle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}