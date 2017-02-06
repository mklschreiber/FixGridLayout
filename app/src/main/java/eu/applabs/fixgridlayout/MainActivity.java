package eu.applabs.fixgridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvValues);
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        initView();
        return true;
    }

    private void initView() {
        int spanCount = getRandomNumber(1, 20);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount);
        ValueAdapter valueAdapter = new ValueAdapter(getValueList(getRandomNumber(spanCount, spanCount * 2)), gridLayoutManager);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(valueAdapter);
    }

    private List<String> getValueList(int count) {
        List<String> returnValue = new ArrayList<>();

        for(int i = 0; i < count; ++i) {
            returnValue.add("String " + String.valueOf(i));
        }

        return returnValue;
    }

    private int getRandomNumber(int min, int max) {
        return (int) (min + Math.random() * max);
    }
}
