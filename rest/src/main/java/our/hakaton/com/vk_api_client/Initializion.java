package our.hakaton.com.vk_api_client;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 813632 on 27.06.2020.
 */
@Configuration
public class Initializion {

  @Bean
  public VkApiClient getVkApiClient() {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        return vk;
  }
}
