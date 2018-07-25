// Make sure to add your package here and to add the activity also in AndroidManifest.xml
package x.y.z;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @author Cantoni Giorgio - giorgio.canto98@gmail.com on 25/07/18.
 */

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webview = new WebView(this);
        webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        // Allow JS
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        setContentView(webview);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // Check if the URL starts with http or https
                if( url.startsWith("http:") || url.startsWith("https:") ) {
                    return false;
                }

                // If the URL doesn't start with http or https allow OS to open tel, mailto & more
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity( intent );
                return true;
            }
        });
        // Enter here the URL of the web page you want to view
        webview.loadUrl(".............");
    }
}
