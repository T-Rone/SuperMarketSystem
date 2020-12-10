package com.pojo;
import java.util.Date;

public class Provider {
  private int id;
  private String proCode;
  private String proName;
  private String proDesc;
  private String proContact;
  private String proPhone;
  private String proAddress;
  private String proFax;
  private Date creationDate;
  public Provider() {

  }

    public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getProCode() {
    return proCode;
  }

  public void setProCode(String proCode) {
    this.proCode = proCode;
  }


  public String getProName() {
    return proName;
  }

  public void setProName(String proName) {
    this.proName = proName;
  }


  public String getProDesc() {
    return proDesc;
  }

  public void setProDesc(String proDesc) {
    this.proDesc = proDesc;
  }


  public String getProContact() {
    return proContact;
  }

  public void setProContact(String proContact) {
    this.proContact = proContact;
  }


  public String getProPhone() {
    return proPhone;
  }

  public void setProPhone(String proPhone) {
    this.proPhone = proPhone;
  }


  public String getProAddress() {
    return proAddress;
  }

  public void setProAddress(String proAddress) {
    this.proAddress = proAddress;
  }


  public String getProFax() {
    return proFax;
  }

  public void setProFax(String proFax) {
    this.proFax = proFax;
  }


  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  @Override
  public String toString() {
    return "Provider{" +
            "id=" + id +
            ", proCode='" + proCode + '\'' +
            ", proName='" + proName + '\'' +
            ", proDesc='" + proDesc + '\'' +
            ", proContact='" + proContact + '\'' +
            ", proPhone='" + proPhone + '\'' +
            ", proAddress='" + proAddress + '\'' +
            ", proFax='" + proFax + '\'' +
            ", creationDate=" + creationDate +
            '}';
  }

  public Provider(String proCode, String proName, String proDesc, String proContact, String proPhone, String proAddress, String proFax, Date creationDate) {
    this.proCode = proCode;
    this.proName = proName;
    this.proDesc = proDesc;
    this.proContact = proContact;
    this.proPhone = proPhone;
    this.proAddress = proAddress;
    this.proFax = proFax;
    this.creationDate = creationDate;
  }

}
