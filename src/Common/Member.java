package Common;

public class Member {
	private String SttafName;
	private String SttafAddress;
	private int MelliCode;
	private int NumberPhone;
	/////////////////////////// getSttafName
	public String getSttafName() {
		if (SttafName != null && SttafName.matches("[\\p{L} ]+"))
			return SttafName;
		else
			return "";	}
	////////////////////////////////////////// setSttafName
	public void setSttafName(String sttafName) {
		if (sttafName.matches("[\\p{L} ]+"))
			SttafName =sttafName;
	}
	////////////////////////////////////////// getSttafAddress
	public String getSttafAddress() {
		return SttafAddress;
	}
	////////////////////////////////////////// setSttafAddress
	public void setSttafAddress(String sttafAddress) {
		SttafAddress = sttafAddress;
	}
	////////////////////////////////////////// getMelliCode
	public int getMelliCode() {
		if (MelliCode >= 0)
			return MelliCode;
		else
			return -1;
	}
	////////////////////////////////////////// setMelliCode
	public void setMelliCode(int melliCode) {
		if (melliCode >= 0)
			MelliCode = melliCode;
		else
			MelliCode = 00;
	}
	////////////////////////////////////////// getNumberPhone
	public int getNumberPhone() {
		if (NumberPhone >= 0)
			return NumberPhone;
		else
			return -1;
	}
	////////////////////////////////////////// setNumberPhone
	public void setNumberPhone(int numberPhone) {
		if  (numberPhone>= 0)
			NumberPhone = numberPhone;
		else
			NumberPhone = 00;
	}
}
