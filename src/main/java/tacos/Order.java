//tag::all[]
//tag::allButValidation[]
package tacos;


import lombok.Data;

/**
 * @author Joly
 */
@Data
public class Order {

    private String name;

    private String street;

    private String city;

    private String state;

    /**
     * ÓÊÕş±àÂë
     */
    private String zip;

    private String ccNumber;

    private String ccExpiration;

    private String ccCVV;

}

