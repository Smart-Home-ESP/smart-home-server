package com.smarthome.server.utils;

import com.smarthome.server.entity.GenericOwnerItemDto;
import com.smarthome.server.service.auth.AuthenticationFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AuthUtils {

    private static final AuthenticationFacade authenticationFacade = new AuthenticationFacade();

    public static String authUsername() {
        return authenticationFacade.getAuthentication().getName();
    }

    public static boolean authBelongsCheck(GenericOwnerItemDto scenery) {
        return scenery.getOwners().contains(authUsername());
    }
}
