package de.htwg_konstanz.ebus.framework.wholesaler.vo;




public interface IUser
{
	public Address getAddress();

	public void setAddress(Address address);

	public String getEmail();

	public void setEmail(String email);

	public String getFaxnumber();

	public void setFaxnumber(String faxnumber);

	public String getFirstname();

	public void setFirstname(String firstname);

	public Integer getId();

	public void setId(Integer id);

	public String getLastname();

	public void setLastname(String lastname);

	public String getLogin();

	public void setLogin(String login);

	public String getMobilenumber();

	public void setMobilenumber(String mobilenumber);

	public String getPasswd();

	public void setPasswd(String passwd);

	public String getPhonenumber();

	public void setPhonenumber(String phonenumber);

	public String getRemark();

	public void setRemark(String remark);

	public String getTitle();

	public void setTitle(String title);
}
