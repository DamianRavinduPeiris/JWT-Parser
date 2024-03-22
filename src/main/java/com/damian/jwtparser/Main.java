package com.damian.jwtparser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Scanner;

class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the JWT token: ");
        String JWT = input.next();

        System.out.println("Enter the secret key: ");
        String key = input.next();
        System.out.println("What you want to extract from the token? ");
        String extract = input.next();

        Claims claims = parseTokens(JWT, key);
        if(claims.get(extract)==null){
            System.out.println("The token does not contain the " + extract + " you are looking for.");
            return;

        }
        System.out.println("Here's the " + extract + " from the  token : " + claims.get(extract));

    }

    public static Claims parseTokens(String jwt, String key) {
        try {
            return Jwts.parser().setSigningKey(key.getBytes()).build().parseClaimsJws(jwt).getBody();


        } catch (Exception exception) {
            System.out.println("An exception occurred while parsing the token. Please check the token and the secret key. : " + exception.getLocalizedMessage());
            return null;

        }


    }

}