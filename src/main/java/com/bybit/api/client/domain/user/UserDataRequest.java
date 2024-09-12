package com.bybit.api.client.domain.user;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDataRequest {
    private String username;
    private String password;
    private MemberType memberType;
    private SwitchOption switchOption;
    private IsUta isUta;
    private String note;
    private MasterUserPermissions masterUserPermissions;
    private SubUserPermissions subUserPermissions;
    private Map<String, List<String>> permissionsMap;
    private UserPermissionsMap userPermissionsMap;
    private FrozenStatus frozenStatus;
    private Integer subuid;
    private List<String> memberIds; // Multiple sub UID are supported, separated by commas
    private List<String> ips;
    private String apikey;
    private ReadOnlyStatus readOnlyStatus;
    private String uid;
    private String subMemberId;
    private Integer limit;
    private String pageSize;
    private String nextCursor;
    private String cursor;
}
