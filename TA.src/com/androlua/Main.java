package com.androlua;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.mobstat.StatService;

public class Main extends LuaActivity
{
  private void a(String paramString1, String paramString2)
  {
    runFunc("onVersionChanged", new Object[] { paramString1, paramString2 });
  }

  public String getLuaDir()
  {
    return getLocalDir();
  }

  public String getLuaPath()
  {
    initMain();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getLocalDir());
    localStringBuilder.append("/main.lua");
    return localStringBuilder.toString();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle == null) && (getIntent().getData() != null))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = getIntent();
      runFunc("onNewIntent", arrayOfObject);
    }
    if ((getIntent().getBooleanExtra("isVersionChanged", false)) && (paramBundle == null))
      a(getIntent().getStringExtra("newVersionName"), getIntent().getStringExtra("oldVersionName"));
    StatService.start(this);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    runFunc("onNewIntent", new Object[] { paramIntent });
    super.onNewIntent(paramIntent);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.Main
 * JD-Core Version:    0.6.2
 */