package our.hakaton.com.service.impl;

import org.apache.commons.lang3.StringUtils;
import our.hakaton.com.service.VkParser;

public class VkUrlParserImpl implements VkParser {

  @Override
  public String getIdUserFromUrl(String url) {
    //https://vk.com/ariumu29
    String substringBetween = StringUtils.substringBetween("com/", "");
    return substringBetween;
  }


}
