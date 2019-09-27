package bsh;

public abstract interface NameSource
{
  public abstract void addNameSourceListener(Listener paramListener);

  public abstract String[] getAllNames();

  public static abstract interface Listener
  {
    public abstract void nameSourceChanged(NameSource paramNameSource);
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.NameSource
 * JD-Core Version:    0.6.2
 */