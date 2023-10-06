package com.bybit.api.client.domain.user;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Builder
public class UserPermissionsMap {
    private final Map<String, List<String>> permissionMap;

    public UserPermissionsMap(Map<String, List<String>> permissionMap) {
        this.permissionMap = permissionMap;
    }

    @JsonAnyGetter // This annotation allows the map's entries to be serialized as properties.
    public Map<String, List<String>> getPermissionMap() {
        return permissionMap;
    }
}