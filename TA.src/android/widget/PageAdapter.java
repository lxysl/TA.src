package android.widget;

import android.view.View;

public class PageAdapter extends BasePageAdapter
{
  private final Adapter a;
  private View[] b;

  public PageAdapter(Adapter paramAdapter)
  {
    this.a = paramAdapter;
    this.b = new View[paramAdapter.getViewTypeCount()];
  }

  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    View localView = (View)paramObject;
    ((PageView)paramView).removeView(localView);
    this.b[this.a.getItemViewType(paramInt)] = localView;
  }

  public int getCount()
  {
    return this.a.getCount();
  }

  public Object instantiateItem(View paramView, int paramInt)
  {
    int i = this.a.getItemViewType(paramInt);
    if (this.b[i] != null)
      ((PageView)paramView).removeView(this.b[i]);
    Adapter localAdapter = this.a;
    View localView1 = this.b[i];
    PageView localPageView = (PageView)paramView;
    View localView2 = localAdapter.getView(paramInt, localView1, localPageView);
    localPageView.addView(localView2, 0);
    this.b[i] = null;
    return localView2;
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.widget.PageAdapter
 * JD-Core Version:    0.6.2
 */