package com.androlua;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.b.a.a.a;
import com.b.a.a.g;
import com.b.a.a.h;
import com.b.a.b.b;
import com.b.a.b.b.a;
import com.b.a.b.d;
import com.b.a.b.e;
import com.b.a.b.f;
import com.b.a.b.k;
import com.b.a.b.l;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class LuaEditor extends com.b.a.a.c
{
  private l A;
  private int B;
  private String C;
  private boolean u;
  private Context v;
  private String w;
  private String x = LuaApplication.getInstance().getLuaExtDir("fonts");
  private String y = LuaApplication.getInstance().getLuaExtPath("android.jar");
  private int z;

  @SuppressLint({"StaticFieldLeak"})
  public LuaEditor(Context paramContext)
  {
    super(paramContext);
    this.v = paramContext;
    setTypeface(Typeface.MONOSPACE);
    File localFile1 = new File(this.x, "default.ttf");
    if (localFile1.exists())
      setTypeface(Typeface.createFromFile(localFile1));
    File localFile2 = new File(this.x, "bold.ttf");
    if (localFile2.exists())
      setBoldTypeface(Typeface.createFromFile(localFile2));
    File localFile3 = new File(this.x, "italic.ttf");
    if (localFile3.exists())
      setItalicTypeface(Typeface.createFromFile(localFile3));
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    setTextSize((int)TypedValue.applyDimension(2, d, localDisplayMetrics));
    setShowLineNumbers(true);
    setHighlightCurrentRow(true);
    setWordWrap(false);
    setAutoIndentWidth(2);
    k.a(com.b.a.b.i.g());
    if (isAccessibilityEnabled());
    for (Object localObject = new h(this); ; localObject = new com.b.a.a.i(this))
    {
      setNavigationMethod((g)localObject);
      break;
    }
    TypedArray localTypedArray = this.v.getTheme().obtainStyledAttributes(new int[] { 16842801, 16842806, 16842905 });
    localTypedArray.getColor(0, 16711935);
    int i = localTypedArray.getColor(1, 16711935);
    int j = localTypedArray.getColor(2, 16711935);
    localTypedArray.recycle();
    setTextColor(i);
    setTextHighlightColor(j);
  }

  public void addNames(String[] paramArrayOfString)
  {
    com.b.a.b.i locali = (com.b.a.b.i)k.a();
    String[] arrayOfString1 = locali.c();
    String[] arrayOfString2 = new String[arrayOfString1.length + paramArrayOfString.length];
    System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, arrayOfString1.length);
    System.arraycopy(paramArrayOfString, 0, arrayOfString2, arrayOfString1.length, paramArrayOfString.length);
    locali.b(arrayOfString2);
    k.a(locali);
    respan();
    invalidate();
  }

  public void addPackage(String paramString, String[] paramArrayOfString)
  {
    com.b.a.b.i locali = (com.b.a.b.i)k.a();
    locali.a(paramString, paramArrayOfString);
    k.a(locali);
    respan();
    invalidate();
  }

  public boolean findNext(String paramString)
  {
    if (!paramString.equals(this.C))
    {
      this.C = paramString;
      this.B = 0;
    }
    this.A = new l();
    String str = this.C;
    if (str.isEmpty())
    {
      selectText(false);
      return false;
    }
    this.B = this.A.a(getText(), str, this.B, getText().length(), false, false);
    if (this.B == -1)
    {
      selectText(false);
      Toast.makeText(this.v, "未找到", 0).show();
      this.B = 0;
      return false;
    }
    setSelection(this.B, this.C.length());
    this.B += this.C.length();
    moveCaret(this.B);
    return true;
  }

  public String getFilePath()
  {
    return this.w;
  }

  public String getSelectedText()
  {
    return this.h.subSequence(getSelectionStart(), getSelectionEnd() - getSelectionStart()).toString();
  }

  public f getText()
  {
    return createDocumentProvider();
  }

  public void gotoLine()
  {
    startGotoMode();
  }

  public void gotoLine(int paramInt)
  {
    if (paramInt > this.h.f())
      paramInt = this.h.f();
    setSelection(getText().e(paramInt - 1));
  }

  public void insert(int paramInt, String paramString)
  {
    selectText(false);
    moveCaret(paramInt);
    paste(paramString);
  }

  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if (KeyEvent.metaStateHasNoModifiers(0xFFFF8FFF & paramKeyEvent.getMetaState()))
      if (paramInt != 29)
      {
        if (paramInt != 31)
        {
          if (paramInt != 35)
          {
            if (paramInt != 40)
            {
              if (paramInt != 47)
              {
                if (paramInt != 50)
                {
                  if (paramInt == 52)
                  {
                    cut();
                    return true;
                  }
                }
                else
                {
                  paste();
                  return true;
                }
              }
              else
              {
                search();
                return true;
              }
            }
            else
            {
              format();
              return true;
            }
          }
          else
          {
            gotoLine();
            return true;
          }
        }
        else
        {
          copy();
          return true;
        }
      }
      else
      {
        selectAll();
        return true;
      }
    return super.onKeyShortcut(paramInt, paramKeyEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.z != 0) && (paramInt3 > 0))
    {
      moveCaret(this.z);
      this.z = 0;
    }
  }

  public void open(String paramString)
  {
    this.w = paramString;
    BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramString));
    StringBuilder localStringBuilder = new StringBuilder();
    while (true)
    {
      String str = localBufferedReader.readLine();
      if (str == null)
        break;
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
    }
    if (localStringBuilder.length() > 1)
      localStringBuilder.setLength(localStringBuilder.length() - 1);
    setText(localStringBuilder);
  }

  public void redo()
  {
    int i = createDocumentProvider().m();
    if (i >= 0)
    {
      setEdited(true);
      respan();
      selectText(false);
      moveCaret(i);
      invalidate();
    }
  }

  public void removePackage(String paramString)
  {
    com.b.a.b.i locali = (com.b.a.b.i)k.a();
    locali.b(paramString);
    k.a(locali);
    respan();
    invalidate();
  }

  public boolean save()
  {
    return save(this.w);
  }

  public boolean save(String paramString)
  {
    if (paramString == null)
      return true;
    File localFile = new File(paramString);
    if ((localFile.exists()) && (!localFile.canWrite()))
      return false;
    BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(paramString));
    localBufferedWriter.write(getText().toString());
    localBufferedWriter.close();
    return true;
  }

  public void search()
  {
    startFindMode();
  }

  public void setBackgoudColor(int paramInt)
  {
    getColorScheme().a(b.a.b, paramInt);
  }

  public void setBasewordColor(int paramInt)
  {
    getColorScheme().a(b.a.l, paramInt);
  }

  public void setCommentColor(int paramInt)
  {
    getColorScheme().a(b.a.j, paramInt);
  }

  public void setDark(boolean paramBoolean)
  {
    if (paramBoolean);
    for (Object localObject = new com.b.a.b.c(); ; localObject = new d())
    {
      setColorScheme((b)localObject);
      return;
    }
  }

  public void setKeywordColor(int paramInt)
  {
    getColorScheme().a(b.a.k, paramInt);
  }

  public void setPanelBackgroundColor(int paramInt)
  {
    this.s.b(paramInt);
  }

  public void setPanelTextColor(int paramInt)
  {
    this.s.a(paramInt);
  }

  public void setSelection(int paramInt)
  {
    selectText(false);
    if (!hasLayout())
    {
      moveCaret(paramInt);
      return;
    }
    this.z = paramInt;
  }

  public void setStringColor(int paramInt)
  {
    getColorScheme().a(b.a.n, paramInt);
  }

  public void setText(CharSequence paramCharSequence)
  {
    e locale = new e(this);
    locale.a(this.u);
    locale.a(paramCharSequence);
    setDocumentProvider(new f(locale));
  }

  public void setText(CharSequence paramCharSequence, boolean paramBoolean)
  {
    replaceText(0, -1 + getLength(), paramCharSequence.toString());
  }

  public void setTextColor(int paramInt)
  {
    getColorScheme().a(b.a.a, paramInt);
  }

  public void setTextHighlightColor(int paramInt)
  {
    getColorScheme().a(b.a.d, paramInt);
  }

  public void setUserwordColor(int paramInt)
  {
    getColorScheme().a(b.a.m, paramInt);
  }

  public void setWordWrap(boolean paramBoolean)
  {
    this.u = paramBoolean;
    super.setWordWrap(paramBoolean);
  }

  public void startFindMode()
  {
    startActionMode(new ActionMode.Callback()
    {
      private l b;
      private int c;
      private EditText d;

      private void a()
      {
        this.b = new l();
        String str = this.d.getText().toString();
        if (str.isEmpty())
        {
          LuaEditor.this.selectText(false);
          return;
        }
        this.c = this.b.a(LuaEditor.this.getText(), str, this.c, LuaEditor.this.getText().length(), false, false);
        if (this.c == -1)
        {
          LuaEditor.this.selectText(false);
          Toast.makeText(LuaEditor.a(LuaEditor.this), "未找到", 0).show();
          this.c = 0;
          return;
        }
        LuaEditor.this.setSelection(this.c, this.d.getText().length());
        this.c += this.d.getText().length();
        LuaEditor.this.moveCaret(this.c);
      }

      public boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        switch (paramAnonymousMenuItem.getItemId())
        {
        default:
          break;
        case 2:
          a();
        case 1:
        }
        return false;
      }

      public boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        paramAnonymousActionMode.setTitle("搜索");
        paramAnonymousActionMode.setSubtitle(null);
        this.d = new EditText(LuaEditor.a(LuaEditor.this))
        {
          public void onTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            if (paramAnonymous2CharSequence.length() > 0)
            {
              LuaEditor.2.a(LuaEditor.2.this, 0);
              LuaEditor.2.a(LuaEditor.2.this);
            }
          }
        };
        this.d.setSingleLine(true);
        this.d.setImeOptions(3);
        this.d.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public boolean onEditorAction(TextView paramAnonymous2TextView, int paramAnonymous2Int, KeyEvent paramAnonymous2KeyEvent)
          {
            LuaEditor.2.a(LuaEditor.2.this);
            return true;
          }
        });
        this.d.setLayoutParams(new RadioGroup.LayoutParams(LuaEditor.this.getWidth() / 3, -1));
        paramAnonymousMenu.add(0, 1, 0, "").setActionView(this.d);
        paramAnonymousMenu.add(0, 2, 0, LuaEditor.a(LuaEditor.this).getString(17039372));
        this.d.requestFocus();
        return true;
      }

      public void onDestroyActionMode(ActionMode paramAnonymousActionMode)
      {
      }

      public boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return false;
      }
    });
  }

  public void startGotoMode()
  {
    startActionMode(new ActionMode.Callback()
    {
      private int b;
      private EditText c;

      private void a()
      {
        String str = this.c.getText().toString();
        if (str.isEmpty())
          return;
        int i = Integer.valueOf(str).intValue();
        if (i > LuaEditor.b(LuaEditor.this).f())
          i = LuaEditor.c(LuaEditor.this).f();
        LuaEditor.this.gotoLine(i);
      }

      public boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        switch (paramAnonymousMenuItem.getItemId())
        {
        default:
          break;
        case 2:
          a();
        case 1:
        }
        return false;
      }

      public boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        paramAnonymousActionMode.setTitle("转到");
        paramAnonymousActionMode.setSubtitle(null);
        this.c = new EditText(LuaEditor.a(LuaEditor.this))
        {
          public void onTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            if (paramAnonymous2CharSequence.length() > 0)
            {
              LuaEditor.1.a(LuaEditor.1.this, 0);
              LuaEditor.1.a(LuaEditor.1.this);
            }
          }
        };
        this.c.setSingleLine(true);
        this.c.setInputType(2);
        this.c.setImeOptions(2);
        this.c.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public boolean onEditorAction(TextView paramAnonymous2TextView, int paramAnonymous2Int, KeyEvent paramAnonymous2KeyEvent)
          {
            LuaEditor.1.a(LuaEditor.1.this);
            return true;
          }
        });
        this.c.setLayoutParams(new RadioGroup.LayoutParams(LuaEditor.this.getWidth() / 3, -1));
        paramAnonymousMenu.add(0, 1, 0, "").setActionView(this.c);
        paramAnonymousMenu.add(0, 2, 0, LuaEditor.a(LuaEditor.this).getString(17039370));
        this.c.requestFocus();
        return true;
      }

      public void onDestroyActionMode(ActionMode paramAnonymousActionMode)
      {
      }

      public boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return false;
      }
    });
  }

  public void undo()
  {
    int i = createDocumentProvider().l();
    if (i >= 0)
    {
      setEdited(true);
      respan();
      selectText(false);
      moveCaret(i);
      invalidate();
    }
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.androlua.LuaEditor
 * JD-Core Version:    0.6.2
 */