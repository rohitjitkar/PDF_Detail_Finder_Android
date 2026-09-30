package com.example.pdfdetailfinder;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class MainActivity extends Activity {
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        web = new WebView(this);
        web.setWebViewClient(new WebViewClient());

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setAllowContentAccess(true);

        web.addJavascriptInterface(new PdfBridge(), "AndroidPDF");
        web.loadUrl("file:///android_asset/index.html");

        setContentView(web);
    }

    private class PdfBridge {
        @JavascriptInterface
        public void openPdf(int page) {
            try {
                File pdf = new File(getCacheDir(), "electoral_roll.pdf");

                if (!pdf.exists()) {
                    try (InputStream in = getAssets().open("TAC3_DIST490_PART5_EN.pdf");
                         FileOutputStream out = new FileOutputStream(pdf)) {
                        byte[] buffer = new byte[8192];
                        int n;
                        while ((n = in.read(buffer)) != -1) {
                            out.write(buffer, 0, n);
                        }
                    }
                }

                Uri uri = FileProvider.getUriForFile(
                        MainActivity.this,
                        getPackageName() + ".fileprovider",
                        pdf
                );

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(uri, "application/pdf");
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(
                            MainActivity.this,
                            "No PDF viewer is installed on this device.",
                            Toast.LENGTH_LONG
                    ).show();
                }
            } catch (Exception e) {
                Toast.makeText(
                        MainActivity.this,
                        "Unable to open the source PDF.",
                        Toast.LENGTH_LONG
                ).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()) web.goBack();
        else super.onBackPressed();
    }
}
