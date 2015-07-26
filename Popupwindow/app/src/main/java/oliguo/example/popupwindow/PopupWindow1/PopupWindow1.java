package oliguo.example.popupwindow.PopupWindow1;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import oliguo.example.popupwindow.R;


public class PopupWindow1 extends AppCompatActivity {
    private Button mButton,mButton1,mButton2,mButton3,mButton4;
    private PopupWindow mPopupWindow,mPopupWindow1,mPopupWindow2,mPopupWindow3,mPopupWindow4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window1);

        View popupView = getLayoutInflater().inflate(R.layout.popupwindow1_showasdropdown, null);

        mPopupWindow = new PopupWindow(popupView, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));

        mButton = (Button) findViewById(R.id.btn_test_popupwindow);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPopupWindow.showAsDropDown(v);
            }
        });

        View popupView1 = getLayoutInflater().inflate(R.layout.popupwindow1_bottom, null);

        mPopupWindow1 = new PopupWindow(popupView1, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow1.setTouchable(true);
        mPopupWindow1.setOutsideTouchable(true);
        mPopupWindow1.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        mPopupWindow1.setAnimationStyle(R.style.PopupAnimation);

        mPopupWindow1.getContentView().setFocusableInTouchMode(true);
        mPopupWindow1.getContentView().setFocusable(true);
        mPopupWindow1.getContentView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_MENU && event.getRepeatCount() == 0
                        && event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (mPopupWindow1 != null && mPopupWindow1.isShowing()) {
                        mPopupWindow1.dismiss();
                    }
                    return true;
                }
                return false;
            }
        });
        mButton1 = (Button) findViewById(R.id.btn_test_popupwindow1);
        mButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPopupWindow1.showAtLocation(findViewById(R.id.btn_test_popupwindow1), Gravity.BOTTOM, 0, 0);
            }
        });


        View popupView2=getLayoutInflater().inflate(R.layout.popupwindow1_left,null);

        mPopupWindow2=new PopupWindow(popupView2,ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT,true);
        mPopupWindow2.setTouchable(true);
        mPopupWindow2.setOutsideTouchable(true);
        mPopupWindow2.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        mPopupWindow2.setAnimationStyle(R.style.PopupAnimationLeft);
        mButton2=(Button)findViewById(R.id.btn_test_popupwindow2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow2.showAtLocation(findViewById(R.id.btn_test_popupwindow2),Gravity.LEFT,0,0);

            }
        });


        View popupView3=getLayoutInflater().inflate(R.layout.popupwindow1_right,null);

        mPopupWindow3=new PopupWindow(popupView3,ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT,true);
        mPopupWindow3.setTouchable(true);
        mPopupWindow3.setOutsideTouchable(true);
        mPopupWindow3.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        mPopupWindow3.setAnimationStyle(R.style.PopupAnimationRight);
        mButton3=(Button)findViewById(R.id.btn_test_popupwindow3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow3.showAtLocation(findViewById(R.id.btn_test_popupwindow3),Gravity.RIGHT,0,0);

            }
        });


        View popupView4=getLayoutInflater().inflate(R.layout.popupwindow1_top,null);

        mPopupWindow4=new PopupWindow(popupView4,ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT,true);
        mPopupWindow4.setTouchable(true);
        mPopupWindow4.setOutsideTouchable(true);
        mPopupWindow4.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        mPopupWindow4.setAnimationStyle(R.style.PopupAnimationTop);
        mButton4=(Button)findViewById(R.id.btn_test_popupwindow4);
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow4.showAtLocation(findViewById(R.id.btn_test_popupwindow4),Gravity.TOP,0,0);

            }
        });


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && event.getRepeatCount() == 0) {
            if (mPopupWindow1 != null && !mPopupWindow1.isShowing()) {
                mPopupWindow1.showAtLocation(findViewById(R.id.btn_test_popupwindow1), Gravity.BOTTOM, 0, 0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_popup_window1, menu);
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
