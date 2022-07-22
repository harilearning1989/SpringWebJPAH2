package com.web.demo.services;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.web.demo.dtos.CropInsuranceDTO;
import com.web.demo.helper.JSONHelper;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("CropServiceImpl")
public class CropServiceImpl implements CropService{

    @Override
    public List<CropInsuranceDTO> readCropDetails() {

        List<CropInsuranceDTO> countryRegion = null;
        try {
            String fixture = JSONHelper.readResource("crops.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, CropInsuranceDTO.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryRegion;
    }

    public void givenJsonArray_whenDeserializingAsArray_thenCorrect()
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<CropInsuranceDTO> listOfDtos = new ArrayList<>();
        String jsonArray = mapper.writeValueAsString(listOfDtos);
        CropInsuranceDTO[] asArray = mapper.readValue(jsonArray, CropInsuranceDTO[].class);

        /*ObjectMapper mapper = new ObjectMapper();
        List<MyDto> listOfDtos = new ArrayList<>();
        String jsonArray = mapper.writeValueAsString(listOfDtos);
        List<MyDto> asList = mapper.readValue(jsonArray, new TypeReference<List<MyDto>>() { });*/
    }
}
