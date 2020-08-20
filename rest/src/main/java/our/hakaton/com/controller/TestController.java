package our.hakaton.com.controller;

import com.vk.api.sdk.client.Lang;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.queries.users.UserField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import our.hakaton.com.vk_api_client.Authorization;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/auth/")
public class TestController {

  @Autowired
  private Authorization authorization;
  @Autowired
  private VkApiClient vkApiClient;

    @GetMapping("/")
    public ResponseEntity<List> testMethod() throws ClientException, ApiException {
      List<UserXtrCounters> users = vkApiClient.users().get(authorization.getAuthActor())
              .userIds("55140268")
              .fields(UserField.BDATE, UserField.SEX)
              .lang(Lang.RU)
              .execute();

      return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
