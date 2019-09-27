local L0_0, L1_1, L2_2, L3_3, L4_4, L5_5, L6_6, L7_7, L8_8, L9_9, L10_10, L11_11, L12_12, L13_13, L14_14, L15_15, L16_16, L17_17, L18_18, L19_19, L20_20, L21_21, L22_22, L23_23, L24_24, L25_25, L26_26, L27_27, L28_28, L29_29, L30_30, L31_31, L32_32, L33_33, L34_34, L35_35, L36_36, L37_37, L38_38, L39_39, L40_40, L41_41, L42_42, L43_43, L44_44, L45_45, L46_46, L47_47, L48_48, L49_49, L50_50, L51_51, L52_52, L53_53, L54_54
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
L7_7 = {}
L8_8 = activity
L8_8 = L8_8 or service
L9_9 = L6_6
L10_10 = "android.view.ViewGroup"
L9_9 = L9_9(L10_10)
L10_10 = L6_6
L11_11 = "java.lang.String"
L10_10 = L10_10(L11_11)
L11_11 = L6_6
L12_12 = "android.view.Gravity"
L11_11 = L11_11(L12_12)
L12_12 = L6_6
L13_13 = "android.view.View$OnClickListener"
L12_12 = L12_12(L13_13)
L13_13 = luajava
L13_13 = L13_13.bindClass
L14_14 = "android.util.TypedValue"
L13_13 = L13_13(L14_14)
L14_14 = luajava
L14_14 = L14_14.bindClass
L15_15 = "android.graphics.drawable.BitmapDrawable"
L14_14 = L14_14(L15_15)
L15_15 = luajava
L15_15 = L15_15.bindClass
L16_16 = "com.androlua.LuaDrawable"
L15_15 = L15_15(L16_16)
L16_16 = luajava
L16_16 = L16_16.bindClass
L17_17 = "com.androlua.LuaBitmapDrawable"
L16_16 = L16_16(L17_17)
L17_17 = luajava
L17_17 = L17_17.bindClass
L18_18 = "com.androlua.LuaAdapter"
L17_17 = L17_17(L18_18)
L18_18 = L6_6
L19_19 = "android.widget.ArrayListAdapter"
L18_18 = L18_18(L19_19)
L19_19 = L6_6
L20_20 = "android.widget.ArrayPageAdapter"
L19_19 = L19_19(L20_20)
L20_20 = L6_6
L21_21 = "android.widget.AdapterView"
L20_20 = L20_20(L21_21)
L21_21 = L6_6
L22_22 = "android.widget.ImageView$ScaleType"
L21_21 = L21_21(L22_22)
L22_22 = L6_6
L23_23 = "android.text.TextUtils$TruncateAt"
L22_22 = L22_22(L23_23)
L23_23 = L21_21.values
L23_23 = L23_23()
L24_24 = L6_6
L25_25 = "android.R"
L24_24 = L24_24(L25_25)
L25_25 = {}
L25_25.R = L24_24
android = L25_25
L25_25 = L6_6
L26_26 = "android.content.Context"
L25_25 = L25_25(L26_26)
L26_26 = L6_6
L27_27 = "android.util.DisplayMetrics"
L26_26 = L26_26(L27_27)
L27_27 = L8_8.getSystemService
L28_28 = L25_25.WINDOW_SERVICE
L27_27 = L27_27(L28_28)
L28_28 = L26_26
L28_28 = L28_28()
L29_29 = L27_27.getDefaultDisplay
L29_29 = L29_29()
L29_29 = L29_29.getMetrics
L30_30 = L28_28
L29_29(L30_30)
L29_29 = L28_28.widthPixels
L30_30 = L28_28.heightPixels
function L31_31(A0_55)
  local L1_56, L2_57, L3_58, L4_59, L5_60, L6_61, L7_62
  L1_56 = package
  L1_56 = L1_56.path
  L2_57 = L1_56
  L1_56 = L1_56.gsub
  L3_58 = "%.lua;"
  L4_59 = ".aly;"
  L1_56 = L1_56(L2_57, L3_58, L4_59)
  L2_57 = package
  L2_57 = L2_57.searchpath
  L3_58 = A0_55
  L4_59 = L1_56
  L3_58 = L2_57(L3_58, L4_59)
  if L3_58 then
    return L3_58
  end
  L4_59 = io
  L4_59 = L4_59.open
  L5_60 = L2_57
  L4_59 = L4_59(L5_60)
  L6_61 = L4_59
  L5_60 = L4_59.read
  L7_62 = "*a"
  L5_60 = L5_60(L6_61, L7_62)
  L7_62 = L4_59
  L6_61 = L4_59.close
  L6_61(L7_62)
  L6_61 = string
  L6_61 = L6_61.sub
  L7_62 = L5_60
  L6_61 = L6_61(L7_62, 1, 4)
  if L6_61 == "\027Lua" then
    L6_61 = assert
    L7_62 = loadfile
    L7_62 = L7_62(L2_57)
    L6_61 = L6_61(L7_62, L7_62(L2_57))
    L7_62 = L2_57
    return L6_61, L7_62
  else
    L6_61 = loadstring
    L7_62 = "return "
    L7_62 = L7_62 .. L5_60
    L7_62 = L6_61(L7_62, L2_57:match("[^/]+/[^/]+$"), "bt")
    if L7_62 then
      error(L7_62:gsub("%b[]", L2_57, 1), 0)
    end
    return L6_61, L7_62
  end
