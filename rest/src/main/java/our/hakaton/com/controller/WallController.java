package our.hakaton.com.controller;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.responses.GetExtendedResponse;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import com.vk.api.sdk.queries.wall.WallGetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import our.hakaton.com.vk_api_client.Authorization;

/**
 * Created by 813632 on 01.07.2020.
 */

@CrossOrigin
@RestController
@RequestMapping("/api/auth/wall")
public class WallController {

    @Autowired
    private Authorization authorization;
    @Autowired
    private VkApiClient vkApiClient;

    @GetMapping("/")
    public ResponseEntity<GetExtendedResponse> getWall(@RequestParam int id) throws ClientException, ApiException {
      GetExtendedResponse response = vkApiClient
              .wall()
              .getExtended(authorization.getAuthActor())
              .ownerId(id)
              .count(100).offset(5)
              .filter(WallGetFilter.OWNER)
              .execute();

      return new ResponseEntity<>(response, HttpStatus.OK);
    }
}



