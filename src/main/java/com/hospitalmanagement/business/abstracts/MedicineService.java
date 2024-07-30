package com.hospitalmanagement.business.abstracts;

import com.hospitalmanagement.dtos.MedicineDto;
import com.hospitalmanagement.entities.Medicine;

import java.util.List;

public interface MedicineService {
    MedicineDto postMedicine(MedicineDto medicineDto);

    List<MedicineDto> getAllMedicines();
}
