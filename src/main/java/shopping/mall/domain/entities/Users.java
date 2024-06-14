package shopping.mall.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shopping.mall.ui.api.request.SignUpUsersRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
@Getter
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Users create(SignUpUsersRequest request) {
        if(!isValidEmail(request.getEmail())){
            throw new IllegalArgumentException("이메일이 올바르지 않습니다.");
        }

        if(request.getPassword().length() < 5){
            throw new IllegalArgumentException("비밀번호는 5글자 이상이어야 합니다.");
        };
        return new Users(request.getEmail(), request.getPassword());
    }

    private boolean isValidEmail(String email) {
        String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
