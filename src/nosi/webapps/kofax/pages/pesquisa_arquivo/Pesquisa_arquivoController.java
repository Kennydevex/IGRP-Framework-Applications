/*-------------------------*/

/*Create Controller*/

package nosi.webapps.kofax.pages.pesquisa_arquivo;
/*---- Import your packages here... ----*/
import nosi.core.webapp.Controller;
import nosi.core.webapp.Igrp;

import java.io.IOException;
import java.util.ArrayList;

import nosi.core.webapp.Response;
import nosi.core.webapp.helpers.IgrpHelper;
import nosi.core.webapp.helpers.Permission;
import nosi.webapps.kofax.dao.Campos;
import nosi.webapps.kofax.dao.Campos_Dados;
import nosi.webapps.kofax.dao.Dados;
import nosi.webapps.kofax.dao.Objeto;

/*---- End ----*/

public class Pesquisa_arquivoController extends Controller {		


	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		/*---- Insert your code here... ----*/		
		Pesquisa_arquivo model = new Pesquisa_arquivo();
		//recupera os valor escolhidos
		if(Igrp.getInstance().getRequest().getMethod().equalsIgnoreCase("POST")){
			model.load();
		}
		Pesquisa_arquivoView view = new Pesquisa_arquivoView(model);
		//inicializa o tipo de objecto
		view.tipo_de_objecto.setValue(IgrpHelper.toMap(new Objeto().find().andWhere("id_organica", "=", Permission.getCurrentOrganization()).all(), "id", "objeto", "--- Escolher Tipo Objecto ---"));
		String ichange = Igrp.getInstance().getRequest().getParameter("ichange");
		if(ichange != null && model.getTipo_de_objecto()!= null && !model.getTipo_de_objecto().equals("")) {
			view.campo.setValue(IgrpHelper.toMap(new ArrayList<>(new Objeto().findOne(model.getTipo_de_objecto()).getCampos()), "id", "campo", "--- Escolher Tipo campo ---"));
		}
		//Para alimentar a tabela
		ArrayList<Pesquisa_arquivo.Table_1> lista = new ArrayList<>();
		for(Campos_Dados cd: new Campos_Dados().find().andWhere("campo", "=", model.getCampo()).andWhere("valor", "like", model.getValor()).all()) {
			Pesquisa_arquivo.Table_1 tabela = new Pesquisa_arquivo.Table_1();
			tabela.setTipo_de_objecto(cd.getDados().getObjeto().getObjeto());
			tabela.setDescricao(cd.getDados().getDescricao());
			tabela.setData_registo(""+cd.getDados().getDt_registo());
			tabela.setLink_1_desc(cd.getDados().getFile_name());
			lista.add(tabela);
		}
		view.table_1.addData(lista);
		
		return this.renderView(view);
			/*---- End ----*/
	}


	public Response actionPesquisar() throws IOException{
		/*---- Insert your code here... ----*/		
		
		return this.redirect("kofax","ListaObjeto","index");
			/*---- End ----*/
	}
	
	/*---- Insert your actions here... ----*//*---- End ----*/
}
