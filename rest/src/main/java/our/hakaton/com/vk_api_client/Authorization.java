package our.hakaton.com.vk_api_client;

import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.UserAuthResponse;
import org.springframework.stereotype.Service;

/**
 * Created by 813632 on 27.06.2020.
 */
@Service
public class Authorization {
  private final Integer CLIENT_ID = 7526556;
  private final String REDIRECT_URI = "https://oauth.vk.com/blank.html";

  //todo вынести не хардкодить/могут со временем стать невалидными
  private final String CODE = "bc826b9c244f86e053";
  private final String CLIENT_SECRET = "awVO0pj8hVej9L8YyTQa";

  public UserActor getAuthActor() throws ClientException, ApiException {
    Initializion initializion = new Initializion();
    UserAuthResponse authResponse = initializion.getVkApiClient().oauth()
            .userAuthorizationCodeFlow(CLIENT_ID, CLIENT_SECRET, REDIRECT_URI, CODE)
            .execute();
  //  UserActor actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    //todo access token get from ***
    UserActor actor = new UserActor(6660870, "");
    return actor;
  }
}
