package shopping.mall.ui.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import shopping.mall.application.AuthService;
import shopping.mall.ui.api.request.GetTokenRequest;
import shopping.mall.ui.api.response.GetTokenResponse;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("/tokens")
    public ResponseEntity<GetTokenResponse> getToken(
            @RequestBody GetTokenRequest request
    ) {
         GetTokenResponse response = new GetTokenResponse(authService.tokenGenerate(request.getUserId()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
