package com.springframework.spring5restmvc.services;

import com.springframework.spring5restmvc.api.v1.mapper.VendorMapper;
import com.springframework.spring5restmvc.api.v1.model.VendorDTO;
import com.springframework.spring5restmvc.domain.Vendor;
import com.springframework.spring5restmvc.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll().stream().map(vendor ->{
            VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl("/api/v1/vendors/"+vendor.getId());
                    return vendorDTO;}).collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository.findById(id).map(
                vendorMapper::vendorToVendorDTO
        ).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        return saveAndReturnDTO(vendor);
    }

    private VendorDTO saveAndReturnDTO(Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);
        VendorDTO savedVendorDto = vendorMapper.vendorToVendorDTO(savedVendor);
        savedVendorDto.setVendorUrl("/api/v1/vendors/"+vendor.getId());
        return savedVendorDto;
    }

    @Override
    public VendorDTO saveVendor(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        vendor.setId(id);
        return saveAndReturnDTO(vendor);
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        return vendorRepository.findById(id).map(vendor -> {
            if(vendorDTO.getName() != null){
                vendor.setName(vendorDTO.getName());
            }
            VendorDTO returnDTO = vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
            returnDTO.setVendorUrl("/api/v1/vendors/"+vendor.getId());
            return returnDTO;
        }
        ).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
