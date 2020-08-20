package our.hakaton.com.vk_api_client;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.queries.groups.GroupsGetQuery;

/**
 * Created by 813632 on 28.06.2020.
 */
public class Groups extends AbstractAction {

    public Groups(VkApiClient client) {

        super(client);
    }

    public GroupsGetQuery get(UserActor actor) {
        return new GroupsGetQuery(getClient(), actor);
    }
}
