package our.hakaton.com.service.impl;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.objects.groups.responses.GetExtendedResponse;
import com.vk.api.sdk.queries.groups.GroupsGetFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import our.hakaton.com.service.VkGroupService;
import our.hakaton.com.vk_api_client.Authorization;
import our.hakaton.com.wrapper.VkGroupWrapper;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static org.apache.logging.log4j.util.Strings.EMPTY;

@Service
public class VkGroupServiceImpl implements VkGroupService {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private Authorization authorization;
  @Autowired
  private VkApiClient vkApiClient;

  @Override
  public List<VkGroupWrapper> getGroupsByIdUser(int id) {
    GetExtendedResponse response = null;
    try {
      response = vkApiClient
              .groups()
              .getExtended(authorization.getAuthActor())
              .userId(id)
              .filter(GroupsGetFilter.GROUPS)
              .execute();
    } catch (Exception e) {
      logger.error("Page with groups is closed");
      emptyList();
    }
    return response != null ? response.getItems()
            .stream()
            .map(group -> new VkGroupWrapper(
                    group.getName(),
                    group.getCity() != null ? group.getCity().getTitle() : EMPTY,
                    group.getCountry() != null ? group.getCountry().getTitle() : EMPTY))
            .collect(Collectors.toList()) : emptyList();
  }
}
