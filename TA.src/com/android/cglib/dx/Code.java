package com.android.cglib.dx;

import com.android.cglib.dx.c.b.f;
import com.android.cglib.dx.c.b.j;
import com.android.cglib.dx.c.b.k;
import com.android.cglib.dx.c.b.n;
import com.android.cglib.dx.c.b.p;
import com.android.cglib.dx.c.b.r;
import com.android.cglib.dx.c.b.s;
import com.android.cglib.dx.c.b.t;
import com.android.cglib.dx.c.b.u;
import com.android.cglib.dx.c.c.l;
import com.android.cglib.dx.c.d.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Code
{
  private final MethodId<?, ?> a;
  private final List<Label> b = new ArrayList();
  private Label c;
  private boolean d;
  private final Local<?> e;
  private final List<Local<?>> f = new ArrayList();
  private final List<Local<?>> g = new ArrayList();
  private s h = s.a;
  private final List<TypeId<?>> i = new ArrayList();
  private final List<Label> j = new ArrayList();
  private b k = b.a;

  Code(DexMaker.b paramb)
  {
    this.a = paramb.a;
    if (paramb.a())
    {
      this.e = null;
    }
    else
    {
      this.e = Local.a(this, this.a.a);
      this.f.add(this.e);
    }
    for (TypeId localTypeId : this.a.d.a)
      this.f.add(Local.a(this, localTypeId));
    this.c = new Label();
    a(this.c);
    this.c.c = true;
  }

  private <T> Local<T> a(Local<?> paramLocal, TypeId<T> paramTypeId)
  {
    if (!paramLocal.a.equals(paramTypeId))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requested ");
      localStringBuilder.append(paramTypeId);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(paramLocal.a);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramLocal;
  }

  private static n a(Local<?> paramLocal, Local<?>[] paramArrayOfLocal)
  {
    int m;
    if (paramLocal != null)
      m = 1;
    else
      m = 0;
    n localn = new n(m + paramArrayOfLocal.length);
    int n = 0;
    if (paramLocal != null)
      localn.a(0, paramLocal.b());
    while (n < paramArrayOfLocal.length)
    {
      localn.a(n + m, paramArrayOfLocal[n].b());
      n++;
    }
    return localn;
  }

  private p a(com.android.cglib.dx.c.d.c paramc1, com.android.cglib.dx.c.d.c paramc2)
  {
    if (paramc1.c() == 6)
    {
      int m = paramc2.c();
      if (m != 8)
        switch (m)
        {
        default:
          break;
        case 3:
          return r.bu;
        case 2:
          return r.bt;
        }
      else
        return r.bv;
    }
    return r.a(paramc2, paramc1);
  }

  private b a(List<TypeId<?>> paramList)
  {
    b localb = new b(paramList.size());
    for (int m = 0; m < paramList.size(); m++)
      localb.a(m, ((TypeId)paramList.get(m)).b);
    return localb;
  }

  private void a(Label paramLabel)
  {
    if (paramLabel.b == this)
      return;
    if (paramLabel.b != null)
      throw new IllegalArgumentException("Cannot adopt label; it belongs to another Code");
    paramLabel.b = this;
    this.b.add(paramLabel);
  }

  private void a(Label paramLabel, List<Label> paramList)
  {
    Label localLabel = new Label();
    a(localLabel);
    this.c.e = localLabel;
    this.c.f = paramLabel;
    this.c.d = paramList;
    this.c = localLabel;
    this.c.c = true;
  }

  private void a(Local<?> paramLocal, boolean paramBoolean)
  {
    p localp;
    if (paramBoolean)
      localp = r.d(paramLocal.a.b);
    else
      localp = r.c(paramLocal.a.b);
    a(new k(localp, this.h, paramLocal.b(), n.a));
  }

  private void a(f paramf)
  {
    a(paramf, null);
  }

  private void a(f paramf, Label paramLabel)
  {
    if ((this.c != null) && (this.c.c))
    {
      this.c.a.add(paramf);
      int m = paramf.d().b();
      if (m != 6)
      {
        switch (m)
        {
        default:
          throw new IllegalArgumentException();
        case 4:
          if (paramLabel == null)
            throw new IllegalArgumentException("branch == null");
          a(paramLabel, Collections.emptyList());
          return;
        case 3:
          if (paramLabel == null)
            throw new IllegalArgumentException("branch == null");
          this.c.e = paramLabel;
          break;
        case 2:
          if (paramLabel != null)
          {
            StringBuilder localStringBuilder3 = new StringBuilder();
            localStringBuilder3.append("unexpected branch: ");
            localStringBuilder3.append(paramLabel);
            throw new IllegalArgumentException(localStringBuilder3.toString());
          }
          this.c = null;
          return;
        case 1:
        }
        if (paramLabel != null)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("unexpected branch: ");
          localStringBuilder2.append(paramLabel);
          throw new IllegalArgumentException(localStringBuilder2.toString());
        }
        return;
      }
      if (paramLabel != null)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("unexpected branch: ");
        localStringBuilder1.append(paramLabel);
        throw new IllegalArgumentException(localStringBuilder1.toString());
      }
      a(null, new ArrayList(this.j));
      return;
    }
    throw new IllegalStateException("no current label");
  }

  private <D, R> void a(p paramp, MethodId<D, R> paramMethodId, Local<? super R> paramLocal, Local<? extends D> paramLocal1, Local<?>[] paramArrayOfLocal)
  {
    t localt = new t(paramp, this.h, a(paramLocal1, paramArrayOfLocal), this.k, paramMethodId.f);
    a(localt);
    if (paramLocal != null)
      a(paramLocal, false);
  }

  private void d()
  {
    Iterator localIterator = this.b.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (localLabel.a())
      {
        localIterator.remove();
      }
      else
      {
        localLabel.b();
        int n = m + 1;
        localLabel.g = m;
        m = n;
      }
    }
  }

  void a()
  {
    if (this.d)
      throw new AssertionError();
    this.d = true;
    Iterator localIterator1 = this.g.iterator();
    int m = 0;
    while (localIterator1.hasNext())
      m += ((Local)localIterator1.next()).a(m);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator2 = this.f.iterator();
    int n = m;
    while (localIterator2.hasNext())
    {
      Local localLocal = (Local)localIterator2.next();
      l locall = l.a(n - m);
      n += localLocal.a(n);
      j localj = new j(r.b(localLocal.a.b), this.h, localLocal.b(), n.a, locall);
      localArrayList.add(localj);
    }
    ((Label)this.b.get(0)).a.addAll(0, localArrayList);
  }

  public void addCatchClause(TypeId<? extends Throwable> paramTypeId, Label paramLabel)
  {
    if (this.i.contains(paramTypeId))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Already caught: ");
      localStringBuilder.append(paramTypeId);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    a(paramLabel);
    this.i.add(paramTypeId);
    this.k = a(this.i);
    this.j.add(paramLabel);
  }

  public void aget(Local<?> paramLocal1, Local<?> paramLocal2, Local<Integer> paramLocal)
  {
    a(new u(r.k(paramLocal1.a.b), this.h, n.a(paramLocal2.b(), paramLocal.b()), this.k));
    a(paramLocal1, true);
  }

  public void aput(Local<?> paramLocal1, Local<Integer> paramLocal, Local<?> paramLocal2)
  {
    a(new u(r.l(paramLocal2.a.b), this.h, n.a(paramLocal2.b(), paramLocal1.b(), paramLocal.b()), this.k));
  }

  public <T> void arrayLength(Local<Integer> paramLocal, Local<T> paramLocal1)
  {
    a(new u(r.bC, this.h, n.a(paramLocal1.b()), this.k));
    a(paramLocal, true);
  }

  int b()
  {
    Iterator localIterator = this.f.iterator();
    int m = 0;
    while (localIterator.hasNext())
      m += ((Local)localIterator.next()).a();
    return m;
  }

  com.android.cglib.dx.c.b.c c()
  {
    if (!this.d)
      a();
    d();
    com.android.cglib.dx.c.b.c localc = new com.android.cglib.dx.c.b.c(this.b.size());
    for (int m = 0; m < this.b.size(); m++)
      localc.a(m, ((Label)this.b.get(m)).c());
    return localc;
  }

  public void cast(Local<?> paramLocal1, Local<?> paramLocal2)
  {
    if (paramLocal2.getType().b.j())
    {
      t localt = new t(r.ch, this.h, n.a(paramLocal2.b()), this.k, paramLocal1.a.c);
      a(localt);
      a(paramLocal1, true);
      return;
    }
    a(new k(a(paramLocal2.a.b, paramLocal1.a.b), this.h, paramLocal1.b(), paramLocal2.b()));
  }

  public <T> void compare(Comparison paramComparison, Label paramLabel, Local<T> paramLocal1, Local<T> paramLocal2)
  {
    a(paramLabel);
    a(new k(paramComparison.rop(b.a(paramLocal1.a.b, paramLocal2.a.b)), this.h, null, n.a(paramLocal1.b(), paramLocal2.b())), paramLabel);
  }

  public <T extends Number> void compareFloatingPoint(Local<Integer> paramLocal, Local<T> paramLocal1, Local<T> paramLocal2, int paramInt)
  {
    p localp;
    if (paramInt == 1)
    {
      localp = r.i(paramLocal1.a.b);
    }
    else
    {
      if (paramInt != -1)
        break label72;
      localp = r.h(paramLocal1.a.b);
    }
    a(new k(localp, this.h, paramLocal.b(), n.a(paramLocal1.b(), paramLocal2.b())));
    return;
    label72: StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expected 1 or -1 but was ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }

  public void compareLongs(Local<Integer> paramLocal, Local<Long> paramLocal1, Local<Long> paramLocal2)
  {
    a(new k(r.bc, this.h, paramLocal.b(), n.a(paramLocal1.b(), paramLocal2.b())));
  }

  public <T> Local<T> getParameter(int paramInt, TypeId<T> paramTypeId)
  {
    if (this.e != null)
      paramInt++;
    return a((Local)this.f.get(paramInt), paramTypeId);
  }

  public <T> Local<T> getThis(TypeId<T> paramTypeId)
  {
    if (this.e == null)
      throw new IllegalStateException("static methods cannot access 'this'");
    return a(this.e, paramTypeId);
  }

  public <D, V> void iget(FieldId<D, V> paramFieldId, Local<V> paramLocal, Local<D> paramLocal1)
  {
    t localt = new t(r.n(paramLocal.a.b), this.h, n.a(paramLocal1.b()), this.k, paramFieldId.e);
    a(localt);
    a(paramLocal, true);
  }

  public void instanceOfType(Local<?> paramLocal1, Local<?> paramLocal2, TypeId<?> paramTypeId)
  {
    t localt = new t(r.ci, this.h, n.a(paramLocal2.b()), this.k, paramTypeId.c);
    a(localt);
    a(paramLocal1, true);
  }

  public <D, R> void invokeDirect(MethodId<D, R> paramMethodId, Local<? super R> paramLocal, Local<? extends D> paramLocal1, Local<?>[] paramArrayOfLocal)
  {
    a(r.d(paramMethodId.b(true)), paramMethodId, paramLocal, paramLocal1, paramArrayOfLocal);
  }

  public <D, R> void invokeInterface(MethodId<D, R> paramMethodId, Local<? super R> paramLocal, Local<? extends D> paramLocal1, Local<?>[] paramArrayOfLocal)
  {
    a(r.e(paramMethodId.b(true)), paramMethodId, paramLocal, paramLocal1, paramArrayOfLocal);
  }

  public <R> void invokeStatic(MethodId<?, R> paramMethodId, Local<? super R> paramLocal, Local<?>[] paramArrayOfLocal)
  {
    a(r.a(paramMethodId.b(true)), paramMethodId, paramLocal, null, paramArrayOfLocal);
  }

  public <D, R> void invokeSuper(MethodId<D, R> paramMethodId, Local<? super R> paramLocal, Local<? extends D> paramLocal1, Local<?>[] paramArrayOfLocal)
  {
    a(r.c(paramMethodId.b(true)), paramMethodId, paramLocal, paramLocal1, paramArrayOfLocal);
  }

  public <D, R> void invokeVirtual(MethodId<D, R> paramMethodId, Local<? super R> paramLocal, Local<? extends D> paramLocal1, Local<?>[] paramArrayOfLocal)
  {
    a(r.b(paramMethodId.b(true)), paramMethodId, paramLocal, paramLocal1, paramArrayOfLocal);
  }

  public <D, V> void iput(FieldId<D, V> paramFieldId, Local<D> paramLocal, Local<V> paramLocal1)
  {
    t localt = new t(r.o(paramLocal1.a.b), this.h, n.a(paramLocal1.b(), paramLocal.b()), this.k, paramFieldId.e);
    a(localt);
  }

  public void jump(Label paramLabel)
  {
    a(paramLabel);
    a(new k(r.s, this.h, null, n.a), paramLabel);
  }

  public <T> void loadConstant(Local<T> paramLocal, T paramT)
  {
    if (paramT == null);
    p localp2;
    for (p localp1 = r.r; ; localp1 = r.e(paramLocal.a.b))
    {
      localp2 = localp1;
      break;
    }
    if (localp2.b() == 1)
    {
      j localj = new j(localp2, this.h, paramLocal.b(), n.a, Constants.a(paramT));
      a(localj);
      return;
    }
    t localt = new t(localp2, this.h, n.a, this.k, Constants.a(paramT));
    a(localt);
    a(paramLocal, true);
  }

  public void mark(Label paramLabel)
  {
    a(paramLabel);
    if (paramLabel.c)
      throw new IllegalStateException("already marked");
    paramLabel.c = true;
    if (this.c != null)
      jump(paramLabel);
    this.c = paramLabel;
  }

  public void monitorEnter(Local<?> paramLocal)
  {
    a(new u(r.bE, this.h, n.a(paramLocal.b()), this.k));
  }

  public void monitorExit(Local<?> paramLocal)
  {
    a(new u(r.bE, this.h, n.a(paramLocal.b()), this.k));
  }

  public <T> void move(Local<T> paramLocal1, Local<T> paramLocal2)
  {
    a(new k(r.a(paramLocal2.a.b), this.h, paramLocal1.b(), paramLocal2.b()));
  }

  public <T> void newArray(Local<T> paramLocal, Local<Integer> paramLocal1)
  {
    t localt = new t(r.m(paramLocal.a.b), this.h, n.a(paramLocal1.b()), this.k, paramLocal.a.c);
    a(localt);
    a(paramLocal, true);
  }

  public <T> void newInstance(Local<T> paramLocal, MethodId<T, Void> paramMethodId, Local<?>[] paramArrayOfLocal)
  {
    if (paramLocal == null)
      throw new IllegalArgumentException();
    t localt = new t(r.bY, this.h, n.a, this.k, paramMethodId.a.c);
    a(localt);
    a(paramLocal, true);
    invokeDirect(paramMethodId, null, paramLocal, paramArrayOfLocal);
  }

  public <T> Local<T> newLocal(TypeId<T> paramTypeId)
  {
    if (this.d)
      throw new IllegalStateException("Cannot allocate locals after adding instructions");
    Local localLocal = Local.a(this, paramTypeId);
    this.g.add(localLocal);
    return localLocal;
  }

  public <T1, T2> void op(BinaryOp paramBinaryOp, Local<T1> paramLocal1, Local<T1> paramLocal2, Local<T2> paramLocal)
  {
    p localp = paramBinaryOp.rop(b.a(paramLocal2.a.b, paramLocal.a.b));
    n localn = n.a(paramLocal2.b(), paramLocal.b());
    if (localp.b() == 1)
    {
      a(new k(localp, this.h, paramLocal1.b(), localn));
      return;
    }
    a(new u(localp, this.h, localn, this.k));
    a(paramLocal1, true);
  }

  public <T> void op(UnaryOp paramUnaryOp, Local<T> paramLocal1, Local<T> paramLocal2)
  {
    a(new k(paramUnaryOp.rop(paramLocal2.a), this.h, paramLocal1.b(), paramLocal2.b()));
  }

  public Label removeCatchClause(TypeId<? extends Throwable> paramTypeId)
  {
    int m = this.i.indexOf(paramTypeId);
    if (m == -1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("No catch clause: ");
      localStringBuilder.append(paramTypeId);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.i.remove(m);
    this.k = a(this.i);
    return (Label)this.j.remove(m);
  }

  public void returnValue(Local<?> paramLocal)
  {
    if (!paramLocal.a.equals(this.a.b))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("declared ");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append(" but returned ");
      localStringBuilder.append(paramLocal.a);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    a(new k(r.j(paramLocal.a.b), this.h, null, n.a(paramLocal.b())));
  }

  public void returnVoid()
  {
    if (!this.a.b.equals(TypeId.VOID))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("declared ");
      localStringBuilder.append(this.a.b);
      localStringBuilder.append(" but returned void");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    a(new k(r.bw, this.h, null, n.a));
  }

  public <V> void sget(FieldId<?, V> paramFieldId, Local<V> paramLocal)
  {
    t localt = new t(r.p(paramLocal.a.b), this.h, n.a, this.k, paramFieldId.e);
    a(localt);
    a(paramLocal, true);
  }

  public <V> void sput(FieldId<?, V> paramFieldId, Local<V> paramLocal)
  {
    t localt = new t(r.q(paramLocal.a.b), this.h, n.a(paramLocal.b()), this.k, paramFieldId.e);
    a(localt);
  }

  public void throwValue(Local<? extends Throwable> paramLocal)
  {
    a(new u(r.bD, this.h, n.a(paramLocal.b()), this.k));
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.android.cglib.dx.Code
 * JD-Core Version:    0.6.2
 */