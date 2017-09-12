package nosi.webapps.kofax.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import nosi.base.ActiveRecord.BaseActiveRecord;
import nosi.core.webapp.helpers.DateHelper;

/**
 * @author: Emanuel Pereira
 * 14 Aug 2017
 */
@Entity
@Table(name="tbl_dados")
public class Dados extends BaseActiveRecord<Dados> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_objeto",foreignKey = @ForeignKey(name="OBJETO_DADOS_ID_OBJETO"),nullable=false)
	private Objeto objeto;
	private String descricao;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dt_registo;
	@Column(nullable=false)
	@Lob
	private String conteudo;
	@Column(nullable=false)
	private String file_name;

	@Column(nullable=false)
	private String mime_type;
	
	public Dados(){}

	

	public Dados(Objeto objeto, String descricao, String dt_registo, String conteudo,String file_name,String mime_type) {
		super();
		this.objeto = objeto;
		this.descricao = descricao;
		this.dt_registo = DateHelper.formatDate(dt_registo,"dd-MM-yyyy","yyyy-MM-dd");
		this.conteudo = conteudo;
		this.file_name = file_name;
		this.mime_type = mime_type;
	}




	public String getMime_type() {
		return mime_type;
	}



	public void setMime_type(String mime_type) {
		this.mime_type = mime_type;
	}



	public String getFile_name() {
		return file_name;
	}



	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Objeto getObjeto() {
		return objeto;
	}



	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Date getDt_registo() {
		return dt_registo;
	}



	public void setDt_registo(String dt_registo) {
		this.dt_registo = DateHelper.formatDate(dt_registo,"dd-MM-yyyy","yyyy-MM-dd");
	}



	public String getConteudo() {
		return conteudo;
	}



	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}



	@Override
	public String toString() {
		return "Dados [id=" + id + ", objeto=" + objeto + ", descricao=" + descricao + ", dt_registo=" + dt_registo
				+ ", conteudo=" + conteudo + " ,filenmae = "+file_name+"]";
	}



	@Override
	public String getConnectionName() {
		return "hibernate-kofax";
	}
}
