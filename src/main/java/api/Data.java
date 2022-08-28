package api;

import lombok.Builder;


@lombok.Data
@Builder
public class Data {
    public String email;
    public String password;
}