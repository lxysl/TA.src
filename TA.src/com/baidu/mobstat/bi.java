package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

class bi extends WebViewClient
{
  private WeakReference<Context> a;
  private WebViewClient b;

  public bi(Context paramContext, WebViewClient paramWebViewClient)
  {
    this.a = new WeakReference(paramContext);
    this.b = paramWebViewClient;
  }

  private void a(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject(paramString);
    String str = localJSONObject1.getString("action");
    JSONObject localJSONObject2 = localJSONObject1.getJSONObject("obj");
    Context localContext = (Context)this.a.get();
    if (localContext == null)
      return;
    if ("onPageStart".equals(str))
    {
      StatService.onPageStart(localContext, localJSONObject2.getString("page"));
      return;
    }
    if ("onPageEnd".equals(str))
    {
      StatService.onPageEnd(localContext, localJSONObject2.getString("page"));
      return;
    }
    if ("onEvent".equals(str))
    {
      StatService.onEvent(localContext, localJSONObject2.getString("event_id"), localJSONObject2.getString("label"), localJSONObject2.getInt("acc"));
      return;
    }
    if ("onEventStart".equals(str))
    {
      StatService.onEventStart(localContext, localJSONObject2.getString("event_id"), localJSONObject2.getString("label"));
      return;
    }
    if ("onEventEnd".equals(str))
    {
      StatService.onEventEnd(localContext, localJSONObject2.getString("event_id"), localJSONObject2.getString("label"));
      return;
    }
    if ("onEventDuration".equals(str))
      StatService.onEventDuration(localContext, localJSONObject2.getString("event_id"), localJSONObject2.getString("label"), localJSONObject2.getLong("duration"));
  }

  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    if (this.b != null)
      this.b.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
  }

  public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    if (this.b != null)
      this.b.onFormResubmission(paramWebView, paramMessage1, paramMessage2);
  }

  public void onLoadResource(WebView paramWebView, String paramString)
  {
    if (this.b != null)
      this.b.onLoadResource(paramWebView, paramString);
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.b != null)
      this.b.onPageFinished(paramWebView, paramString);
  }

  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (this.b != null)
      this.b.onPageStarted(paramWebView, paramString, paramBitmap);
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (this.b != null)
      this.b.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }

  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    if (this.b != null)
      this.b.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
  }

  public void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if (this.b != null)
      this.b.onReceivedLoginRequest(paramWebView, paramString1, paramString2, paramString3);
  }

  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (this.b != null)
      this.b.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }

  public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    if (this.b != null)
      this.b.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
  }

  @Deprecated
  public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    if (this.b != null)
      this.b.onTooManyRedirects(paramWebView, paramMessage1, paramMessage2);
  }

  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    if (this.b != null)
      this.b.onUnhandledKeyEvent(paramWebView, paramKeyEvent);
  }

  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (this.b != null)
      return this.b.shouldInterceptRequest(paramWebView, paramString);
    return null;
  }

  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    if (this.b != null)
      return this.b.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
    return false;
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Log.d("BaiduStatJSInterface", "shouldOverrideUrlLoading");
    String str;
    Object localObject;
    try
    {
      str = URLDecoder.decode(paramString, "UTF-8");
      try
      {
        if ((TextUtils.isEmpty(str)) || (!str.startsWith("bmtj:")))
          break label65;
        a(str.substring(5));
        return true;
      }
      catch (UnsupportedEncodingException|JSONException localUnsupportedEncodingException2)
      {
      }
    }
    catch (UnsupportedEncodingException|JSONException localUnsupportedEncodingException1)
    {
      str = paramString;
      localObject = localUnsupportedEncodingException1;
    }
    cz.b(localObject);
    label65: if (this.b != null)
      return this.b.shouldOverrideUrlLoading(paramWebView, str);
    return false;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.baidu.mobstat.bi
 * JD-Core Version:    0.6.2
 */