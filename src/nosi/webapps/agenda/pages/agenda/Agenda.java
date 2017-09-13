/*---------------------- Create Model ----------------------*/
package nosi.webapps.agenda.pages.agenda;
import nosi.core.config.Config;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.gui.components.IGRPSeparatorList.Pair;
import nosi.core.webapp.SeparatorList;
import java.util.ArrayList;
import java.util.List;

public class Agenda extends Model{		
	@RParam(rParamName = "p_page_title_text")
	private String page_title_text;

	@SeparatorList(name = Separatorlist_1.class)
	private List<Separatorlist_1> separatorlist_1 = new ArrayList<>();
	public void setSeparatorlist_1(List<Separatorlist_1> separatorlist_1){
		this.separatorlist_1 = separatorlist_1;
	}
	public List<Separatorlist_1> getseparatorlist_1(){
		return this.separatorlist_1;
	}
	
	public void setPage_title_text(String page_title_text){
		this.page_title_text = page_title_text;
	}
	public String getPage_title_text(){
		return this.page_title_text;
	}


	public static class Separatorlist_1{
		private Pair servico;
		private Pair numero_de_atendimentos;
		private Pair hora_inicio;
		private Pair hora_fim;
		private Pair dias_de_semana;
		private Pair tempo_medio_de_atendimento_mn;
		private Pair antecedencia_alterarcancelar_hr;
		private Pair antecedencia_de_agendamento_hr;
		private Pair periodo;
		private Pair numero_de_atendedores;
		public void setServico(Pair servico){
			this.servico = servico;
		}
		public Pair getServico(){
			return this.servico;
		}

		public void setNumero_de_atendimentos(Pair numero_de_atendimentos){
			this.numero_de_atendimentos = numero_de_atendimentos;
		}
		public Pair getNumero_de_atendimentos(){
			return this.numero_de_atendimentos;
		}

		public void setHora_inicio(Pair hora_inicio){
			this.hora_inicio = hora_inicio;
		}
		public Pair getHora_inicio(){
			return this.hora_inicio;
		}

		public void setHora_fim(Pair hora_fim){
			this.hora_fim = hora_fim;
		}
		public Pair getHora_fim(){
			return this.hora_fim;
		}

		public void setDias_de_semana(Pair dias_de_semana){
			this.dias_de_semana = dias_de_semana;
		}
		public Pair getDias_de_semana(){
			return this.dias_de_semana;
		}

		public void setTempo_medio_de_atendimento_mn(Pair tempo_medio_de_atendimento_mn){
			this.tempo_medio_de_atendimento_mn = tempo_medio_de_atendimento_mn;
		}
		public Pair getTempo_medio_de_atendimento_mn(){
			return this.tempo_medio_de_atendimento_mn;
		}

		public void setAntecedencia_alterarcancelar_hr(Pair antecedencia_alterarcancelar_hr){
			this.antecedencia_alterarcancelar_hr = antecedencia_alterarcancelar_hr;
		}
		public Pair getAntecedencia_alterarcancelar_hr(){
			return this.antecedencia_alterarcancelar_hr;
		}

		public void setAntecedencia_de_agendamento_hr(Pair antecedencia_de_agendamento_hr){
			this.antecedencia_de_agendamento_hr = antecedencia_de_agendamento_hr;
		}
		public Pair getAntecedencia_de_agendamento_hr(){
			return this.antecedencia_de_agendamento_hr;
		}

		public void setPeriodo(Pair periodo){
			this.periodo = periodo;
		}
		public Pair getPeriodo(){
			return this.periodo;
		}

		public void setNumero_de_atendedores(Pair numero_de_atendedores){
			this.numero_de_atendedores = numero_de_atendedores;
		}
		public Pair getNumero_de_atendedores(){
			return this.numero_de_atendedores;
		}

	}
}
/*-------------------------*/