end
L32_32 = L1_1.insert
L33_33 = package
L33_33 = L33_33.searchers
L34_34 = L31_31
L32_32(L33_33, L34_34)
L32_32 = L8_8.getResources
L32_32 = L32_32()
L32_32 = L32_32.getDisplayMetrics
L32_32 = L32_32()
L33_33 = 2130706432
L34_34 = {}
L34_34.auto = 0
L34_34.low = 1
L34_34.high = 2
L34_34.auto = 0
L34_34.yes = 1
L34_34.no = 2
L34_34.none = 0
L34_34.software = 1
L34_34.hardware = 2
L34_34.ltr = 0
L34_34.rtl = 1
L34_34.inherit = 2
L34_34.locale = 3
L34_34.insideOverlay = 0
L34_34.insideInset = 16777216
L34_34.outsideOverlay = 33554432
L34_34.outsideInset = 50331648
L34_34.visible = 0
L34_34.invisible = 4
L34_34.gone = 8
L34_34.wrap_content = -2
L34_34.fill_parent = -1
L34_34.match_parent = -1
L34_34.wrap = -2
L34_34.fill = -1
L34_34.match = -1
L34_34.none = 0
L34_34.web = 1
L34_34.email = 2
L34_34.phon = 4
L34_34.map = 8
L34_34.all = 15
L34_34.vertical = 1
L34_34.horizontal = 0
L34_34.axis_clip = 8
L34_34.axis_pull_after = 4
L34_34.axis_pull_before = 2
L34_34.axis_specified = 1
L34_34.axis_x_shift = 0
L34_34.axis_y_shift = 4
L34_34.bottom = 80
L34_34.center = 17
L34_34.center_horizontal = 1
L34_34.center_vertical = 16
L34_34.clip_horizontal = 8
L34_34.clip_vertical = 128
L34_34.display_clip_horizontal = 16777216
L34_34.display_clip_vertical = 268435456
L34_34.fill_horizontal = 7
L34_34.fill_vertical = 112
L34_34.horizontal_gravity_mask = 7
L34_34.left = 3
L34_34.no_gravity = 0
L34_34.relative_horizontal_gravity_mask = 8388615
L34_34.relative_layout_direction = 8388608
L34_34.right = 5
L34_34.start = 8388611
L34_34.top = 48
L34_34.vertical_gravity_mask = 112
L34_34["end"] = 8388613
L34_34.inherit = 0
L34_34.gravity = 1
L34_34.textStart = 2
L34_34.textEnd = 3
L34_34.textCenter = 4
L34_34.viewStart = 5
L34_34.viewEnd = 6
L34_34.none = 0
L34_34.text = 1
L34_34.textCapCharacters = 4097
L34_34.textCapWords = 8193
L34_34.textCapSentences = 16385
L34_34.textAutoCorrect = 32769
L34_34.textAutoComplete = 65537
L34_34.textMultiLine = 131073
L34_34.textImeMultiLine = 262145
L34_34.textNoSuggestions = 524289
L34_34.textUri = 17
L34_34.textEmailAddress = 33
L34_34.textEmailSubject = 49
L34_34.textShortMessage = 65
L34_34.textLongMessage = 81
L34_34.textPersonName = 97
L34_34.textPostalAddress = 113
L34_34.textPassword = 129
L34_34.textVisiblePassword = 145
L34_34.textWebEditText = 161
L34_34.textFilter = 177
L34_34.textPhonetic = 193
L34_34.textWebEmailAddress = 209
L34_34.textWebPassword = 225
L34_34.number = 2
L34_34.numberSigned = 4098
L34_34.numberDecimal = 8194
L34_34.numberPassword = 18
L34_34.phone = 3
L34_34.datetime = 4
L34_34.date = 20
L34_34.time = 36
L34_34.normal = 0
L34_34.actionUnspecified = 0
L34_34.actionNone = 1
L34_34.actionGo = 2
L34_34.actionSearch = 3
L34_34.actionSend = 4
L34_34.actionNext = 5
L34_34.actionDone = 6
L34_34.actionPrevious = 7
L34_34.flagNoFullscreen = 33554432
L34_34.flagNavigatePrevious = 67108864
L34_34.flagNavigateNext = 134217728
L34_34.flagNoExtractUi = 268435456
L34_34.flagNoAccessoryAction = 536870912
L34_34.flagNoEnterAction = 1073741824
L34_34.flagForceAscii = 2147483648
L35_35 = {}
L35_35.matrix = 0
L35_35.fitXY = 1
L35_35.fitStart = 2
L35_35.fitCenter = 3
L35_35.fitEnd = 4
L35_35.center = 5
L35_35.centerCrop = 6
L35_35.centerInside = 7
L36_36 = {}
L36_36.layout_above = 2
L36_36.layout_alignBaseline = 4
L36_36.layout_alignBottom = 8
L36_36.layout_alignEnd = 19
L36_36.layout_alignLeft = 5
L36_36.layout_alignParentBottom = 12
L36_36.layout_alignParentEnd = 21
L36_36.layout_alignParentLeft = 9
L36_36.layout_alignParentRight = 11
L36_36.layout_alignParentStart = 20
L36_36.layout_alignParentTop = 10
L36_36.layout_alignRight = 7
L36_36.layout_alignStart = 18
L36_36.layout_alignTop = 6
L36_36.layout_alignWithParentIfMissing = 0
L36_36.layout_below = 3
L36_36.layout_centerHorizontal = 14
L36_36.layout_centerInParent = 13
L36_36.layout_centerVertical = 15
L36_36.layout_toEndOf = 17
L36_36.layout_toLeftOf = 0
L36_36.layout_toRightOf = 1
L36_36.layout_toStartOf = 16
L37_37 = {}
L37_37.px = 0
L37_37.dp = 1
L37_37.sp = 2
L37_37.pt = 3
L37_37["in"] = 4
L37_37.mm = 5
function L38_38(A0_63)
  local L1_64, L2_65, L3_66, L4_67
  L1_64 = string
  L1_64 = L1_64.match
  L2_65 = A0_63
  L3_66 = "^(%-?[%.%d]+)(%a%a)$"
  L2_65 = L1_64(L2_65, L3_66)
  L3_66 = tonumber
  L4_67 = L1_64
  L3_66 = L3_66(L4_67)
  L4_67 = L37_37[L2_65]
  return L3_66, L4_67
