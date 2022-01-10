package com.aa.eagleeye.common.data;

public class Config {

	private Integer intervalInMinutes;

	private Integer uploadFileSize;

	private Integer downloadFileSize;

	public Integer getIntervalInMinutes() {
		return intervalInMinutes;
	}

	public void setIntervalInMinutes(Integer intervalInMinutes) {
		this.intervalInMinutes = intervalInMinutes;
	}

	public Integer getUploadFileSize() {
		return uploadFileSize;
	}

	public void setUploadFileSize(Integer uploadFileSize) {
		this.uploadFileSize = uploadFileSize;
	}

	public Integer getDownloadFileSize() {
		return downloadFileSize;
	}

	public void setDownloadFileSize(Integer downloadFileSize) {
		this.downloadFileSize = downloadFileSize;
	}
}
