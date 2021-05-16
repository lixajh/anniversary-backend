package com.peake.webseed.utils;

import java.util.UUID;

public class PkUtils {
    public static String getPk(){
        return UUID.randomUUID().toString();
    }
}
