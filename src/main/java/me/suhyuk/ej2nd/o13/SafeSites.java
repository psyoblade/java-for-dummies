package me.suhyuk.ej2nd.o13;

public class SafeSites {
    // This code has potential security hole !!
    public static final String[] LEGAL_SITES = new String[] { "http://www.naver.com", "http://www.google.com" };

    public static boolean isValid(String url) {
        for (String site : LEGAL_SITES) {
            if (url.equalsIgnoreCase(site)) {
                return true;
            }
        }
        return false;
    }

}
