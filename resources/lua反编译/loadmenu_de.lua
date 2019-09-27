local L0_0, L1_1, L2_2, L3_3, L4_4, L5_5, L6_6, L7_7, L8_8, L9_9
L0_0 = require
L1_1 = L0_0
L2_2 = "table"
L1_1 = L1_1(L2_2)
L2_2 = luajava
L3_3 = luajava
L3_3 = L3_3.ids
if not L3_3 then
  L3_3 = {}
  L3_3.id = 2130706432
end
L2_2.ids = L3_3
L2_2 = luajava
L2_2 = L2_2.ids
L3_3 = _G
L4_4 = L1_1.insert
L5_5 = luajava
L5_5 = L5_5.new
L6_6 = luajava
L6_6 = L6_6.bindClass
L7_7 = luajava
L7_7 = L7_7.bindClass
L8_8 = "com.androlua.LuaDrawable"
L7_7 = L7_7(L8_8)
L8_8 = L0_0
L9_9 = "loadbitmap"
L8_8 = L8_8(L9_9)
function L9_9(A0_10, A1_11, A2_12, A3_13)
  local L4_14, L5_15, L6_16, L7_17, L8_18, L9_19, L10_20
  A2_12 = A2_12 or L3_3
  A3_13 = A3_13 or 0
  for L7_17, L8_18 in L4_14(L5_15) do
    L9_19 = L2_2.id
    L10_20 = L2_2.id
    L10_20 = L10_20 + 1
    L2_2.id = L10_20
    L10_20 = L8_18[1]
    if L10_20 == MenuItem then
      L10_20 = A0_10.add
      L10_20 = L10_20(L8_18.group or 0, L9_19, L8_18.order or 0, L8_18.title)
      if L8_18.id then
        rawset(A2_12, L8_18.id, L10_20)
        L2_2[L8_18.id] = L9_19
      end
      if L7_17 <= A3_13 then
        L10_20.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
      end
      if L8_18.icon then
        L10_20.setIcon(BitmapDrawable(L8_8(L8_18.icon)))
      end
      if L8_18.enabled == false then
        L10_20.setEnabled(L8_18.enabled)
      end
      if L8_18.visible == false then
        L10_20.setVisible(L8_18.visible)
      end
    else
      L10_20 = L8_18[1]
      if L10_20 == SubMenu then
        L10_20 = A0_10.addSubMenu
        L10_20 = L10_20(L8_18.group or 0, L9_19, L8_18.order or 0, L8_18.title)
        L9_9(L10_20, L8_18, A2_12)
      end
    end
  end
end
return L9_9
