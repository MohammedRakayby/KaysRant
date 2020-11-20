package com.rakayby.blog.util;

import com.rakayby.blog.constant.DbConstants;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 *
 * @author Mohammed.Rakayby
 */
@RequiredArgsConstructor
public class HttpUtils {

    public static HttpCookie createAccessTokenCookie(String jwt) {
        return ResponseCookie.from("jwt", jwt)
                .maxAge(Duration.ofHours(4))
                .httpOnly(true)
                .path("/")
                .build();
    }

    public static HttpCookie deleteAccessTokenCookie() {
        return ResponseCookie.from("jwt", "").maxAge(0).httpOnly(true).path("/").build();
    }

    public static HashMap<String, Object> convertFromAttributeMap(Map<String, AttributeValue> map) {
        final HashMap<String, Object> keyMap = new HashMap();
        for (Map.Entry<String, AttributeValue> e : map.entrySet()) {
            keyMap.put(e.getKey(), e.getValue().s() == null ? e.getValue().n() : e.getValue().s());
        }
        return keyMap;
    }

    public static HashMap<String, AttributeValue> convertToAttributeMap(Map<String, Object> map) {
        final HashMap<String, AttributeValue> keyMap = new HashMap();
        for (Map.Entry<String, Object> e : map.entrySet()) {
            final String keyValue = e.getKey();
            switch (keyValue) {
                case DbConstants.POST_ATTRIBUTES.DATE:
                    keyMap.put(keyValue, AttributeValue.builder().n((String) e.getValue()).build());
                    break;
                case DbConstants.POST_ATTRIBUTES.SLUG:
                case DbConstants.POST_ATTRIBUTES.TAG:
                    keyMap.put(keyValue, AttributeValue.builder().s((String) e.getValue()).build());
                    break;
            }
        }
        return keyMap;
    }
}
