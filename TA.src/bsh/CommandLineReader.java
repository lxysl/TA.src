package bsh;

import java.io.FilterReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

class CommandLineReader extends FilterReader
{
  int a = 1;

  public CommandLineReader(Reader paramReader)
  {
    super(paramReader);
  }

  public static void main(String[] paramArrayOfString)
  {
    CommandLineReader localCommandLineReader = new CommandLineReader(new InputStreamReader(System.in));
    while (true)
      System.out.println(localCommandLineReader.read());
  }

  public int read()
  {
    if (this.a == 2)
    {
      this.a = 1;
      return 10;
    }
    int i;
    do
      i = this.in.read();
    while (i == 13);
    if (i == 10)
    {
      if (this.a == 1)
      {
        this.a = 2;
        return 59;
      }
      this.a = 1;
      return i;
    }
    this.a = 0;
    return i;
  }

  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = read();
    if (i == -1)
      return -1;
    paramArrayOfChar[paramInt1] = ((char)i);
    return 1;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.CommandLineReader
 * JD-Core Version:    0.6.2
 */