package com.haocang.waterlink.home.ui.web;

import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.haocang.base.config.LibConfig;
import com.haocang.base.utils.ProgressBarDialog;
import com.haocang.waterlink.R;

@Route(path = LibConfig.AROUTE_MODEL_MSG)
public class WebModelFragment extends Fragment {

    private WebView webView;
    private TextView titletv;
    private ProgressBarDialog dialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.fragment_web_model, null);
        initView(view);

        return view;
    }

    private void initView(View view) {
        dialog = new ProgressBarDialog(getActivity());
        dialog.show();
        titletv = view.findViewById(R.id.home_title_tv);
        titletv.setText("专题图查询");
        view.findViewById(R.id.sccan_iv).setVisibility(View.GONE);
        view.findViewById(R.id.back_v).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        webView = view.findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webSettings.setAppCacheEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if (dialog != null && dialog.isShowing()) {
                    dialog.cancel();
                }
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                // 不要使用super，否则有些手机访问不了，因为包含了一条 handler.cancel()
                // super.onReceivedSslError(view, handler, error);
                //handler.cancel(); 默认的处理方式，WebView变成空白页
                // 接受所有网站的证书，忽略SSL错误，执行访问网页
                if (handler != null) {
                    handler.proceed();//忽略证书的错误继续加载页面内容，不会变成空白页面
                }
            }
        });
        webView.loadUrl("http://www.qdhsdd.com:18106/#/mapapp");
    }
}
