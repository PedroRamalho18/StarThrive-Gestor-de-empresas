/**
 * Classe abstrata para construir os Restaurantes
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
abstract class Restaurante extends Restauracao{

    /**
     * dias de funcionamento da empresa por ano
     */
    protected int diasFuncionamentoAno;
    /**
     * numero de mesas no interior da empresa
     */
    protected int numMesasInterior;
    /**
     * valor médio de faturação por mesa por dia
     */
    protected double valMedFatMesaDia;

    /**
     * Construtor vazio para a Classe Empresas
     */
    Restaurante(){}

    /**
     * Construtor da Classe Cafe
     * @param nome nome da empresa
     * @param distrito distrito da empresa
     * @param localizacao localização da empresa
     * @param numEmpregados número de empregados
     * @param salarioMedioAnual salário médio anual
     * @param numMedClientesDiario número médio de clientes diário
     * @param diasFuncionamentoAno dias de funcionamento por ano
     * @param numMesasInterior número de mesas no interior
     * @param valMedFatMesaDia valor médio de faturação por mesa por dia
     */
    Restaurante(String nome,String distrito,String localizacao,int numEmpregados,double salarioMedioAnual,double numMedClientesDiario,int diasFuncionamentoAno,int numMesasInterior,double valMedFatMesaDia){
        super(nome,distrito,localizacao,numEmpregados,salarioMedioAnual,numMedClientesDiario);
        this.diasFuncionamentoAno=diasFuncionamentoAno;
        this.numMesasInterior=numMesasInterior;
        this.valMedFatMesaDia=valMedFatMesaDia;
    }
    /**
     * Metodo para obter o número de dias de funcionamento por ano
     * @return número de dias de funcionamento por ano
     */
    public int getDiasFuncionamentoAno() {return diasFuncionamentoAno;}
    /**
     * Metodo para definir o número de dias de funcionamento por ano
     * @param diasFuncionamentoAno número de dias de funcionamento por ano
     */
    public void setDiasFuncionamentoAno(int diasFuncionamentoAno) {this.diasFuncionamentoAno = diasFuncionamentoAno;}
    /**
     * Metodo para obter o número de mesas no interior
     * @return número de mesas no interior
     */
    public int getNumMesasInterior() {return numMesasInterior;}
    /**
     * Método para definir o número de mesas no interior
     * @param numMesasInterior  numero de mesas no interior
     */
    public void setNumMesasInterior(int numMesasInterior) {this.numMesasInterior = numMesasInterior;}
    /**
     * Método para obter o valor médio de faturação anual por mesa por dia
     * @return valor médio de faturação anual por mesa por dia
     */
    public double getValMedFatMesaDia() {return valMedFatMesaDia;}
    /**
     * Método para definir o valor médio de faturação anual por mesa por dia
     * @param valMedFatMesaDia valor médio de faturação anual por mesa por dia
     */
    public void setValMedFatMesaDia(double valMedFatMesaDia) {this.valMedFatMesaDia = valMedFatMesaDia;}
    /**
     * Imprime os atributos provenientes da superclasse
     * @return string com a impressao de todos os atributos da superclasse
     */
    @Override
    public String toString(){

        return super.toString();

    }


}
