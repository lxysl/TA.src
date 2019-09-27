package bsh;

public class BSHPackageDeclaration extends SimpleNode
{
  public BSHPackageDeclaration(int paramInt)
  {
    super(paramInt);
  }

  public Object eval(CallStack paramCallStack, Interpreter paramInterpreter)
  {
    BSHAmbiguousName localBSHAmbiguousName = (BSHAmbiguousName)jjtGetChild(0);
    NameSpace localNameSpace = paramCallStack.top();
    localNameSpace.c(localBSHAmbiguousName.text);
    localNameSpace.importPackage(localBSHAmbiguousName.text);
    return Primitive.VOID;
  }
}

/* Location:           C:\Users\86186\Downloads\反编译工具包\01_反编译工具包\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     bsh.BSHPackageDeclaration
 * JD-Core Version:    0.6.2
 */