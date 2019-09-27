local L0_0, L1_1, L2_2, L3_3, L4_4, L5_5, L6_6, L7_7, L8_8, L9_9, L10_10, L11_11, L12_12, L13_13, L14_14, L15_15, L16_16, L17_17, L18_18, L19_19, L20_20, L21_21, L22_22, L23_23, L24_24, L25_25, L26_26, L27_27, L28_28, L29_29, L30_30, L31_31, L32_32, L33_33, L34_34, L35_35, L36_36
L0_0 = require
L1_1 = L0_0
L2_2 = "table"
L1_1 = L1_1(L2_2)
L2_2 = {}
L3_3 = {}
L4_4 = luajava
L4_4.loaded = L2_2
L4_4 = luajava
L4_4.imported = L3_3
L4_4 = _G
L5_5 = L1_1.insert
L6_6 = luajava
L6_6 = L6_6.new
L7_7 = luajava
L7_7 = L7_7.bindClass
L8_8 = {}
L9_9 = {}
L10_10 = activity
L10_10 = L10_10 or service
L11_11 = luajava
L11_11 = L11_11.astable
L12_12 = L10_10.getClassLoaders
L36_36 = L12_12()
L11_11 = L11_11(L12_12, L13_13, L14_14, L15_15, L16_16, L17_17, L18_18, L19_19, L20_20, L21_21, L22_22, L23_23, L24_24, L25_25, L26_26, L27_27, L28_28, L29_29, L30_30, L31_31, L32_32, L33_33, L34_34, L35_35, L36_36, L12_12())
L8_8 = L11_11
L11_11 = L10_10.getLibrarys
L11_11 = L11_11()
function L12_12(A0_37)
  local L1_38
  L1_38 = A0_37.match
  L1_38 = L1_38(A0_37, "^%a+")
  L1_38 = L11_11[L1_38]
  if L1_38 then
    return assert(package.loadlib(L1_38, "luaopen_" .. A0_37:gsub("%.", "_"))), L1_38
  else
    return [[

	no file ./libs/lib]] .. A0_37 .. ".so"
  end
end
L13_13 = L1_1.insert
L14_14 = package
L14_14 = L14_14.searchers
L15_15 = L12_12
L13_13(L14_14, L15_15)
function L13_13(A0_39)
  if A0_39:find("_") then
    A0_39 = A0_39:gsub("_", "$")
  end
  return A0_39
end
function L14_14(A0_40)
  if pcall(L7_7, A0_40) then
    L2_2[A0_40] = pcall(L7_7, A0_40)
    return pcall(L7_7, A0_40)
  end
end
function L15_15(A0_41)
  A0_41 = L13_13(A0_41)
  return L2_2[A0_41] or L14_14(A0_41)
end
function L16_16(A0_42)
  A0_42 = L13_13(A0_42)
  for _FORV_4_, _FORV_5_ in ipairs(L8_8) do
    if pcall(_FORV_5_.loadClass, A0_42) then
      L2_2[A0_42] = pcall(_FORV_5_.loadClass, A0_42)
      return pcall(_FORV_5_.loadClass, A0_42)
    end
  end
end
function L17_17(A0_43)
  A0_43 = L13_13(A0_43)
  return L2_2[A0_43] or L16_16(A0_43)
end
L18_18 = {}
function L19_19(A0_44, A1_45)
  local L2_46, L3_47
  L2_46 = pcall
  L3_47 = luajava
  L3_47 = L3_47.bindClass
  L3_47 = L2_46(L3_47, rawget(A0_44, "__name") .. A1_45)
  if L2_46 then
    rawset(A0_44, A1_45, L3_47)
    return L3_47
  else
    error(A1_45 .. " is not in " .. rawget(A0_44, "__name"), 2)
  end
end
L18_18.__index = L19_19
function L19_19(A0_48)
  local L1_49
  L1_49 = {}
  L1_49.__name = A0_48
  setmetatable(L1_49, L18_18)
  return L1_49
end
function L20_20(A0_50)
  local L1_51, L2_52
  L1_51 = pcall
  L2_52 = L0_0
  L2_52 = L1_51(L2_52, A0_50)
  if not L1_51 and not L2_52:find("no file") then
    error(L2_52, 0)
  end
  return L1_51 and L2_52
end
function L21_21(A0_53, A1_54)
  for _FORV_5_, _FORV_6_ in ipairs(A0_53) do
    if _FORV_6_ == A1_54 then
      return
    end
  end
  L5_5(A0_53, A1_54)
