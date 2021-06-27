package one.digitalinnovation.userapi.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String cpf;

    private String birthDate;

    @NotNull
    private List<PhoneDTO>phones;
}
