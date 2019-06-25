package company.amazon;


//TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
//and it returns a short URL such as http://tinyurl.com/4e9iAk.
//
//Design the encode and decode methods for the TinyURL service. There is no restriction on how your 
//encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL 
//and the tiny URL can be decoded to the original URL.

import java.util.HashMap;

public class EncodeAndDecodeTinyURL {

    private static HashMap<String, String> map = new HashMap<>();
    private static String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static int count = 1;

    public static void main(String[] args) {
        String longURL = "https://leetcode.com/problems/design-tinyurl";
        String shortURL = encode(longURL);
        System.out.println(shortURL);
    }

    private static String getKey() {
        String key = "";
        while (count > 0) {
            count--;
            key += characters.charAt(count);
            count /= characters.length();
        }
        return key;
    }

    // Encodes a URL to a shortened URL.
    private static String encode(String longUrl) {
        String key = getKey();
        map.put(key, longUrl);
        count++;
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    private static String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}