end
function L22_22(A0_55, A1_56, A2_57)
  local L3_58, L4_59, L5_60, L6_61
  L4_59 = A2_57
  L3_58 = A2_57.find
  L5_60 = ":"
  L3_58 = L3_58(L4_59, L5_60)
  if L3_58 then
    L5_60 = A2_57
    L4_59 = A2_57.sub
    L6_61 = 1
    L4_59 = L4_59(L5_60, L6_61, L3_58 - 1)
    L6_61 = A2_57
    L5_60 = A2_57.sub
    L5_60 = L5_60(L6_61, L3_58 + 1, -1)
    L6_61 = L10_10.loadDex
    L6_61 = L6_61(L4_59)
    L6_61 = L6_61.loadClass
    L6_61 = L6_61(L5_60)
    A0_55[A2_57:match("([^%.$]+)$")] = L6_61
    L21_21(L3_3, A2_57)
    return L6_61
  end
  L5_60 = A2_57
  L4_59 = A2_57.find
  L6_61 = "%*$"
  L4_59 = L4_59(L5_60, L6_61)
  if L4_59 then
    L5_60 = L21_21
    L6_61 = A1_56
    L5_60(L6_61, A2_57:sub(1, -2))
    L5_60 = L21_21
    L6_61 = L3_3
    L5_60(L6_61, A2_57)
    L5_60 = L19_19
    L6_61 = A2_57.sub
    L6_61 = L6_61(A2_57, 1, -2)
    return L5_60(L6_61, L6_61(A2_57, 1, -2))
  else
    L6_61 = A2_57
    L5_60 = A2_57.match
    L5_60 = L5_60(L6_61, "([^%.$]+)$")
    L6_61 = L20_20
    L6_61 = L6_61(A2_57)
    if not L6_61 then
      L6_61 = L15_15
      L6_61 = L6_61(A2_57)
      if not L6_61 then
        L6_61 = L17_17
        L6_61 = L6_61(A2_57)
      end
    end
    if L6_61 then
      if L6_61 ~= true then
        if type(L6_61) ~= "table" then
          L21_21(L3_3, A2_57)
        end
        A0_55[L5_60] = L6_61
      end
      return L6_61
    else
      error("cannot find " .. A2_57, 2)
    end
  end
end
function L23_23(A0_62)
  local L1_63, L2_64, L3_65, L4_66, L5_67, L6_68, L7_69
  L1_63 = A0_62 or {}
  L2_64 = {}
  L3_65 = {}
  L4_66 = L21_21
  L5_67 = L2_64
  L6_68 = ""
  L4_66(L5_67, L6_68)
  L4_66 = L21_21
  L5_67 = L2_64
  L6_68 = "java.lang."
  L4_66(L5_67, L6_68)
  L4_66 = L21_21
  L5_67 = L2_64
  L6_68 = "java.util."
  L4_66(L5_67, L6_68)
  L4_66 = L21_21
  L5_67 = L2_64
  L6_68 = "com.androlua."
  L4_66(L5_67, L6_68)
  function L4_66(A0_70)
    local L1_71, L2_72, L3_73, L4_74, L5_75
    for L4_74, L5_75 in L1_71(L2_72) do
      if L15_15(L5_75 .. A0_70) then
        return (L15_15(L5_75 .. A0_70))
      end
    end
  end
  function L5_67(A0_76)
    local L1_77, L2_78, L3_79, L4_80, L5_81
    for L4_80, L5_81 in L1_77(L2_78) do
      if L17_17(L5_81 .. A0_76) then
        return (L17_17(L5_81 .. A0_76))
      end
    end
  end
  L6_68 = L21_21
  L6_68(L7_69, L4_66)
  L6_68 = L21_21
  L6_68(L7_69, L5_67)
  L6_68 = {}
  L6_68.__index = L7_69
  if L7_69 == "string" then
    return L7_69({}, L1_63)
  end
  L7_69(L1_63, L6_68)
  for _FORV_10_, _FORV_11_ in L7_69(L9_9) do
    L1_63[_FORV_10_] = _FORV_11_
  end
  L1_63.import = L7_69
  L7_69("loadlayout", L1_63)
  L7_69("loadbitmap", L1_63)
  L7_69("loadmenu", L1_63)
  return L1_63
end
function L24_24(A0_82)
  local L1_83, L2_84
  L1_83 = L21_21
  L2_84 = L8_8
  L1_83(L2_84, L10_10.loadDex(A0_82))
