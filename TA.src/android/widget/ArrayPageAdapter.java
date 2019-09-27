package android.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPageAdapter extends BasePageAdapter
{
  public ArrayList<View> mListViews;

  public ArrayPageAdapter()
  {
    this.mListViews = new ArrayList();
  }

  public ArrayPageAdapter(ArrayList<View> paramArrayList)
  {
    this.mListViews = paramArrayList;
  }

  public ArrayPageAdapter(View[] paramArrayOfView)
  {
    this.mListViews = new ArrayList(Arrays.asList(paramArrayOfView));
  }

  public void add(View paramView)
  {
    this.mListViews.add(paramView);
  }

  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((PageView)paramView).removeView((View)this.mListViews.get(paramInt));
  }

  public int getCount()
  {
    return this.mListViews.size();
  }

  public ArrayList<View> getData()
  {
    return this.mListViews;
  }

  public View getItem(int paramInt)
  {
    return (View)this.mListViews.get(paramInt);
  }

  public void insert(int paramInt, View paramView)
  {
    this.mListViews.add(paramInt, paramView);
  }

  public Object instantiateItem(View paramView, int paramInt)
  {
    ((PageView)paramView).addView((View)this.mListViews.get(paramInt), 0);
    return this.mListViews.get(paramInt);
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }

  public View remove(int paramInt)
  {
    return (View)this.mListViews.remove(paramInt);
  }

  public boolean remove(View paramView)
  {
    return this.mListViews.remove(paramView);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.ArrayPageAdapter
 * JD-Core Version:    0.6.2
 */