package tw.org.iii.brad.brad18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private F1 f1;
    private F2 f2;
    private F3 f3;
    private FragmentManager fmgr;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fmgr = getSupportFragmentManager();     //從Activity身上取出 不用new
        title = findViewById(R.id.main_title);

        f1 = new F1();
        f2 = new F2();
        f3 = new F3();

        FragmentTransaction transaction = fmgr.beginTransaction();
        transaction.add(R.id.container, f1);
        transaction.commit();
    }

    public void gotoPage1(View view){
        FragmentTransaction transaction = fmgr.beginTransaction();
        transaction.replace(R.id.container,f1);
        transaction.commit();
    }
    public void gotoPage2(View view){
        FragmentTransaction transaction = fmgr.beginTransaction();
        transaction.replace(R.id.container,f2);
        transaction.commit();
    }
    public void gotoPage3(View view){
        FragmentTransaction transaction = fmgr.beginTransaction();
        transaction.replace(R.id.container,f3);
        transaction.commit();
    }

    public void test1(View view){
        f1.showLottery();
    }

    public void changeTitle(String newTitle){
        title.setText(newTitle);
    }
}
