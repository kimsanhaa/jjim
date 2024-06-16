package shopping.mall.ui.api.response;

import lombok.Getter;

@Getter
public class GetTokenResponse {
    private String token;

    public GetTokenResponse(String token) {
        this.token = token;
    }
}
