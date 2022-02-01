// tag::all[]
// tag::allButValidation[]
package tacos;

import java.util.List;

import lombok.Data;

/**
 * @author jrl
 * @date 2022/2/1
 */
@Data
public class Taco {
    private String name;
    private List<String> ingredients;
}