end
L9_9.compile = L24_24
function L24_24(A0_85)
  local L1_86
  function L1_86()
    if A0_85.hasMoreElements() then
      return A0_85.nextElement()
    end
  end
  return L1_86
end
L9_9.enum = L24_24
function L24_24(A0_87)
  local L1_88
  L1_88 = A0_87.iterator
  L1_88 = L1_88()
  return function()
    if L1_88.hasNext() then
      return L1_88.next()
    end
  end
end
L9_9.each = L24_24
L24_24 = {}
L25_25 = setmetatable
L26_26 = L24_24
L27_27 = {}
function L28_28()
  local L0_89, L1_90
  L0_89 = "nil"
  return L0_89
end
L27_27.__tostring = L28_28
L25_25(L26_26, L27_27)
function L25_25(A0_91)
  local L1_92, L2_93, L3_94, L4_95, L5_96, L6_97
  L1_92 = {}
  L2_93 = {}
  L3_94 = {}
  L4_95 = string
  L4_95 = L4_95.rep
  L5_96 = " "
  L6_97 = 2
  L4_95 = L4_95(L5_96, L6_97)
  L5_96 = 0
  function L6_97(A0_98, A1_99)
    local L2_100, L3_101, L4_102, L5_103, L6_104, L7_105, L8_106
    L2_100 = type
    L2_100 = L2_100(L3_101)
    if L2_100 == "number" then
      L2_100 = L1_1.insert
      L2_100(L3_101, L4_102)
    else
      L2_100 = type
      L2_100 = L2_100(L3_101)
      if L2_100 == "string" then
        L2_100 = L1_1.insert
        L6_104 = A0_98
        L8_106 = L4_102(L5_103, L6_104)
        L2_100(L3_101, L4_102, L5_103, L6_104, L7_105, L8_106, L4_102(L5_103, L6_104))
      else
        L2_100 = type
        L2_100 = L2_100(L3_101)
        if L2_100 == "table" then
          L2_100 = getmetatable
          L2_100 = L2_100(L3_101)
          if L2_100 then
            if L3_101 then
              L6_104 = A0_98
              L8_106 = L5_103(L6_104)
              L3_101(L4_102, L5_103, L6_104, L7_105, L8_106, L5_103(L6_104))
            end
          else
            L5_96 = L3_101
            L3_101(L4_102, L5_103)
            for L6_104, L7_105 in L3_101(L4_102) do
              L8_106 = L4_4
              if L7_105 == L8_106 then
                L8_106 = L1_1.insert
                L8_106(L1_92, string.format("\r\n%s%s\t=%s ;", string.rep(L4_95, L5_96 - 1), L6_104, "_G"))
              else
                L8_106 = package
                L8_106 = L8_106.loaded
                if L7_105 ~= L8_106 then
                  L8_106 = tonumber
                  L8_106 = L8_106(L6_104)
                  if L8_106 then
                    L8_106 = string
                    L8_106 = L8_106.format
                    L8_106 = L8_106("[%s]", L6_104)
                    L6_104 = L8_106
                  else
                    L8_106 = string
                    L8_106 = L8_106.format
                    L8_106 = L8_106("[\"%s\"]", L6_104)
                    L6_104 = L8_106
                  end
                  L8_106 = L1_1.insert
                  L8_106(L1_92, string.format("\r\n%s%s\t= ", string.rep(L4_95, L5_96 - 1), L6_104))
                  L8_106 = L24_24
                  if L7_105 == L8_106 then
                    L8_106 = L1_1.insert
                    L8_106(L1_92, string.format("%s ;", "nil"))
                  else
                    L8_106 = type
                    L8_106 = L8_106(L7_105)
                    if L8_106 == "table" then
                      L8_106 = tostring
                      L8_106 = L8_106(L7_105)
                      L8_106 = L2_93[L8_106]
                      if L8_106 == nil then
                        L8_106 = tostring
                        L8_106 = L8_106(L7_105)
                        L2_93[L8_106] = L7_105
                        L8_106 = A1_99
                        L8_106 = L8_106 .. L6_104
                        L2_93[tostring(L7_105)] = L8_106
                        L6_97(L7_105, L8_106)
                      else
                        L8_106 = L1_1.insert
                        L8_106(L1_92, tostring(L2_93[tostring(L7_105)]))
                        L8_106 = L1_1.insert
                        L8_106(L1_92, ";")
                      end
                    else
                      L8_106 = L6_97
                      L8_106(L7_105, A1_99)
                    end
                  end
                end
              end
            end
            L6_104 = "\r\n%s}"
            L7_105 = string
            L7_105 = L7_105.rep
            L8_106 = L4_95
            L8_106 = L7_105(L8_106, L5_96 - 1)
            L8_106 = L5_103(L6_104, L7_105, L8_106, L7_105(L8_106, L5_96 - 1))
            L3_101(L4_102, L5_103, L6_104, L7_105, L8_106, L5_103(L6_104, L7_105, L8_106, L7_105(L8_106, L5_96 - 1)))
            L5_96 = L3_101
          end
        else
          L2_100 = L1_1.insert
          L8_106 = L4_102(L5_103)
          L2_100(L3_101, L4_102, L5_103, L6_104, L7_105, L8_106, L4_102(L5_103))
        end
      end
    end
    L2_100 = L1_1.insert
    L2_100(L3_101, L4_102)
    L2_100 = L1_92
    return L2_100
  end
  L1_92 = L6_97(A0_91, "")
  return L1_1.concat(L1_92)
