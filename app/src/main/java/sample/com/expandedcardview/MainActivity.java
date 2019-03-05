package sample.com.expandedcardview;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import widget.com.expandablelayout.ExpandableLayout;
import widget.com.expandedcardview.R;

public class MainActivity extends AppCompatActivity {
    ExpandableLayout expandableLayout;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableLayout = findViewById(R.id.expandable);
        container = findViewById(R.id.container);
        setListener();
        addExpandable();
        addCustomExpandable();
    }

    private void addExpandable() {
        ExpandableLayout expandableLayout = new ExpandableLayout(this);
        expandableLayout.setDefaultHeaderTitle("Added By Java");
        expandableLayout.setDefaultContentTitle("Content xxx xxxxxxxxx xxxxxxxx xxxxxx xxx");
        expandableLayout.setDefaultContentTextColor(Color.RED);
        expandableLayout.setArrowDrawable(ContextCompat.getDrawable(this, R.drawable.arrow_down));

        container.addView(expandableLayout);
    }

    private void addCustomExpandable() {
        ExpandableLayout expandableLayout = new ExpandableLayout(this);
        expandableLayout.setHeaderLayout(R.layout.layout_expandable_header);
        expandableLayout.setContentLayout(R.layout.layout_expandable_content);

        container.addView(expandableLayout);
    }

    private void setListener() {
        expandableLayout.setOnExpandedListener((v,
                                                isExpanded) -> Toast.makeText(MainActivity.this, "isExpanded== " + isExpanded, Toast.LENGTH_SHORT).show());
    }
}
