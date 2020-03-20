package makoto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false,onlyExplicitlyIncluded = true)
public class OnePo {
    @EqualsAndHashCode.Include
    private String id;
    private List<String> bb;
    private Integer num = 0;
}
