package com.aa.eagleeye.common.data;

public class RFData {

	private String carrierName;

	private Boolean isHomeNetwork;

	private Double rsrp;

	private Double rsrq;

	private Double snir;

	private Integer pci;

	private String networkType;

	private String lteBand;

	private Location location;

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public Boolean getIsHomeNetwork() {
		return isHomeNetwork;
	}

	public void setIsHomeNetwork(Boolean isHomeNetwork) {
		this.isHomeNetwork = isHomeNetwork;
	}

	public Double getRsrp() {
		return rsrp;
	}

	public void setRsrp(Double rsrp) {
		this.rsrp = rsrp;
	}

	public Double getRsrq() {
		return rsrq;
	}

	public void setRsrq(Double rsrq) {
		this.rsrq = rsrq;
	}

	public Double getSnir() {
		return snir;
	}

	public void setSnir(Double snir) {
		this.snir = snir;
	}

	public Integer getPci() {
		return pci;
	}

	public void setPci(Integer pci) {
		this.pci = pci;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getLteBand() {
		return lteBand;
	}

	public void setLteBand(String lteBand) {
		this.lteBand = lteBand;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}