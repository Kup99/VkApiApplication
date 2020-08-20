package our.hakaton.com.service;

import our.hakaton.com.wrapper.VkGroupWrapper;

import java.util.List;

public interface VkGroupService {

  List<VkGroupWrapper> getGroupsByIdUser(int id);
}
