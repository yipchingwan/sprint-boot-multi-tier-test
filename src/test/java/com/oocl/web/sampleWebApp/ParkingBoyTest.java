package com.oocl.web.sampleWebApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.web.sampleWebApp.domain.ParkingBoy;
import com.oocl.web.sampleWebApp.domain.ParkingBoyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingBoyTest {
    @Autowired
    private ParkingBoyRepository parkingBoyRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void should_return_201_when_created_parking_boy() throws Exception {
        //Given
        final ParkingBoy boy = new ParkingBoy("boy");
        final ObjectMapper objectMapper = new ObjectMapper();
        //When
        final MvcResult result = mvc.perform(post("/parkingboys").
                contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(boy))).andReturn();

        //Then
        assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    public void should_return_400_when_created_NULL_parking_boy() throws Exception {
        //Given
        final ParkingBoy boy = null;
        final ObjectMapper objectMapper = new ObjectMapper();
        //When
        final MvcResult result = mvc.perform(post("/parkingboys").
                contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(boy))).andReturn();

        //Then
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    public void should_return_400_when_created_parking_boy_with_ID_length_more_than_64() throws Exception {
        //Given
        final ParkingBoy boy = new ParkingBoy("fnsdjfnjsdklfasssmkldskmsdkfmsdklfnkldsfnkldsnlfdsfndsklfnsdklnfklsdnklfdlnfnsdklfnklsdnfklsdnklfsdfnsdklfnsdklnfksdlnfklsd");
        final ObjectMapper objectMapper = new ObjectMapper();
        //When
        final MvcResult result = mvc.perform(post("/parkingboys").
                contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(boy))).andReturn();

        //Then
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    public void should_return_400_when_created_parking_boy_with_ID_is_null() throws Exception {
        //Given
        final ParkingBoy boy = new ParkingBoy("Boy");
        boy.setEmployeeId(null);
        final ObjectMapper objectMapper = new ObjectMapper();
        //When
        //Then
        this.mvc.perform(post("/parkingboys")
                 .content(objectMapper.writeValueAsString(boy))
                 .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isBadRequest());



    }
}
