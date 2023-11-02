package lk.ijse.springboot.guideService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Guide implements Super {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long guideId;
    @NotNull(message = "Guide name shouldn't be null")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" , message ="Invalid guide name")
    private String guideName;
    @NotEmpty(message = "Nic cannot be empty")
    @Column(unique = true)
    String nicNumber;
    @NotNull(message = "Guide address shouldn't be null ")
   /* @Pattern(regexp ="^[a-zA-Z0-9\\\\s,.'-]+[a-zA-Z0-9\\\\s,.'-]+[a-zA-Z0-9\\\\s,.'-]+$"
    , message = "Invalid  guide address")*/
    private String guideAddress;
    @NotNull(message = "Guide's Id images shouldn't be empty")
    @Column(columnDefinition = "longtext")
    private String guideIdImage;
    @NotEmpty(message = "Gender shouldn't be empty")
    private String gender;
    @NotBlank(message = "Contact No shouldn't be blank")
    @Pattern(regexp ="^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$" , message = "Invalid contact number")
    private String contactNumber;
    @NotNull(message = "Guide's NIC Images FrontEnd shouldn't be empty")
    @Column(columnDefinition = "longtext")
    private String nicImageFrontEnd;
    @NotNull(message = "Guide's NIC Images BackEnd shouldn't be empty")
    @Column(columnDefinition = "longtext")
    private String nicImageBackEnd;
    @NotEmpty(message = "Experience shouldn't be empty")
    private String Experience;
    @Positive(message = " Man day value shouldn't be empty")
    @Min(value = 0, message = "Man day value shouldn't be less than 0")
    private int manDayValue;
    @NotEmpty(message = "Remarks shouldn't be empty")
    private String remarks;




}
