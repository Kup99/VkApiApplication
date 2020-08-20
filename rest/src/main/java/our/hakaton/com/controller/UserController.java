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
import org.springframework.web.bind.annotation.*;
import our.hakaton.com.vk_api_client.Authorization;
import our.hakaton.com.wrapper.VkUserWrapper;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.Strings.EMPTY;


@CrossOrigin
@RestController
@RequestMapping("/api/auth/user")
public class UserController {

  @Autowired
  private Authorization authorization;
  @Autowired
  private VkApiClient vkApiClient;

    @GetMapping("/")
    public ResponseEntity getUser(@RequestParam String id) throws ClientException, ApiException {
      List<UserXtrCounters> users = vkApiClient.users().get(authorization.getAuthActor())
              .userIds(id)
              .fields(UserField.BDATE, UserField.SEX)
              .lang(Lang.RU)
              .execute();


      List<VkUserWrapper> collect = users.stream()
              .map(user -> new VkUserWrapper(user.getId().toString(),
                      user.getFirstName(),
                      user.getLastName(),
                      user.getSex().toString(),
                      user.getCity() != null ? user.getCity().getTitle() : EMPTY,
                      user.getEducationForm()))
              .collect(Collectors.toList());

      return new ResponseEntity<>(collect, HttpStatus.OK);
    }
}
