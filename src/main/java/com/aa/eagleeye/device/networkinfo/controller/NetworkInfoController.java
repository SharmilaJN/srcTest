package com.aa.eagleeye.device.networkinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aa.eagleeye.common.config.CommonConfig;
import com.aa.eagleeye.common.data.NetworkInfoDto;
import com.aa.eagleeye.device.networkinfo.service.NetworkInfoService;
import com.nimbusds.jose.shaded.json.JSONObject;

@RestController
public class NetworkInfoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NetworkInfoController.class);
	
	@Autowired
	private CommonConfig configuration;
	
	@Autowired
	private NetworkInfoService networkInfoService;

	@GetMapping(value = "/demoRun")
	public String getMessage() {
		LOGGER.debug("Sample Logging");
		LOGGER.info("Value of EventHub Name from property file is: " + configuration.getEventHubName());
		return "Welcome to EagleEye Application!";
	}
	
	@PostMapping("/saveNetworkInfo")
    public ResponseEntity<?> saveNetworkInfo(@RequestBody NetworkInfoDto networkInfoData) {
        try {
        	LOGGER.info("Network controller save data request received");
            return new ResponseEntity<>(getNetworkInfoResposeForSave(networkInfoService.saveNetworkInfo(networkInfoData), "200"), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error in saving network data: " + e.getMessage());
            return new ResponseEntity<>(getNetworkInfoResposeForSave(e.getMessage(), "400"), HttpStatus.BAD_REQUEST);
        }
    }

	private Object getNetworkInfoResposeForSave(Object saveNetworkInfo, String status) {
		JSONObject response = new JSONObject();
		response.put("successDevices", saveNetworkInfo);
		response.put("status", status);
		return response;
	}
}
