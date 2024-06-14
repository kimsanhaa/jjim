package shopping.mall.domain.vo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import shopping.mall.domain.entities.Users;

import java.util.Date;


public class Jwt {
    private static final long expirationMs = 1000 * 60;
    private final String token;
    private final String secret = "hIVZQaKeZ3Vn9+N33AxllGw5Bm+T8Q9G4KID7FHAAaCPTQtQmuS589mELaXfjUY08x7dkhCiiYfpIhtN/vphoQ==";
    private Users users;

    public String getToken() {
        return token;
    }

    public Users getUsers() {
        return users;
    }

    public Jwt(Users users) {
        this.token = generateToken(users);
        this.users = users;
    }

    public boolean validate(String token, Users targetUser) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        if(body.getSubject().equals(String.valueOf(targetUser.getId()))){
            return true;
        }else{
            return false;
        }
    }

    public boolean validate(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return true;
    }


    private String generateToken(Users users) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);
        return Jwts.builder()
                .setSubject(String.valueOf(users.getId()))
                .claim("user", users)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
//    private String generateSecretKey(){
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            md.update(salt.getBytes());
//            String s = bytesToHex(md.digest());
//            System.out.println(s);
//            return bytesToHex(md.digest());
//        }catch (NoSuchAlgorithmException e){
//            e.printStackTrace();
//            return null;
//        }
//    }

//    private String bytesToHex(byte[] bytes) {
//        StringBuilder builder = new StringBuilder();
//        for (byte b: bytes) {
//            builder.append(String.format("%02x", b));
//        }
//        return builder.toString();
//    }
}
