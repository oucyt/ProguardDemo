package cn.fortrun.proguarddemo;

import android.app.Application;

import me.yokeyword.fragmentation.Fragmentation;

/**
 * description
 *
 * @author tianyu
 * @create 2018.12.06 10:36
 * @since 1.0.0
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFragmentation();
    }

    private void initFragmentation() {
        Fragmentation.builder()
                // show stack view. Mode: BUBBLE, SHAKE, NONE
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                .install();
    }
}
