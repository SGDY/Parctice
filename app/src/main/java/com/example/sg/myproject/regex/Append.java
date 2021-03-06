package com.example.sg.myproject.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author SGDY
 * @version 1.0
 * @description
 * @createDate 2015/1/27
 */
public class Append {
    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoob";
    private static String REPLACE = "-";
    public static void main(String[] args) {
        tail();
        replace();
        quote();
    }

    private static void tail(){
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        m.appendTail(sb);
        m.appendTail(sb);
        m.appendTail(sb);
        System.out.println(sb.toString());
    }

    private static void replace(){
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,REPLACE);
        }
        System.out.println(sb.toString());
    }

    private static void quote(){
        try {
            Pattern p = Pattern.compile(REGEX);
            // 获取 matcher 对象
            Matcher m = p.matcher(INPUT);
            StringBuffer sb = new StringBuffer();
            if (m.find()) {
                sb.append(m.quoteReplacement("123"));
            }
            System.out.println(sb.toString());
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
        }
    }
}