end
function L39_39(A0_68)
  local L1_69
  L1_69 = string
  L1_69 = L1_69.match
  L1_69 = L1_69(A0_68, "^(%-?[%.%d]+)%%([wh])$")
  if L1_69(A0_68, "^(%-?[%.%d]+)%%([wh])$") == nil then
    return nil
  elseif L1_69(A0_68, "^(%-?[%.%d]+)%%([wh])$") == "w" then
    return tonumber(L1_69) * L29_29 / 100
  elseif L1_69(A0_68, "^(%-?[%.%d]+)%%([wh])$") == "h" then
    return tonumber(L1_69) * L30_30 / 100
  end
end
function L40_40(A0_70, A1_71)
  local L2_72, L3_73, L4_74
  L2_72 = 1
  L3_73 = #A0_70
  function L4_74()
    if L2_72 >= L3_73 then
      return nil
    end
    if A0_70:find(A1_71, L2_72) == nil then
    end
    L2_72 = L3_73 + 1 + 1
    return (A0_70:sub(L2_72, L3_73 + 1 - 1))
  end
  return L4_74
end
function L41_41(A0_75)
  local L1_76
  L1_76 = 0
  for _FORV_5_ in L40_40(A0_75, "|") do
    if L34_34[_FORV_5_] then
      L1_76 = L1_76 | L34_34[_FORV_5_]
    else
      return nil
    end
  end
  return L1_76
end
function L42_42(A0_77)
  local L1_78, L2_79, L3_80, L4_81, L5_82
  L1_78 = type
  L2_79 = A0_77
  L1_78 = L1_78(L2_79)
  if L1_78 == "string" then
    if A0_77 == "true" then
      L1_78 = true
      return L1_78
    elseif A0_77 == "false" then
      L1_78 = false
      return L1_78
    end
    L1_78 = L34_34[A0_77]
    if L1_78 then
      L1_78 = L34_34[A0_77]
      return L1_78
    end
    L1_78 = L39_39
    L2_79 = A0_77
    L1_78 = L1_78(L2_79)
    if L1_78 then
      return L1_78
    end
    L2_79 = L41_41
    L3_80 = A0_77
    L2_79 = L2_79(L3_80)
    if L2_79 then
      return L2_79
    end
    L3_80 = string
    L3_80 = L3_80.match
    L4_81 = A0_77
    L5_82 = "^#(%x+)$"
    L3_80 = L3_80(L4_81, L5_82)
    if L3_80 then
      L4_81 = tonumber
      L5_82 = L3_80
      L4_81 = L4_81(L5_82, 16)
      if L4_81 then
        L5_82 = #L3_80
        if L5_82 <= 6 then
          L5_82 = L4_81 - 16777216
          return L5_82
        else
          L5_82 = #L3_80
          if L5_82 <= 8 then
            if L4_81 > 2147483647 then
              L5_82 = L4_81 - 4294967296
              return L5_82
            else
              return L4_81
            end
          end
        end
      end
    end
    L4_81 = L38_38
    L5_82 = A0_77
    L5_82 = L4_81(L5_82)
    if L5_82 then
      return L13_13.applyDimension(L5_82, L4_81, L32_32)
    end
  end
