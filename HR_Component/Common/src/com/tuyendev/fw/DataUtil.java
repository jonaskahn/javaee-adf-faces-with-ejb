package com.tuyendev.fw;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;

import com.rits.cloning.Cloner;

import one.util.streamex.StreamEx;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.text.DecimalFormat;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>DataUtil</h1>
 * This s a util class that will process data before you do something.
 * Class was made by so many authors, I just recompile and optimize this.
 * <p>
 * <b>Note:</b> Cloning lib was reusable from here: https://github.com/kostaskougios/cloning
 *
 * @author  tuyendev
 * @version 1.0
 * @since   8/11/2017
 */
public class DataUtil {

    public static final String ID_SEPARATE_CHARACTER = " - ";
    public static final String ID_SEPARATE_MSG = ";";
    public static final String ID_SEPARATE_TEXT = ",";
    private static final Cloner cloner = new Cloner();


    /**
     * Clone an object completely
     * @param source
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T deepClone(T source) {
        return cloner.deepClone(source);
    }

    /**
     * Do check null or zero of a Long value
     * @param value
     * @return
     */
    public static boolean isNullOrZero(Long value) {
        return (value == null || value.equals(0L));
    }


    /**
     * Do check null or -1L of a Long value
     * @param value
     * @return
     */
    public static boolean isNullOrOneNavigate(Long value) {
        return (value == null || value.equals(-1L));
    }


    /**
     * Do check null or zero of a BigDecimal value
     * @param value
     * @return
     */
    public static boolean isNullOrZero(BigDecimal value) {
        return (value == null || value.compareTo(BigDecimal.ZERO) == 0);
    }

