package com.example.demoProgettoLibreriaSpring.DTO;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {

    /*
    {
        "clientName": "Mario",
        "clientSurname": "Rossi",
        "clientEmail": "mario@gmail.com",
        "clientNumber": "123456789",
        "bookIds" [34, 7, 12],
        "wahrehouseId": 7
     }
     */

    private String clientName;
    private String clientSurname;
    private String clientEmail;
    private String clientNumber;
    private List<Long> bookIds;
    private long warehouseId;
}
