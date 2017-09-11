/*-------------------------*/

/*Create Controller*/

package nosi.webapps.kofax.pages.recuperacao;

/*---- Import your packages here... ----*/
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.swing.ImageIcon;

import nosi.core.gui.components.IGRPSeparatorList.Pair;
import nosi.core.webapp.Controller;
import java.sql.Date;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import nosi.core.webapp.Response;
import nosi.core.webapp.Igrp;
import nosi.core.xml.XMLWritter;
import nosi.webapps.kofax.dao.Campos;
import nosi.webapps.kofax.dao.Dados;
import nosi.webapps.kofax.dao.Objeto;
import nosi.webapps.kofax.pages.recuperacao.Recuperacao.Formlist_1;
import nosi.core.webapp.helpers.DateHelper;
import nosi.core.webapp.helpers.IgrpHelper;
import nosi.core.webapp.helpers.Permission;
/*---- End ----*/

public class RecuperacaoController extends Controller {		


	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		/*---- Insert your code here... ----*/														
		Recuperacao model = new Recuperacao();
		String ichange = Igrp.getInstance().getRequest().getParameter("ichange");
		
		if(Igrp.getInstance().getRequest().getMethod().equalsIgnoreCase("POST")){
			model.load();
		}
		List<Recuperacao.Formlist_1> campos = new ArrayList<>();
		if(ichange!=null && model.getTipo_objeto()!=null && !model.getTipo_objeto().equals("")){
			for(Campos c:new Objeto().findOne(model.getTipo_objeto()).getCampos()){
				Formlist_1 e = new Formlist_1();
				e.setCampo(new Pair(c.getCampo(), ""+c.getId()));
				e.setValor(new Pair(" ", " "));
				campos.add(e);
			}
		}
		RecuperacaoView view = new RecuperacaoView(model);
		view.tipo_objeto.setValue(IgrpHelper.toMap(new Objeto().find().andWhere("id_organica", "=", Permission.getCurrentOrganization()).all(), "id", "objeto", "--- Escolher Tipo Objecto ---"));
		view.data_de_registo.setValue(DateHelper.convertDate(new Date(System.currentTimeMillis()).toString(),"yyyy-MM-dd","dd-MM-yyyy"));
		
		view.formlist_1.addData(campos);
		return this.renderView(view);
									/*---- End ----*/
	}
	
	public Response actionGravar() throws IOException, IllegalArgumentException, IllegalAccessException, ServletException{
		/*---- Insert your code here... ----*/														
		Recuperacao model = new Recuperacao();
//		if(Igrp.getInstance().getRequest().getMethod().toUpperCase().equals("POST")){
//			model.load();
//			XMLWritter xml = new XMLWritter();
//			xml.startElement("columns");
//			if(model.getP_campo_fk()!=null){
//				for(int i=0;i<model.getP_campo_fk().length;i++){
//					xml.setElement(model.getP_campo_fk_desc()[i], model.getP_valor_fk_desc()[i]);
//				}
//			}
////			File file = new File("");
//		    byte[] imgInBytes = new byte[(int) Igrp.getInstance().getRequest().getPart("p_imagem").getSize()];
//		    Igrp.getInstance().getRequest().getPart("p_imagem").getInputStream().read(imgInBytes);
////		    FileInputStream fileInputStream = new FileInputStream(file);
////		    fileInputStream.read(imgInBytes);
////		    fileInputStream.close();
//            
//			Objeto obj = new Objeto().findOne(model.getTipo_objeto());
//			Dados dados = new Dados(obj, ""+model.getN_do_negocio(), model.getN_de_processo(), model.getNome(), model.getTipo_documento(), model.getN_de_documento(), model.getEstante(), model.getPasta(), model.getLivro(), model.getFolha(), model.getData_de_registo(), xml.toString(), imgInBytes);
//			if(dados.insert()!=null){
//				Igrp.getInstance().getFlashMessage().addMessage("success", "OperaÃƒÆ’Ã‚Â§ÃƒÆ’Ã‚Â£o realizada com sucesso!");
//			}else{
//				Igrp.getInstance().getFlashMessage().addMessage("error", "OperaÃƒÆ’Ã‚Â§ÃƒÆ’Ã‚Â£o falhau!");
//			}
//		}
		return this.redirect("kofax","Recuperacao","index");
									/*---- End ----*/
	}
	
	/*---- Insert your actions here... ----*//*---- End ----*/
}
