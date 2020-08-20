package our.hakaton.com.controller;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.objects.groups.responses.GetExtendedResponse;
import com.vk.api.sdk.queries.groups.GroupsGetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import our.hakaton.com.vk_api_client.Authorization;
import our.hakaton.com.wrapper.VkGroupWrapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@CrossOrigin
@RestController
@RequestMapping("/api/auth/group")
public class GroupController {

  @Autowired
  private Authorization authorization;
  @Autowired
  private VkApiClient vkApiClient;

  @GetMapping("/")
  public ResponseEntity<List<VkGroupWrapper>> getGroups(@RequestParam int id) {
    GetExtendedResponse response;
    try {
      response = vkApiClient
              .groups()
              .getExtended(authorization.getAuthActor())
              .userId(id)
              .filter(GroupsGetFilter.GROUPS)
//             .offset(100)
              .execute();
    } catch (Exception e) {
      return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }
    List<VkGroupWrapper> collect = response.getItems()
            .stream()
            .map(group -> new VkGroupWrapper(
                    group.getName(),
                    group.getCity() != null ? group.getCity().getTitle() : EMPTY,
                    group.getCountry() != null ? group.getCountry().getTitle() : EMPTY)
            ).collect(Collectors.toList());
    return new ResponseEntity<>(collect, HttpStatus.OK);
  }
}
