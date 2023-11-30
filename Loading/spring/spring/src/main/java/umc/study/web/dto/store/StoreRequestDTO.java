package umc.study.web.dto.store;

import lombok.Getter;
import umc.study.domain.Region;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDTO {
    @Getter
    public static class AddDTO{
        @NotBlank
        String name;
        @NotBlank
        String address;
        @NotNull
        Float score;
        @NotNull
        Long regionId;
    }
}
