package com.haocang.patrol.patroloutside.nfcutil;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

/**
 * 子类在onNewIntent方法中进行NFC标签相关操作。
 * launchMode设置为singleTop或singelTask，保证Activity的重用唯一
 * 在onNewIntent方法中执行intent传递过来的Tag数据
 * 将NFC标签卡靠近手机后部
 * <p>
 * reated by Rick.Lau on 2018/09/04 11:29.
 */
public class BaseNfcActivity extends AppCompatActivity {
    protected NfcAdapter mNfcAdapter;
    private PendingIntent mPendingIntent;

    @Override
    protected void onStart() {
        super.onStart();
        //此处adapter需要重新获取，否则无法获取message
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        //一旦截获NFC消息，就会通过PendingIntent调用窗口
        mPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()), 0);
    }

    /**
     * 获得焦点，按钮可以点击
     */
    @Override
    public void onResume() {
        super.onResume();
        //设置处理优于所有其他NFC的处理
        if (mNfcAdapter != null) {
            mNfcAdapter.enableForegroundDispatch(this, mPendingIntent, null, null);
        }
    }

    /**
     * 暂停Activity，界面获取焦点，按钮可以点击
     */
    @Override
    public void onPause() {
        super.onPause();
        //恢复默认状态
        if (mNfcAdapter != null)
            mNfcAdapter.disableForegroundDispatch(this);
    }

    public void back(View view) {
        finish();
    }
}