end
L9_9.dump = L25_25
function L25_25()
  local L0_107, L1_108, L2_109, L3_110, L4_111, L5_112, L6_113, L7_114, L8_115, L9_116, L10_117, L11_118, L12_119, L13_120, L14_121, L15_122, L16_123
  L0_107 = {}
  for L4_111 = 2, 16 do
    L5_112 = {}
    L6_113 = debug
    L6_113 = L6_113.getinfo
    L7_114 = L4_111
    L6_113 = L6_113(L7_114)
    if L6_113 ~= nil then
      L7_114 = L1_1.insert
      L8_115 = L0_107
      L9_116 = L5_112
      L7_114(L8_115, L9_116)
      L5_112.info = L6_113
      L7_114 = L6_113.func
      L8_115 = L6_113.nups
      L9_116 = {}
      L5_112.upvalues = L9_116
      for L13_120 = 1, L8_115 do
        L14_121 = debug
        L14_121 = L14_121.getupvalue
        L15_122 = L7_114
        L16_123 = L13_120
        L15_122 = L14_121(L15_122, L16_123)
        if L15_122 == nil then
          L15_122 = L24_24
        end
        L16_123 = string
        L16_123 = L16_123.byte
        L16_123 = L16_123(L14_121)
        if L16_123 == 40 then
          L16_123 = L9_116[L14_121]
          if L16_123 == nil then
            L16_123 = {}
            L9_116[L14_121] = L16_123
          end
          L16_123 = L1_1.insert
          L16_123(L9_116[L14_121], L15_122)
        else
          L9_116[L14_121] = L15_122
        end
      end
      L5_112.localvalues = L10_117
      L10_117.vararg = L11_118
      for L14_121 = -1, -255, -1 do
        L15_122 = debug
        L15_122 = L15_122.getlocal
        L16_123 = L4_111
        L16_123 = L15_122(L16_123, L14_121)
        if L15_122 ~= nil then
          if L16_123 == nil then
            L16_123 = L24_24
          end
          L1_1.insert(L10_117.vararg, L16_123)
        end
      end
      for L14_121 = 1, 255 do
        L15_122 = debug
        L15_122 = L15_122.getlocal
        L16_123 = L4_111
        L16_123 = L15_122(L16_123, L14_121)
        if L15_122 ~= nil then
          if L16_123 == nil then
            L16_123 = L24_24
          end
          if string.byte(L15_122) == 40 then
            if L10_117[L15_122] == nil then
              L10_117[L15_122] = {}
            end
            L1_1.insert(L10_117[L15_122], L16_123)
          else
            L10_117[L15_122] = L16_123
          end
        end
      end
    end
  end
  L16_123 = L2_109(L3_110)
  L1_108(L2_109, L3_110, L4_111, L5_112, L6_113, L7_114, L8_115, L9_116, L10_117, L11_118, L12_119, L13_120, L14_121, L15_122, L16_123, L2_109(L3_110))
end
L9_9.printstack = L25_25
L25_25 = activity
if L25_25 then
  function L25_25(...)
    local L1_125, L2_126, L3_127, L4_128
    L0_124 = {}
    L4_128 = ...
    for L4_128 = 1, L2_126(L3_127, L4_128, ...) do
      L1_1.insert(L0_124, tostring(select(L4_128, ...)))
    end
    L2_126(L3_127)
  end
  L9_9.print = L25_25
end
function L25_25()
  local L1_129
  L1_129 = luajava
  L1_129 = L1_129.ids
  return L1_129
