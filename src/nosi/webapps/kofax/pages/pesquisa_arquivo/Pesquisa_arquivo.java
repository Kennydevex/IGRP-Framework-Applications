/*---------------------- Create Model ----------------------*/
package nosi.webapps.kofax.pages.pesquisa_arquivo;
import nosi.core.config.Config;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.gui.components.IGRPSeparatorList.Pair;
import nosi.core.webapp.SeparatorList;
import java.util.ArrayList;
import java.util.List;

public class Pesquisa_arquivo extends Model{		
	@RParam(rParamName = "p_tipo_de_objecto")
	private String tipo_de_objecto;
	@RParam(rParamName = "p_campo")
	private String campo;
	@RParam(rParamName = "p_valor")
	private String valor;
	@RParam(rParamName = "p_sectionheader_1_text")
	private String sectionheader_1_text;

	@SeparatorList(name = Table_1.class)
	private List<Table_1> table_1 = new ArrayList<>();
	public void setTable_1(List<Table_1> table_1){
		this.table_1 = table_1;
	}
	public List<Table_1> gettable_1(){
		return this.table_1;
	}
	
	public void setTipo_de_objecto(String tipo_de_objecto){
		this.tipo_de_objecto = tipo_de_objecto;
	}
	public String getTipo_de_objecto(){
		return this.tipo_de_objecto;
	}
	
	public void setCampo(String campo){
		this.campo = campo;
	}
	public String getCampo(){
		return this.campo;
	}
	
	public void setValor(String valor){
		this.valor = valor;
	}
	public String getValor(){
		return this.valor;
	}
	
	public void setSectionheader_1_text(String sectionheader_1_text){
		this.sectionheader_1_text = sectionheader_1_text;
	}
	public String getSectionheader_1_text(){
		return this.sectionheader_1_text;
	}


	public static class Table_1{
		private String tipo_de_objecto;
		private String campo;
		private String valor;
		private String arquivo;
		public void setTipo_de_objecto(String tipo_de_objecto){
			this.tipo_de_objecto = tipo_de_objecto;
		}
		public String getTipo_de_objecto(){
			return this.tipo_de_objecto;
		}

		public void setCampo(String campo){
			this.campo = campo;
		}
		public String getCampo(){
			return this.campo;
		}

		public void setValor(String valor){
			this.valor = valor;
		}
		public String getValor(){
			return this.valor;
		}

		public void setArquivo(String arquivo){
			this.arquivo = arquivo;
		}
		public String getArquivo(){
			return this.arquivo;
		}

	}
}
/*-------------------------*/