end
function L43_43(A0_83)
  return tonumber(A0_83) or L42_42(A0_83) or A0_83
end
function L44_44(...)
  L0_84 = {
    ...
  }
  for _FORV_4_ = 1, #L0_84 do
    L0_84[_FORV_4_] = L43_43(L0_84[_FORV_4_])
  end
  return unpack(L0_84)
end
function L45_45(A0_85)
  return L24_24.attr[A0_85]
end
function L46_46(A0_86)
  if pcall(L45_45, A0_86) then
    return pcall(L45_45, A0_86)
  end
  return nil
end
function L47_47(A0_87)
  return L8_8.getResources().getIdentifier(A0_87, null, null)
end
function L48_48(A0_88)
  local L1_89, L2_90, L3_91, L4_92, L5_93, L6_94
  L1_89 = {}
  L5_93 = A0_88
  L6_94 = L4_92(L5_93)
  L2_90(L3_91, L4_92, L5_93, L6_94, L4_92(L5_93))
  L2_90(L3_91, L4_92)
  for L5_93, L6_94 in L2_90(L3_91) do
    if type(L6_94) == "table" then
      L1_1.insert(L1_89, "\t\t" .. tostring(L5_93) .. "={" .. tostring(L6_94[1]) .. " ...}")
    else
      L1_1.insert(L1_89, "\t\t" .. tostring(L5_93) .. "=" .. tostring(L6_94))
    end
  end
  L2_90(L3_91, L4_92)
  A0_88 = L2_90
  return A0_88
end
L49_49 = luajava
L49_49 = L49_49.bindClass
L50_50 = "android.os.Build"
L49_49 = L49_49(L50_50)
L49_49 = L49_49.VERSION
L50_50 = "SDK_INT"
L49_49 = L49_49[L50_50]
function L50_50(A0_95, A1_96)
  if L49_49 < 16 then
    A0_95.setBackgroundDrawable(A1_96)
  else
    A0_95.setBackground(A1_96)
  end
