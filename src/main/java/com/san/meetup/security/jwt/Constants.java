package com.san.meetup.security.jwt;

public class Constants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 10*60;
    public static final String SIGNING_KEY = "dontenter";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
