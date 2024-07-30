package com.hospitalmanagement.business.concretes;

import com.hospitalmanagement.business.abstracts.MedicineService;
import com.hospitalmanagement.dtos.MedicineDto;
import com.hospitalmanagement.entities.Medicine;
import com.hospitalmanagement.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public MedicineDto postMedicine(MedicineDto medicineDto) {
        Medicine medicine = new Medicine();
        medicine.setId(medicineDto.getId());
        medicine.setDrugName(medicineDto.getDrugName());
        medicine.setStock(medicineDto.getStock());
        Medicine createdMedicine = medicineRepository.save(medicine);
        MedicineDto createdMedicineDto = new MedicineDto();
        createdMedicine.setId(createdMedicineDto.getId());
        createdMedicine.setDrugName(createdMedicineDto.getDrugName());
        createdMedicine.setStock(createdMedicineDto.getStock());
        return createdMedicineDto;
    }

    @Override
    public List<MedicineDto> getAllMedicines() {
        return medicineRepository.findAll().stream().map(Medicine::getMedicineDto).collect(Collectors.toList());
    }
}
