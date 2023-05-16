package com.church.adeprchurchmanagement.AppSecurity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class userSecurity {
        public String encryptePassword(String password)
        {
            String secret = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjE9MSdvciAnMT0xNycifQ.PnKeHFaSYl1UjgSS9O3gf_VXgO7AQEOien6mQxWvcgU";
        String token = JWT.create()
            .withClaim("hideeverything", password)
            .sign(Algorithm.HMAC256(secret));
            return token;
        }
        public String encrypteEmail(String email)
        {
            String secret = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IkVtYWlsIn0.SgmfGhFc0j5Hv-LFYg3G_0lnhexHPBcHSlEjcPc8b48";
        String token = JWT.create()
            .withClaim("verybeautifulseesalt", email)
            .sign(Algorithm.HMAC256(secret));
            return token;
        }
        public String encrypteUrl(String url)
        {
            String secret = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJNeU5hbWVzIEVuY3J5cCI6InVybHNld2Z3ZSJ9.uKHwH8K1C-gfgzQx7MHZLsRl9vDmUjJJoJJxvF-Pyik";
        String token = JWT.create()
            .withClaim("mostencoder", url)
            .sign(Algorithm.HMAC256(secret));
            return token;
        }
        public String decrypteUrl(String url)
        { String secret = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJNeU5hbWVzIEVuY3J5cCI6InVybHNld2Z3ZSJ9.uKHwH8K1C-gfgzQx7MHZLsRl9vDmUjJJoJJxvF-Pyik";
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
          DecodedJWT decodedJWT = verifier.verify(url);
          String passwordClaim = decodedJWT.getClaim("mostencoder").asString();
          return passwordClaim;
        }

}