end
function L51_51(A0_97, A1_98, A2_99, A3_100, A4_101, A5_102)
  local L6_103, L7_104, L8_105, L9_106, L10_107, L11_108
  if A3_100 == "layout_x" then
    L6_103 = L43_43
    L6_103 = L6_103(L7_104)
    A2_99.x = L6_103
  elseif A3_100 == "layout_y" then
    L6_103 = L43_43
    L6_103 = L6_103(L7_104)
    A2_99.y = L6_103
  elseif A3_100 == "layout_weight" then
    L6_103 = L43_43
    L6_103 = L6_103(L7_104)
    A2_99.weight = L6_103
  elseif A3_100 == "layout_gravity" then
    L6_103 = L43_43
    L6_103 = L6_103(L7_104)
    A2_99.gravity = L6_103
  elseif A3_100 == "layout_marginStart" then
    L6_103 = A2_99.setMarginStart
    L11_108 = L7_104(L8_105)
    L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L7_104(L8_105))
  elseif A3_100 == "layout_marginEnd" then
    L6_103 = A2_99.setMarginEnd
    L11_108 = L7_104(L8_105)
    L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L7_104(L8_105))
  else
    L6_103 = L36_36[A3_100]
    if L6_103 and (A4_101 == true or A4_101 == "true") then
      L6_103 = A2_99.addRule
      L6_103(L7_104)
    else
      L6_103 = L36_36[A3_100]
      if L6_103 then
        L6_103 = A2_99.addRule
        L6_103(L7_104, L8_105)
      elseif A3_100 == "items" then
        L6_103 = type
        L6_103 = L6_103(L7_104)
        if L6_103 == "table" then
          L6_103 = A1_98.adapter
          if L6_103 then
            L6_103 = A1_98.adapter
            L6_103 = L6_103.addAll
            L6_103(L7_104)
          else
            L6_103 = L18_18
            L10_107 = A4_101
            L11_108 = L9_106(L10_107)
            L6_103 = L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L9_106(L10_107))
            L7_104(L8_105)
          end
        else
          L6_103 = type
          L6_103 = L6_103(L7_104)
          if L6_103 == "function" then
            L6_103 = A1_98.adapter
            if L6_103 then
              L6_103 = A1_98.adapter
              L6_103 = L6_103.addAll
              L11_108 = L7_104()
              L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L7_104())
            else
              L6_103 = L18_18
              L10_107 = A4_101
              L11_108 = L10_107()
              L11_108 = L9_106(L10_107, L11_108, L10_107())
              L6_103 = L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L9_106(L10_107, L11_108, L10_107()))
              L7_104(L8_105)
            end
          else
            L6_103 = type
            L6_103 = L6_103(L7_104)
            if L6_103 == "string" then
              L6_103 = rawget
              L6_103 = L6_103(L7_104, L8_105)
              if not L6_103 then
                L6_103 = rawget
                L6_103 = L6_103(L7_104, L8_105)
              end
              if L7_104 then
                L11_108 = L8_105()
                L7_104(L8_105, L9_106, L10_107, L11_108, L8_105())
              else
                L10_107 = L10_10
                L11_108 = L6_103
                L11_108 = L11_108()
                L11_108 = L10_107(L11_108, L11_108())
                L8_105(L9_106)
              end
            end
          end
        end
      elseif A3_100 == "pages" then
        L6_103 = type
        L6_103 = L6_103(L7_104)
        if L6_103 == "table" then
          L6_103 = {}
          for L10_107, L11_108 in L7_104(L8_105) do
            if type(L11_108) == "string" or type(L11_108) == "table" then
              L1_1.insert(L6_103, loadlayout(L11_108, A0_97))
            else
              L1_1.insert(L6_103, L11_108)
            end
          end
          L11_108 = L8_105(L9_106)
          L8_105(L9_106)
        end
      elseif A3_100 == "textSize" then
        L6_103 = tonumber
        L6_103 = L6_103(L7_104)
        if L6_103 then
          L6_103 = A1_98.setTextSize
          L11_108 = L7_104(L8_105)
          L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L7_104(L8_105))
        else
          L6_103 = type
          L6_103 = L6_103(L7_104)
          if L6_103 == "string" then
            L6_103 = L38_38
            L6_103 = L6_103(L7_104)
            if L7_104 then
              L10_107 = L6_103
              L8_105(L9_106, L10_107)
            else
              L8_105(L9_106)
            end
          else
            L6_103 = A1_98.setTextSize
            L6_103(L7_104)
          end
        end
      elseif A3_100 == "textAppearance" then
        L6_103 = A1_98.setTextAppearance
        L11_108 = L8_105(L9_106)
        L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L8_105(L9_106))
      elseif A3_100 == "ellipsize" then
        L6_103 = A1_98.setEllipsize
        L6_103(L7_104)
      elseif A3_100 == "url" then
        L6_103 = A1_98.loadUrl
        L6_103(L7_104)
      elseif A3_100 == "src" then
        L6_103 = A4_101.find
        L6_103 = L6_103(L7_104, L8_105)
        if L6_103 then
          L6_103 = A1_98.setImageResource
          L10_107 = 2
          L11_108 = -1
          L11_108 = L8_105(L9_106, L10_107, L11_108)
          L11_108 = L7_104(L8_105, L9_106, L10_107, L11_108, L8_105(L9_106, L10_107, L11_108))
          L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L7_104(L8_105, L9_106, L10_107, L11_108, L8_105(L9_106, L10_107, L11_108)))
        else
          L6_103 = A4_101.find
          L6_103 = L6_103(L7_104, L8_105)
          if L6_103 then
            L6_103 = task
            L6_103(L7_104, L8_105, L9_106)
          else
            L6_103 = A1_98.setImageBitmap
            L11_108 = L7_104(L8_105)
            L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L7_104(L8_105))
          end
        end
      elseif A3_100 == "scaleType" then
        L6_103 = A1_98.setScaleType
        L6_103(L7_104)
      elseif A3_100 == "background" then
        L6_103 = type
        L6_103 = L6_103(L7_104)
        if L6_103 == "string" then
          L6_103 = A4_101.find
          L6_103 = L6_103(L7_104, L8_105)
          if L6_103 then
            L6_103 = A1_98.setBackgroundResource
            L10_107 = 2
            L11_108 = -1
            L11_108 = L8_105(L9_106, L10_107, L11_108)
            L11_108 = L7_104(L8_105, L9_106, L10_107, L11_108, L8_105(L9_106, L10_107, L11_108))
            L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L7_104(L8_105, L9_106, L10_107, L11_108, L8_105(L9_106, L10_107, L11_108)))
          else
            L6_103 = A4_101.find
            L6_103 = L6_103(L7_104, L8_105)
            if L6_103 then
              L6_103 = A1_98.setBackgroundColor
              L11_108 = L7_104(L8_105)
              L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L7_104(L8_105))
            else
              L6_103 = rawget
              L6_103 = L6_103(L7_104, L8_105)
              if not L6_103 then
                L6_103 = rawget
                L6_103 = L6_103(L7_104, L8_105)
              else
                if L6_103 then
                  L6_103 = rawget
                  L6_103 = L6_103(L7_104, L8_105)
                  A4_101 = L6_103 or L6_103
                  L6_103 = type
                  L6_103 = L6_103(L7_104)
                  if L6_103 == "function" then
                    L6_103 = L50_50
                    L11_108 = L8_105(L9_106)
                    L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L8_105(L9_106))
                  else
                    L6_103 = type
                    L6_103 = L6_103(L7_104)
                    if L6_103 == "userdata" then
                      L6_103 = L50_50
                      L6_103(L7_104, L8_105)
                    end
                  end
              end
              else
                L6_103 = A4_101.find
                L6_103 = L6_103(L7_104, L8_105)
                if not L6_103 then
                  L6_103 = luadir
                  if L6_103 then
                    L6_103 = luadir
                    A4_101 = L6_103 .. L7_104
                  end
                end
                L6_103 = A4_101.find
                L6_103 = L6_103(L7_104, L8_105)
                if L6_103 then
                  L6_103 = L50_50
                  L10_107 = A4_101
                  L11_108 = L9_106(L10_107)
                  L11_108 = L8_105(L9_106, L10_107, L11_108, L9_106(L10_107))
                  L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L8_105(L9_106, L10_107, L11_108, L9_106(L10_107)))
                else
                  L6_103 = L50_50
                  L10_107 = A4_101
                  L11_108 = L8_105(L9_106, L10_107)
                  L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L8_105(L9_106, L10_107))
                end
              end
            end
          end
        else
          L6_103 = type
          L6_103 = L6_103(L7_104)
          if L6_103 == "userdata" then
            L6_103 = L50_50
            L6_103(L7_104, L8_105)
          else
            L6_103 = type
            L6_103 = L6_103(L7_104)
            if L6_103 == "number" then
              L6_103 = L50_50
              L6_103(L7_104, L8_105)
            end
          end
        end
      elseif A3_100 == "onClick" then
        L6_103 = nil
        if L7_104 == "function" then
          L8_105.onClick = A4_101
          L6_103 = L7_104
        elseif L7_104 == "userdata" then
          L6_103 = A4_101
        elseif L7_104 == "string" then
          if L7_104 then
            L6_103 = L7_7[A4_101]
          else
            if L8_105 == "function" then
              L9_106.onClick = L7_104
              L6_103 = L8_105
            elseif L8_105 == "userdata" then
              L6_103 = L7_104
            else
              function L10_107(A0_109)
                ;(A0_97[A4_101] or L3_3[A4_101])(A0_109)
              end
              L9_106.onClick = L10_107
              L6_103 = L8_105
            end
            L7_7[A4_101] = L6_103
          end
        end
        L7_104(L8_105)
      elseif A3_100 == "password" and (A4_101 == "true" or A4_101 == true) then
        L6_103 = A1_98.setInputType
        L6_103(L7_104)
      else
        L6_103 = type
        L6_103 = L6_103(L7_104)
        if L6_103 == "string" then
          L6_103 = A3_100.find
          L6_103 = L6_103(L7_104, L8_105)
          if not L6_103 then
            L6_103 = A3_100.find
            L6_103 = L6_103(L7_104, L8_105)
            if not L6_103 and A3_100 ~= "style" then
              L6_103 = string
              L6_103 = L6_103.gsub
              L6_103 = L6_103(L7_104, L8_105, L9_106)
              A3_100 = L6_103
              if A3_100 == "Text" or A3_100 == "Title" or A3_100 == "Subtitle" then
                L6_103 = "set"
                L6_103 = L6_103 .. L7_104
                L6_103 = A1_98[L6_103]
                L6_103(L7_104)
              else
                L6_103 = A3_100.find
                L6_103 = L6_103(L7_104, L8_105)
                if not L6_103 then
                  L6_103 = A3_100.find
                  L6_103 = L6_103(L7_104, L8_105)
                  if not L6_103 then
                    L6_103 = type
                    L6_103 = L6_103(L7_104)
                    if L6_103 == "table" then
                      L6_103 = "set"
                      L6_103 = L6_103 .. L7_104
                      L6_103 = A1_98[L6_103]
                      L11_108 = L8_105(L9_106)
                      L11_108 = L7_104(L8_105, L9_106, L10_107, L11_108, L8_105(L9_106))
                      L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L7_104(L8_105, L9_106, L10_107, L11_108, L8_105(L9_106)))
                    end
                  end
                else
                  L6_103 = "set"
                  L6_103 = L6_103 .. L7_104
                  L6_103 = A1_98[L6_103]
                  L11_108 = L7_104(L8_105)
                  L6_103(L7_104, L8_105, L9_106, L10_107, L11_108, L7_104(L8_105))
                end
              end
            end
          end
        end
      end
    end
  end
