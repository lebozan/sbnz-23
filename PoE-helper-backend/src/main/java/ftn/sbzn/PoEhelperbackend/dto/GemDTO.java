package ftn.sbzn.PoEhelperbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GemDTO {
    private String name, classId;
    private List<String> tags;
}
