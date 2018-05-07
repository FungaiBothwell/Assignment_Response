package com.econetwireless.epay.business.services.impl;

import com.econetwireless.epay.business.config.EpayBusinessConfig;
import com.econetwireless.epay.business.config.IntegrationsConfig;
import com.econetwireless.epay.business.config.RootConfig;
import com.econetwireless.epay.business.integrations.api.ChargingPlatform;
import com.econetwireless.epay.business.integrations.impl.ChargingPlatformImpl;
import com.econetwireless.epay.business.services.api.CreditsService;
import com.econetwireless.epay.dao.subscriberrequest.api.SubscriberRequestDao;
import com.econetwireless.epay.domain.SubscriberRequest;
import com.econetwireless.in.soap.service.IntelligentNetworkService;
import com.econetwireless.utils.constants.SystemConstants;
import com.econetwireless.utils.enums.ResponseCode;
import com.econetwireless.utils.messages.AirtimeTopupRequest;
import com.econetwireless.utils.messages.AirtimeTopupResponse;
import com.econetwireless.utils.pojo.INCreditRequest;
import com.econetwireless.utils.pojo.INCreditResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(classes = {EpayBusinessConfig.class}),
        @ContextConfiguration(classes = {IntegrationsConfig.class}),
        @ContextConfiguration(classes = {RootConfig.class})
})
public class CreditsServiceImplTest {
    @Autowired
    CreditsService service;
    @InjectMocks
    private ChargingPlatform chargingPlatform;
    @Mock
    private SubscriberRequestDao subscriberRequestDao;
    @Mock
    private IntelligentNetworkService intellegentNetwork;


    @Before
 public void init(){
    service = new CreditsServiceImpl(chargingPlatform,subscriberRequestDao);
   chargingPlatform = new ChargingPlatformImpl(intellegentNetwork);


 }
    @Test
    public void shouldThrowNullExceptionIfAirtimeRequestIsNull() {
        //assert true
        final AirtimeTopupRequest airtimeTopupRequest = new AirtimeTopupRequest();
        airtimeTopupRequest.setMsisdn("263771222044");
        airtimeTopupRequest.setAmount(1.0);
        airtimeTopupRequest.setPartnerCode("123");
        airtimeTopupRequest.setReferenceNumber("12345");
         AirtimeTopupResponse response =   service.credit(airtimeTopupRequest);
        Assert.assertNotNull(response);


    }


    @Test
    public void shouldFailIfPartnerCodeIsNull() {
        Assert.assertNotNull(null);

    }


}