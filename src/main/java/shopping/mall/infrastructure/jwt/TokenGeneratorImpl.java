package shopping.mall.infrastructure.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import shopping.mall.domain.generator.TokenGenerator;

import java.util.Date;

public class TokenGeneratorImpl implements TokenGenerator {
    private final String secret = "hIVZQaKeZ3Vn9+N33AxllGw5Bm+T8Q9G4KID7FHAAaCPTQtQmuS589mELaXfjUY08x7dkhCiiYfpIhtN/vphoQ==";

    @Override
    public String generate(long userId,long expireMs) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expireMs);
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
