package com.example.airbnb.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.airbnb.exception.JWTCreationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final String GITHUB_ACCESS_TOKEN_URI = "https://github.com/login/oauth/access_token";
    private final String GITHUB_USER_URI = "https://api.github.com/user";
    private final String ISSUER = "";
    private final String CLIENT_ID = "c7adc71d1700acad7b68";
    private final String CLIENT_SECRET = "비번";
    private HttpSession httpSession;

    @GetMapping
    public String hello() {
        return "index";
    }

    /*
    @GetMapping("/github/callback")
    public ResponseEntity<Jwt> auth(String code) {

        RestTemplate gitHubRequest = new RestTemplate();

        GithubAccessTokenResponse accessToken = getAccessToken(code, gitHubRequest)
                .orElseThrow(() -> new RuntimeException("바디 없음"));

        System.out.println(accessToken);
        System.out.println(gitHubRequest);

        User user = getUserFromGitHub(accessToken, gitHubRequest)
                .orElseThrow(() -> new RuntimeException("바디 없음"));

        String jwt = getJwt(user);
        //CODE = jwt;
        //return new AuthDTO(jwt,);
        return ResponseEntity.ok(new Jwt(jwt));
    }
    */

    @GetMapping("/github")
    public AuthDTO githubToken(@RequestParam String code) {
        logger.info("code : {}", code);
        RestTemplate gitHubRequest = new RestTemplate();

        GithubAccessTokenResponse accessToken = getAccessToken(code, gitHubRequest)
                .orElseThrow(() -> new RuntimeException("바디 없음"));


        User user = getUserFromGitHub(accessToken, gitHubRequest)
                .orElseThrow(() -> new RuntimeException("바디 없음"));

        String jwt = getJwt(user);
        logger.info("accessToken : {}", accessToken);
        logger.info("gitHubRequest : {}", gitHubRequest);
        logger.info("jwt : {}", jwt);
        logger.info("user : {} ", user);
        return new AuthDTO(jwt, user.getAvatar_url(), user.getLogin());
    }

    private String getJwt(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withClaim("login", user.getLogin())
                    .withClaim("name", user.getName())
                    .withIssuer(ISSUER)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException(exception);
        }
    }

    private Optional<User> getUserFromGitHub(GithubAccessTokenResponse accessToken, RestTemplate gitHubRequest) {
        RequestEntity<Void> request = RequestEntity
                .get(GITHUB_USER_URI)
                .header("Accept", "application/json")
                .header("Authorization", "token " + accessToken.getAccessToken())
                .build();

        ResponseEntity<User> response = gitHubRequest
                .exchange(request, User.class);

        return Optional.ofNullable(response.getBody());
    }

    private Optional<GithubAccessTokenResponse> getAccessToken(String code, RestTemplate gitHubRequest) {
        RequestEntity<GithubAccessTokenRequest> request = RequestEntity
                .post(GITHUB_ACCESS_TOKEN_URI)
                .header("Accept", "application/json")
                .body(new GithubAccessTokenRequest(CLIENT_ID, CLIENT_SECRET, code));

        ResponseEntity<GithubAccessTokenResponse> response = gitHubRequest
                .exchange(request, GithubAccessTokenResponse.class);

        return Optional.ofNullable(response.getBody());
    }

    private Optional<GithubAccountInfoResponse> getInfoAccount(String jwt) {

        logger.info("getInfoAccount : jwt : {}", jwt);
        RequestEntity<Void> InfoAcc = RequestEntity
                .get(GITHUB_USER_URI)
                .header("Accept", "*/*")
                .header("Authorization", "token " + jwt)
                .build();
        logger.info("RequestEntity(InfoAcc) : {}",InfoAcc);
        RestTemplate gitHubRequest = new RestTemplate();

        ResponseEntity<GithubAccountInfoResponse> response = gitHubRequest
                .exchange(InfoAcc, GithubAccountInfoResponse.class);
        logger.info("RequestEntity(GithubAccountInfoResponse) : {}",response);
        return Optional.ofNullable(response.getBody());
    }

}
