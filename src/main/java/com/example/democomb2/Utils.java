package com.example.democomb2;

public class Utils {

    public static String notNull(String tag, String s) {
        return s == null ? "" : String.format(",%s='%s'", tag, s);
    }

    public static String notNull(String tag, Long c) {
        return (c == null || 0 == c) ? "" : String.format(",%s=%d", tag, c);
    }

    public static String notNull(String tag, Byte b) {
        return (b == null || 0 == b) ? "" : String.format(",%s=%d", tag, b);
    }

    public static <T> void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void hackSwap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    public static int[] swapClone(int[] in, int a, int b) {
        int[] out = in.clone();
        out[b] = in[a];
        out[a] = in[b];
        return out;
    }

    public static String wordSplit(String word) {
        return String.join("-", word
                .replaceAll("([ёуеыаоэяию])", "$1=")
                .replaceAll("=([^ёуеыаоэяию]+)$", "$1")
                .replaceAll("(=[^ёуеыаоэяию]*)([^ёуеыаоэяию])", "$1=$2")
                .replaceAll("=([^ёуеыаоэяию]+)=", "$1=")
                .split("=+"));
    }
}