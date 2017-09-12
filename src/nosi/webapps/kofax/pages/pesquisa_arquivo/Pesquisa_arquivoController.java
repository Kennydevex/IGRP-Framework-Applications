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
		//ArrayList<Pesquisa_arquivo.Table_1> lista = new ArrayList<>();
		//for(Dados d: new Dados().find().andWhere("objeto", "=", model.getTipo_de_objecto()).andWhere(columnName, operator, value)) {}
		
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
