package com.damian.jwtparser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

class Main {
    public static void main(String[] args) {
        String JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxkZXIiLCJpYXQiOjE3MTEwOTg4OTEsImV4cCI6MTc0MjYzNDg5MSwiYXVkIjoid3d3LmV4YW1wbGUuY29tIiwic3ViIjoianJvY2tldEBleGFtcGxlLmNvbSIsIkdpdmVuTmFtZSI6IkRhbWlhbiIsIlN1cm5hbWUiOiJQZWlyaXMiLCJFbWFpbCI6ImhlbGxvQGRhbWlhbi5jb20iLCJSb2xlIjpbIk1hbmFnZXIiLCJQcm9qZWN0IEFkbWluaXN0cmF0b3IiXX0.hWdzgpWyI0xjPsUcMaAJGpgrrnFik7MlK_9lFrSjrno";
        String key = "supersecretkey";
        Claims claims = parseTokens(JWT, key);
        System.out.println("Here's the email from token : "+claims.get("email"));

    }

    public static Claims parseTokens(String jwt, String key){
        return Jwts.parser()
                .setSigningKey(key.getBytes())
                .build()
                .parseClaimsJws(jwt).getBody();

    }

}