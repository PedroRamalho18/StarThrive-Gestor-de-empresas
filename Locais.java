/**
 * Classe para construir as empresas do tipo Restaurante local
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
class Locais extends Restaurante{
    /**
     * Número de mesas na esplanada
     */
    private int numMesasEsplanada;
    /**
     * Custo da licença anual da esplanada
     */
    private double custoLicAnualEsplanada;
    /**
     * atributo estático para guardar o indice da empresa com maior receita anual
     */
    private static int indiceMRA=-1;
    /**
     * atributo estático para guardar o indice da empresa com menor custoEmpregadosMesa anual
     */
    private static int indicemDA=-1;
    /**
     * atributo estático para guardar o indice da empresa com maior lucro anual
     */
    private static int indiceMLA=-1;

    /**
     * Construtor vazio do restaurante local
     */
    Locais(){}

    /**
     * Construtor da Classe Restaurante local
     * @param nome nome da empresa
     * @param distrito distrito da empresa
     * @param localizacao localização da empresa
     * @param numEmpregados número de empregados
     * @param salarioMedioAnual salário médio anual
     * @param numMedClientesDiario número médio de clientes diário
     * @param diasFuncionamentoAno dias de funcionamento por ano
     * @param numMesasInterior numero de mesas no interior
     * @param valMedFatMesaDia valor medio de faturação por mesa por dia
     * @param numMesasEsplanada numero de mesas na esplanada
     * @param custoLicAnualEsplanada custo da licença anual da esplanada
     */
    Locais(String nome,String distrito,String localizacao,int numEmpregados,double salarioMedioAnual,double numMedClientesDiario,int diasFuncionamentoAno,int numMesasInterior,double valMedFatMesaDia,int numMesasEsplanada,double custoLicAnualEsplanada){
        super(nome,distrito,localizacao,numEmpregados,salarioMedioAnual,numMedClientesDiario,diasFuncionamentoAno,numMesasInterior,valMedFatMesaDia);
        this.numMesasEsplanada=numMesasEsplanada;
        this.custoLicAnualEsplanada=custoLicAnualEsplanada;
    }
    /**
     * Metodo para obter o número de mesas da esplanada
     * @return número de mesas da esplanada
     */
    public int getNumMesasEsplanada() {return numMesasEsplanada;}
    /**
     * Metodo para definir o número de mesas da esplanada
     * @param numMesasEsplanada número de mesas da esplanada
     */
    public void setNumMesasEsplanada(int numMesasEsplanada) {this.numMesasEsplanada = numMesasEsplanada;}
    /**
     * Metodo para obter o custo da licença anual da esplanada
     * @return custo da licença anual da esplanada
     */
    public double getCustoLicAnualEsplanada() {return custoLicAnualEsplanada;}
    /**
     * Metodo para definir o custo da licença anual da esplanada
     * @param custoLicAnualEsplanada custo da licença anual da esplanada
     */
    public void setCustoLicAnualEsplanada(double custoLicAnualEsplanada) {this.custoLicAnualEsplanada = custoLicAnualEsplanada;}
    /**
     * Metodo para calcular a despesa anual da empresa
     * @return despesa anual
     */
    @Override
    double despesaAnual() {
        return this.numEmpregados * this.salarioMedioAnual + this.numMesasEsplanada* this.custoLicAnualEsplanada;
    }
    /**
     * Metodo para calcular a receita anual da empresa
     * @return receita anual
     */
    @Override
    double receitaAnual(){
        return (this.numMesasEsplanada+this.numMesasInterior)*this.valMedFatMesaDia*this.diasFuncionamentoAno;
    }
    /**
     * Metodo para alterar o indice da empresa com maior receita anual
     */
    @Override
    void alteraIndiceReceita(int i) {
        indiceMRA=i;
    }
    /**
     * Metodo para alterar o indice da empresa com menor custoEmpregadosMesa
     */
    @Override
    void alteraIndiceDespesa(int i) {
        indicemDA=i;
    }
    /**
     * Metodo para alterar o indice da empresa com maior lucro anual
     */
    @Override
    void alteraIndiceLucro(int i) {
        indiceMLA=i;
    }
    /**
     * Metodo para devolver o indice da empresa com maior receita anual
     * @return indice da empresa com maior receita anual
     */
    @Override
    int devolveIndiceReceita() {
        return indiceMRA;
    }
    /**
     * Metodo para devolver o indice da empresa com menor despesa anual
     * @return indice da empresa com menor despesa anual
     */
    @Override
    int devolveIndiceDespesa() {
        return indicemDA;
    }
    /**
     * Metodo para devolver o indice da empresa com maior lucro anual
     * @return indice da empresa com maior lucro anual
     */
    @Override
    int devolveIndiceLucro() {
        return indiceMLA;
    }
    /**
     * Metodo para devolver a capacidade de clientes por dia da empresa
     * @return capacidade de clientes por dia da empresa
     */
    @Override
    double capacidadeClientesDia() {
        return this.numMedClientesDiario;
    }

    /**
     * Imprime os atributos especificos do Restaurante local e os atributos comuns a todas as empresas
     * @return string com a impressao de todos os atributos do Restaurante local
     */
    @Override
    public String toString(){

        return super.toString()+ ", "+"Restaurante local" +", "+ this.despesaAnual() + ", "+this.receitaAnual()+", "+escreveLucro();

    }

}
