package com.androlua;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.webkit.ClientCertRequest;
import android.webkit.DownloadListener;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.a.a.a.a.a.a.a;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LuaWebView extends WebView
  implements LuaGcable
{
  private DownloadBroadcastReceiver a;
  private HashMap<Long, String[]> b = new HashMap();
  private OnDownloadCompleteListener c;
  private LuaActivity d;
  private ProgressBar e;
  private DisplayMetrics f;
  private Dialog g;
  private ListView h;
  private ValueCallback<Uri> i;
  private String j = "/";
  private LuaFunction<Boolean> k;
  private boolean l;
  private OnReceivedTitleListener m;
  private OnReceivedIconListener n;

  @SuppressLint({"AddJavascriptInterface", "SetJavaScriptEnabled"})
  public LuaWebView(LuaActivity paramLuaActivity)
  {
    super(paramLuaActivity);
    paramLuaActivity.regGc(this);
    this.d = paramLuaActivity;
    getSettings().setJavaScriptEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().setDisplayZoomControls(true);
    getSettings().setSupportZoom(true);
    getSettings().setDomStorageEnabled(true);
    if (Build.VERSION.SDK_INT >= 21)
      getSettings().setMixedContentMode(0);
    addJavascriptInterface(new LuaJavaScriptInterface(paramLuaActivity), "androlua");
    setWebViewClient(new WebViewClient()
    {
      public void onReceivedSslError(WebView paramAnonymousWebView, final SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(LuaWebView.b(LuaWebView.this));
        localBuilder.setTitle("SslError");
        localBuilder.setMessage(paramAnonymousSslError.toString());
        localBuilder.setPositiveButton(17039370, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymousSslErrorHandler.proceed();
          }
        });
        localBuilder.setNegativeButton(17039360, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymousSslErrorHandler.cancel();
          }
        });
        localBuilder.setCancelable(false);
        localBuilder.create();
        localBuilder.show();
      }

      public WebResourceResponse shouldInterceptRequest(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (LuaWebView.a(LuaWebView.this) != null)
          try
          {
            Boolean localBoolean = (Boolean)LuaWebView.a(LuaWebView.this).call(new Object[] { paramAnonymousString });
            if ((localBoolean != null) && (localBoolean.booleanValue()))
            {
              WebResourceResponse localWebResourceResponse = new WebResourceResponse(null, null, null);
              return localWebResourceResponse;
            }
          }
          catch (LuaException localLuaException)
          {
            a.a(localLuaException);
          }
        return null;
      }

      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (LuaWebView.a(LuaWebView.this) != null)
          try
          {
            Boolean localBoolean = (Boolean)LuaWebView.a(LuaWebView.this).call(new Object[] { paramAnonymousString });
            if (localBoolean != null)
            {
              boolean bool = localBoolean.booleanValue();
              if (bool)
                return true;
            }
          }
          catch (LuaException localLuaException)
          {
            a.a(localLuaException);
          }
        if ((!paramAnonymousString.startsWith("http")) && (!paramAnonymousString.startsWith("file")))
          try
          {
            LuaWebView.b(LuaWebView.this).startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString)), 0);
            return true;
          }
          catch (Exception localException)
          {
            LuaWebView.b(LuaWebView.this).sendError("LuaWebView", localException);
            return true;
          }
        paramAnonymousWebView.loadUrl(paramAnonymousString);
        return true;
      }
    });
    this.f = paramLuaActivity.getResources().getDisplayMetrics();
    int i1 = (int)TypedValue.applyDimension(1, 2.0F, this.f);
    this.e = new ProgressBar(paramLuaActivity, null, 16842872);
    this.e.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, i1, 0, 0));
    addView(this.e);
    setWebChromeClient(new LuaWebChromeClient());
    setDownloadListener(new Download(null));
  }

  @SuppressLint({"AddJavascriptInterface"})
  public void addJSInterface(JsInterface paramJsInterface, String paramString)
  {
    super.addJavascriptInterface(new JsObject(paramJsInterface), paramString);
  }

  @SuppressLint({"AddJavascriptInterface"})
  public void addJsInterface(JsInterface paramJsInterface, String paramString)
  {
    super.addJavascriptInterface(new JsObject(paramJsInterface), paramString);
  }

  public void destroy()
  {
    if (this.a != null)
      this.d.unregisterReceiver(this.a);
    super.destroy();
  }

  public void gc()
  {
    destroy();
    this.l = true;
  }

  public boolean isGc()
  {
    return this.l;
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (canGoBack()))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.x = paramInt1;
    localLayoutParams.y = paramInt2;
    this.e.setLayoutParams(localLayoutParams);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void openFile(String paramString)
  {
    if (this.g == null)
    {
      this.g = new Dialog(getContext());
      this.h = new ListView(getContext());
      this.h.setFastScrollEnabled(true);
      this.h.setFastScrollAlwaysVisible(true);
      this.g.setContentView(this.h);
      this.h.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          String str1 = ((TextView)paramAnonymousView).getText().toString();
          if (str1.equals("../"))
          {
            LuaWebView localLuaWebView = LuaWebView.this;
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(new File(LuaWebView.c(LuaWebView.this)).getParent());
            localStringBuilder2.append("/");
            LuaWebView.a(localLuaWebView, localStringBuilder2.toString());
            LuaWebView.this.openFile(LuaWebView.c(LuaWebView.this));
            return;
          }
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(LuaWebView.c(LuaWebView.this));
          localStringBuilder1.append(str1);
          String str2 = localStringBuilder1.toString();
          if (new File(str2).isDirectory())
          {
            LuaWebView.a(LuaWebView.this, str2);
            LuaWebView.this.openFile(LuaWebView.c(LuaWebView.this));
            return;
          }
          LuaWebView.d(LuaWebView.this).onReceiveValue(Uri.parse(str2));
        }
      });
    }
    File localFile = new File(paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("../");
    String[] arrayOfString = localFile.list();
    if (arrayOfString != null)
    {
      Arrays.sort(arrayOfString);
      int i1 = arrayOfString.length;
      int i2 = 0;
      for (int i3 = 0; i3 < i1; i3++)
      {
        String str2 = arrayOfString[i3];
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(this.j);
        localStringBuilder2.append(str2);
        if (new File(localStringBuilder2.toString()).isDirectory())
        {
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append(str2);
          localStringBuilder3.append("/");
          localArrayList.add(localStringBuilder3.toString());
        }
      }
      int i4 = arrayOfString.length;
      while (i2 < i4)
      {
        String str1 = arrayOfString[i2];
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.j);
        localStringBuilder1.append(str1);
        if (new File(localStringBuilder1.toString()).isFile())
          localArrayList.add(str1);
        i2++;
      }
    }
    ArrayAdapter localArrayAdapter = new ArrayAdapter(getContext(), 17367043, localArrayList);
    this.h.setAdapter(localArrayAdapter);
    this.g.setTitle(this.j);
    this.g.show();
  }

  public void setAdsFilter(LuaFunction<Boolean> paramLuaFunction)
  {
    this.k = paramLuaFunction;
  }

  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    super.setDownloadListener(paramDownloadListener);
  }

  public void setOnDownloadCompleteListener(OnDownloadCompleteListener paramOnDownloadCompleteListener)
  {
    this.c = paramOnDownloadCompleteListener;
  }

  public void setOnDownloadStartListener(final OnDownloadStartListener paramOnDownloadStartListener)
  {
    setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        paramOnDownloadStartListener.onDownloadStart(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, paramAnonymousLong);
      }
    });
  }

  public void setOnKeyListener(View.OnKeyListener paramOnKeyListener)
  {
    super.setOnKeyListener(paramOnKeyListener);
  }

  public void setOnReceivedIconListener(OnReceivedIconListener paramOnReceivedIconListener)
  {
    this.n = paramOnReceivedIconListener;
  }

  public void setOnReceivedTitleListener(OnReceivedTitleListener paramOnReceivedTitleListener)
  {
    this.m = paramOnReceivedTitleListener;
  }

  public void setProgressBar(ProgressBar paramProgressBar)
  {
    this.e = paramProgressBar;
  }

  public void setProgressBarEnabled(boolean paramBoolean)
  {
    ProgressBar localProgressBar;
    if (paramBoolean)
      localProgressBar = this.e;
    for (int i1 = 0; ; i1 = 8)
    {
      localProgressBar.setVisibility(i1);
      return;
      localProgressBar = this.e;
    }
  }

  public void setWebViewClient(LuaWebViewClient paramLuaWebViewClient)
  {
    super.setWebViewClient(new SimpleLuaWebViewClient(paramLuaWebViewClient));
  }

  private class Download
    implements DownloadListener
  {
    EditText a;
    private String c;
    private String d;
    private String e;
    private String f;
    private long g;
    private String h;

    private Download()
    {
    }

    private long a(boolean paramBoolean)
    {
      if (LuaWebView.g(LuaWebView.this) == null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        LuaWebView.a(LuaWebView.this, new LuaWebView.DownloadBroadcastReceiver(LuaWebView.this, null));
        LuaWebView.b(LuaWebView.this).registerReceiver(LuaWebView.g(LuaWebView.this), localIntentFilter);
      }
      DownloadManager localDownloadManager = (DownloadManager)LuaWebView.b(LuaWebView.this).getSystemService("download");
      Uri localUri = Uri.parse(this.c);
      localUri.getLastPathSegment();
      DownloadManager.Request localRequest = new DownloadManager.Request(localUri);
      String str = LuaWebView.b(LuaWebView.this).getLuaExtDir("Download");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(new File(LuaWebView.b(LuaWebView.this).getLuaExtDir()).getName());
      localStringBuilder.append("/");
      localStringBuilder.append("Download");
      localRequest.setDestinationInExternalPublicDir(localStringBuilder.toString(), this.h);
      localRequest.setTitle(this.h);
      localRequest.setDescription(this.c);
      if (paramBoolean)
        localRequest.setAllowedNetworkTypes(2);
      File localFile = new File(str, this.h);
      if (localFile.exists())
        localFile.delete();
      localRequest.setMimeType(this.f);
      long l = localDownloadManager.enqueue(localRequest);
      HashMap localHashMap = LuaWebView.e(LuaWebView.this);
      Long localLong = Long.valueOf(l);
      String[] arrayOfString = new String[2];
      arrayOfString[0] = new File(str, this.h).getAbsolutePath();
      arrayOfString[1] = this.f;
      localHashMap.put(localLong, arrayOfString);
      return l;
    }

    @SuppressLint({"DefaultLocale"})
    public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    {
      this.c = paramString1;
      this.d = paramString2;
      this.e = paramString3;
      this.f = paramString4;
      this.g = paramLong;
      this.h = Uri.parse(this.c).getLastPathSegment();
      if (paramString3 != null)
      {
        int i = paramString3.indexOf("filename=\"");
        if (i != -1)
        {
          int j = i + "filename=\"".length();
          int k = paramString3.indexOf('"', j);
          if (k > j)
            this.h = paramString3.substring(j, k);
        }
      }
      this.a = new EditText(LuaWebView.b(LuaWebView.this));
      this.a.setText(this.h);
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(String.valueOf(paramLong));
      localStringBuilder1.append("B");
      String str1 = localStringBuilder1.toString();
      String str2;
      Object[] arrayOfObject;
      if (paramLong > 1048576L)
      {
        str2 = "%.2f MB";
        arrayOfObject = new Object[1];
        arrayOfObject[0] = Double.valueOf(Long.valueOf(paramLong).doubleValue() / 1048576.0D);
      }
      while (true)
      {
        str1 = String.format(str2, arrayOfObject);
        break;
        if (paramLong <= 1024L)
          break;
        str2 = "%.2f KB";
        arrayOfObject = new Object[1];
        arrayOfObject[0] = Double.valueOf(Long.valueOf(paramLong).doubleValue() / 1024.0D);
      }
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(LuaWebView.b(LuaWebView.this)).setTitle("Download");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Type: ");
      localStringBuilder2.append(paramString4);
      localStringBuilder2.append("\nSize: ");
      localStringBuilder2.append(str1);
      localBuilder.setMessage(localStringBuilder2.toString()).setView(this.a).setPositiveButton("Download", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          LuaWebView.Download.a(LuaWebView.Download.this, LuaWebView.Download.this.a.getText().toString());
          LuaWebView.Download.a(LuaWebView.Download.this, false);
        }
      }).setNegativeButton(17039360, null).setNeutralButton("Only Wifi", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          LuaWebView.Download.a(LuaWebView.Download.this, LuaWebView.Download.this.a.getText().toString());
          LuaWebView.Download.a(LuaWebView.Download.this, true);
        }
      }).create().show();
    }
  }

  private class DownloadBroadcastReceiver extends BroadcastReceiver
  {
    private DownloadBroadcastReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      long l = paramIntent.getLongExtra("extra_download_id", 0L);
      paramIntent.getExtras();
      if ((LuaWebView.e(LuaWebView.this).containsKey(Long.valueOf(l))) && (LuaWebView.f(LuaWebView.this) != null))
      {
        String[] arrayOfString = (String[])LuaWebView.e(LuaWebView.this).get(Long.valueOf(l));
        LuaWebView.f(LuaWebView.this).onDownloadComplete(arrayOfString[0], arrayOfString[1]);
      }
    }
  }

  public static abstract interface JsInterface
  {
    @JavascriptInterface
    public abstract String execute(String paramString);
  }

  class JsObject
  {
    private LuaWebView.JsInterface b;

    public JsObject(LuaWebView.JsInterface arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    @JavascriptInterface
    public String execute(String paramString)
    {
      return this.b.execute(paramString);
    }
  }

  private class LuaJavaScriptInterface
  {
    private LuaActivity b;

    public LuaJavaScriptInterface(LuaActivity arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    @JavascriptInterface
    public Object callLuaFunction(String paramString)
    {
      return this.b.runFunc(paramString, new Object[0]);
    }

    @JavascriptInterface
    public Object callLuaFunction(String paramString1, String paramString2)
    {
      return this.b.runFunc(paramString1, new Object[] { paramString2 });
    }

    @JavascriptInterface
    public Object doLuaString(String paramString)
    {
      return this.b.doString(paramString, new Object[0]);
    }
  }

  class LuaWebChromeClient extends WebChromeClient
  {
    EditText a = new EditText(LuaWebView.b(LuaWebView.this));

    LuaWebChromeClient()
    {
    }

    public Bitmap getDefaultVideoPoster()
    {
      return BitmapFactory.decodeResource(LuaWebView.b(LuaWebView.this).getResources(), 2130771968);
    }

    public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, final JsResult paramJsResult)
    {
      new AlertDialog.Builder(LuaWebView.b(LuaWebView.this)).setTitle(paramString1).setMessage(paramString2).setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramJsResult.confirm();
        }
      }).setCancelable(false).create().show();
      return true;
    }

    public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, final JsResult paramJsResult)
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(LuaWebView.b(LuaWebView.this));
      localBuilder.setTitle(paramString1);
      localBuilder.setMessage(paramString2);
      localBuilder.setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramJsResult.confirm();
        }
      });
      localBuilder.setNegativeButton(17039360, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramJsResult.cancel();
        }
      });
      localBuilder.setCancelable(false);
      localBuilder.create();
      localBuilder.show();
      return true;
    }

    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, final JsPromptResult paramJsPromptResult)
    {
      this.a.setText(paramString3);
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(LuaWebView.b(LuaWebView.this));
      localBuilder.setTitle(paramString1);
      localBuilder.setMessage(paramString2);
      localBuilder.setView(this.a);
      localBuilder.setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          String str = LuaWebView.LuaWebChromeClient.this.a.getText().toString();
          paramJsPromptResult.confirm(str);
        }
      });
      localBuilder.setNegativeButton(17039360, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramJsPromptResult.cancel();
        }
      });
      localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          paramJsPromptResult.cancel();
        }
      });
      localBuilder.show();
      return true;
    }

    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100)
      {
        LuaWebView.h(LuaWebView.this).setVisibility(8);
      }
      else
      {
        LuaWebView.h(LuaWebView.this).setVisibility(0);
        LuaWebView.h(LuaWebView.this).setProgress(paramInt);
      }
      super.onProgressChanged(paramWebView, paramInt);
    }

    public void onReceivedIcon(WebView paramWebView, Bitmap paramBitmap)
    {
      super.onReceivedIcon(paramWebView, paramBitmap);
      if (LuaWebView.j(LuaWebView.this) != null)
        LuaWebView.j(LuaWebView.this).onReceivedIcon(paramBitmap);
    }

    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      super.onReceivedTitle(paramWebView, paramString);
      if (LuaWebView.i(LuaWebView.this) != null)
        LuaWebView.i(LuaWebView.this).onReceivedTitle(paramString);
    }

    public void openFileChooser(ValueCallback<Uri> paramValueCallback)
    {
      openFileChooser(paramValueCallback, "");
    }

    public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
    {
      if (LuaWebView.d(LuaWebView.this) != null)
        return;
      LuaWebView.a(LuaWebView.this, paramValueCallback);
      LuaWebView.this.openFile(LuaWebView.c(LuaWebView.this));
    }

    public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      openFileChooser(paramValueCallback, paramString1);
    }
  }

  public static abstract interface LuaWebViewClient
  {
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;

    public abstract void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean);

    public abstract void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2);

    public abstract void onLoadResource(WebView paramWebView, String paramString);

    public abstract void onPageFinished(WebView paramWebView, String paramString);

    public abstract void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);

    public abstract void onProceededAfterSslError(WebView paramWebView, SslError paramSslError);

    public abstract void onReceivedClientCertRequest(WebView paramWebView, ClientCertRequest paramClientCertRequest, String paramString);

    public abstract void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2);

    public abstract void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2);

    public abstract void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3);

    public abstract void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError);

    public abstract void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2);

    @Deprecated
    public abstract void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2);

    public abstract void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent);

    public abstract WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString);

    public abstract boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent);

    public abstract boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
  }

  public static abstract interface OnDownloadCompleteListener
  {
    public abstract void onDownloadComplete(String paramString1, String paramString2);
  }

  public static abstract interface OnDownloadStartListener
  {
    public abstract void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong);
  }

  public static abstract interface OnReceivedIconListener
  {
    public abstract void onReceivedIcon(Bitmap paramBitmap);
  }

  public static abstract interface OnReceivedTitleListener
  {
    public abstract void onReceivedTitle(String paramString);
  }

  private class SimpleLuaWebViewClient extends WebViewClient
  {
    private LuaWebView.LuaWebViewClient b;

    public SimpleLuaWebViewClient(LuaWebView.LuaWebViewClient arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
    {
      this.b.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
    }

    public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
    {
      paramMessage1.sendToTarget();
    }

    public void onLoadResource(WebView paramWebView, String paramString)
    {
      this.b.onLoadResource(paramWebView, paramString);
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      this.b.onPageFinished(paramWebView, paramString);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      this.b.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public void onProceededAfterSslError(WebView paramWebView, SslError paramSslError)
    {
      this.b.onProceededAfterSslError(paramWebView, paramSslError);
    }

    public void onReceivedClientCertRequest(WebView paramWebView, ClientCertRequest paramClientCertRequest, String paramString)
    {
      this.b.onReceivedClientCertRequest(paramWebView, paramClientCertRequest, paramString);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      this.b.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }

    public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
    {
      this.b.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
    }

    public void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3)
    {
      this.b.onReceivedLoginRequest(paramWebView, paramString1, paramString2, paramString3);
    }

    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      this.b.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    }

    public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
    {
      this.b.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
    }

    @Deprecated
    public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
    {
      paramMessage1.sendToTarget();
    }

    public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
    {
      this.b.onUnhandledKeyEvent(paramWebView, paramKeyEvent);
    }

    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
    {
      if (LuaWebView.a(LuaWebView.this) != null)
        try
        {
          if (((Boolean)LuaWebView.a(LuaWebView.this).call(new Object[] { paramString })).booleanValue())
          {
            WebResourceResponse localWebResourceResponse = new WebResourceResponse(null, null, null);
            return localWebResourceResponse;
          }
        }
        catch (LuaException localLuaException)
        {
          a.a(localLuaException);
        }
      return this.b.shouldInterceptRequest(paramWebView, paramString);
    }

    public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
    {
      return this.b.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      return this.b.shouldOverrideUrlLoading(paramWebView, paramString);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaWebView
 * JD-Core Version:    0.6.2
 */