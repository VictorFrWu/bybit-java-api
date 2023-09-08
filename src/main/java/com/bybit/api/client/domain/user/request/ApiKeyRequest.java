package com.bybit.api.client.domain.user.request;

import com.bybit.api.client.constant.BybitApiConstants;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ApiKeyRequest {

    private final Integer subuid; // required
    private final String note;
    private final Integer readOnly; // required
    private final List<String> ips;
    private final Permissions permissions; // required

    public Integer getSubuid() {
        return subuid;
    }

    public String getNote() {
        return note;
    }

    public Integer getReadOnly() {
        return readOnly;
    }

    public List<String> getIps() {
        return ips;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    private ApiKeyRequest(Builder builder) {
        this.subuid = builder.subuid;
        this.note = builder.note;
        this.readOnly = builder.readOnly;
        this.ips = builder.ips;
        this.permissions = builder.permissions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("subuid", subuid)
                .append("note", note)
                .append("readOnly", readOnly)
                .append("ips", ips)
                .append("permissions", permissions)
                .toString();

    }

    @Getter
    @Setter
    public static class Builder {
        private Integer subuid;
        private String note;
        private Integer readOnly;
        private List<String> ips;
        private Permissions permissions;

        public Builder(Integer subuid, Integer readOnly, Permissions permissions) {
            this.subuid = subuid;
            this.readOnly = readOnly;
            this.permissions = permissions;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public Builder readOnly(Integer readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        public Builder ips(List<String> ips) {
            this.ips = ips;
            return this;
        }

        public ApiKeyRequest build() {
            return new ApiKeyRequest(this);
        }
    }

    @Getter
    @Setter
    public static class Permissions {
        private final Map<String, List<String>> permissionMap;

        public Permissions(Map<String, List<String>> permissionMap) {
            this.permissionMap = permissionMap;
        }

        @JsonAnyGetter // This annotation allows the map's entries to be serialized as properties.
        public Map<String, List<String>> getPermissionMap() {
            return permissionMap;
        }
    }

}


