package cn.fortrun.proguarddemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);

        Utils.init(this);
//        if (NetworkUtils.getWifiEnabled()) {
        String result = DeviceUtils.getMacAddress();
        LogUtils.e("mac地址:" + result);
        result = EncryptUtils.encryptMD5ToString(result);//.toLowerCase();
        LogUtils.e("加密后的DeviceId:" + result);
        tv.setText(result);

        EventBusActivityScope.getDefault(this).register(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void fromResultFragment(MainActivity mainActivity) {
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBusActivityScope.getDefault(this).unregister(this);
    }
}
