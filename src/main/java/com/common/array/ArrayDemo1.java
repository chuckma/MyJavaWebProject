package com.common.array;


/**
 * @author Administrator
 */
public class ArrayDemo1 {

    private static final String[] exchangeIp = {"10.1.0.238", "2.2.2.1", "10.1.254.200"};

    private static final String s = "1231";

    public static void main(String[] args) {
//        System.out.println(exchangeIp[0]);
//        System.out.println(exchangeIp);
        System.out.println(getMac());

        String  mac=  "6C-0B-84-3E-4C-12";
        System.out.println(!mac.equals("234"));
        System.out.println(mac.equals("234"));
        System.out.println("".equals(mac));
        System.out.println(!"6C-0B-84-3E-4C-12".equals(mac.toUpperCase())&& !mac.equals(""));
        System.out.println(!"".equals(mac.toUpperCase()) && !"".equals(""));

    }

    private static String getMac() {
        String code = "";
            int count = 0;
        for (String s : exchangeIp) {
            String  mac=  "6C-0B-84-3E-4C-12";
            String ip = mac;//;
            if (ip.equals("")) {
                //return "0033";
                count++;
                code = "003n";
                if (count > exchangeIp.length-1) {
                    return code;
                }
            }
            if (!ip.equals(mac) && !ip.equals("")) {
                code ="003";
                return code;
            } else if (ip.equals(mac)) {
                code = "";
                break;
            }
        }
        return code;
    }
}
