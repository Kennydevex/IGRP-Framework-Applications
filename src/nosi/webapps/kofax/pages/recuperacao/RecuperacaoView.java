/*-------------------------*/

/*Create View*/

package nosi.webapps.kofax.pages.recuperacao;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;

public class RecuperacaoView extends View {
	
	
	public Field identificacao;
	public Field tipo_objeto;
	public Field data_de_registo;
	public Field descricao;
	public Field localizacao_fisica;
	public Field estante;
	public Field pasta;
	public Field livro;
	public Field folha;
	public Field adicionar_ficheiro;
	public Field imagem;
	public Field p_id;
	public Field campo;
	public Field valor;
	public IGRPForm form_1;
	public IGRPFormList formlist_1;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_gravar;
	public RecuperacaoView(Recuperacao model){
		this.setPageTitle("Recuperacao de Arquivo");
			
		form_1 = new IGRPForm("form_1","");
		formlist_1 = new IGRPFormList("formlist_1","");
		identificacao = new SeparatorField(model,"identificacao");
		identificacao.setLabel("Identifica�o");
		identificacao.setValue("");
		identificacao.propertie().add("name","p_identificacao").add("type","separator").add("maxlength","30").add("placeholder","").add("right","false");
		tipo_objeto = new ListField(model,"tipo_objeto");
		tipo_objeto.setLabel("Tipo Objeto");
		tipo_objeto.setValue("");
		tipo_objeto.propertie().add("name","p_tipo_objeto").add("type","select").add("multiple","false").add("domain","").add("maxlength","30").add("required","true").add("change","true").add("disabled","false").add("right","false");
		data_de_registo = new DateField(model,"data_de_registo");
		data_de_registo.setLabel("Data de registo");
		data_de_registo.setValue("");
		data_de_registo.propertie().add("name","p_data_de_registo").add("type","date").add("format","IGRP_datePicker").add("maxlength","30").add("required","true").add("change","false").add("readonly","false").add("disabled","false").add("placeholder","").add("right","false").add("class","default");
		descricao = new TextField(model,"descricao");
		descricao.setLabel("Descricao");
		descricao.setValue("Magna perspiciatis laudantium aliqua omnis");
		descricao.propertie().add("name","p_descricao").add("type","text").add("maxlength","100").add("required","false").add("change","false").add("readonly","false").add("disabled","false").add("placeholder","").add("right","false");
		localizacao_fisica = new SeparatorField(model,"localizacao_fisica");
		localizacao_fisica.setLabel("Localiza��o F�sica");
		localizacao_fisica.setValue("");
		localizacao_fisica.propertie().add("name","p_localizacao_fisica").add("type","separator").add("maxlength","30").add("placeholder","").add("right","false");
		estante = new TextField(model,"estante");
		estante.setLabel("Estante");
		estante.setValue("Magna iste consectetur anim ma");
		estante.propertie().add("name","p_estante").add("type","text").add("maxlength","30").add("required","false").add("change","false").add("readonly","false").add("disabled","false").add("placeholder","").add("right","false");
		pasta = new TextField(model,"pasta");
		pasta.setLabel("Pasta");
		pasta.setValue("Deserunt natus unde voluptatem");
		pasta.propertie().add("name","p_pasta").add("type","text").add("maxlength","30").add("required","false").add("change","false").add("readonly","false").add("disabled","false").add("placeholder","").add("right","false");
		livro = new TextField(model,"livro");
		livro.setLabel("Livro");
		livro.setValue("Voluptatem unde totam aliqua a");
		livro.propertie().add("name","p_livro").add("type","text").add("maxlength","30").add("required","false").add("change","false").add("readonly","false").add("disabled","false").add("placeholder","").add("right","false");
		folha = new TextField(model,"folha");
		folha.setLabel("Folha");
		folha.setValue("Omnis sed aliqua iste mollit");
		folha.propertie().add("name","p_folha").add("type","text").add("maxlength","30").add("required","false").add("change","false").add("readonly","false").add("disabled","false").add("placeholder","").add("right","false");
		adicionar_ficheiro = new SeparatorField(model,"adicionar_ficheiro");
		adicionar_ficheiro.setLabel("Adicionar Ficheiro");
		adicionar_ficheiro.setValue("");
		adicionar_ficheiro.propertie().add("name","p_adicionar_ficheiro").add("type","separator").add("maxlength","30").add("placeholder","").add("right","false");
		imagem = new TextField(model,"imagem");
		imagem.setLabel("Imagem");
		imagem.setValue("");
		imagem.propertie().add("name","p_imagem").add("type","img").add("persist","true").add("img","").add("width","500").add("height","400").add("croppie","true").add("rounded","false").add("maxlength","30").add("placeholder","").add("right","false");
		p_id = new HiddenField(model,"p_id");
		p_id.setLabel("");
		p_id.setValue("");
		p_id.propertie().add("name","p_id").add("type","hidden").add("maxlength","30").add("tag","id");
		campo = new PlainTextField(model,"campo");
		campo.setLabel("Campo");
		campo.setValue("");
		campo.propertie().add("name","p_campo").add("type","plaintext").add("maxlength","30").add("right","false").add("desc","true");
		valor = new TextField(model,"valor");
		valor.setLabel("Valor");
		valor.setValue("");
		valor.propertie().add("name","p_valor").add("type","text").add("maxlength","200").add("required","false").add("change","false").add("readonly","false").add("disabled","false").add("placeholder","").add("right","false").add("desc","true");

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");
		btn_gravar = new IGRPButton("Gravar","kofax","Recuperacao","gravar","submit_ajax","success|fa-save","","");
		btn_gravar.propertie.add("type","specific").add("code","").add("rel","gravar");
		
	}
		
	@Override
	public void render(){
		

		form_1.addField(identificacao);
		form_1.addField(tipo_objeto);
		form_1.addField(data_de_registo);
		form_1.addField(descricao);
		form_1.addField(localizacao_fisica);
		form_1.addField(estante);
		form_1.addField(pasta);
		form_1.addField(livro);
		form_1.addField(folha);
		form_1.addField(adicionar_ficheiro);
		form_1.addField(imagem);
		form_1.addField(p_id);

		formlist_1.addField(campo);
		formlist_1.addField(valor);

		toolsbar_1.addButton(btn_gravar);
		this.addToPage(form_1);
		this.addToPage(formlist_1);
		this.addToPage(toolsbar_1);
	}
}
/*-------------------------*/