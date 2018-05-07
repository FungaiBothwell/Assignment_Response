package com.econetwireless.epay.business.services.impl;


import com.econetwireless.epay.business.services.api.EnquiriesService;
import com.econetwireless.epay.dao.requestpartner.api.RequestPartnerDao;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public  class PartnerCodeValidatorImplTest {
    private String partnerCode;

    @Mock
  private RequestPartnerDao requestPartnerDao;
    @InjectMocks
    private PartnerCodeValidatorImpl requestPartnerDaoImpl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        partnerCode = "123";
      requestPartnerDaoImpl =  new PartnerCodeValidatorImpl(requestPartnerDao);

    }
    @Test
    void validatePartnerCode() {
    }
}