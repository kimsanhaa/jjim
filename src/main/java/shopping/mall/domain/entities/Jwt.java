package shopping.mall.domain.entities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Jwt {
    private static final long expirationMs = 1000 * 60;
    private final String salt = "jjimjjim";
    private final String token;
    private Users users;

    public Jwt(Users users) {
        this.token = generateToken(users);
    }

    public boolean validate(String token, Users users) {
        Claims body = Jwts.parser().setSigningKey(Keys.secretKeyFor(SignatureAlgorithm.HS512)).parseClaimsJws(token).getBody();
        if(body.getSubject().equals(users.getId())){
            return true;
        }else{
            return false;
        }
    }

    private String generateToken(Users users) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);
        return Jwts.builder()
                .setSubject(String.valueOf(users.getId()))
                .claim("user", users)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, Keys.secretKeyFor(SignatureAlgorithm.HS512))
                .compact();
    }
    private String generateSecretKey(){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            String s = bytesToHex(md.digest());
            System.out.println(s);
            return bytesToHex(md.digest());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b: bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
