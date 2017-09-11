/*-------------------------*/

/*Create Controller*/

package nosi.webapps.kofax.pages.recuperacao;

/*---- Import your packages here... ----*/
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import nosi.core.config.Config;
import nosi.core.gui.components.IGRPSeparatorList.Pair;
import nosi.core.webapp.Controller;
import java.sql.Date;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import nosi.core.webapp.Response;
import nosi.core.webapp.Igrp;
import nosi.webapps.kofax.dao.Campos;
import nosi.webapps.kofax.dao.Dados;
import nosi.webapps.kofax.dao.Objeto;
import nosi.webapps.kofax.pages.recuperacao.Recuperacao.Formlist_1;
import nosi.core.webapp.helpers.DateHelper;
import nosi.core.webapp.helpers.FileHelper;
import nosi.core.webapp.helpers.IgrpHelper;
import nosi.core.webapp.helpers.OCRHelper;
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
				e.setValor(new Pair(c.getValor()!=null?c.getValor():" ", " "));
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
	
	public PrintWriter actionGravar() throws IOException, IllegalArgumentException, IllegalAccessException, ServletException{
		/*---- Insert your code here... ----*/
		Igrp.getInstance().getResponse().setContentType("application/xml");															
		Recuperacao model = new Recuperacao();
		if(Igrp.getInstance().getRequest().getMethod().toUpperCase().equals("POST")){
			model.load();
			String pathImg = Config.getBasePathXsl()+"WebContent/images/IGRP2.3/app/kofax/recuperacao/images";
			Part img = Igrp.getInstance().getRequest().getPart("p_imagem");
			String fileName = img.getName()+"_"+System.currentTimeMillis();
			Dados d = new Dados();
			d.setDescricao(model.getDescricao());
			d.setDt_registo(model.getData_de_registo());
			d.setEstante(model.getEstante());
			d.setFile_name(fileName);
			d.setFolha(model.getFolha());
			d.setLivro(model.getLivro());
			d.setPasta(model.getPasta());
			d.setObjeto(new Objeto().findOne(model.getTipo_objeto()));
			d.setConteudo(" ");
			if(img!=null){
				d.setMime_type(img.getContentType());
			}
			d = d.insert();
			if(d!=null){
				d.setFile_name(d.getFile_name()+"_"+d.getId()+"."+FileHelper.getFileExtension(img));
				
				FileHelper.saveFile(pathImg, d.getFile_name(), img);
				OCRHelper ocr = new OCRHelper(pathImg+File.separator+d.getFile_name());
				ocr.open();
				d.setConteudo(ocr.outputText());
				ocr.outputPDF(pathImg+File.separator+d.getFile_name()+"_"+d.getId());
				ocr.close();
				d.update();
				if(model.getformlist_1().size() > 0 ){
					for(Recuperacao.Formlist_1 formList:model.getformlist_1()){
						Campos c = new Campos().findOne(formList.getCampo().getValue());
						c.setValor(formList.getValor().getKey());
						c.update();
					}
				}	
				return Igrp.getInstance().getResponse().getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><messages><message type=\"success\">Operação efectuada com sucesso</message></messages>");
			}
		}	
		return Igrp.getInstance().getResponse().getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><messages><message type=\"error\">Operação falhada</message></messages>");
		/*---- End ----*/
	}
	
	/*---- Insert your actions here... ----*//*---- End ----*/
}
