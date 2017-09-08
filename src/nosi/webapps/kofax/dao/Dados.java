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
	private String estante;
	private String pasta;
	private String livro;
	private String folha;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dt_registo;
	@Column(nullable=false)
	@Lob
	private String conteudo;

	
	public Dados(){}

	

	public Dados(Objeto objeto, String descricao, String estante, String pasta, String livro, String folha,
			String dt_registo, String conteudo) {
		super();
		this.objeto = objeto;
		this.descricao = descricao;
		this.estante = estante;
		this.pasta = pasta;
		this.livro = livro;
		this.folha = folha;
		this.dt_registo = DateHelper.formatDate(dt_registo,"dd-MM-yyyy","yyyy-MM-dd");
		this.conteudo = conteudo;
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



	public String getEstante() {
		return estante;
	}



	public void setEstante(String estante) {
		this.estante = estante;
	}



	public String getPasta() {
		return pasta;
	}



	public void setPasta(String pasta) {
		this.pasta = pasta;
	}



	public String getLivro() {
		return livro;
	}



	public void setLivro(String livro) {
		this.livro = livro;
	}



	public String getFolha() {
		return folha;
	}



	public void setFolha(String folha) {
		this.folha = folha;
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
		return "Dados [id=" + id + ", objeto=" + objeto + ", descricao=" + descricao + ", estante=" + estante
				+ ", pasta=" + pasta + ", livro=" + livro + ", folha=" + folha + ", dt_registo=" + dt_registo
				+ ", conteudo=" + conteudo + "]";
	}



	@Override
	public String getConnectionName() {
		return "hibernate-kofax";
	}
}
