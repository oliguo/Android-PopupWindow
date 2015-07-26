package oliguo.example.popupwindow.Tooltips;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import oliguo.example.popupwindow.R;

public class Tooltips extends AppCompatActivity {

    TooltipWindow tipWindow;
    Button bottom_tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tooltips);
        tipWindow = new TooltipWindow(Tooltips.this);
        bottom_tip=(Button)findViewById(R.id.bottomTip);
        bottom_tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tipWindow.isTooltipShown()) {
                    tipWindow.showToolTip(view);
                }else{
                    tipWindow.dismissTooltip();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        if(tipWindow != null && tipWindow.isTooltipShown()){
        tipWindow.dismissTooltip();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tooltips, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
