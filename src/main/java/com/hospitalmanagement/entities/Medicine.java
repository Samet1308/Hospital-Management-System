package com.hospitalmanagement.entities;

import com.hospitalmanagement.dtos.MedicineDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "medicines")
@Data
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drugName;

    private String stock;

    public MedicineDto getMedicineDto(){
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setId(id);
        medicineDto.setDrugName(drugName);
        medicineDto.setStock(stock);
        return medicineDto;
    }

}
