package com.b.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.ClipboardManager;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.method.CharacterPickerDialog;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import com.b.a.b.b.a;
import com.b.a.b.e.a;
import com.b.a.b.h;
import com.b.a.b.i;
import com.b.a.b.k;
import com.b.a.b.k.a;
import com.b.a.b.m;
import com.b.a.b.n;
import com.b.a.b.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c extends View
  implements e.a
{
  public static final int SCROLL_DOWN = 1;
  public static final int SCROLL_LEFT = 2;
  public static final int SCROLL_RIGHT = 3;
  public static final int SCROLL_UP = 0;
  protected static float a = 0.75F;
  protected static float b = 0.5F;
  protected static int c = 4;
  protected static int d = 16;
  protected static long e = 250L;
  private static SparseArray<String> u = new SparseArray();
  private int A = 0;
  private Paint B;
  private int C = 0;
  private int D = 0;
  private boolean E = false;
  private b F;
  private ClipboardManager G;
  private float H = 1.0F;
  private int I;
  private int J;
  private f K;
  private int L;
  private Typeface M = Typeface.DEFAULT;
  private Typeface N = Typeface.DEFAULT_BOLD;
  private Typeface O = Typeface.create(Typeface.DEFAULT, 2);
  private char P;
  private boolean Q;
  private Paint R;
  private int S;
  private final Runnable T = new Runnable()
  {
    public void run()
    {
      c.a(c.this).c();
      if (!c.this.d())
        c.this.postDelayed(c.b(c.this), c.e);
    }
  };
  private final Runnable U = new Runnable()
  {
    public void run()
    {
      c.a(c.this).d();
      if (!c.this.c())
        c.this.postDelayed(c.c(c.this), c.e);
    }
  };
  private final Runnable V = new Runnable()
  {
    public void run()
    {
      c.a(c.this).b(false);
      if ((c.this.i > 0) && (c.d(c.this) == c.this.h.b(-1 + c.this.i)))
        c.this.postDelayed(c.e(c.this), c.e);
    }
  };
  private final Runnable W = new Runnable()
  {
    public void run()
    {
      c.a(c.this).a(false);
      if ((!c.this.e()) && (c.d(c.this) == c.this.h.b(1 + c.this.i)))
        c.this.postDelayed(c.f(c.this), c.e);
    }
  };
  private int aa;
  private long ab;
  private boolean ac = false;
  private MotionEvent ad;
  private float ae;
  private float af;
  protected boolean f = false;
  protected g g = new g(this);
  protected com.b.a.b.f h = new com.b.a.b.f(this);
  protected int i = 0;
  protected int j = -1;
  protected int k = -1;
  protected int l = c;
  protected com.b.a.b.b m = new com.b.a.b.d();
  protected boolean n = false;
  protected boolean o = false;
  protected boolean p = true;
  protected int q = 4;
  protected boolean r = false;
  protected a s;
  protected boolean t = true;
  private final Scroller v;
  private a w;
  private b x;
  private n y;
  private e z;

  static
  {
    u.put(65, "ÀÁÂÄÆÃÅĄĀ");
    u.put(67, "ÇĆČ");
    u.put(68, "Ď");
    u.put(69, "ÈÉÊËĘĚĒ");
    u.put(71, "Ğ");
    u.put(76, "Ł");
    u.put(73, "ÌÍÎÏĪİ");
    u.put(78, "ÑŃŇ");
    u.put(79, "ØŒÕÒÓÔÖŌ");
    u.put(82, "Ř");
    u.put(83, "ŚŠŞ");
    u.put(84, "Ť");
    u.put(85, "ÙÚÛÜŮŪ");
    u.put(89, "ÝŸ");
    u.put(90, "ŹŻŽ");
    u.put(97, "àáâäæãåąā");
    u.put(99, "çćč");
    u.put(100, "ď");
    u.put(101, "èéêëęěē");
    u.put(103, "ğ");
    u.put(105, "ìíîïīı");
    u.put(108, "ł");
    u.put(110, "ñńň");
    u.put(111, "øœõòóôöō");
    u.put(114, "ř");
    u.put(115, "§ßśšş");
    u.put(116, "ť");
    u.put(117, "ùúûüůū");
    u.put(121, "ýÿ");
    u.put(122, "źżž");
    u.put(61185, "…¥•®©±[]{}\\|");
    u.put(47, "\\");
    u.put(49, "¹½⅓¼⅛");
    u.put(50, "²⅔");
    u.put(51, "³¾⅜");
    u.put(52, "⁴");
    u.put(53, "⅝");
    u.put(55, "⅞");
    u.put(48, "ⁿ∅");
    u.put(36, "¢£€¥₣₤₱");
    u.put(37, "‰");
    u.put(42, "†‡");
    u.put(45, "–—");
    u.put(43, "±");
    u.put(40, "[{<");
    u.put(41, "]}>");
    u.put(33, "¡");
    u.put(34, "“”«»˝");
    u.put(63, "¿");
    u.put(44, "‚„");
    u.put(61, "≠≈∞");
    u.put(60, "≤«‹");
    u.put(62, "≥»›");
  }

  public c(Context paramContext)
  {
    super(paramContext);
    this.v = new Scroller(paramContext);
    f();
  }

  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.v = new Scroller(paramContext);
    f();
  }

  public c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.v = new Scroller(paramContext);
    f();
  }

  private int a(Canvas paramCanvas)
  {
    return paramCanvas.getClipBounds().top / a();
  }

  private int a(Canvas paramCanvas, char paramChar, int paramInt1, int paramInt2)
  {
    int i1 = this.B.getColor();
    int i2 = getAdvance(paramChar, paramInt1);
    if ((paramInt1 > getScrollX()) || (paramInt1 < getScrollX() + getContentWidth()))
    {
      String str;
      switch (paramChar)
      {
      default:
        if (this.P == 0)
          break label297;
        char[] arrayOfChar = new char[2];
        arrayOfChar[0] = this.P;
        arrayOfChar[1] = paramChar;
        paramCanvas.drawText(arrayOfChar, 0, 2, paramInt1, paramInt2, this.B);
        this.P = '\000';
        return i2;
      case '���':
      case '���':
        this.P = paramChar;
        return i2;
      case ' ':
        if (this.o)
        {
          this.B.setColor(this.m.a(b.a.i));
          str = "·";
        }
        else
        {
          paramCanvas.drawText(" ", 0, 1, paramInt1, paramInt2, this.B);
          return i2;
        }
        break;
      case '\n':
      case '����':
        if (!this.o)
          break label319;
        this.B.setColor(this.m.a(b.a.i));
        str = "↵";
        break;
      case '\t':
        if (!this.o)
          break label319;
        this.B.setColor(this.m.a(b.a.i));
        str = "»";
      }
      paramCanvas.drawText(str, 0, 1, paramInt1, paramInt2, this.B);
      this.B.setColor(i1);
      return i2;
      label297: paramCanvas.drawText(new char[] { paramChar }, 0, 1, paramInt1, paramInt2, this.B);
    }
    label319: return i2;
  }

  private int a(Canvas paramCanvas, String paramString, int paramInt1, int paramInt2)
  {
    paramCanvas.drawText(paramString, paramInt1, paramInt2, this.R);
    return 0;
  }

  private void a(char paramChar)
  {
    a locala;
    if ((Character.isLowerCase(paramChar)) && (paramChar == this.h.charAt(-1 + this.i)))
    {
      this.w.a('\b');
      locala = this.w;
      paramChar = Character.toUpperCase(paramChar);
    }
    else
    {
      locala = this.w;
    }
    locala.a(paramChar);
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    int i1 = (int)paramFloat1 + getScrollX();
    int i2 = (int)paramFloat2 + getScrollY();
    int i3 = Math.max(getMaxScrollX(), getScrollX());
    if (i1 > i3)
      i1 = i3;
    else if (i1 < 0)
      i1 = 0;
    int i4 = Math.max(getMaxScrollY(), getScrollY());
    if (i2 > i4)
      i2 = i4;
    else if (i2 < 0)
      i2 = 0;
    smoothScrollTo(i1, i2);
  }

  private void a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.isShiftPressed()) && (!isSelectText()))
    {
      h();
      this.w.c(true);
    }
    else if ((!paramKeyEvent.isShiftPressed()) && (isSelectText()))
    {
      i();
      this.w.c(false);
    }
    switch (paramInt)
    {
    default:
      return;
    case 22:
      this.w.a(false);
      return;
    case 21:
      this.w.b(false);
      return;
    case 20:
      this.w.c();
      return;
    case 19:
    }
    this.w.d();
  }

  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int i1 = this.B.getColor();
    this.I = paramInt1;
    this.J = paramInt2;
    int i2 = this.m.a(b.a.g);
    this.B.setColor(i2);
    a(paramCanvas, paramInt1 - 1, paramInt2, 2);
    this.B.setColor(i1);
  }

  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    Paint.FontMetricsInt localFontMetricsInt = this.B.getFontMetricsInt();
    paramCanvas.drawRect(paramInt1, paramInt2 + localFontMetricsInt.ascent, paramInt1 + paramInt3, paramInt2 + localFontMetricsInt.descent, this.B);
  }

  private void a(String paramString, final boolean paramBoolean)
  {
    final SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Selection.setSelection(localSpannableStringBuilder, 0);
    CharacterPickerDialog localCharacterPickerDialog = new CharacterPickerDialog(getContext(), this, localSpannableStringBuilder, paramString, true);
    localCharacterPickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        if (localSpannableStringBuilder.length() > 0)
        {
          if (paramBoolean)
            c.a(c.this).a('\b');
          c.a(c.this).a(localSpannableStringBuilder.charAt(0));
        }
      }
    });
    localCharacterPickerDialog.show();
  }

  private int b(Canvas paramCanvas)
  {
    return (-1 + paramCanvas.getClipBounds().bottom) / a();
  }

  private int b(Canvas paramCanvas, char paramChar, int paramInt1, int paramInt2)
  {
    int i1 = this.B.getColor();
    int i2 = getAdvance(paramChar);
    this.B.setColor(this.m.a(b.a.d));
    a(paramCanvas, paramInt1, paramInt2, i2);
    this.B.setColor(this.m.a(b.a.c));
    a(paramCanvas, paramChar, paramInt1, paramInt2);
    this.B.setColor(i1);
    return i2;
  }

  private void b(char paramChar)
  {
    int i1;
    if (Character.isUpperCase(this.h.charAt(this.i - 1)))
      i1 = Character.toUpperCase(paramChar);
    else
      i1 = paramChar;
    String str = (String)u.get(i1);
    if (str != null)
    {
      this.w.f();
      a(str, true);
      return;
    }
    this.w.a(paramChar);
  }

  private void c(Canvas paramCanvas)
  {
    int i1 = a(paramCanvas);
    int i2 = this.h.d(i1);
    if (i2 < 0)
      return;
    this.h.length();
    if (isWordWrap());
    int i4;
    for (int i3 = 1 + this.h.c(i2); ; i3 = i1 + 1)
    {
      i4 = i3;
      break;
    }
    if (this.E)
    {
      Paint localPaint3 = this.R;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h.f());
      localStringBuilder.append(" ");
      this.D = ((int)localPaint3.measureText(localStringBuilder.toString()));
    }
    int i5 = b(paramCanvas);
    int i6 = getPaintBaseline(i1);
    List localList = this.h.i();
    q.a(true ^ localList.isEmpty(), "No spans to paint in TextWarrior.paint()");
    if (localList.isEmpty())
      localList.add(new m(0, 0));
    Object localObject1 = (m)localList.get(0);
    int i7 = localList.size();
    int i8 = 0;
    int i10;
    int i11;
    Object localObject2;
    for (int i9 = 1; ; i9 = i11)
    {
      i10 = i8 + ((m)localObject1).a();
      if (i9 < i7)
      {
        int i45 = i9 + 1;
        m localm = (m)localList.get(i9);
        i11 = i45;
        localObject2 = localm;
      }
      else
      {
        i11 = i9;
        localObject2 = null;
      }
      if ((localObject2 == null) || (i10 > i2))
        break;
      i8 = i10;
      localObject1 = localObject2;
    }
    int i12 = ((m)localObject1).b();
    int i13 = ((m)localObject1).b();
    Paint localPaint1;
    Typeface localTypeface1;
    if (i13 != 1)
      if (i13 != 30)
      {
        localPaint1 = this.B;
        localTypeface1 = this.M;
      }
    while (true)
    {
      localPaint1.setTypeface(localTypeface1);
      break;
      localPaint1 = this.B;
      localTypeface1 = this.O;
      continue;
      localPaint1 = this.B;
      localTypeface1 = this.N;
    }
    int i14 = this.m.a(((m)localObject1).b());
    this.B.setColor(i14);
    int i15 = this.h.f();
    int i19;
    int i20;
    int i21;
    int i22;
    int i16;
    int i17;
    int i18;
    if (this.E)
    {
      this.R.setColor(this.m.a(b.a.i));
      float f1 = this.D - this.aa / 2;
      float f2 = getScrollY();
      float f3 = this.D - this.aa / 2;
      float f4 = getScrollY() + getHeight();
      Paint localPaint2 = this.R;
      i19 = i1;
      i20 = i2;
      i21 = 30;
      i22 = i15;
      i16 = i12;
      i17 = i10;
      i18 = i7;
      paramCanvas.drawLine(f1, f2, f3, f4, localPaint2);
    }
    else
    {
      i16 = i12;
      i17 = i10;
      i18 = i7;
      i19 = i1;
      i20 = i2;
      i21 = 30;
      i22 = i15;
    }
    Typeface localTypeface2;
    if (i16 != 1)
    {
      if (i16 != i21)
        localTypeface2 = this.M;
      else
        localTypeface2 = this.O;
    }
    else
      localTypeface2 = this.N;
    this.B.setTypeface(localTypeface2);
    Object localObject3 = localTypeface2;
    int i23 = i19;
    int i24 = 0;
    while (i23 <= i5)
    {
      int i25 = this.h.g(i23);
      if (i23 >= i22)
        break;
      if ((this.E) && (i4 != i24))
      {
        a(paramCanvas, String.valueOf(i4), 0, i6);
        i24 = i4;
      }
      int i26 = this.D;
      int i27 = i24;
      Object localObject4 = localObject3;
      int i28 = i26;
      int i29 = i22;
      int i30 = i16;
      Object localObject5 = localObject2;
      int i31 = i11;
      int i32 = 0;
      int i33 = i17;
      int i34 = i20;
      while (i32 < i25)
      {
        int i40;
        int i38;
        int i41;
        Object localObject7;
        Object localObject6;
        if ((localObject5 != null) && (i34 >= i33))
        {
          i33 += localObject5.a();
          i40 = localObject5.b();
          if (i30 != i40)
          {
            Typeface localTypeface3;
            if (i40 != 1)
            {
              if (i40 != 30)
                localTypeface3 = this.M;
              else
                localTypeface3 = this.O;
            }
            else
              localTypeface3 = this.N;
            if (localObject4 != localTypeface3)
            {
              this.B.setTypeface(localTypeface3);
              localObject4 = localTypeface3;
            }
            int i44 = this.m.a(i40);
            Object localObject8 = localObject4;
            this.B.setColor(i44);
            i38 = i18;
            localObject4 = localObject8;
          }
          else
          {
            i38 = i18;
          }
          if (i31 < i38)
          {
            i41 = i31 + 1;
            localObject7 = (m)localList.get(i31);
            localObject6 = localObject4;
          }
        }
        while (true)
        {
          break;
          localObject6 = localObject4;
          i41 = i31;
          localObject7 = null;
          continue;
          int i37 = i30;
          i38 = i18;
          localObject6 = localObject4;
          int i39 = i31;
          localObject7 = localObject5;
          i40 = i37;
          i41 = i39;
        }
        if (i34 == this.i)
          a(paramCanvas, i28, i6);
        char c1 = this.h.charAt(i34);
        int i42 = i25;
        if (this.w.b(i34));
        for (int i43 = b(paramCanvas, c1, i28, i6); ; i43 = a(paramCanvas, c1, i28, i6))
        {
          i28 += i43;
          break;
        }
        i34++;
        i32++;
        i18 = i38;
        localObject4 = localObject6;
        i25 = i42;
        i30 = i40;
        localObject5 = localObject7;
        i31 = i41;
      }
      int i35 = i30;
      int i36 = i18;
      if (this.h.charAt(i34 - 1) == '\n')
        i4++;
      i6 += a();
      if (i28 > this.C)
        this.C = i28;
      i23++;
      localObject3 = localObject4;
      i11 = i31;
      i18 = i36;
      i20 = i34;
      i17 = i33;
      i16 = i35;
      i24 = i27;
      i22 = i29;
      localObject2 = localObject5;
    }
    e(paramCanvas);
    if (!isWordWrap())
      d(paramCanvas);
  }

  private void d(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 <= paramInt2) && (paramInt1 >= 0))
      bool = true;
    else
      bool = false;
    q.a(bool, "Invalid startRow and/or endRow");
    Rect localRect = this.g.a();
    Paint.FontMetricsInt localFontMetricsInt = this.B.getFontMetricsInt();
    super.invalidate(0, Math.max(0, paramInt1 * a() + getPaddingTop() - Math.max(localRect.top, localFontMetricsInt.descent)), getScrollX() + getWidth(), paramInt2 * a() + getPaddingTop() + localRect.bottom);
  }

  private void d(Canvas paramCanvas)
  {
    ArrayList localArrayList = k.d();
    if (localArrayList != null)
    {
      if (localArrayList.isEmpty())
        return;
      Rect localRect1 = paramCanvas.getClipBounds();
      int i1 = localRect1.top;
      int i2 = localRect1.bottom;
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Rect localRect2 = (Rect)localIterator.next();
        int i3 = (1 + localRect2.top) * a();
        int i4 = localRect2.bottom * a();
        if ((i4 >= i1) && (i3 <= i2))
        {
          float f1 = Math.min(b(localRect2.left).a(), b(localRect2.right).a());
          paramCanvas.drawLine(f1, i3, f1, i4, this.R);
        }
      }
    }
  }

  private void e(Canvas paramCanvas)
  {
    if (this.n)
    {
      int i1 = getPaintBaseline(this.A);
      int i2 = this.B.getColor();
      this.B.setColor(this.m.a(b.a.h));
      a(paramCanvas, 0, i1, Math.max(this.C, getContentWidth()));
      this.B.setColor(i2);
    }
  }

  private final boolean e(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 < getWidth()) && (paramInt2 >= 0) && (paramInt2 < getHeight());
  }

  private int f(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    if ((i1 != 1073741824) && (i1 != -2147483648))
    {
      i2 = 2147483647;
      q.a("MeasureSpec cannot be UNSPECIFIED. Setting dimensions to max.");
    }
    return i2;
  }

  private void f()
  {
    this.ac = ((AccessibilityManager)getContext().getSystemService("accessibility")).isTouchExplorationEnabled();
    this.w = new a(null);
    this.G = ((ClipboardManager)getContext().getSystemService("clipboard"));
    this.B = new Paint();
    this.B.setAntiAlias(true);
    this.B.setTextSize(d);
    this.R = new Paint();
    this.R.setAntiAlias(true);
    this.R.setTextSize(d);
    setLongClickable(true);
    setFocusableInTouchMode(true);
    setHapticFeedbackEnabled(true);
    this.y = new n()
    {
      public void a(int paramAnonymousInt)
      {
      }
    };
    this.z = new e()
    {
      public void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousBoolean)
        {
          c.g(c.this).a();
          return;
        }
        c.g(c.this).b();
      }
    };
    this.K = new f()
    {
      public void a(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (c.h(c.this))
        {
          AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(16);
          localAccessibilityEvent.setFromIndex(paramAnonymousInt1 - paramAnonymousInt2);
          localAccessibilityEvent.setRemovedCount(paramAnonymousInt2);
          localAccessibilityEvent.setBeforeText(c.this.h);
          c.this.sendAccessibilityEventUnchecked(localAccessibilityEvent);
        }
        c.this.s.b();
      }

      public void a(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (c.h(c.this))
        {
          AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(16);
          localAccessibilityEvent.setFromIndex(paramAnonymousInt1 - 1);
          localAccessibilityEvent.setAddedCount(1);
          c.this.sendAccessibilityEventUnchecked(localAccessibilityEvent);
        }
        c.this.s.b();
      }

      public void b(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (c.h(c.this))
        {
          AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(16);
          localAccessibilityEvent.setFromIndex(paramAnonymousInt1 - paramAnonymousInt2);
          localAccessibilityEvent.setAddedCount(paramAnonymousInt2);
          c.this.sendAccessibilityEventUnchecked(localAccessibilityEvent);
        }
        if (!c.this.t)
          return;
        for (int i = c.this.i; i >= 0; i--)
        {
          char c = c.this.h.charAt(i - 1);
          if ((!Character.isLetterOrDigit(c)) && (c != '_') && (c != '.'))
            break;
        }
        if (c.this.i - i > 0)
        {
          c.this.s.a(c.this.h.subSequence(i, c.this.i - i));
          return;
        }
        c.this.s.b();
      }
    };
    g();
    this.F = new b(this);
    this.s = new a(this);
    this.s.a(i.g());
    invalidate();
  }

  private void g()
  {
    this.i = 0;
    this.A = 0;
    this.C = 0;
    this.w.c(false);
    this.w.f();
    this.h.h();
    if ((getContentWidth() > 0) || (!this.h.j()))
      this.h.k();
    this.y.a(0);
    scrollTo(0, 0);
  }

  private void g(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0)
      bool = true;
    else
      bool = false;
    q.a(bool, "Invalid startRow");
    Rect localRect = this.g.a();
    Paint.FontMetricsInt localFontMetricsInt = this.B.getFontMetricsInt();
    super.invalidate(0, Math.max(0, paramInt * a() + getPaddingTop() - Math.max(localRect.top, localFontMetricsInt.descent)), getScrollX() + getWidth(), getScrollY() + getHeight());
  }

  private void h()
  {
    d(this.A, 1 + this.A);
  }

  private boolean h(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.h.g()))
      bool = true;
    else
      bool = false;
    q.a(bool, "Invalid charOffset given");
    int i1 = i(paramInt);
    int i2 = j(paramInt);
    if ((i1 == 0) && (i2 == 0))
      return false;
    scrollBy(i2, i1);
    return true;
  }

  private int i(int paramInt)
  {
    int i1 = this.h.b(paramInt) * a();
    int i2 = i1 + a();
    if (i1 < getScrollY())
      return i1 - getScrollY();
    if (i2 > getScrollY() + getContentHeight())
      return i2 - getScrollY() - getContentHeight();
    return 0;
  }

  private void i()
  {
    d(this.h.b(this.j), 1 + this.h.b(this.k));
  }

  private int j(int paramInt)
  {
    m localm = b(paramInt);
    int i1 = localm.a();
    int i2 = localm.b();
    int i3;
    if (i2 > getScrollX() + getContentWidth())
      i3 = i2 - getScrollX() - getContentWidth();
    else
      i3 = 0;
    if (i1 < getScrollX() + this.S)
      i3 = i1 - getScrollX() - this.S;
    return i3;
  }

  protected int a()
  {
    Paint.FontMetricsInt localFontMetricsInt = this.B.getFontMetricsInt();
    return localFontMetricsInt.descent - localFontMetricsInt.ascent;
  }

  protected int a(int paramInt)
  {
    if (this.o)
      return this.l * (int)this.B.measureText("·", 0, "·".length());
    int i1 = (paramInt - this.D) / this.aa % this.l;
    return (this.l - i1) * this.aa;
  }

  int a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2 / a();
    if (i1 > this.h.f())
      return this.h.g() - 1;
    int i2 = this.h.d(i1);
    if (i2 < 0)
      return -1;
    if (paramInt1 < 0)
      return i2;
    String str = this.h.a(i1);
    int i3 = this.D;
    int i4 = str.length();
    int i5 = i3;
    int i6 = 0;
    int i7 = 0;
    while (i6 < i4)
    {
      char c1 = str.charAt(i6);
      switch (c1)
      {
      default:
        if (i7 != 0)
          i7 = 0;
        break;
      case '���':
      case '���':
        char[] arrayOfChar = new char[2];
        arrayOfChar[0] = c1;
        arrayOfChar[1] = str.charAt(i6 + 1);
        i5 += (int)this.B.measureText(arrayOfChar, 0, 2);
        i7 = 1;
        break;
      case ' ':
        i8 = getSpaceAdvance();
        break;
      case '\n':
      case '����':
        i8 = getEOLAdvance();
        break;
      case '\t':
      }
      for (int i8 = a(i5); ; i8 = getCharAdvance(c1))
      {
        i5 += i8;
        break;
      }
      if (i5 >= paramInt1)
        break;
      i6++;
    }
    if (i6 < str.length())
      return i2 + i6;
    return i2 + i6 - 1;
  }

  void a(boolean paramBoolean)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (paramBoolean)
    {
      localInputMethodManager.showSoftInput(this, 0);
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
  }

  int b(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2 / a();
    int i2 = this.h.d(i1);
    if (i2 >= 0)
    {
      if (paramInt1 < 0)
        return -1;
      String str = this.h.a(i1);
      int i3 = str.length();
      int i4 = 0;
      int i5 = 0;
      int i6 = 0;
      while (i4 < i3)
      {
        char c1 = str.charAt(i4);
        switch (c1)
        {
        default:
          if (i5 != 0)
            i5 = 0;
          break;
        case '���':
        case '���':
          char[] arrayOfChar = new char[2];
          arrayOfChar[0] = c1;
          arrayOfChar[1] = str.charAt(i4 + 1);
          i6 += (int)this.B.measureText(arrayOfChar, 0, 2);
          i5 = 1;
          break;
        case ' ':
          i7 = getSpaceAdvance();
          break;
        case '\n':
        case '����':
          i7 = getEOLAdvance();
          break;
        case '\t':
        }
        for (int i7 = a(i6); ; i7 = getCharAdvance(c1))
        {
          i6 += i7;
          break;
        }
        if (i6 >= paramInt1)
          break;
        i4++;
      }
      if (i4 < str.length())
        return i2 + i4;
    }
    return -1;
  }

  protected m b(int paramInt)
  {
    int i1 = this.h.b(paramInt);
    int i2 = this.h.d(i1);
    int i3 = this.D;
    int i4 = this.D;
    String str = this.h.a(i1);
    int i5 = str.length();
    int i6 = i4;
    int i7 = 0;
    int i8 = i3;
    int i9 = 0;
    while ((i2 + i9 <= paramInt) && (i9 < i5))
    {
      char c1 = str.charAt(i9);
      int i11;
      switch (c1)
      {
      default:
        if (i7 != 0)
        {
          i11 = i6;
          i7 = 0;
        }
        break;
      case '���':
      case '���':
        char[] arrayOfChar = new char[2];
        arrayOfChar[0] = c1;
        arrayOfChar[1] = str.charAt(i9 + 1);
        i11 = i6 + (int)this.B.measureText(arrayOfChar, 0, 2);
        i7 = 1;
        break;
      case ' ':
        i10 = getSpaceAdvance();
        break;
      case '\n':
      case '����':
        i10 = getEOLAdvance();
        break;
      case '\t':
      }
      for (int i10 = a(i6); ; i10 = getCharAdvance(c1))
      {
        i11 = i10 + i6;
        break;
      }
      i9++;
      int i12 = i6;
      i6 = i11;
      i8 = i12;
    }
    return new m(i8, i6);
  }

  void b()
  {
    removeCallbacks(this.T);
    removeCallbacks(this.U);
    removeCallbacks(this.V);
    removeCallbacks(this.W);
  }

  Rect c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.h.g()))
    {
      int i1 = this.h.b(paramInt) * a();
      int i2 = i1 + a();
      m localm = b(paramInt);
      return new Rect(localm.a(), i1, localm.b(), i2);
    }
    return new Rect(-1, -1, -1, -1);
  }

  void c(int paramInt1, int paramInt2)
  {
    this.v.fling(getScrollX(), getScrollY(), paramInt1, paramInt2, 0, getMaxScrollX(), 0, getMaxScrollY());
    postInvalidate();
  }

  protected boolean c()
  {
    return this.A == 0;
  }

  public void cancelSpanning()
  {
    this.w.b();
  }

  public void computeScroll()
  {
    if (this.v.computeScrollOffset())
    {
      scrollTo(this.v.getCurrX(), this.v.getCurrY());
      postInvalidate();
    }
  }

  protected int computeVerticalScrollOffset()
  {
    return getScrollY();
  }

  protected int computeVerticalScrollRange()
  {
    return this.h.f() * a() + getPaddingTop() + getPaddingBottom();
  }

  public void copy()
  {
    if (this.j != this.k)
      this.w.b(this.G);
    selectText(false);
  }

  public void copy(ClipboardManager paramClipboardManager)
  {
    this.w.b(paramClipboardManager);
  }

  public AccessibilityNodeInfo createAccessibilityNodeInfo()
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = super.createAccessibilityNodeInfo();
    if (Build.VERSION.SDK_INT > 20)
    {
      localAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
      localAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
      localAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
      localAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY);
    }
    else if (Build.VERSION.SDK_INT > 15)
    {
      localAccessibilityNodeInfo.addAction(4096);
      localAccessibilityNodeInfo.addAction(8192);
      localAccessibilityNodeInfo.addAction(256);
      localAccessibilityNodeInfo.addAction(512);
    }
    if (Build.VERSION.SDK_INT >= 18)
      localAccessibilityNodeInfo.setTextSelection(getSelectionStart(), getSelectionEnd());
    localAccessibilityNodeInfo.setFocusable(true);
    if (Build.VERSION.SDK_INT >= 18)
      localAccessibilityNodeInfo.setEditable(true);
    if (Build.VERSION.SDK_INT >= 19)
      localAccessibilityNodeInfo.setMultiLine(true);
    return localAccessibilityNodeInfo;
  }

  public com.b.a.b.f createDocumentProvider()
  {
    return new com.b.a.b.f(this.h);
  }

  public void cut()
  {
    if (this.j != this.k)
      this.w.a(this.G);
  }

  public void cut(ClipboardManager paramClipboardManager)
  {
    this.w.a(paramClipboardManager);
  }

  protected boolean d()
  {
    return this.A == this.h.f() - 1;
  }

  boolean d(int paramInt)
  {
    Runnable localRunnable;
    switch (paramInt)
    {
    default:
      q.a("Invalid scroll direction");
      break;
    case 3:
      removeCallbacks(this.W);
      if ((e()) || (this.A != this.h.b(1 + this.i)))
        break label182;
      localRunnable = this.W;
      break;
    case 2:
      removeCallbacks(this.V);
      if ((this.i <= 0) || (this.A != this.h.b(this.i - 1)))
        break label182;
      localRunnable = this.V;
      break;
    case 1:
      removeCallbacks(this.T);
      if (d())
        break label182;
      localRunnable = this.T;
      break;
    case 0:
      removeCallbacks(this.U);
      if (c())
        break label182;
      localRunnable = this.U;
    }
    post(localRunnable);
    return true;
    label182: return false;
  }

  protected int e(int paramInt)
  {
    int i1 = this.h.b(paramInt);
    boolean bool;
    if (i1 >= 0)
      bool = true;
    else
      bool = false;
    q.a(bool, "Invalid char offset given to getColumn");
    return paramInt - this.h.d(i1);
  }

  protected boolean e()
  {
    return this.i == this.h.g() - 1;
  }

  public void focusCaret()
  {
    h(this.i);
  }

  public void focusSelectionEnd()
  {
    this.w.d(false);
  }

  public void focusSelectionStart()
  {
    this.w.d(true);
  }

  public void format()
  {
    selectText(false);
    CharSequence localCharSequence = com.b.a.b.a.a(new com.b.a.b.f(this.h), this.q);
    this.h.d();
    this.h.a(0, -1 + this.h.g(), System.nanoTime());
    this.h.a(localCharSequence.toString().toCharArray(), 0, System.nanoTime());
    this.h.e();
    this.h.h();
    respan();
    invalidate();
  }

  public int getAdvance(char paramChar)
  {
    char[] arrayOfChar2;
    switch (paramChar)
    {
    default:
      if (this.P != 0)
      {
        arrayOfChar2 = new char[2];
        arrayOfChar2[0] = this.P;
        arrayOfChar2[1] = paramChar;
      }
    case ' ':
    case '\n':
    case '����':
    case '\t':
      char[] arrayOfChar1;
      for (float f1 = this.B.measureText(arrayOfChar2, 0, 2); ; f1 = this.B.measureText(arrayOfChar1, 0, 1))
      {
        return (int)f1;
        return getSpaceAdvance();
        return getEOLAdvance();
        return getTabAdvance();
        arrayOfChar1 = new char[] { paramChar };
      }
    case '���':
    case '���':
    }
    return 0;
  }

  public int getAdvance(char paramChar, int paramInt)
  {
    char[] arrayOfChar2;
    switch (paramChar)
    {
    default:
      if (this.P != 0)
      {
        arrayOfChar2 = new char[2];
        arrayOfChar2[0] = this.P;
        arrayOfChar2[1] = paramChar;
      }
    case ' ':
    case '\n':
    case '����':
    case '\t':
      char[] arrayOfChar1;
      for (float f1 = this.B.measureText(arrayOfChar2, 0, 2); ; f1 = this.B.measureText(arrayOfChar1, 0, 1))
      {
        return (int)f1;
        return getSpaceAdvance();
        return getEOLAdvance();
        return a(paramInt);
        arrayOfChar1 = new char[] { paramChar };
      }
    case '���':
    case '���':
    }
    return 0;
  }

  public int getAutoIndentWidth()
  {
    return this.q;
  }

  public int getCaretPosition()
  {
    return this.i;
  }

  public int getCaretRow()
  {
    return this.A;
  }

  public int getCaretX()
  {
    return this.I;
  }

  public int getCaretY()
  {
    return this.J;
  }

  public int getCharAdvance(char paramChar)
  {
    char[] arrayOfChar = { paramChar };
    return (int)this.B.measureText(arrayOfChar, 0, 1);
  }

  public com.b.a.b.b getColorScheme()
  {
    return this.m;
  }

  protected int getContentHeight()
  {
    return getHeight() - getPaddingTop() - getPaddingBottom();
  }

  protected int getContentWidth()
  {
    return getWidth() - getPaddingLeft() - getPaddingRight();
  }

  protected int getEOLAdvance()
  {
    if (this.o);
    for (float f1 = this.B.measureText("↵", 0, "↵".length()); ; f1 = a * this.B.measureText(" ", 0, 1))
      return (int)f1;
  }

  public int getLeftOffset()
  {
    return this.D;
  }

  public int getLength()
  {
    return this.h.g();
  }

  int getMaxScrollX()
  {
    if (isWordWrap())
      return this.D;
    return Math.max(0, this.C - getContentWidth() + this.g.a().right + this.S);
  }

  int getMaxScrollY()
  {
    return Math.max(0, this.h.f() * a() - getContentHeight() / 2 + this.g.a().bottom);
  }

  protected int getNumVisibleRows()
  {
    return (int)Math.ceil(getContentHeight() / a());
  }

  public int getPaintBaseline(int paramInt)
  {
    Paint.FontMetricsInt localFontMetricsInt = this.B.getFontMetricsInt();
    return (paramInt + 1) * a() - localFontMetricsInt.descent;
  }

  public final int getRowWidth()
  {
    return getContentWidth() - this.D;
  }

  public int getSelectionEnd()
  {
    if (this.k < 0)
      return this.i;
    return this.k;
  }

  public int getSelectionStart()
  {
    if (this.j < 0)
      return this.i;
    return this.j;
  }

  protected int getSpaceAdvance()
  {
    if (this.o)
      return (int)this.B.measureText("·", 0, "·".length());
    return this.aa;
  }

  protected int getTabAdvance()
  {
    int i1;
    if (this.o)
      i1 = this.l;
    for (int i2 = (int)this.B.measureText("·", 0, "·".length()); ; i2 = this.aa)
    {
      return i1 * i2;
      i1 = this.l;
    }
  }

  public float getTextSize()
  {
    return this.B.getTextSize();
  }

  public int getTopOffset()
  {
    return this.L;
  }

  public Parcelable getUiState()
  {
    return new c(this);
  }

  public float getZoom()
  {
    return this.H;
  }

  public boolean hasLayout()
  {
    return getWidth() == 0;
  }

  public boolean inSelectionRange(int paramInt)
  {
    return this.w.b(paramInt);
  }

  public boolean isAccessibilityEnabled()
  {
    return this.ac;
  }

  public boolean isEdited()
  {
    return this.f;
  }

  public boolean isFlingScrolling()
  {
    return true ^ this.v.isFinished();
  }

  public boolean isSaveEnabled()
  {
    return true;
  }

  public final boolean isSelectText()
  {
    return this.w.g();
  }

  public final boolean isSelectText2()
  {
    return this.w.h();
  }

  public boolean isShowLineNumbers()
  {
    return this.E;
  }

  public boolean isWordWrap()
  {
    return this.h.j();
  }

  public void moveCaret(int paramInt)
  {
    this.w.a(paramInt);
  }

  public void moveCaretDown()
  {
    this.w.c();
  }

  public void moveCaretLeft()
  {
    this.w.b(false);
  }

  public void moveCaretRight()
  {
    this.w.a(false);
  }

  public void moveCaretUp()
  {
    this.w.d();
  }

  public boolean onCheckIsTextEditor()
  {
    return true;
  }

  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    paramEditorInfo.inputType = 131073;
    paramEditorInfo.imeOptions = 1342177286;
    if (this.x == null)
      this.x = new b(this);
    else
      this.x.a();
    return this.x;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.clipRect(getScrollX() + getPaddingLeft(), getScrollY() + getPaddingTop(), getScrollX() + getWidth() - getPaddingRight(), getScrollY() + getHeight() - getPaddingBottom());
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    c(paramCanvas);
    paramCanvas.restore();
    this.g.a(paramCanvas);
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    h();
  }

  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((0x2 & paramMotionEvent.getSource()) != 0) && (paramMotionEvent.getAction() == 8))
    {
      a(0.0F, -paramMotionEvent.getAxisValue(9) * a());
      return true;
    }
    return super.onGenericMotionEvent(paramMotionEvent);
  }

  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    if (this.ac)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i1 = paramMotionEvent.getAction();
      if (i1 != 7)
        switch (i1)
        {
        default:
          break;
        case 10:
          this.g.a(paramMotionEvent);
          break;
        case 9:
          this.ad = paramMotionEvent;
          break;
        }
      else
        this.g.onScroll(this.ad, paramMotionEvent, this.ae - f1, this.af - f2);
      this.ae = f1;
      this.af = f2;
    }
    return super.onHoverEvent(paramMotionEvent);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.g.a(paramInt, paramKeyEvent))
      return true;
    if (d.b(paramKeyEvent))
    {
      a(paramInt, paramKeyEvent);
      return true;
    }
    if ((paramInt != 63) && (paramInt != 61185))
    {
      char c1 = d.a(paramKeyEvent);
      if (c1 == 0)
        return super.onKeyDown(paramInt, paramKeyEvent);
      int i1 = paramKeyEvent.getRepeatCount();
      if (i1 == 1)
      {
        if (this.r)
        {
          a(c1);
          return true;
        }
        b(c1);
        return true;
      }
      if ((i1 == 0) || ((this.r) && (!Character.isLowerCase(c1))) || ((!this.r) && (u.get(c1) == null)))
        this.w.a(c1);
      return true;
    }
    a((String)u.get(61185), false);
    return true;
  }

  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.r) && (paramKeyEvent.getRepeatCount() == 1) && (paramKeyEvent.getAction() == 0))
    {
      char c1 = d.a(paramKeyEvent);
      if ((Character.isLowerCase(c1)) && (c1 == Character.toLowerCase(this.h.charAt(this.i - 1))))
      {
        this.w.a('\b');
        this.w.a(Character.toUpperCase(c1));
        return true;
      }
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.g.b(paramInt, paramKeyEvent))
      return true;
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.L = (localRect.top + localRect.height() - getHeight());
      if (!this.Q)
        respan();
      boolean bool;
      if (paramInt3 > 0)
        bool = true;
      else
        bool = false;
      this.Q = bool;
      invalidate();
      this.s.c(getWidth() / 2);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(f(paramInt1), f(paramInt2));
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.h.j()) && (paramInt3 != paramInt1))
      this.h.k();
    this.w.e();
    if (paramInt2 < paramInt4)
      h(this.i);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (isFocused())
    {
      this.g.b(paramMotionEvent);
      return true;
    }
    if (((0xFF & paramMotionEvent.getAction()) == 1) && (e((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
      requestFocus();
    return true;
  }

  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    int i1 = Math.round(paramMotionEvent.getX());
    int i2 = Math.round(paramMotionEvent.getY());
    while (i1 > 0)
    {
      this.w.a(false);
      i1--;
    }
    while (i1 < 0)
    {
      this.w.b(false);
      i1++;
    }
    while (i2 > 0)
    {
      this.w.c();
      i2--;
    }
    while (i2 < 0)
    {
      this.w.d();
      i2++;
    }
    return true;
  }

  public void paste()
  {
    CharSequence localCharSequence = this.G.getText();
    if (localCharSequence != null)
      this.w.a(localCharSequence.toString());
  }

  public void paste(String paramString)
  {
    this.w.a(paramString);
  }

  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 16)
      return super.performAccessibilityAction(paramInt, paramBundle);
    if (paramInt != 256)
    {
      if (paramInt != 512)
        return super.performAccessibilityAction(paramInt, paramBundle);
      int i2 = paramBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
      if (i2 != 1)
      {
        if (i2 != 4)
          return true;
        moveCaretUp();
        return true;
      }
      moveCaretLeft();
      return true;
    }
    int i1 = paramBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
    if (i1 != 1)
    {
      if (i1 != 4)
        return true;
      moveCaretDown();
      return true;
    }
    moveCaretRight();
    return true;
  }

  public void replaceText(int paramInt1, int paramInt2, String paramString)
  {
    this.h.d();
    this.w.a(paramInt1, paramInt2, paramString);
    this.w.f();
    this.h.e();
  }

  public void respan()
  {
    this.w.a();
  }

  public void restoreUiState(Parcelable paramParcelable)
  {
    c localc = (c)paramParcelable;
    final int i1 = localc.a;
    if (localc.d)
    {
      post(new Runnable()
      {
        public void run()
        {
          c.this.setSelectionRange(this.a, this.b - this.a);
          if (i1 < this.b)
            c.this.focusSelectionStart();
        }
      });
      return;
    }
    post(new Runnable()
    {
      public void run()
      {
        c.this.moveCaret(i1);
      }
    });
  }

  public void selectAll()
  {
    this.w.a(0, this.h.g() - 1, false, true);
  }

  public void selectText(boolean paramBoolean)
  {
    a locala;
    if ((this.w.g()) && (!paramBoolean))
    {
      i();
      locala = this.w;
    }
    for (boolean bool = false; ; bool = true)
    {
      locala.c(bool);
      return;
      if ((this.w.g()) || (!paramBoolean))
        break;
      h();
      locala = this.w;
    }
  }

  public void setAutoComplete(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }

  public void setAutoIndent(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void setAutoIndentWidth(int paramInt)
  {
    this.q = paramInt;
  }

  public void setBoldTypeface(Typeface paramTypeface)
  {
    this.N = paramTypeface;
  }

  public void setChirality(boolean paramBoolean)
  {
    this.g.a(paramBoolean);
  }

  public void setColorScheme(com.b.a.b.b paramb)
  {
    this.m = paramb;
    this.g.a(paramb);
    setBackgroundColor(paramb.a(b.a.b));
  }

  public void setDocumentProvider(com.b.a.b.f paramf)
  {
    this.h = paramf;
    g();
    this.w.b();
    this.w.a();
    invalidate();
    if (this.ac)
      setContentDescription(this.h);
  }

  public void setEdited(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public void setHighlightCurrentRow(boolean paramBoolean)
  {
    this.n = paramBoolean;
    h();
  }

  public void setItalicTypeface(Typeface paramTypeface)
  {
    this.O = paramTypeface;
  }

  public void setLongPressCaps(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }

  public void setNavigationMethod(g paramg)
  {
    this.g = paramg;
  }

  public void setNonPrintingCharVisibility(boolean paramBoolean)
  {
    if ((paramBoolean ^ this.o))
    {
      this.o = paramBoolean;
      if (this.h.j())
        this.h.k();
      this.w.e();
      if (!h(this.i))
        invalidate();
    }
  }

  public void setOnSelectionChangedListener(e parame)
  {
    this.z = parame;
  }

  public void setRowListener(n paramn)
  {
    this.y = paramn;
  }

  public void setSelection(int paramInt1, int paramInt2)
  {
    this.w.a(paramInt1, paramInt2, true, false);
  }

  public void setSelectionRange(int paramInt1, int paramInt2)
  {
    this.w.a(paramInt1, paramInt2, true, true);
  }

  public void setShowLineNumbers(boolean paramBoolean)
  {
    this.E = paramBoolean;
  }

  public void setTabSpaces(int paramInt)
  {
    if (paramInt < 0)
      return;
    this.l = paramInt;
    if (this.h.j())
      this.h.k();
    this.w.e();
    if (!h(this.i))
      invalidate();
  }

  public void setTextSize(int paramInt)
  {
    if ((paramInt > 8) && (paramInt < 80))
    {
      float f1 = paramInt;
      if (f1 == this.B.getTextSize())
        return;
      double d1 = a();
      double d2 = getAdvance('a');
      this.H = (paramInt / d);
      this.B.setTextSize(f1);
      this.R.setTextSize(f1);
      if (this.h.j())
        this.h.k();
      this.w.e();
      double d3 = getScrollX() * (getAdvance('a') / d2);
      double d4 = getScrollY() * (a() / d1);
      scrollTo((int)d3, (int)d4);
      this.S = ((int)this.B.measureText("a"));
      this.aa = ((int)this.B.measureText(" "));
      invalidate();
    }
  }

  public void setTypeface(Typeface paramTypeface)
  {
    this.M = paramTypeface;
    this.N = Typeface.create(paramTypeface, 1);
    this.O = Typeface.create(paramTypeface, 2);
    this.B.setTypeface(paramTypeface);
    this.R.setTypeface(paramTypeface);
    if (this.h.j())
      this.h.k();
    this.w.e();
    if (!h(this.i))
      invalidate();
  }

  public void setWordWrap(boolean paramBoolean)
  {
    this.h.a(paramBoolean);
    if (paramBoolean)
    {
      this.C = 0;
      scrollTo(0, 0);
    }
    this.w.e();
    if (!h(this.i))
      invalidate();
  }

  public void setZoom(float paramFloat)
  {
    if ((paramFloat > 0.5D) && (paramFloat < 5.0F))
    {
      if (paramFloat == this.H)
        return;
      this.H = paramFloat;
      int i1 = (int)(paramFloat * d);
      Paint localPaint = this.B;
      float f1 = i1;
      localPaint.setTextSize(f1);
      this.R.setTextSize(f1);
      if (this.h.j())
        this.h.k();
      this.w.e();
      this.S = ((int)this.B.measureText("a"));
      invalidate();
    }
  }

  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (getHeight() == 0)
      return;
    if (AnimationUtils.currentAnimationTimeMillis() - this.ab > 250L)
    {
      int i1 = getScrollY();
      int i2 = getScrollX();
      this.v.startScroll(i2, i1, paramInt1, paramInt2);
      postInvalidate();
    }
    else
    {
      if (!this.v.isFinished())
        this.v.abortAnimation();
      scrollBy(paramInt1, paramInt2);
    }
    this.ab = AnimationUtils.currentAnimationTimeMillis();
  }

  public final void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY());
  }

  public void stopFlingScrolling()
  {
    this.v.forceFinished(true);
  }

  private class a
    implements k.a
  {
    private final k b = new k(this);
    private boolean c = false;
    private boolean d;

    private a()
    {
    }

    private void b(int paramInt1, int paramInt2)
    {
      if ((c.h(c.this)) && (Build.VERSION.SDK_INT >= 16))
      {
        AccessibilityRecord.obtain();
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(131072);
        int i = paramInt1 - paramInt2;
        if (i * i == 1)
          localAccessibilityEvent.setMovementGranularity(1);
        if (paramInt1 > paramInt2);
        for (int j = 512; ; j = 256)
        {
          localAccessibilityEvent.setAction(j);
          break;
        }
        localAccessibilityEvent.setFromIndex(Math.min(paramInt1, paramInt2));
        localAccessibilityEvent.setToIndex(Math.max(paramInt1, paramInt2));
        c.this.sendAccessibilityEventUnchecked(localAccessibilityEvent);
      }
      if (!this.c)
        return;
      if (paramInt1 < c.this.k)
        if (paramInt2 > c.this.k)
        {
          c.this.j = c.this.k;
          c.this.k = paramInt2;
          return;
        }
      while (true)
      {
        c.this.j = paramInt2;
        return;
        if (paramInt2 >= c.this.j)
          break;
        c.this.k = c.this.j;
      }
    }

    private char[] j()
    {
      int i = c.this.h.c(c.this.i);
      int j = c.this.h.e(i);
      c.this.h.f(j);
      int k = 0;
      for (int m = 0; c.this.h.a(); m++)
      {
        int i1 = c.this.h.b();
        if (((i1 != 32) && (i1 != 9)) || (j + m >= c.this.i))
          break;
      }
      int n = m + c.this.q * com.b.a.b.a.a(c.this.h.subSequence(j, c.this.i - j));
      if (n < 0)
        return new char[] { '\n' };
      char[] arrayOfChar = new char[n + 1];
      arrayOfChar[0] = '\n';
      c.this.h.f(j);
      while (k < n)
      {
        k++;
        arrayOfChar[k] = ' ';
      }
      return arrayOfChar;
    }

    private void k()
    {
      int i = c.d(c.this);
      e();
      if (!c.b(c.this, c.this.i))
      {
        c.a(c.this, i, i + 1);
        c.m(c.this);
      }
      f();
    }

    public void a()
    {
      this.b.a(c.this.h);
    }

    public void a(char paramChar)
    {
      int i;
      if (this.c)
      {
        i();
        i = 1;
      }
      else
      {
        i = 0;
      }
      int j = c.d(c.this);
      int k = c.this.h.d(j);
      if (paramChar != '\b')
        if (paramChar != '\n')
        {
          c.this.h.a(paramChar, c.this.i, System.nanoTime());
          a(true);
          f localf3 = c.i(c.this);
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append(paramChar);
          localStringBuilder3.append("");
          localf3.b(localStringBuilder3.toString(), c.this.i, 1);
          if (!c.this.h.j())
            break label578;
          if (k == c.this.h.d(j));
        }
      while (true)
      {
        j--;
        do
        {
          while (true)
          {
            c.a(c.this, j);
            break;
            if (c.this.p)
            {
              char[] arrayOfChar = j();
              c.this.h.a(arrayOfChar, c.this.i, System.nanoTime());
              a(c.this.i + arrayOfChar.length);
            }
            else
            {
              c.this.h.a(paramChar, c.this.i, System.nanoTime());
              a(true);
            }
            if ((c.this.h.j()) && (k != c.this.h.d(j)))
              j--;
            f localf2 = c.i(c.this);
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(paramChar);
            localStringBuilder2.append("");
            localf2.a(localStringBuilder2.toString(), c.this.i, 1);
          }
          if ((i != 0) || (c.this.i <= 0))
            break;
          f localf1 = c.i(c.this);
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(paramChar);
          localStringBuilder1.append("");
          localf1.a(localStringBuilder1.toString(), c.this.i, 1);
          c.this.h.a(c.this.i - 1, System.nanoTime());
          if ((c.this.h.charAt(-2 + c.this.i) == 55357) || (c.this.h.charAt(-2 + c.this.i) == 55356))
          {
            c.this.h.a(-2 + c.this.i, System.nanoTime());
            b(true);
          }
          b(true);
          if (c.d(c.this) < j)
          {
            c.a(c.this, c.d(c.this));
            break;
          }
          if (!c.this.h.j())
            break;
        }
        while (k == c.this.h.d(j));
      }
      label578: c.this.setEdited(true);
      a();
    }

    public void a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < c.this.h.g()))
      {
        b(c.this.i, paramInt);
        c.this.i = paramInt;
        k();
        return;
      }
      q.a("Invalid caret position");
    }

    void a(int paramInt1, int paramInt2)
    {
      int i = c.this.i - paramInt1;
      if (i < 0)
        i = 0;
      int j = paramInt2 + c.this.i;
      int k = -1 + c.this.h.g();
      if (j > k)
        j = k;
      b(i, j - i, "");
    }

    void a(int paramInt1, int paramInt2, String paramString)
    {
      int i;
      int j;
      int m;
      int k;
      if (this.c)
      {
        i = c.this.h.b(c.this.j);
        j = c.this.h.d(i);
        int i5 = c.this.k - c.this.j;
        if (i5 > 0)
        {
          c.this.i = c.this.j;
          c.this.h.a(c.this.j, i5, System.nanoTime());
          int i6;
          if (i != c.d(c.this))
            i6 = 0;
          else
            i6 = 1;
          m = i6;
          k = 1;
        }
        else
        {
          k = 0;
          m = 1;
        }
        c(false);
      }
      else
      {
        i = c.d(c.this);
        j = c.this.h.d(c.d(c.this));
        k = 0;
        m = 1;
      }
      if (paramInt2 > 0)
      {
        int i4 = c.this.h.b(paramInt1);
        if (i4 < i)
        {
          j = c.this.h.d(i4);
          i = i4;
        }
        if (i != c.d(c.this))
          m = 0;
        c.this.i = paramInt1;
        c.this.h.a(paramInt1, paramInt2, System.nanoTime());
        k = 1;
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        int i2 = c.this.h.b(paramInt1);
        if (i2 < i)
        {
          int i3 = c.this.h.d(i2);
          i = i2;
          j = i3;
        }
        c.this.h.a(paramString.toCharArray(), c.this.i, System.nanoTime());
        c localc = c.this;
        localc.i += paramString.length();
        k = 1;
      }
      if (k != 0)
      {
        c.this.setEdited(true);
        a();
      }
      int n = c.d(c.this);
      e();
      int i1;
      if (n != c.d(c.this))
        i1 = 0;
      else
        i1 = m;
      if (!c.b(c.this, c.this.i))
      {
        if ((c.this.h.j()) && (j != c.this.h.d(i)))
          i--;
        if ((i1 != 0) && (!c.this.h.j()))
        {
          c.a(c.this, c.d(c.this), 1 + c.d(c.this));
          return;
        }
        c.a(c.this, i);
      }
    }

    public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      boolean bool1;
      if ((paramInt1 >= 0) && (paramInt2 <= c.this.h.g() - 1) && (paramInt2 >= 0))
        bool1 = true;
      else
        bool1 = false;
      q.a(bool1, "Invalid range to select");
      if (this.c)
      {
        c.p(c.this);
      }
      else
      {
        c.m(c.this);
        if (paramBoolean2)
          c(true);
        else
          this.c = true;
      }
      c.this.j = paramInt1;
      c.this.k = (paramInt2 + c.this.j);
      c.this.i = c.this.k;
      f();
      e();
      if (paramBoolean2)
        c.o(c.this).a(g(), c.this.j, c.this.k);
      boolean bool2 = c.b(c.this, c.this.k);
      if (paramBoolean1)
        bool2 = c.b(c.this, c.this.j);
      if (!bool2)
        c.p(c.this);
    }

    public void a(ClipboardManager paramClipboardManager)
    {
      b(paramClipboardManager);
      i();
    }

    public void a(String paramString)
    {
      if (paramString == null)
        return;
      c.this.h.d();
      i();
      int i = c.d(c.this);
      int j = c.this.h.d(i);
      c.this.h.a(paramString.toCharArray(), c.this.i, System.nanoTime());
      c.this.h.e();
      c localc = c.this;
      localc.i += paramString.length();
      e();
      c.this.setEdited(true);
      a();
      f();
      if (!c.b(c.this, c.this.i))
      {
        int k;
        if ((c.this.h.j()) && (j != c.this.h.d(i)))
          k = i - 1;
        else
          k = i;
        if ((i == c.d(c.this)) && (!c.this.h.j()))
        {
          c.a(c.this, k, k + 1);
          return;
        }
        c.a(c.this, k);
      }
    }

    public void a(final List<m> paramList)
    {
      c.this.post(new Runnable()
      {
        public void run()
        {
          c.this.h.a(paramList);
          c.this.invalidate();
        }
      });
    }

    public void a(boolean paramBoolean)
    {
      if (!c.this.e())
      {
        int i = c.d(c.this);
        c localc = c.this;
        localc.i = (1 + localc.i);
        e();
        b(-1 + c.this.i, c.this.i);
        if (!c.b(c.this, c.this.i))
          c.a(c.this, i, 1 + c.d(c.this));
        if (!paramBoolean)
          f();
      }
    }

    public void b()
    {
      this.b.b();
    }

    void b(int paramInt1, int paramInt2, String paramString)
    {
      int i;
      int j;
      int m;
      int k;
      if (this.c)
      {
        i = c.this.h.b(c.this.j);
        j = c.this.h.d(i);
        int i4 = c.this.k - c.this.j;
        if (i4 > 0)
        {
          c.this.i = c.this.j;
          c.this.h.a(c.this.j, i4, System.nanoTime());
          int i5;
          if (i != c.d(c.this))
            i5 = 0;
          else
            i5 = 1;
          m = i5;
          k = 1;
        }
        else
        {
          k = 0;
          m = 1;
        }
        c(false);
      }
      else
      {
        i = c.d(c.this);
        j = c.this.h.d(c.d(c.this));
        k = 0;
        m = 1;
      }
      if (paramInt2 > 0)
      {
        int i3 = c.this.h.b(paramInt1);
        if (i3 < i)
        {
          j = c.this.h.d(i3);
          i = i3;
        }
        if (i != c.d(c.this))
          m = 0;
        c.this.i = paramInt1;
        c.this.h.a(paramInt1, paramInt2, System.nanoTime());
        k = 1;
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        int i2 = c.this.h.b(paramInt1);
        if (i2 < i)
        {
          j = c.this.h.d(i2);
          i = i2;
        }
        c.this.h.a(paramString.toCharArray(), c.this.i, System.nanoTime());
        c localc = c.this;
        localc.i += paramString.length();
        k = 1;
      }
      c.i(c.this).b(paramString, c.this.i, paramString.length() - paramInt2);
      if (k != 0)
      {
        c.this.setEdited(true);
        a();
      }
      int n = c.d(c.this);
      e();
      int i1;
      if (n != c.d(c.this))
        i1 = 0;
      else
        i1 = m;
      if (!c.b(c.this, c.this.i))
      {
        if ((c.this.h.j()) && (j != c.this.h.d(i)))
          i--;
        if ((i1 != 0) && (!c.this.h.j()))
        {
          c.a(c.this, c.d(c.this), 1 + c.d(c.this));
          return;
        }
        c.a(c.this, i);
      }
    }

    public void b(ClipboardManager paramClipboardManager)
    {
      if ((this.c) && (c.this.j < c.this.k))
        paramClipboardManager.setText(c.this.h.subSequence(c.this.j, c.this.k - c.this.j));
    }

    public void b(boolean paramBoolean)
    {
      if (c.this.i > 0)
      {
        int i = c.d(c.this);
        c localc = c.this;
        localc.i = (-1 + localc.i);
        e();
        b(1 + c.this.i, c.this.i);
        if (!c.b(c.this, c.this.i))
          c.a(c.this, c.d(c.this), i + 1);
        if (!paramBoolean)
          f();
      }
    }

    public boolean b(int paramInt)
    {
      if (c.this.j < 0)
        return false;
      int i = c.this.j;
      boolean bool = false;
      if (i <= paramInt)
      {
        int j = c.this.k;
        bool = false;
        if (paramInt < j)
          bool = true;
      }
      return bool;
    }

    String c(int paramInt)
    {
      int i = c.this.h.g();
      if (paramInt + c.this.i > i - 1);
      for (CharSequence localCharSequence = c.this.h.subSequence(c.this.i, -1 + (i - c.this.i)); ; localCharSequence = c.this.h.subSequence(c.this.i, paramInt))
        return localCharSequence.toString();
    }

    public void c()
    {
      if (!c.this.d())
      {
        int i = c.this.i;
        int j = c.d(c.this);
        int k = j + 1;
        int m = c.this.e(i);
        int n = c.this.h.g(j);
        int i1 = c.this.h.g(k);
        if (m < i1)
        {
          c localc2 = c.this;
          localc2.i = (n + localc2.i);
        }
        else
        {
          c localc1 = c.this;
          localc1.i += -1 + (i1 + (n - m));
        }
        c.j(c.this);
        b(i, c.this.i);
        if (!c.b(c.this, c.this.i))
          c.a(c.this, j, k + 1);
        c.k(c.this).a(k);
        f();
      }
    }

    public void c(boolean paramBoolean)
    {
      if (!(paramBoolean ^ this.c))
        return;
      c localc2;
      int i;
      if (paramBoolean)
      {
        c.this.j = c.this.i;
        localc2 = c.this;
        i = c.this.i;
      }
      while (true)
      {
        localc2.k = i;
        break;
        c localc1 = c.this;
        i = -1;
        localc1.j = i;
        localc2 = c.this;
      }
      this.c = paramBoolean;
      this.d = paramBoolean;
      c.o(c.this).a(paramBoolean, c.this.getSelectionStart(), c.this.getSelectionEnd());
    }

    String d(int paramInt)
    {
      int i = c.this.i - paramInt;
      if (i < 0)
        i = 0;
      return c.this.h.subSequence(i, c.this.i - i).toString();
    }

    public void d()
    {
      if (!c.this.c())
      {
        int i = c.this.i;
        int j = c.d(c.this);
        int k = j - 1;
        int m = c.this.e(i);
        int n = c.this.h.g(k);
        if (m < n)
        {
          c localc2 = c.this;
          localc2.i -= n;
        }
        else
        {
          c localc1 = c.this;
          localc1.i -= m + 1;
        }
        c.l(c.this);
        b(i, c.this.i);
        if (!c.b(c.this, c.this.i))
          c.a(c.this, k, j + 1);
        c.k(c.this).a(k);
        f();
      }
    }

    public void d(boolean paramBoolean)
    {
      if (this.c)
      {
        c localc;
        if ((paramBoolean) && (c.this.i != c.this.j))
          localc = c.this;
        for (int i = c.this.j; ; i = c.this.k)
        {
          localc.i = i;
          k();
          return;
          if ((paramBoolean) || (c.this.i == c.this.k))
            break;
          localc = c.this;
        }
      }
    }

    void e()
    {
      int i = c.this.h.b(c.this.i);
      if (c.d(c.this) != i)
      {
        c.c(c.this, i);
        c.k(c.this).a(i);
      }
    }

    public void f()
    {
      ((InputMethodManager)c.this.getContext().getSystemService("input_method")).restartInput(c.this);
      if ((c.n(c.this) != null) && (c.n(c.this).b()))
        c.n(c.this).a();
    }

    public final boolean g()
    {
      return this.c;
    }

    public final boolean h()
    {
      return this.d;
    }

    public void i()
    {
      if (!this.c)
        return;
      int i = c.this.k - c.this.j;
      if (i > 0)
      {
        int j = c.this.h.b(c.this.j);
        int k = c.this.h.d(j);
        int m;
        if (c.this.h.b(c.this.k) == j)
          m = 1;
        else
          m = 0;
        c.i(c.this).a("", c.this.i, i);
        c.this.h.a(c.this.j, i, System.nanoTime());
        c.this.i = c.this.j;
        e();
        c.this.setEdited(true);
        a();
        c(false);
        f();
        if (!c.b(c.this, c.this.i))
        {
          if ((c.this.h.j()) && (k != c.this.h.d(j)))
            j--;
          if ((m != 0) && (!c.this.h.j()))
          {
            c.a(c.this, j, j + 1);
            return;
          }
          c.a(c.this, j);
        }
      }
      else
      {
        c(false);
        c.m(c.this);
      }
    }
  }

  private class b extends BaseInputConnection
  {
    private boolean b = false;
    private int c = 0;

    public b(c arg2)
    {
      super(true);
    }

    public void a()
    {
      this.c = 0;
      this.b = false;
      c.this.h.e();
    }

    public boolean b()
    {
      return this.b;
    }

    public boolean commitText(CharSequence paramCharSequence, int paramInt)
    {
      c.a(c.this).b(c.this.getCaretPosition() - this.c, this.c, paramCharSequence.toString());
      this.c = 0;
      c.this.h.e();
      if (paramInt > 1)
        c.a(c.this).a(paramInt + c.this.i - 1);
      else if (paramInt <= 0)
        c.a(c.this).a(c.this.i - paramCharSequence.length() - paramInt);
      this.b = false;
      return true;
    }

    public boolean deleteSurroundingText(int paramInt1, int paramInt2)
    {
      if (this.c != 0)
        Log.i("lua", "Warning: Implmentation of InputConnection.deleteSurroundingText will not skip composing text");
      c.a(c.this).a(paramInt1, paramInt2);
      return true;
    }

    public boolean finishComposingText()
    {
      a();
      return true;
    }

    public int getCursorCapsMode(int paramInt)
    {
      int i = paramInt & 0x2000;
      int j = 1;
      if (i == 8192)
      {
        int n = c.this.i - j;
        if ((n < 0) || (k.a().b(c.this.h.charAt(n))))
        {
          if ((paramInt & 0x4000) == 16384)
            return 24576;
          return 8192;
        }
      }
      else
      {
        h localh = k.a();
        int k = c.this.i - j;
        int m = 0;
        while (k >= 0)
        {
          char c1 = c.this.h.charAt(k);
          if (c1 == '\n')
            break;
          if (!localh.b(c1))
          {
            if ((m != 0) && (localh.c(c1)))
              break;
            j = 0;
            break;
          }
          m++;
          k--;
        }
        if (j != 0)
          return 16384;
      }
      return 0;
    }

    public CharSequence getTextAfterCursor(int paramInt1, int paramInt2)
    {
      return c.a(c.this).c(paramInt1);
    }

    public CharSequence getTextBeforeCursor(int paramInt1, int paramInt2)
    {
      return c.a(c.this).d(paramInt1);
    }

    public boolean performContextMenuAction(int paramInt)
    {
      switch (paramInt)
      {
      default:
        switch (paramInt)
        {
        default:
        case 16908328:
        case 16908329:
        }
        break;
      case 16908322:
        c.this.paste();
        break;
      case 16908321:
        c.this.copy();
        break;
      case 16908320:
        c.this.cut();
        break;
      case 16908319:
        c.this.selectAll();
      }
      return false;
    }

    public boolean reportFullscreenMode(boolean paramBoolean)
    {
      return false;
    }

    public boolean sendKeyEvent(KeyEvent paramKeyEvent)
    {
      int i = paramKeyEvent.getKeyCode();
      if (i != 59)
      {
        switch (i)
        {
        default:
          switch (i)
          {
          default:
            return super.sendKeyEvent(paramKeyEvent);
          case 123:
            c.this.moveCaret(c.this.h.length());
            return true;
          case 122:
          }
          c.this.moveCaret(0);
          return true;
        case 22:
          c.this.moveCaretRight();
          return true;
        case 21:
          c.this.moveCaretLeft();
          return true;
        case 20:
          c.this.moveCaretDown();
          return true;
        case 19:
        }
        c.this.moveCaretUp();
        return true;
      }
      if (c.this.isSelectText())
      {
        c.this.selectText(false);
        return true;
      }
      c.this.selectText(true);
      return true;
    }

    public boolean setComposingText(CharSequence paramCharSequence, int paramInt)
    {
      this.b = true;
      if (!c.this.h.c())
        c.this.h.d();
      c.a(c.this).b(c.this.getCaretPosition() - this.c, this.c, paramCharSequence.toString());
      this.c = paramCharSequence.length();
      if (paramInt > 1)
      {
        c.a(c.this).a(paramInt + c.this.i - 1);
        return true;
      }
      if (paramInt <= 0)
        c.a(c.this).a(c.this.i - paramCharSequence.length() - paramInt);
      return true;
    }

    public boolean setSelection(int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2)
      {
        c.a(c.this).a(paramInt1);
        return true;
      }
      c.a(c.this).a(paramInt1, paramInt2 - paramInt1, false, true);
      return true;
    }
  }

  public static class c
    implements Parcelable
  {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator()
    {
      public c.c a(Parcel paramAnonymousParcel)
      {
        return new c.c(paramAnonymousParcel, null);
      }

      public c.c[] a(int paramAnonymousInt)
      {
        return new c.c[paramAnonymousInt];
      }
    };
    final int a;
    final int b;
    final int c;
    final boolean d;
    final int e;
    final int f;

    private c(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
      this.c = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() != 0)
        bool = true;
      else
        bool = false;
      this.d = bool;
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
    }

    public c(c paramc)
    {
      this.a = paramc.getCaretPosition();
      this.b = paramc.getScrollX();
      this.c = paramc.getScrollY();
      this.d = paramc.isSelectText();
      this.e = paramc.getSelectionStart();
      this.f = paramc.getSelectionEnd();
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.b);
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.b.a.a.c
 * JD-Core Version:    0.6.2
 */