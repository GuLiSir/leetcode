package com.leetcodelib.p500_599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 535. TinyURL 的加密与解密
 * encode-and-decode-tinyUrl
 * <p>
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，
 * 它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 * <p>
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。
 * 你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，
 * 并且这个TinyURL可以用解密方法恢复成原本的URL。
 */
public class EncodeAndDecodeTinyUrl {

    public static void main(String[] args) {
        init();
        for (int i = 0; i < 100; i++) {
            String randomString = getRandomString();
            System.out.println("创建:" + randomString);
        }
        encode("http://animal.example.com/bee.php");
        encode("http://animal.example.com/bee1.php");
        encode("http://animal.example.com/bee2.php");
        encode("http://animal.example.com/bee3.php");
        encode("http://animal.example.com/bee4.php");
        encode("http://animal.example.com/bee5.php");
        encode("http://animal.example.com/bee6.php");
        encode("http://animal.example.com/bee7.php");
    }

    private static Map<String, String> stringMap = new HashMap<>();
    private static List<String> charSequences;

    /**
     *解析:先生成随机的列表,然后从列表中随机组合成参数;
     * 在获取短url的过程中,需要对之前是否生成过进行判断,如果有直接返回,这是为了去重,避免一个长url对应多个短url;
     * 在生成短url过程中,需要对该短url进行判断,看看是否之前被当成key过,不然的话会造成生成重复key,但是之前的值被覆盖了
     */
    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        //检查并且初始化列表
        init();

        String s = null;
        if (stringMap.containsValue(longUrl)) {
            //如果是之前的url已经生成短url,则直接返回即可
            for (String s1 : stringMap.keySet()) {
                if (stringMap.get(s1).equals(longUrl)) {
                    s = s1;
                    return "http://tinyurl.com/" + s;
                }
            }
        } else {
            //没有生成,就创建新的短url,并且需要注意不要跟之前生成的重复了,否则会被覆盖掉,导致之前的结果解析错误
            s = getRandomString();
            while (stringMap.containsKey(s)) {
                System.out.println("重复了:" + s);
                s = getRandomString();
            }
        }

        stringMap.put(s, longUrl);

        return "http://tinyurl.com/" + s;
    }


    /**
     * 说明:直接从已生成的值中取出来就可以了
     * @param shortUrl
     * @return
     */
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String replace = shortUrl.replace("http://tinyurl.com/", "");
        String s = stringMap.get(replace);
        return s;
    }


    private static Random random = new Random();

    /**
     * 从随机列表中,获取一个随机的key,key的长度可控制
     * @return
     */
    public static String getRandomString() {
        StringBuilder builder = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int nextInt = random.nextInt(charSequences.size());
            String s = charSequences.get(nextInt);
            builder.append(s);
        }
        String s = builder.toString();

        return s;
    }

    /**
     * 初始化随机生成的列表集合
     */
    private static void init() {
        if (charSequences != null) {
            return;
        }

        charSequences = new ArrayList<>();
        for (char i = '0'; i <= '9'; i++) {
            charSequences.add(Character.toString(i));
        }
        for (char i = 'a'; i <= 'z'; i++) {
            charSequences.add(Character.toString(i));
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            charSequences.add(Character.toString(i));
        }

        System.out.println("init suc");
    }

}
