package com.b.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.TextView;
import com.b.a.b.g;
import com.b.a.b.h;
import com.b.a.b.j;
import java.util.ArrayList;

public class a
{
  private static h c = j.g();
  private c a;
  private Context b;
  private ListPopupWindow d;
  private a e;
  private Filter f;
  private int g;
  private int h;
  private int i;
  private CharSequence j;
  private int k;
  private GradientDrawable l;
  private int m;

  public a(c paramc)
  {
    this.a = paramc;
    this.b = paramc.getContext();
    d();
  }

  private void d()
  {
    this.d = new ListPopupWindow(this.b);
    this.d.setAnchorView(this.a);
    this.e = new a(this.b, 17367043);
    this.d.setAdapter(this.e);
    this.f = this.e.getFilter();
    d(300);
    TypedArray localTypedArray = this.b.getTheme().obtainStyledAttributes(new int[] { 16842801, 16842806 });
    int n = localTypedArray.getColor(0, 16711935);
    int i1 = localTypedArray.getColor(1, 16711935);
    localTypedArray.recycle();
    this.l = new GradientDrawable();
    this.l.setColor(n);
    this.l.setCornerRadius(4.0F);
    this.l.setStroke(1, i1);
    a(i1);
    this.d.setBackgroundDrawable(this.l);
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        a.a(a.this).replaceText(a.a(a.this).getCaretPosition() - a.b(a.this).length(), a.b(a.this).length(), ((TextView)paramAnonymousView).getText().toString());
        a.c(a.this).a();
        a.this.b();
      }
    });
  }

  private void d(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      this.d.setHeight(paramInt);
    }
  }

  private void e(int paramInt)
  {
    int n = Math.min(paramInt, this.a.getWidth() / 2);
    if (this.i != n)
    {
      this.i = n;
      this.d.setHorizontalOffset(n);
    }
  }

  private void f(int paramInt)
  {
    int n = 0 - this.d.getHeight();
    if (paramInt > n)
    {
      this.a.scrollBy(0, paramInt - n);
      paramInt = n;
    }
    if (this.g != paramInt)
    {
      this.g = paramInt;
      this.d.setVerticalOffset(paramInt);
    }
  }

  public void a()
  {
    if (!this.d.isShowing())
      this.d.show();
    this.d.getListView().setFadingEdgeLength(0);
  }

  public void a(int paramInt)
  {
    this.m = paramInt;
    this.l.setStroke(1, paramInt);
    this.d.setBackgroundDrawable(this.l);
  }

  public void a(h paramh)
  {
    try
    {
      c = paramh;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(CharSequence paramCharSequence)
  {
    this.e.b();
    this.f.filter(paramCharSequence);
  }

  public void b()
  {
    if (this.d.isShowing())
      this.d.dismiss();
  }

  public void b(int paramInt)
  {
    this.k = paramInt;
    this.l.setColor(paramInt);
    this.d.setBackgroundDrawable(this.l);
  }

  public void c(int paramInt)
  {
    this.d.setWidth(paramInt);
  }

  class a extends ArrayAdapter<String>
    implements Filterable
  {
    private int b;
    private g c = new g();
    private DisplayMetrics d;

    public a(Context paramInt, int arg3)
    {
      super(i);
      setNotifyOnChange(false);
      this.d = paramInt.getResources().getDisplayMetrics();
    }

    public void a()
    {
      this.c.a();
    }

    public void b()
    {
      this.c.b();
    }

    public int c()
    {
      if (this.b != 0)
        return this.b;
      TextView localTextView = (TextView)((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(17367043, null);
      localTextView.measure(0, 0);
      this.b = localTextView.getMeasuredHeight();
      return this.b;
    }

    public Filter getFilter()
    {
      return new Filter()
      {
        protected Filter.FilterResults performFiltering(CharSequence paramAnonymousCharSequence)
        {
          ArrayList localArrayList = new ArrayList();
          String str1 = String.valueOf(paramAnonymousCharSequence).toLowerCase();
          String[] arrayOfString1 = str1.split("\\.");
          int i = arrayOfString1.length;
          int j = 0;
          String str2;
          if (i == 2)
          {
            String str7 = arrayOfString1[0];
            str2 = arrayOfString1[1];
            if (a.c().f(str7))
            {
              String[] arrayOfString6 = a.c().a(str7);
              int i4 = arrayOfString6.length;
              while (j < i4)
              {
                String str8 = arrayOfString6[j];
                if (str8.toLowerCase().startsWith(str2))
                  localArrayList.add(str8);
                j++;
              }
            }
          }
          else if (arrayOfString1.length == 1)
          {
            if (str1.charAt(str1.length() - 1) == '.')
            {
              String str6 = str1.substring(0, str1.length() - 1);
              str2 = "";
              if (a.c().f(str6))
              {
                String[] arrayOfString5 = a.c().a(str6);
                int i3 = arrayOfString5.length;
                while (j < i3)
                {
                  localArrayList.add(arrayOfString5[j]);
                  j++;
                }
              }
            }
            else
            {
              for (String str5 : a.c().b())
                if (str5.toLowerCase().startsWith(str1))
                  localArrayList.add(str5);
              for (String str4 : a.c().d())
                if (str4.indexOf(str1) == 0)
                  localArrayList.add(str4);
              String[] arrayOfString4 = a.c().c();
              int i2 = arrayOfString4.length;
              while (j < i2)
              {
                String str3 = arrayOfString4[j];
                if (str3.toLowerCase().startsWith(str1))
                  localArrayList.add(str3);
                j++;
              }
            }
          }
          else
          {
            str2 = str1;
          }
          a.a(a.this, str2);
          Filter.FilterResults localFilterResults = new Filter.FilterResults();
          localFilterResults.values = localArrayList;
          localFilterResults.count = localArrayList.size();
          return localFilterResults;
        }

        protected void publishResults(CharSequence paramAnonymousCharSequence, Filter.FilterResults paramAnonymousFilterResults)
        {
          if ((paramAnonymousFilterResults != null) && (paramAnonymousFilterResults.count > 0) && (!a.a.a(a.a.this).c()))
          {
            a.a.this.clear();
            a.a.this.addAll((ArrayList)paramAnonymousFilterResults.values);
            int i = a.a(a.this).getCaretY() + a.a(a.this).a() / 2 - a.a(a.this).getScrollY();
            a.a(a.this, a.a.this.c() * Math.min(2, paramAnonymousFilterResults.count));
            a.b(a.this, a.a(a.this).getCaretX() - a.a(a.this).getScrollX());
            a.c(a.this, i - a.a(a.this).getHeight());
            a.a.this.notifyDataSetChanged();
            a.this.a();
            return;
          }
          a.a.this.notifyDataSetInvalidated();
        }
      };
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      TextView localTextView = (TextView)super.getView(paramInt, paramView, paramViewGroup);
      localTextView.setTextColor(a.d(a.this));
      return localTextView;
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.a.a
 * JD-Core Version:    0.6.2
 */