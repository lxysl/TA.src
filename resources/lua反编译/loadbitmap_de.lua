local L0_0, L1_1
L0_0 = activity
L0_0 = L0_0 or service
L1_1 = luajava
L1_1 = L1_1.bindClass
L1_1 = L1_1("com.androlua.LuaBitmap")
return function(A0_2)
  if not A0_2:find("^https*://") and not A0_2:find("%.%a%a%a%a?$") then
    A0_2 = A0_2 .. ".png"
  end
  if A0_2:find("^https*://") then
    return L1_1.getHttpBitmap(L0_0, A0_2)
  elseif not A0_2:find("^/") then
    return L1_1.getLocalBitmap(L0_0, string.format("%s/%s", luajava.luadir, A0_2))
  else
    return L1_1.getLocalBitmap(L0_0, A0_2)
  end
end
