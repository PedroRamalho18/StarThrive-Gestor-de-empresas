/**
 * Classe para construir as empresas do tipo Frutaria
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
class Frutaria extends Mercearia{
    /**
     * número de produtos
     */
    private int numProd;
    /**
     * valor médio de faturação anual por produto
     */
    private double valMedFatAnualProd;

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
     * Construtor vazio da Classe Frutaria
     */
    Frutaria(){}

    /**
     *Construtor da Classe Frutaria
     * @param nome nome da empresa
     * @param distrito distrito da empresa
     * @param localizacao localização da empresa
     * @param custoAnualLimpeza custo anual de limpeza da empresa
     * @param numProd número de produtos
     * @param valMedFatAnualProd valor médio de faturação anual por produto
     */
    Frutaria(String nome,String distrito,String localizacao,double custoAnualLimpeza,int numProd,double valMedFatAnualProd){
        super(nome,distrito,localizacao,custoAnualLimpeza);
        this.numProd=numProd;
        this.valMedFatAnualProd=valMedFatAnualProd;
    }
    /**
     * Metodo para obter o número de produtos
     * @return número de produtos
     */
    public int getNumProd() {return numProd;}
    /**
     * Metodo para definir o número de produtos
     * @param numProd número de produtos
     */
    public void setNumProd(int numProd) {this.numProd = numProd;}
    /**
     * Metodo para obter o valor médio de faturação anual por produto
     * @return valor médio de faturação anual por produto
     */
    public double getValMedFatAnualProd() {return valMedFatAnualProd;}
    /**
     * Metodo para definir o valor médio de faturação anual por produto
     * @param valMedFatAnualProd valor médio de faturação anual por produto
     */
    public void setValMedFatAnualProd(double valMedFatAnualProd) {this.valMedFatAnualProd = valMedFatAnualProd;}
    /**
     * Metodo para calcular a despesa anual da empresa
     * @return despesa anual
     */
    @Override
    double despesaAnual() {
        return this.custoAnualLimpeza;
    }
    /**
     * Metodo para calcular a receita anual da empresa
     * @return receita anual
     */
    @Override
    double receitaAnual(){
        return this.numProd*this.valMedFatAnualProd;
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
        return 0;
    }
    /**
     * Imprime os atributos especificos da Frutaria e os atributos comuns a todas as empresas
     * @return string com a impressao de todos os atributos da Frutaria
     */
    @Override
    public String toString(){

        return super.toString()+ ", " +"Frutaria" +", " + this.despesaAnual() + ", "+this.receitaAnual()+", "+escreveLucro();

    }

}
