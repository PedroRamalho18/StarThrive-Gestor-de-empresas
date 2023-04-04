/**
 * Classe para construir as empresas do tipo Restaurante Fast-food
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
class FastFood extends Restaurante{
    /**
     * Número médio diário de clientes drive-thru
     */
    private double numMedClientesDT;
    /**
     * valor médio diário da faturação de clientes drive-thru
     */
    private double valMedFatClientesDT;
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
     * Construtor vazio da Classe Restaurante Fast-food
     */
    FastFood(){}

    /**
     * Construtor da Classe Restaurante Fast-food
     * @param nome nome da empresa
     * @param distrito distrito da empresa
     * @param localizacao localização da empresa
     * @param numEmpregados número de empregados
     * @param salarioMedioAnual salário médio anual
     * @param numMedClientesDiario número médio de clientes diário
     * @param diasFuncionamentoAno dias de funcionamento por ano
     * @param numMesasInterior numero de mesas no interior
     * @param valMedFatMesaDia valor medio de faturação por mesa por dia
     * @param numMedClientesDT número médio diário de clientes drive-thru
     * @param valMedFatClientesDT valor médio diário de faturação de clientes drive-thru
     */
    FastFood(String nome,String distrito,String localizacao,int numEmpregados,double salarioMedioAnual,double numMedClientesDiario,int diasFuncionamentoAno,int numMesasInterior,double valMedFatMesaDia, double numMedClientesDT,double valMedFatClientesDT){
        super(nome,distrito,localizacao,numEmpregados,salarioMedioAnual,numMedClientesDiario,diasFuncionamentoAno,numMesasInterior,valMedFatMesaDia);
        this.numMedClientesDT=numMedClientesDT;
        this.valMedFatClientesDT=valMedFatClientesDT;
    }
    /**
     * Metodo para obter o número médio diário de clientes drive-thru
     * @return número de mesas da esplanada
     */
    public double getNumMedClientesDT() {return numMedClientesDT;}
    /**
     * Metodo para definir o número médio diário de clientes drive-thru
     * @param numMedClientesDT número médio diário de clientes drive-thru
     */
    public void setNumMedClientesDT(double numMedClientesDT) {this.numMedClientesDT = numMedClientesDT;}
    /**
     * Metodo para obter o valor médio diário de faturação de clientes drive-thru
     * @return número de mesas da esplanada
     */
    public double getValMedFatClientesDT() {return valMedFatClientesDT;}
    /**
     * Metodo para definir o valor médio diário de faturação de clientes drive-thru
     * @param valMedFatClientesDT valor médio diário de faturação de clientes drive-thru
     */
    public void setValMedFatClientesDT(double valMedFatClientesDT) {this.valMedFatClientesDT = valMedFatClientesDT;}
    /**
     * Metodo para calcular a despesa anual da empresa
     * @return custoEmpregadosMesa anual
     */
    @Override
    double despesaAnual() {
        return this.numEmpregados * this.salarioMedioAnual;
    }
    /**
     * Metodo para calcular a receita anual da empresa
     * @return receita anual
     */
    @Override
    double receitaAnual(){
        return (this.numMesasInterior*this.valMedFatMesaDia+this.numMedClientesDT*this.valMedFatClientesDT)*this.diasFuncionamentoAno;
    }
    /**
     * Metodo para alterar o indice da empresa com maior receita anual
     */
    @Override
    void alteraIndiceReceita(int i) {
        indiceMRA=i;
    }
    /**
     * Metodo para alterar o indice da empresa com menor despesa
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
     * Metodo para devolver o indice da empresa com menor custoEmpregadosMesa anual
     * @return indice da empresa com menor custoEmpregadosMesa anual
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
        return this.numMedClientesDT+this.numMedClientesDiario;
    }
    /**
     * Imprime os atributos especificos do Restaurante fast-food e os atributos comuns a todas as empresas
     * @return string com a impressao de todos os atributos do Restaurante fast-food
     */
    @Override
    public String toString(){

        return super.toString()+ ", " + "Restaurante Fast-food" +", " + this.despesaAnual() + ", "+this.receitaAnual()+", "+escreveLucro();

    }
}
