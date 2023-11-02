package lk.ijse.springboot.hotelService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity

public class Hotel implements Super {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hotelId;
    @NotNull(message = "Hotel name shouldn't be null")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" , message ="Invalid hotel name")
    private String hotelName;
    @NotEmpty(message = "hotel Location shouldn't be empty")
    private String hotelLocation;
    @NotNull(message = "Address shouldn't be null")
  /*  @Pattern(regexp ="^[a-zA-Z0-9\\\\s,.'-]+[a-zA-Z0-9\\\\s,.'-]+[a-zA-Z0-9\\\\s,.'-]+$"
    , message = "Invalid address")*/
    private String address;
    @Email(message = "Invalid hotel email address")
    @Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$" , message = "Invalid hotel email address")
    private String hotelEmail;
    @Embedded
    private Contact contactNumber;
    @Positive(message = " Hotel Fee shouldn't be empty")
    @Min(value = 0, message = "Hotel Fee shouldn't be less than 0")
    private double hotelFee;
    @NotEmpty(message = "Hotel Category shouldn't be empty")
    private String hotelCategory;
    @NotNull(message = "pets Allowed Or Not shouldn't be empty")
    private boolean petsAllowedOrNot;
    @NotEmpty(message = "Remarks shouldn't be empty")
    private String remarks;

}
