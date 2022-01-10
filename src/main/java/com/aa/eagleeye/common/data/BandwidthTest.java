package com.aa.eagleeye.common.data;

public class BandwidthTest {

	private String description;

	private String downloadInMbps;

	private String uploadInMbps;

	private String latencyInMs;

	private String result;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDownloadInMbps() {
		return downloadInMbps;
	}

	public void setDownloadInMbps(String downloadInMbps) {
		this.downloadInMbps = downloadInMbps;
	}

	public String getUploadInMbps() {
		return uploadInMbps;
	}

	public void setUploadInMbps(String uploadInMbps) {
		this.uploadInMbps = uploadInMbps;
	}

	public String getLatencyInMs() {
		return latencyInMs;
	}

	public void setLatencyInMs(String latencyInMs) {
		this.latencyInMs = latencyInMs;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}