/**
 * Classe abstrata para construir a Restauracao
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
abstract class Restauracao extends Empresa{
    /**
     * número de empregados de mesa
     */
    protected int numEmpregados;
    /**
     * custo do salário médio anual
     */
    protected double salarioMedioAnual;
    /**
     * número médio de clientes diário
     */
    protected double numMedClientesDiario;

    /**
     * Construtor vazio da restauração
     */
    Restauracao(){
    }

    /**
     * Construtor da Classe Restauração
     * @param nome nome da empresa
     * @param distrito distrito da empresa
     * @param localizacao localização da empresa
     * @param numEmpregados número de empregados da empresa
     * @param salarioMedioAnual salário médio anual
     * @param numMedClientesDiario número médio de clientes diário
     */
    Restauracao(String nome, String distrito, String localizacao, int numEmpregados, double salarioMedioAnual,double numMedClientesDiario){
        super(nome,distrito,localizacao);
        this.numEmpregados=numEmpregados;
        this.salarioMedioAnual=salarioMedioAnual;
        this.numMedClientesDiario=numMedClientesDiario;
    }
    /**
     * Metodo para obter o número de empregados da empresa
     * @return número de empregados da empresa
     */
    public int getNumEmpregados() {return numEmpregados;}
    /**
     * Metodo para definir o número de empregados da empresa
     * @param numEmpregados número de empregados da empresa
     */
    public void setNumEmpregados(int numEmpregados) {this.numEmpregados = numEmpregados;}
    /**
     * Metodo para obter o salário médio anual
     * @return salário médio anual
     */
    public double getSalarioMedioAnual() {return salarioMedioAnual;}

    /**
     * Metodo para definir o salário médio anual
     * @param salarioMedioAnual salário médio anual
     */
    public void setSalarioMedioAnual(double salarioMedioAnual) {this.salarioMedioAnual = salarioMedioAnual;}
    /**
     * Imprime os atributos provenientes da superclasse
     * @return string com a impressao de todos os atributos da superclasse
     */
    @Override
    public String toString(){

        return super.toString();
    }
}
