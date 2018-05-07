package com.econetwireless.epay.business.services.impl;

import com.econetwireless.epay.business.integrations.api.ChargingPlatform;
import com.econetwireless.epay.business.services.api.EnquiriesService;
import com.econetwireless.epay.dao.subscriberrequest.api.SubscriberRequestDao;
import com.econetwireless.epay.domain.SubscriberRequest;
import com.econetwireless.utils.constants.SystemConstants;
import com.econetwireless.utils.enums.ResponseCode;
import com.econetwireless.utils.messages.AirtimeBalanceResponse;
import com.econetwireless.utils.pojo.INBalanceResponse;
import com.econetwireless.utils.pojo.INCreditResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@Ignore
public class EnquiriesServiceImplTest {

    @Mock
    private ChargingPlatform chargingPlatform;
    @Mock
    private SubscriberRequestDao subscriberRequestDao;
    private String partnerCode;
    private  String msisdn;
    @Mock
    EnquiriesService enquiriesService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        partnerCode = "123";
        msisdn ="263774222193";
        enquiriesService = new EnquiriesServiceImpl(chargingPlatform,subscriberRequestDao);
    }
    @Test
    public void shouldFailIfPartnerCodeIsNull() {
        final AirtimeBalanceResponse airtimeBalanceResponse = new AirtimeBalanceResponse();
        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setBalanceBefore(0.0);
        subscriberRequest.setBalanceAfter(1.0);
        subscriberRequest.setPartnerCode("123");
        subscriberRequest.setRequestType("Enquiry");
        subscriberRequest.setReference("123455");
        subscriberRequest.setMsisdn("0771222044");
         INBalanceResponse inBalanceResponse = chargingPlatform.enquireBalance(partnerCode, msisdn);


        Assert.assertNotNull(inBalanceResponse.getResponseCode(), null);

    }
    @Test
    public void shouldFailIfMSISDNisNull() {
      Assert.assertThat(enquiriesService.enquire(partnerCode,msisdn).getResponseCode().isEmpty(), null);

    }

}