end
function L52_52(A0_110, A1_111, A2_112)
  for _FORV_6_, _FORV_7_ in pairs(A0_110) do
    if _FORV_6_ == 1 then
    elseif A2_112 or A1_111[_FORV_6_] == nil then
      A1_111[_FORV_6_] = _FORV_7_
    end
  end
end
function L53_53(A0_113, A1_114, A2_115, A3_116, A4_117, A5_118)
  local L6_119, L7_120, L8_121, L9_122, L10_123, L11_124, L12_125
  L6_119 = getmetatable
  L7_120 = A1_114
  L6_119 = L6_119(L7_120)
  if L6_119 then
    L7_120 = L6_119.__index
  elseif not L7_120 then
    return
  end
  L7_120 = L6_119.__index
  if L8_121 then
    return
  end
  A0_113[L7_120] = true
  for L11_124, L12_125 in L8_121(L9_122) do
    if not rawget(A0_113, L11_124) then
      pcall(L51_51, A2_115, A3_116, A4_117, L11_124, L12_125, A5_118)
    end
    A0_113[L11_124] = true
  end
  L11_124 = A2_115
  L12_125 = A3_116
  L8_121(L9_122, L10_123, L11_124, L12_125, A4_117, A5_118)
end
function L54_54(A0_126, A1_127, A2_128)
  local L3_129, L4_130, L5_131, L6_132, L7_133, L8_134, L9_135, L10_136, L11_137, L12_138, L13_139
  L3_129 = type
  L4_130 = A0_126
  L3_129 = L3_129(L4_130)
  if L3_129 == "string" then
    L3_129 = L0_0
    L4_130 = A0_126
    L3_129 = L3_129(L4_130)
    A0_126 = L3_129
  else
    L3_129 = type
    L4_130 = A0_126
    L3_129 = L3_129(L4_130)
    if L3_129 ~= "table" then
      L3_129 = error
      L4_130 = string
      L4_130 = L4_130.format
      L5_131 = "loadlayout error: Fist value Must be a table, checked import layout."
      L6_132 = 0
      L13_139 = L4_130(L5_131, L6_132)
      L3_129(L4_130, L5_131, L6_132, L7_133, L8_134, L9_135, L10_136, L11_137, L12_138, L13_139, L4_130(L5_131, L6_132))
    end
  end
  A1_127 = A1_127 or L3_3
  L3_129, L4_130 = nil, nil
  L5_131 = A0_126.style
  if L5_131 then
    L5_131 = A0_126.style
    L6_132 = L5_131
    L5_131 = L5_131.find
    L5_131 = L5_131(L6_132, L7_133)
    if L5_131 then
      L5_131 = L47_47
      L6_132 = A0_126.style
      L6_132 = L6_132.sub
      L13_139 = L6_132(L7_133, L8_134, L9_135)
      L5_131 = L5_131(L6_132, L7_133, L8_134, L9_135, L10_136, L11_137, L12_138, L13_139, L6_132(L7_133, L8_134, L9_135))
      L4_130 = L5_131
    else
      L5_131 = pcall
      L6_132 = L0_0
      L6_132 = L5_131(L6_132, L7_133)
      if L5_131 then
        L9_135.__index = L6_132
        L7_133(L8_134, L9_135)
      else
        L4_130 = L7_133
      end
    end
  end
  L5_131 = A0_126[1]
  if not L5_131 then
    L5_131 = error
    L6_132 = string
    L6_132 = L6_132.format
    L13_139 = L8_134(L9_135)
    L6_132 = L6_132(L7_133, L8_134, L9_135, L10_136, L11_137, L12_138, L13_139, L8_134(L9_135))
    L5_131(L6_132, L7_133)
  end
  if L4_130 then
    L5_131 = A0_126[1]
    L6_132 = L8_8
    L5_131 = L5_131(L6_132, L7_133, L8_134)
    L3_129 = L5_131
  else
    L5_131 = A0_126[1]
    L6_132 = L8_8
    L5_131 = L5_131(L6_132)
    L3_129 = L5_131
  end
  L5_131 = L9_9.LayoutParams
  L6_132 = L43_43
  L6_132 = L6_132(L7_133)
  L6_132 = L6_132 or -2
  L5_131 = L5_131(L6_132, L7_133)
  if A2_128 then
    L6_132 = A2_128.LayoutParams
    L6_132 = L6_132(L7_133)
    L5_131 = L6_132
  end
  L6_132 = A0_126.layout_margin
  if not L6_132 then
    L6_132 = A0_126.layout_marginStart
    if not L6_132 then
      L6_132 = A0_126.layout_marginEnd
      if not L6_132 then
        L6_132 = A0_126.layout_marginLeft
        if not L6_132 then
          L6_132 = A0_126.layout_marginTop
          if not L6_132 then
            L6_132 = A0_126.layout_marginRight
            L6_132 = L6_132 or A0_126.layout_marginBottom
          end
        end
      end
    end
  elseif L6_132 then
    L6_132 = L5_131.setMargins
    L10_136 = A0_126.layout_marginRight
    if not L10_136 then
      L10_136 = A0_126.layout_margin
      L10_136 = L10_136 or 0
    end
    L11_137 = A0_126.layout_marginBottom
    if not L11_137 then
      L11_137 = A0_126.layout_margin
      L11_137 = L11_137 or 0
    end
    L13_139 = L7_133(L8_134, L9_135, L10_136, L11_137)
    L6_132(L7_133, L8_134, L9_135, L10_136, L11_137, L12_138, L13_139, L7_133(L8_134, L9_135, L10_136, L11_137))
  end
  L6_132 = A0_126.padding
  if L6_132 then
    L6_132 = type
    L6_132 = L6_132(L7_133)
    if L6_132 == "table" then
      L6_132 = L3_129.setPadding
      L13_139 = L8_134(L9_135)
      L13_139 = L7_133(L8_134, L9_135, L10_136, L11_137, L12_138, L13_139, L8_134(L9_135))
      L6_132(L7_133, L8_134, L9_135, L10_136, L11_137, L12_138, L13_139, L7_133(L8_134, L9_135, L10_136, L11_137, L12_138, L13_139, L8_134(L9_135)))
    end
  else
    L6_132 = A0_126.padding
    if not L6_132 then
      L6_132 = A0_126.paddingLeft
      if not L6_132 then
        L6_132 = A0_126.paddingTop
        if not L6_132 then
          L6_132 = A0_126.paddingRight
          L6_132 = L6_132 or A0_126.paddingBottom
        end
      end
    elseif L6_132 then
      L6_132 = L3_129.setPadding
      L10_136 = A0_126.paddingRight
      if not L10_136 then
        L10_136 = A0_126.padding
        L10_136 = L10_136 or 0
      end
      L11_137 = A0_126.paddingBottom
      if not L11_137 then
        L11_137 = A0_126.padding
        L11_137 = L11_137 or 0
      end
      L13_139 = L7_133(L8_134, L9_135, L10_136, L11_137)
      L6_132(L7_133, L8_134, L9_135, L10_136, L11_137, L12_138, L13_139, L7_133(L8_134, L9_135, L10_136, L11_137))
    end
  end
  L6_132 = A0_126.paddingStart
  if not L6_132 then
    L6_132 = A0_126.paddingEnd
  elseif L6_132 then
    L6_132 = L3_129.setPaddingRelative
    L10_136 = A0_126.paddingEnd
    if not L10_136 then
      L10_136 = A0_126.padding
      L10_136 = L10_136 or 0
    end
    L11_137 = A0_126.paddingBottom
    if not L11_137 then
      L11_137 = A0_126.padding
      L11_137 = L11_137 or 0
    end
    L13_139 = L7_133(L8_134, L9_135, L10_136, L11_137)
    L6_132(L7_133, L8_134, L9_135, L10_136, L11_137, L12_138, L13_139, L7_133(L8_134, L9_135, L10_136, L11_137))
  end
  L6_132 = {}
  L9_135.__index = A0_126
  L7_133(L8_134, L9_135)
  L10_136 = A1_127
  L11_137 = L3_129
  L12_138 = L5_131
  L13_139 = L2_2
  L7_133(L8_134, L9_135, L10_136, L11_137, L12_138, L13_139)
  for L10_136, L11_137 in L7_133(L8_134) do
    L12_138 = tonumber
    L13_139 = L10_136
    L12_138 = L12_138(L13_139)
    if L12_138 then
      L12_138 = type
      L13_139 = L11_137
      L12_138 = L12_138(L13_139)
      if L12_138 ~= "table" then
        L12_138 = type
        L13_139 = L11_137
        L12_138 = L12_138(L13_139)
      elseif L12_138 == "string" then
        L12_138 = luajava
        L12_138 = L12_138.instanceof
        L13_139 = L3_129
        L12_138 = L12_138(L13_139, L20_20)
        if L12_138 then
          L12_138 = type
          L13_139 = L11_137
          L12_138 = L12_138(L13_139)
          if L12_138 == "string" then
            L12_138 = L0_0
            L13_139 = L11_137
            L12_138 = L12_138(L13_139)
            L11_137 = L12_138
          end
          L12_138 = L17_17
          L13_139 = L8_8
          L12_138 = L12_138(L13_139, L11_137)
          L3_129.adapter = L12_138
        else
          L12_138 = L3_129.addView
          L13_139 = L54_54
          L13_139 = L13_139(L11_137, A1_127, A0_126[1])
          L12_138(L13_139, L13_139(L11_137, A1_127, A0_126[1]))
        end
      end
    elseif L10_136 == "id" then
      L12_138 = rawset
      L13_139 = A1_127
      L12_138(L13_139, L11_137, L3_129)
      L12_138 = L2_2.id
      L13_139 = L2_2.id
      L13_139 = L13_139 + 1
      L2_2.id = L13_139
      L13_139 = L3_129.setId
      L13_139(L12_138)
      L2_2[L11_137] = L12_138
    else
      L12_138 = pcall
      L13_139 = L51_51
      L13_139 = L12_138(L13_139, A1_127, L3_129, L5_131, L10_136, L11_137, L2_2)
      if not L12_138 then
        L13_139 = L13_139:sub(L13_139:find(":%d+:") or 1, -1)
        print(string.format([[
loadlayout error %s 
	at %s
	at  key=%s value=%s
	at %s]], L13_139, L3_129.toString(), L10_136, L11_137, L48_48(A0_126)), 0)
      end
    end
  end
  L7_133(L8_134)
  return L3_129
end
return L54_54
