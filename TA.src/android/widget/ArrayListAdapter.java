package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.a.a.a.a.a.a.a;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListAdapter<T> extends BaseAdapter
  implements Filterable
{
  private ArrayList<T> a;
  private final Object b = new Object();
  private int c;
  private int d;
  private int e = 0;
  private boolean f = true;
  private Context g;
  private ArrayList<T> h;
  private ArrayListAdapter<T>.ArrayFilter i;
  private LayoutInflater j;
  private LuaFunction k;

  public ArrayListAdapter(Context paramContext)
  {
    a(paramContext, 17367043, 0, new ArrayList());
  }

  public ArrayListAdapter(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, 0, new ArrayList());
  }

  public ArrayListAdapter(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, new ArrayList());
  }

  public ArrayListAdapter(Context paramContext, int paramInt1, int paramInt2, List<T> paramList)
  {
    a(paramContext, paramInt1, paramInt2, paramList);
  }

  public ArrayListAdapter(Context paramContext, int paramInt1, int paramInt2, T[] paramArrayOfT)
  {
    a(paramContext, paramInt1, paramInt2, Arrays.asList(paramArrayOfT));
  }

  public ArrayListAdapter(Context paramContext, int paramInt, List<T> paramList)
  {
    a(paramContext, paramInt, 0, paramList);
  }

  public ArrayListAdapter(Context paramContext, int paramInt, T[] paramArrayOfT)
  {
    a(paramContext, paramInt, 0, Arrays.asList(paramArrayOfT));
  }

  public ArrayListAdapter(Context paramContext, List<T> paramList)
  {
    a(paramContext, 17367043, 0, paramList);
  }

  public ArrayListAdapter(Context paramContext, T[] paramArrayOfT)
  {
    a(paramContext, 17367043, 0, Arrays.asList(paramArrayOfT));
  }

  private View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    if (paramView == null)
      paramView = this.j.inflate(paramInt2, paramViewGroup, false);
    try
    {
      TextView localTextView;
      if (this.e == 0)
        localTextView = (TextView)paramView;
      else
        localTextView = (TextView)paramView.findViewById(this.e);
      Object localObject1 = getItem(paramInt1);
      if ((localObject1 instanceof CharSequence));
      for (Object localObject2 = (CharSequence)localObject1; ; localObject2 = localObject1.toString())
      {
        localTextView.setText((CharSequence)localObject2);
        return paramView;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
      throw new IllegalStateException("ArrayAdapter requires the resource ID to be a TextView", localClassCastException);
    }
  }

  private void a(Context paramContext, int paramInt1, int paramInt2, List<T> paramList)
  {
    this.g = paramContext;
    this.j = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.d = paramInt1;
    this.c = paramInt1;
    this.a = new ArrayList(paramList);
    this.e = paramInt2;
  }

  public static ArrayListAdapter<CharSequence> createFromResource(Context paramContext, int paramInt1, int paramInt2)
  {
    return new ArrayListAdapter(paramContext, paramInt2, paramContext.getResources().getTextArray(paramInt1));
  }

  public void add(T paramT)
  {
    synchronized (this.b)
    {
      if (this.h != null);
      for (ArrayList localArrayList = this.h; ; localArrayList = this.a)
      {
        localArrayList.add(paramT);
        break;
      }
      if (this.f)
        notifyDataSetChanged();
      return;
    }
  }

  public void addAll(Collection<? extends T> paramCollection)
  {
    synchronized (this.b)
    {
      if (this.h != null);
      for (ArrayList localArrayList = this.h; ; localArrayList = this.a)
      {
        localArrayList.addAll(paramCollection);
        break;
      }
      if (this.f)
        notifyDataSetChanged();
      return;
    }
  }

  public void addAll(T[] paramArrayOfT)
  {
    synchronized (this.b)
    {
      if (this.h != null);
      for (ArrayList localArrayList = this.h; ; localArrayList = this.a)
      {
        Collections.addAll(localArrayList, paramArrayOfT);
        break;
      }
      if (this.f)
        notifyDataSetChanged();
      return;
    }
  }

  public void clear()
  {
    synchronized (this.b)
    {
      if (this.h != null);
      for (ArrayList localArrayList = this.h; ; localArrayList = this.a)
      {
        localArrayList.clear();
        break;
      }
      if (this.f)
        notifyDataSetChanged();
      return;
    }
  }

  public void filter(CharSequence paramCharSequence)
  {
    getFilter().filter(paramCharSequence);
  }

  public Context getContext()
  {
    return this.g;
  }

  public int getCount()
  {
    return this.a.size();
  }

  public Object getData()
  {
    return this.a;
  }

  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup, this.d);
  }

  public Filter getFilter()
  {
    if (this.i == null)
      this.i = new ArrayFilter(null);
    return this.i;
  }

  public T getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt + 1;
  }

  public int getPosition(T paramT)
  {
    return this.a.indexOf(paramT);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup, this.c);
  }

  public void insert(int paramInt, T paramT)
  {
    synchronized (this.b)
    {
      if (this.h != null);
      for (ArrayList localArrayList = this.h; ; localArrayList = this.a)
      {
        localArrayList.add(paramInt, paramT);
        break;
      }
      if (this.f)
        notifyDataSetChanged();
      return;
    }
  }

  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.f = true;
  }

  public void remove(int paramInt)
  {
    synchronized (this.b)
    {
      if (this.h != null);
      for (ArrayList localArrayList = this.h; ; localArrayList = this.a)
      {
        localArrayList.remove(paramInt);
        break;
      }
      if (this.f)
        notifyDataSetChanged();
      return;
    }
  }

  public void remove(T paramT)
  {
    synchronized (this.b)
    {
      if (this.h != null);
      for (ArrayList localArrayList = this.h; ; localArrayList = this.a)
      {
        localArrayList.remove(paramT);
        break;
      }
      if (this.f)
        notifyDataSetChanged();
      return;
    }
  }

  public void setDropDownViewResource(int paramInt)
  {
    this.d = paramInt;
  }

  public void setFilter(LuaFunction paramLuaFunction)
  {
    this.k = paramLuaFunction;
  }

  public void setNotifyOnChange(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public void sort(Comparator<? super T> paramComparator)
  {
    synchronized (this.b)
    {
      if (this.h != null);
      for (ArrayList localArrayList = this.h; ; localArrayList = this.a)
      {
        Collections.sort(localArrayList, paramComparator);
        break;
      }
      if (this.f)
        notifyDataSetChanged();
      return;
    }
  }

  private class ArrayFilter extends Filter
  {
    private ArrayFilter()
    {
    }

    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      if (ArrayListAdapter.a(ArrayListAdapter.this) == null)
        synchronized (ArrayListAdapter.b(ArrayListAdapter.this))
        {
          ArrayListAdapter.a(ArrayListAdapter.this, new ArrayList(ArrayListAdapter.c(ArrayListAdapter.this)));
        }
      if (TextUtils.isEmpty(paramCharSequence))
      {
        localFilterResults.values = new ArrayList(ArrayListAdapter.a(ArrayListAdapter.this));
        localFilterResults.count = ArrayListAdapter.a(ArrayListAdapter.this).size();
        ArrayListAdapter.a(ArrayListAdapter.this, null);
        return localFilterResults;
      }
      LuaFunction localLuaFunction1 = ArrayListAdapter.d(ArrayListAdapter.this);
      int i = 0;
      if (localLuaFunction1 != null)
      {
        ArrayList localArrayList1 = new ArrayList();
        try
        {
          LuaFunction localLuaFunction2 = ArrayListAdapter.d(ArrayListAdapter.this);
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = new ArrayList(ArrayListAdapter.a(ArrayListAdapter.this));
          arrayOfObject[1] = localArrayList1;
          arrayOfObject[2] = paramCharSequence;
          localLuaFunction2.call(arrayOfObject);
        }
        catch (LuaException localLuaException)
        {
          a.a(localLuaException);
        }
        localFilterResults.values = localArrayList1;
        localFilterResults.count = localArrayList1.size();
        return localFilterResults;
      }
      int j;
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
      {
        String str = paramCharSequence.toString().toLowerCase();
        synchronized (ArrayListAdapter.b(ArrayListAdapter.this))
        {
          ArrayList localArrayList3 = new ArrayList(ArrayListAdapter.a(ArrayListAdapter.this));
          int k = localArrayList3.size();
          ArrayList localArrayList4 = new ArrayList();
          while (i < k)
          {
            Object localObject5 = localArrayList3.get(i);
            if (localObject5.toString().toLowerCase().contains(str))
              localArrayList4.add(localObject5);
            i++;
          }
          localFilterResults.values = localArrayList4;
          j = localArrayList4.size();
        }
      }
      synchronized (ArrayListAdapter.b(ArrayListAdapter.this))
      {
        ArrayList localArrayList2 = new ArrayList(ArrayListAdapter.a(ArrayListAdapter.this));
        localFilterResults.values = localArrayList2;
        j = localArrayList2.size();
        localFilterResults.count = j;
        return localFilterResults;
      }
    }

    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      ArrayListAdapter.b(ArrayListAdapter.this, (ArrayList)paramFilterResults.values);
      if (paramFilterResults.count > 0)
      {
        ArrayListAdapter.this.notifyDataSetChanged();
        return;
      }
      ArrayListAdapter.this.notifyDataSetInvalidated();
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.ArrayListAdapter
 * JD-Core Version:    0.6.2
 */