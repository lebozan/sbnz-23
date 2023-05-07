package ftn.sbzn.PoEhelperbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KeystonesDataDTO {
    @JsonProperty("limits")
    private Object limits;

    @JsonProperty("cargoquery")
    private List<KeystoneDataWrapper> allKeystoneData;
}