    /**
     * Do upper first character
     * @param input
     * @return
     */
    public static String upperFirstChar(String input) {
        if (DataUtil.isNullOrEmpty(input)) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    /**
     * Do lower first character
     * @param input
     * @return
     */
    public static String lowerFirstChar(String input) {
        if (DataUtil.isNullOrEmpty(input)) {
            return input;
        }
        return input.substring(0, 1).toLowerCase() + input.substring(1);
    }

    /**
     * Safely convert a Long number with a default number to avoid exception
     * @param obj1
     * @param defaultValue
     * @return
     */
    public static Long safeToLong(Object obj1, Long defaultValue) {
        Long result = defaultValue;
        if (obj1 != null) {
            if (obj1 instanceof BigDecimal) {
                return ((BigDecimal) obj1).longValue();
            }
            if (obj1 instanceof BigInteger) {
                return ((BigInteger) obj1).longValue();
            }
            try {
                result = Long.parseLong(obj1.toString());
            } catch (Exception ignored) {
            }
        }

        return result;
    }


    /**
     * Do checking a CharsSequence is null or empty
     * @param cs
     * @return
     */
    public static boolean isNullOrEmpty(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Do checking a Collection is null or empty
     * @param collection
     * @return
     */
    public static boolean isNullOrEmpty(final Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Do checking a array is null or empty
     * @param collection
     * @return
     */
    public static boolean isNullOrEmpty(final Object[] collection) {
        return collection == null || collection.length == 0;
    }

    /**
     * Do checking a Map is null or empty
     * @param map
     * @return
     */
    public static boolean isNullOrEmpty(final Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * Assign data if object is null
     * @param object
     * @param defaultValue
     * @param <T>
     * @return
     */
    public static <T> T defaultIfNull(final T object, final T defaultValue) {
        return object != null ? object : defaultValue;
    }

    /**
     * Safely convert a long number to avoid exception
     * @param obj1
     * @param obj1
     * @return
     */
    public static Long safeToLong(Object obj1) {
        return safeToLong(obj1, 0L);
    }

    /**
     * Safely convert a Double number with a default number to avoid exception
     * @param obj1
     * @param defaultValue
     * @return
     */
    public static Double safeToDouble(Object obj1, Double defaultValue) {
        Double result = defaultValue;
        if (obj1 != null) {
            try {
                result = Double.parseDouble(obj1.toString());
            } catch (Exception ignored) {
            }
        }

        return result;
    }

    /**
     * Safely convert a Double number to avoid exception
     * @param obj1
     * @return
     */
    public static Double safeToDouble(Object obj1) {
        return safeToDouble(obj1, 0.0);
    }


    /**
     * Safely convert a Short number with a default number to avoid exception
     * @param obj1
     * @param defaultValue
     * @return
     */
    public static Short safeToShort(Object obj1, Short defaultValue) {
        Short result = defaultValue;
        if (obj1 != null) {
            try {
                result = Short.parseShort(obj1.toString());
            } catch (Exception ignored) {
            }
        }

        return result;
    }

    /**
     * Safely convert a Short number to avoid exception
     * @param obj1
     * @return
     */
    public static Short safeToShort(Object obj1) {
        return safeToShort(obj1, (short) 0);
    }

    /**
     * Safely convert a Integer number with a default number to avoid exception
     * @param obj1
     * @param defaultValue
     * @return
     */
    public static int safeToInt(Object obj1, int defaultValue) {
        int result = defaultValue;
        if (obj1 != null) {
            try {
                result = Integer.parseInt(obj1.toString());
            } catch (Exception ignored) {
            }
        }

        return result;
    }

    /**
     * Safely convert a Integer number to avoid exception
     * @param obj1
     * @return
     */
    public static int safeToInt(Object obj1) {
        return safeToInt(obj1, 0);
    }

    /**
     * Safely convert a String with a default value to avoid exception
     * @param obj1
     * @param defaultValue
     * @return
     */
    public static String safeToString(Object obj1, String defaultValue) {
        if (obj1 == null) {
            return defaultValue;
        }

        return obj1.toString();
    }

    /**
     * Safely convert a String to avoid exception
     * @param obj1
     * @return
     */
    public static String safeToString(Object obj1) {
        return safeToString(obj1, "");
    }

    /**
     * Safely convert a BigDecimal to avoid exception
     * @param obj1
     * @return
     */
    public static BigDecimal safeToBigDecimal(Object obj1) {
        BigDecimal result = BigDecimal.ZERO;
        if (obj1 == null) {
            return result;
        }
        try {
            result = new BigDecimal(obj1.toString());
        } catch (Exception ignored) {
        }

        return result;
    }

    /**
     * Safely convert a BigInteger with a default value to avoid exception
     * @param obj1
     * @return
     */
    public static BigInteger safeToBigInteger(Object obj1, BigInteger defaultValue) {
        BigInteger result = defaultValue;
        if (obj1 == null) {
            return result;
        }
        try {
            result = new BigInteger(obj1.toString());
        } catch (Exception ignored) {
        }

        return result;
    }

    public static BigInteger safeToBigInteger(Object obj1) {
        BigInteger result = BigInteger.ZERO;
        try {
            if (obj1 instanceof BigInteger) {
                result = (BigInteger) obj1;
            } else {
                result = new BigInteger(obj1.toString());
            }

        } catch (Exception ignored) {
        }

        return result;
    }

    public static BigDecimal add(BigDecimal number1, BigDecimal number2, BigDecimal... numbers) {
        List<BigDecimal> realNumbers = Lists.newArrayList(number1, number2);
        if (!DataUtil.isNullOrEmpty(numbers)) {
            Collections.addAll(realNumbers, numbers);
        }
        return realNumbers.stream()
                          .filter(Objects::nonNull)
                          .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Long add(Long number1, Long number2, Long... numbers) {
        List<Long> realNumbers = Lists.newArrayList(number1, number2);
        if (!DataUtil.isNullOrEmpty(numbers)) {
            Collections.addAll(realNumbers, numbers);
        }
        return realNumbers.stream()
                          .filter(Objects::nonNull)
                          .reduce(0L, (x, y) -> x + y);
    }


    public static BigInteger add(BigInteger obj1, BigInteger obj2) {
        if (obj1 == null) {
            return obj2;
        } else if (obj2 == null) {
            return obj1;
        }

        return obj1.add(obj2);
    }


    public static String getFormattedString4Digits(String number, String pattern) {
        double amount = 0;
        try {
            amount = Double.parseDouble(number);
            DecimalFormat formatter = new DecimalFormat(pattern);
            return formatter.format(amount);
        } catch (Exception ex) {
            return number;
        }
    }

    public static Character safeToCharacter(Object value) {
        return safeToCharacter(value, '0');
    }

    public static Character safeToCharacter(Object value, Character defaulValue) {
        if (value == null)
            return defaulValue;
        return String.valueOf(value).charAt(0);
    }

    public static Collection<Long> objLstToLongLst(List<Object> list) {
        return isNullOrEmpty(list) ? Lists.newArrayList() : StreamEx.of(list)
                                                                    .map(DataUtil::safeToLong)
                                                                    .toList();
    }

    public static Collection<Short> objLstToShortLst(List<Object> list) {
        return isNullOrEmpty(list) ? Lists.newArrayList() : StreamEx.of(list)
                                                                    .map(DataUtil::safeToShort)
                                                                    .toList();
    }

    public static Collection<BigDecimal> objLstToBigDecimalLst(List<Object> list) {
        return isNullOrEmpty(list) ? Lists.newArrayList() : StreamEx.of(list)
                                                                    .map(DataUtil::safeToBigDecimal)
                                                                    .toList();
    }

    public static Collection<Double> objLstToDoubleLst(List<Object> list) {
        return isNullOrEmpty(list) ? Lists.newArrayList() : StreamEx.of(list)
                                                                    .map(DataUtil::safeToDouble)
                                                                    .toList();
    }

    public static Collection<Character> objLstToCharLst(List<Object> list) {
        return isNullOrEmpty(list) ? Lists.newArrayList() : StreamEx.of(list)
                                                                    .map(DataUtil::safeToCharacter)
                                                                    .toList();
    }

    public static Collection<String> objLstToStringLst(List<Object> list) {
        return isNullOrEmpty(list) ? Lists.newArrayList() : StreamEx.of(list)
                                                                    .map(DataUtil::safeToString)
                                                                    .toList();
    }


    public static boolean isNullObject(Object obj1) {
        return obj1 == null || obj1 instanceof String && isNullOrEmpty(obj1.toString());
    }

    public static String safeUpper(String input) {
        return isNullOrEmpty(input) ? input : input.toUpperCase();
    }

    public static String safeLower(String input) {
        return isNullOrEmpty(input) ? input : input.toLowerCase();
    }

    public static boolean validateStringByPattern(String value, String regex) {
        if (isNullOrEmpty(regex) || isNullOrEmpty(value)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     * Convert special character to acsii
     *
     * @param input
     * @return
     */
    public static String convertCharacter(String input) {
        if (input == null) {
            return "";
        }
        String[] aList = { "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
        String[] eList = { "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
        String[] iList = { "?", "?", "?", "?", "?" };
        String[] oList = { "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
        String[] uList = { "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
        String[] yList = { "?", "?", "?", "?", "?" };
        String[] AList = { "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
        String[] EList = { "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
        String[] IList = { "?", "?", "?", "?", "?" };
        String[] OList = { "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
        String[] UList = { "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
        String[] YList = { "?", "?", "?", "?", "?" };
        for (String s : aList) {
            input = input.replace(s, "a");
        }
        for (String s : AList) {
            input = input.replace(s, "A");
        }
        for (String s : eList) {
            input = input.replace(s, "e");
        }
        for (String s : EList) {
            input = input.replace(s, "E");
        }
        for (String s : iList) {
            input = input.replace(s, "i");
        }
        for (String s : IList) {
            input = input.replace(s, "I");
        }
        for (String s : oList) {
            input = input.replace(s, "o");
        }
        for (String s : OList) {
            input = input.replace(s, "O");
        }
        for (String s : uList) {
            input = input.replace(s, "u");
        }
        for (String s : UList) {
            input = input.replace(s, "U");
        }
        for (String s : yList) {
            input = input.replace(s, "y");
        }
        for (String s : YList) {
            input = input.replace(s, "Y");
        }
        input = input.replace("?", "d");
        input = input.replace("?", "D");
        return input;
    }

    public static Map<String, String> convertStringToMap(String temp, String regex, String regexToMap) {
        if (isNullOrEmpty(temp)) {
            return null;
        }
        String[] q = temp.split(regex);
        Map<String, String> lstParam = new HashMap<>();
        for (String a : q) {
            String key = a.substring(0, (!a.contains(regexToMap) ? 1 : a.indexOf(regexToMap)));
            String value = a.substring(a.indexOf(regexToMap) + 1);
            lstParam.put(key.trim(), value.trim());
        }
        return lstParam;
    }

    public static boolean isNumber(String string) {
        return !isNullOrEmpty(string) && string.trim().matches("^\\d+$");
    }


    /**
     * Tim nhung phan tu co o collection a ma khong co o collection b
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T> List<T> subtract(Collection<T> a, Collection<T> b) {
        if (a == null || b == null) {
            return new ArrayList<>();
        }
        List<T> list = new ArrayList<>(a);
        list.removeAll(b);
        return list;
    }

    public static <T> List<T> intersection(Collection<T> a, Collection<T> b) {
        if (a == null || b == null) {
            return new ArrayList<>();
        }
        List<T> list = new ArrayList<>(a);
        list.retainAll(b);
        return list;
    }

    public static String removeStartingZeroes(String number) {
        if (DataUtil.isNullOrEmpty(number)) {
            return "";
        }
        return CharMatcher.anyOf("0").trimLeadingFrom(number);
    }

    /**
     * Trim tat ca ki tu trang, bao gom ca ki tu trang 2 byte ma ham trim binh thuong cua java khong trim duoc
     *
     * @param needToTrimString Xau can trim
     * @return "" neu la xau null hoac trang, con lai tra ve xau sau khi trim, "" neu trim xong khong con gi
     */
    public static String trim(String needToTrimString) {
        if (needToTrimString == null) {
            return "";
        }
        return CharMatcher.WHITESPACE.trimFrom(needToTrimString);
    }


    public static BigDecimal defaultIfSmallerThanZero(BigDecimal value) {
        return defaultIfSmallerThanZero(value, BigDecimal.ZERO);
    }

    public static BigDecimal defaultIfSmallerThanZero(BigDecimal value, BigDecimal defaultValue) {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            return defaultValue;
        }
        return value;
    }


    private static String convertUnicode2Nosign(String org) {

        char arrChar[] = org.toCharArray();
        char result[] = new char[arrChar.length];
        for (int i = 0; i < arrChar.length; i++) {
            switch (arrChar[i]) {
            case '\u00E1':
            case '\u00E0':
            case '\u1EA3':
            case '\u00E3':
            case '\u1EA1':
            case '\u0103':
            case '\u1EAF':
            case '\u1EB1':
            case '\u1EB3':
            case '\u1EB5':
            case '\u1EB7':
            case '\u00E2':
            case '\u1EA5':
            case '\u1EA7':
            case '\u1EA9':
            case '\u1EAB':
            case '\u1EAD':
            case '\u0203':
            case '\u01CE':
                {
                    result[i] = 'a';
                    break;
                }
            case '\u00E9':
            case '\u00E8':
            case '\u1EBB':
            case '\u1EBD':
            case '\u1EB9':
            case '\u00EA':
            case '\u1EBF':
            case '\u1EC1':
            case '\u1EC3':
            case '\u1EC5':
            case '\u1EC7':
            case '\u0207':
                {
                    result[i] = 'e';
                    break;
                }
            case '\u00ED':
            case '\u00EC':
            case '\u1EC9':
            case '\u0129':
            case '\u1ECB':
                {
                    result[i] = 'i';
                    break;
                }
            case '\u00F3':
            case '\u00F2':
            case '\u1ECF':
            case '\u00F5':
            case '\u1ECD':
            case '\u00F4':
            case '\u1ED1':
            case '\u1ED3':
            case '\u1ED5':
            case '\u1ED7':
            case '\u1ED9':
            case '\u01A1':
            case '\u1EDB':
            case '\u1EDD':
            case '\u1EDF':
            case '\u1EE1':
            case '\u1EE3':
            case '\u020F':
                {
                    result[i] = 'o';
                    break;
                }
            case '\u00FA':
            case '\u00F9':
            case '\u1EE7':
            case '\u0169':
            case '\u1EE5':
            case '\u01B0':
            case '\u1EE9':
            case '\u1EEB':
            case '\u1EED':
            case '\u1EEF':
            case '\u1EF1':
                {
                    result[i] = 'u';
                    break;
                }
            case '\u00FD':
            case '\u1EF3':
            case '\u1EF7':
            case '\u1EF9':
            case '\u1EF5':
                {
                    result[i] = 'y';
                    break;
                }
            case '\u0111':
                {
                    result[i] = 'd';
                    break;
                }
            case '\u00C1':
            case '\u00C0':
            case '\u1EA2':
            case '\u00C3':
            case '\u1EA0':
            case '\u0102':
            case '\u1EAE':
            case '\u1EB0':
            case '\u1EB2':
            case '\u1EB4':
            case '\u1EB6':
            case '\u00C2':
            case '\u1EA4':
            case '\u1EA6':
            case '\u1EA8':
            case '\u1EAA':
            case '\u1EAC':
            case '\u0202':
            case '\u01CD':
                {
                    result[i] = 'A';
                    break;
                }
            case '\u00C9':
            case '\u00C8':
            case '\u1EBA':
            case '\u1EBC':
            case '\u1EB8':
            case '\u00CA':
            case '\u1EBE':
            case '\u1EC0':
            case '\u1EC2':
            case '\u1EC4':
            case '\u1EC6':
            case '\u0206':
                {
                    result[i] = 'E';
                    break;
                }
            case '\u00CD':
            case '\u00CC':
            case '\u1EC8':
            case '\u0128':
            case '\u1ECA':
                {
                    result[i] = 'I';
                    break;
                }
            case '\u00D3':
            case '\u00D2':
            case '\u1ECE':
            case '\u00D5':
            case '\u1ECC':
            case '\u00D4':
            case '\u1ED0':
            case '\u1ED2':
            case '\u1ED4':
            case '\u1ED6':
            case '\u1ED8':
            case '\u01A0':
            case '\u1EDA':
            case '\u1EDC':
            case '\u1EDE':
            case '\u1EE0':
            case '\u1EE2':
            case '\u020E':
                {
                    result[i] = 'O';
                    break;
                }
            case '\u00DA':
            case '\u00D9':
            case '\u1EE6':
            case '\u0168':
            case '\u1EE4':
            case '\u01AF':
            case '\u1EE8':
            case '\u1EEA':
            case '\u1EEC':
            case '\u1EEE':
            case '\u1EF0':
                {
                    result[i] = 'U';
                    break;
                }
            case '\u00DD':
            case '\u1EF2':
            case '\u1EF6':
            case '\u1EF8':
            case '\u1EF4':
                {
                    result[i] = 'Y';
                    break;
                }

            case '\u0110':
            case '\u00D0':
            case '\u0089':
                {
                    result[i] = 'D';
                    break;
                }
            default:
                result[i] = arrChar[i];
            }
        }
        return new String(result);
    }

}