end
L9_9.getids = L25_25
L25_25 = luajava
L25_25 = L25_25.bindClass
L26_26 = "com.androlua.LuaAsyncTask"
L25_25 = L25_25(L26_26)
L26_26 = luajava
L26_26 = L26_26.bindClass
L27_27 = "com.androlua.LuaThread"
L26_26 = L26_26(L27_27)
L27_27 = luajava
L27_27 = L27_27.bindClass
L28_28 = "com.androlua.LuaTimer"
L27_27 = L27_27(L28_28)
L28_28 = luajava
L28_28 = L28_28.bindClass
L29_29 = "java.lang.Object"
L28_28 = L28_28(L29_29)
function L29_29(A0_130, A1_131, A2_132)
  getmetatable(A0_130)[A1_131] = A2_132
end
function L30_30(A0_133, A1_134, A2_135)
  return getmetatable(A0_133)[A1_134]
end
L31_31 = L30_30
L32_32 = L26_26
L33_33 = "__index"
L31_31 = L31_31(L32_32, L33_33)
function L32_32(A0_136, A1_137)
  local L2_138
  function L2_138(...)
    if (...) then
      A0_136.call(A1_137, L28_28({
        ...
      }))
    else
      A0_136.call(A1_137)
    end
  end
  return L2_138
end
function L33_33(A0_139, A1_140)
  local L2_141, L3_142, L4_143
  L2_141 = pcall
  L3_142 = L31_31
  L4_143 = A0_139
  L3_142 = L2_141(L3_142, L4_143, A1_140)
  if L2_141 then
    return L3_142
  end
  L4_143 = L32_32
  L4_143 = L4_143(A0_139, A1_140)
  L29_29(A0_139, A1_140, L4_143)
  return L4_143
end
function L34_34(A0_144, A1_145, A2_146)
  A0_144.set(A1_145, A2_146)
end
function L35_35(A0_147)
  if A0_147:find("^[^/][%w%./_%-]+$") then
    if not A0_147:find("%.lua$") then
      A0_147 = string.format("%s/%s.lua", activity.luaDir, A0_147)
    else
      A0_147 = string.format("%s/%s", activity.luaDir, A0_147)
    end
  end
  return A0_147
end
function L36_36(A0_148, ...)
  L1_149 = type
  L1_149 = L1_149(A0_148)
  if L1_149 == "string" then
    L1_149 = L35_35
    L1_149 = L1_149(A0_148)
    A0_148 = L1_149
  end
  L1_149 = nil
  if (...) then
    L1_149 = L26_26(activity or service, A0_148, true, L28_28({
      ...
    }))
  else
    L1_149 = L26_26(activity or service, A0_148, true)
  end
  L1_149.start()
  return L1_149
end
L9_9.thread = L36_36
function L36_36(A0_150, ...)
  local L2_152
  L1_151 = {
    [2] = ...
  }
  L2_152 = ...
  ;({
    [2] = ...
  })[1] = L2_152
  L2_152 = select
  L2_152 = L2_152("#", ...)
  L2_152 = L1_151[L2_152]
  L1_151[select("#", ...)] = nil
  L25_25(activity or service, A0_150, L2_152).executeOnExecutor(L25_25.THREAD_POOL_EXECUTOR, L1_151)
  return (L25_25(activity or service, A0_150, L2_152))
end
L9_9.task = L36_36
function L36_36(A0_153, A1_154, A2_155, ...)
  L3_156 = L27_27
  L3_156 = L3_156(activity or service, A0_153, L28_28({
    ...
  }))
  if A2_155 == 0 then
    L3_156.start(A1_154)
  else
    L3_156.start(A1_154, A2_155)
  end
  return L3_156
end
L9_9.timer = L36_36
L36_36 = L23_23
L36_36(L4_4)
L36_36 = {}
function L36_36.__index(A0_157, A1_158)
  local L2_159, L3_160
  L2_159 = xpcall
  function L3_160()
    return luajava.bindClass((rawget(A0_157, "__name") or "") .. A1_158)
  end
  L3_160 = L2_159(L3_160, function()
    local L0_161
    L0_161 = {}
    L0_161.__name = (rawget(A0_157, "__name") or "") .. A1_158 .. "."
    setmetatable(L0_161, L36_36)
    return L0_161
  end)
  rawset(A0_157, A1_158, L3_160)
  return L3_160
end
setmetatable(luajava, L36_36)
return L23_23
