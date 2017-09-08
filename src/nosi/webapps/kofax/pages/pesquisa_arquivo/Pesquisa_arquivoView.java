/*-------------------------*/

/*Create View*/

package nosi.webapps.kofax.pages.pesquisa_arquivo;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;

public class Pesquisa_arquivoView extends View {
	
	
	public Field tipo_de_objecto;
	public Field campo;
	public Field valor;
	public Field arquivo;
	public Field sectionheader_1_text;
	public IGRPForm form_1;
	public IGRPTable table_1;
	public IGRPSectionHeader sectionheader_1;

	public IGRPButton btn_pesquisar;
	public Pesquisa_arquivoView(Pesquisa_arquivo model){
		this.setPageTitle("Página para pesquisar o arquivo que queremos");
			
		form_1 = new IGRPForm("form_1","");
		table_1 = new IGRPTable("table_1","");
		sectionheader_1 = new IGRPSectionHeader("sectionheader_1","");
		tipo_de_objecto = new ListField(model,"tipo_de_objecto");
		tipo_de_objecto.setLabel("Tipo de Objecto");
		tipo_de_objecto.setValue("");
		tipo_de_objecto.propertie().add("name","p_tipo_de_objecto").add("type","select").add("multiple","false").add("domain","").add("maxlength","30").add("required","false").add("change","false").add("disabled","false").add("right","false");
		campo = new ListField(model,"campo");
		campo.setLabel("Campo");
		campo.setValue("");
		campo.propertie().add("name","p_campo").add("type","select").add("multiple","false").add("domain","").add("maxlength","30").add("required","false").add("change","false").add("disabled","false").add("right","false");
		valor = new TextAreaField(model,"valor");
		valor.setLabel("Valor");
		valor.setValue("Adipiscing labore natus ipsum");
		valor.propertie().add("name","p_valor").add("type","textarea").add("maxlength","30").add("required","false").add("change","false").add("readonly","false").add("disabled","false").add("placeholder","").add("right","false");
		arquivo = new TextField(model,"arquivo");
		arquivo.setLabel("Arquivo");
		arquivo.setValue("");
		arquivo.propertie().add("name","p_arquivo").add("type","text").add("maxlength","30").add("align","left").add("lookup_parser","false").add("iskey","false");
		sectionheader_1_text = new TextField(model,"sectionheader_1_text");
		sectionheader_1_text.setLabel("");
		sectionheader_1_text.setValue("Pesquiar Arquivo");
		sectionheader_1_text.setValue("Pesquiar Arquivo");
		sectionheader_1_text.propertie().add("type","text").add("name","p_sectionheader_1_text").add("persist","true").add("maxlength","4000");

		btn_pesquisar = new IGRPButton("Pesquisar","kofax","Pesquisa_arquivo","pesquisar","_blank","default|fa-search","","");
		btn_pesquisar.propertie.add("type","form").add("code","").add("class","default").add("rel","pesquisar");
		
	}
		
	@Override
	public void render(){
		
		form_1.addField(tipo_de_objecto);
		form_1.addField(campo);
		form_1.addField(valor);

		table_1.addField(tipo_de_objecto);
		table_1.addField(campo);
		table_1.addField(valor);
		table_1.addField(arquivo);

		sectionheader_1.addField(sectionheader_1_text);

		form_1.addButton(btn_pesquisar);
		this.addToPage(form_1);
		this.addToPage(table_1);
		this.addToPage(sectionheader_1);
	}
}
/*-------------------------*/