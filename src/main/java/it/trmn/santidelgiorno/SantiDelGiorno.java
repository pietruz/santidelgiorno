package it.trmn.santidelgiorno;

import java.util.Date;

public class SantiDelGiorno{
	private Date date;
	private String santo;
	private String altriSanti;
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the santo
	 */
	public String getSanto() {
		return santo;
	}
	/**
	 * @param santo the santo to set
	 */
	public void setSanto(String santo) {
		this.santo = santo;
	}
	/**
	 * @return the altriSanti
	 */
	public String getAltriSanti() {
		return altriSanti;
	}
	/**
	 * @param altriSanti the altriSanti to set
	 */
	public void setAltriSanti(String altriSanti) {
		this.altriSanti = altriSanti;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SantiDelGiorno [date=" + date + ", santo=" + santo + ", altriSanti=" + altriSanti + "]";
	}
	
}
