package com.hospitalmanagement.controllers;

import com.hospitalmanagement.business.abstracts.MedicineService;
import com.hospitalmanagement.dtos.MedicineDto;
import com.hospitalmanagement.dtos.PatientDto;
import com.hospitalmanagement.entities.Medicine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/medicines")
    public ResponseEntity<List<MedicineDto>> getAllMedicines(){
        List<MedicineDto> medicineDtoList = medicineService.getAllMedicines();
        if(medicineDtoList == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(medicineDtoList);
    }

    @PostMapping("/medicine")
    public ResponseEntity<MedicineDto> postMedicine(@RequestBody MedicineDto medicineDto){
        MedicineDto createdMedicineDto = medicineService.postMedicine(medicineDto);
        if(createdMedicineDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(createdMedicineDto);
    }


}
