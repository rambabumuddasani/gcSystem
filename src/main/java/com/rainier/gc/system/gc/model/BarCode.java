package com.rainier.gc.system.gc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BarCode {
	
	@Column (name ="BAR_CODE", length=64)
	private String barCode;

	@Column (name ="BAR_IMAGE", length=100)
	private String barCodeImage;

	@Column (name ="BAR_CODE_TEXT", length=64)
	private String barCodeText;

}
