package work;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Builder;

@Builder
public class CreateContact {
    @Length(max = 64) // 最大64
    @NotBlank // 空の文字列は不可
    private String uid;
    @NotNull // nullは不可
    private ContactType contactType;
    @Length(max = 1600) // 最長1600
    private String contact;
}