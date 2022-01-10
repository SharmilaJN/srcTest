package com.aa.eagleeye.common.data;

import java.util.ArrayList;
import java.util.List;

public class NetworkInfoDto {

	private List<NetworkData> data = new ArrayList<NetworkData>();

	public List<NetworkData> getData() {
		return data;
	}

	public void setData(List<NetworkData> data) {
		this.data = data;
	}
}