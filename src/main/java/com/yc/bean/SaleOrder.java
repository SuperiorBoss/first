package com.yc.bean;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SaleOrder implements java.io.Serializable {

	private static final long serialVersionUID = 1056218493209950488L;
	private Long odrId;
	private Long odrCustomerId = 0L;
	private String odrCustomerName;
	private String odrDeliverAddr;
	
	
	
	private Date odrOrderDate = new Date(new java.util.Date().getTime());
	private Date odrDeliverDate = new Date(new java.util.Date().getTime());
	
	
	private String odrStatus;
	
	//关联。。。外链接查询
	private List<SaleOrderLine> saleOrderLines=new ArrayList<SaleOrderLine>();
	
	
	private String odrOrderDateString;
	private String odrDeliverDateString;
	
	
	private SaleOrderLine saleOrderLine;   //订单项添加功能时用的
	
	
	
	
	

	
	
	
	public SaleOrderLine getSaleOrderLine() {
		return saleOrderLine;
	}

	public void setSaleOrderLine(SaleOrderLine saleOrderLine) {
		this.saleOrderLine = saleOrderLine;
	}
	//�����ݿ��е��¶�ʱ�� תΪ   String
	public String getOdrOrderDateString() {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");;
		this.odrOrderDateString=df.format(   new java.util.Date(  this.odrOrderDate.getTime())      );
		return this.odrOrderDateString;
	}

	public void setOdrOrderDateString(String odrOrderDateString) {
		this.odrOrderDateString = odrOrderDateString;
	}

	public String getOdrDeliverDateString() {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");;
		this.odrDeliverDateString=df.format(   new java.util.Date(  this.odrDeliverDate.getTime())      );
		return this.odrDeliverDateString;
	}

	public void setOdrDeliverDateString(String odrDeliverDateString) {
		this.odrDeliverDateString = odrDeliverDateString;
	}

	public List<SaleOrderLine> getSaleOrderLines() {
		return saleOrderLines;
	}

	public void setSaleOrderLines(List<SaleOrderLine> saleOrderLines) {
		this.saleOrderLines = saleOrderLines;
	}

	public SaleOrder() {
	}
	
	public SaleOrder(Long odrCustomerId, String odrCustomerName,
			String odrDeliverAddr, Date odrDeliverDate, String odrStatus) {
		this.odrCustomerId = odrCustomerId;
		this.odrCustomerName = odrCustomerName;
		this.odrDeliverAddr = odrDeliverAddr;
		this.odrDeliverDate = odrDeliverDate;
		this.odrStatus = odrStatus;
	}



	public Long getOdrId() {
		return this.odrId;
	}

	public void setOdrId(Long odrId) {
		this.odrId = odrId;
	}

	public Long getOdrCustomerId() {
		return this.odrCustomerId;
	}

	public void setOdrCustomerId(Long odrCustomerId) {
		this.odrCustomerId = odrCustomerId;
	}

	public String getOdrCustomerName() {
		return this.odrCustomerName;
	}

	public void setOdrCustomerName(String odrCustomerName) {
		this.odrCustomerName = odrCustomerName;
	}

	public String getOdrDeliverAddr() {
		return this.odrDeliverAddr;
	}

	public void setOdrDeliverAddr(String odrDeliverAddr) {
		this.odrDeliverAddr = odrDeliverAddr;
	}

	//�������String ��ʱ�� ��ʽתΪ   java.sql.Date
	public Date getOdrOrderDate() throws ParseException {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		this.odrOrderDate=    new Date(df.parse(this.odrOrderDateString).getTime() );
		return this.odrOrderDate;
	}

	//�������ݿ��ѯ��ʱ���ʱ��mybatis�����  setOdrOrderDate�������ʱ�� ��ע��.
	//��  ��Ӧ�� odrOrderDateString��û��ֵ�����Ե���  gson����  json�ַ���ʱ�� ��ΪodrOrderDateString��null
	//���Է��ظ������  json��û��  odrOrderDateString,
	//��������� �����������ǿ�Ƶ���һ��  getOdrOrderDateString
	public void setOdrOrderDate(Date odrOrderDate) {
		this.odrOrderDate = odrOrderDate;
		this.getOdrOrderDateString();
	}

	public Date getOdrDeliverDate() throws ParseException {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		this.odrDeliverDate=    new Date(df.parse(this.odrDeliverDateString).getTime() );
		return this.odrDeliverDate;
	}

	public void setOdrDeliverDate(Date odrDeliverDate) {
		this.odrDeliverDate = odrDeliverDate;
		this.getOdrDeliverDateString();
	}

	public String getOdrStatus() {
		return this.odrStatus;
	}

	public void setOdrStatus(String odrStatus) {
		this.odrStatus = odrStatus;
	}

	@Override
	public String toString() {
		return "SaleOrder [odrId=" + odrId + ", odrCustomerId=" + odrCustomerId
				+ ", odrCustomerName=" + odrCustomerName + ", odrDeliverAddr="
				+ odrDeliverAddr + ", odrOrderDate=" + odrOrderDate
				+ ", odrDeliverDate=" + odrDeliverDate + ", odrStatus="
				+ odrStatus + ",\n saleOrderLines=" + saleOrderLines + "]";
	}


}