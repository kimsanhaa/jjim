package shopping.mall.infrastructure.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import shopping.mall.domain.validator.TokenValidator;

import java.util.Date;

public class TokenValidatorImpl implements TokenValidator {
    private final String secret = "hIVZQaKeZ3Vn9+N33AxllGw5Bm+T8Q9G4KID7FHAAaCPTQtQmuS589mELaXfjUY08x7dkhCiiYfpIhtN/vphoQ==";

    @Override
    public boolean validate(String token) {
        Claims claims = parseJwt(token);
        return isTokenExpired(claims);
    }
    private boolean isTokenExpired(Claims claims) {
        Date expirationDate = claims.getExpiration();
        return expirationDate != null && expirationDate.before(new Date());
    }
    private Claims parseJwt(String jwtToken) {
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }
}
