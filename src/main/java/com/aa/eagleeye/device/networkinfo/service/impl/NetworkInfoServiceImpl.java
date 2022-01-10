package com.aa.eagleeye.device.networkinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.eagleeye.common.data.NetworkData;
import com.aa.eagleeye.common.data.NetworkInfoDto;
import com.aa.eagleeye.common.utils.EventHubConn;
import com.aa.eagleeye.device.networkinfo.service.NetworkInfoService;
import com.aa.eagleeye.device.networkinfo.validation.NetworkInfoDataValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NetworkInfoServiceImpl implements NetworkInfoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NetworkInfoServiceImpl.class);

	@Autowired
	private NetworkInfoDataValidator networkDataValidator;

	@Autowired
	private EventHubConn eventHubConn;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public Object saveNetworkInfo(NetworkInfoDto networkInfoData) {
		LOGGER.info("saveNetworkInfo: Going to validate data");

		networkDataValidator.validateInputParams(networkDataValidator);
		LOGGER.info("Data Validation success");

		List<String> dataStrList = new ArrayList<>();
		List<String> successData = new ArrayList<>();

		List<NetworkData> dataList = networkInfoData.getData();
		for (NetworkData eachRecord : dataList) {
			try {
				dataStrList.add(objectMapper.writeValueAsString(eachRecord));
				successData.add(eachRecord.getDeviceInfo().getImei());
//				System.out.println(objectMapper.writeValueAsString(eachRecord));
			} catch (JsonProcessingException e) {
				LOGGER.error("Error in processing JSON data for device with imei: "+ eachRecord.getDeviceInfo().getImei());
				LOGGER.debug("Error is processing JSON data" + e.getMessage());
			}

		}
//			NetworkData a = objectMapper.convertValue(dataList.get(0), NetworkData.class);
//			System.out.println(a);

		LOGGER.info("saveNetworkInfo: Going to Push data into Event Hub");
		eventHubConn.sendDataToEH(dataStrList);

		// Return response data
		return successData;
	}

}
