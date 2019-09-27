package bsh;

import java.io.PrintStream;
import java.io.Reader;

public abstract interface ConsoleInterface
{
  public abstract void error(Object paramObject);

  public abstract PrintStream getErr();

  public abstract Reader getIn();

  public abstract PrintStream getOut();

  public abstract void print(Object paramObject);

  public abstract void println(Object paramObject);
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.ConsoleInterface
 * JD-Core Version:    0.6.2
 */