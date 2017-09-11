/*-------------------------*/

/*Create Controller*/

package nosi.webapps.kofax.pages.pesquisa_arquivo_pdf;
/*---- Import your packages here... ----*/
import nosi.core.webapp.Controller;
import java.io.IOException;
import nosi.core.webapp.Response;

/*---- End ----*/

public class Pesquisa_arquivo_pdfController extends Controller {		


	public Response actionIndex() throws IOException{
		/*---- Insert your code here... ----*/
		Pesquisa_arquivo_pdf model = new Pesquisa_arquivo_pdf();
		Pesquisa_arquivo_pdfView view = new Pesquisa_arquivo_pdfView(model);
		return this.renderView(view);
		/*---- End ----*/
	}


	public Response actionPesquisar() throws IOException{
		/*---- Insert your code here... ----*/
		return this.redirect("kofax","Pesquisa_arquivo_pdf","index");
		/*---- End ----*/
	}
	
	/*---- Insert your actions here... ----*//*---- End ----*/
}
