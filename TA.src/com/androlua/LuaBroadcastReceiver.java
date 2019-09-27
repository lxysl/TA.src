package com.androlua;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LuaBroadcastReceiver extends BroadcastReceiver
{
  private OnReceiveListener a;

  public LuaBroadcastReceiver(OnReceiveListener paramOnReceiveListener)
  {
    this.a = paramOnReceiveListener;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.a.onReceive(paramContext, paramIntent);
  }

  public static abstract interface OnReceiveListener
  {
    public abstract void onReceive(Context paramContext, Intent paramIntent);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaBroadcastReceiver
 * JD-Core Version:    0.6.2
 */