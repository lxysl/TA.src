package bsh.org.objectweb.asm;

public abstract interface ClassVisitor
{
  public abstract void visit(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3);

  public abstract void visitEnd();

  public abstract void visitField(int paramInt, String paramString1, String paramString2, Object paramObject);

  public abstract void visitInnerClass(String paramString1, String paramString2, String paramString3, int paramInt);

  public abstract CodeVisitor visitMethod(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString);
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.org.objectweb.asm.ClassVisitor
 * JD-Core Version:    0.6.2
 */