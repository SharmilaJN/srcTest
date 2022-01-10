package com.aa.eagleeye.common.data;

public class NetworkData {

	private RFData rfData;

	private DeviceInfo deviceInfo;

	private BandwidthTest bandwidthTest;

	private PingTest pingTest;

	private Config config;

	private String lastDataSync;

	private String timestamp;

	public RFData getRfData() {
		return rfData;
	}

	public void setRfData(RFData rfData) {
		this.rfData = rfData;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public BandwidthTest getBandwidthTest() {
		return bandwidthTest;
	}

	public void setBandwidthTest(BandwidthTest bandwidthTest) {
		this.bandwidthTest = bandwidthTest;
	}

	public PingTest getPingTest() {
		return pingTest;
	}

	public void setPingTest(PingTest pingTest) {
		this.pingTest = pingTest;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public String getLastDataSync() {
		return lastDataSync;
	}

	public void setLastDataSync(String lastDataSync) {
		this.lastDataSync = lastDataSync;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
