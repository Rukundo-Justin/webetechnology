package com.church.adeprchurchmanagement;


import java.io.UnsupportedEncodingException;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class mm {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String secret = "yoursecretkey";
        String token = JWT.create()
          .withClaim("mostencoder", "Mike")
          .sign(Algorithm.HMAC256(secret));

          JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
          DecodedJWT decodedJWT = verifier.verify(token);
          String passwordClaim = decodedJWT.getClaim("mostedncoder").asString();
          System.out.println(passwordClaim);
        
       


}
}
