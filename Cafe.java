/**
 * Classe para construir as empresas do tipo cafe
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
class Cafe extends Restauracao {
    /**
     * Número médio de cafés vendpor dia
     */
    private double numMedCafesDia;
    /**
     * valor médio de faturação anual por café vendido por dia
     */
    private double valMedFatCafeDia;
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
     * Construtor vazio para o café
     */
    Cafe(){}

    /**
     * Construtor da Classe Cafe
     * @param nome nome da empresa
     * @param distrito distrito da empresa
     * @param localizacao localização da empresa
     * @param numEmpregados número de empregados
     * @param salarioMedioAnual salário médio anual
     * @param numMedClientesDiario número médio de clientes diário
     * @param numMedCafesDia número médio de cafés por dia
     * @param valMedFatCafeDia valor médio de faturação de cafés por dia
     */
    Cafe(String nome,String distrito,String localizacao,int numEmpregados,double salarioMedioAnual,double numMedClientesDiario,double numMedCafesDia,double valMedFatCafeDia){
        super(nome,distrito,localizacao,numEmpregados,salarioMedioAnual,numMedClientesDiario);
        this.numMedCafesDia=numMedCafesDia;
        this.valMedFatCafeDia=valMedFatCafeDia;
    }

    /**
     * Metodo para obter o número médio de cafés por dia
     * @return número médio de cafés por dia
     */
    public double getNumMedCafesDia () {return numMedCafesDia; }
    /**
     * Metodo para definir o número médio de cafés por dia
     * @param numMedCafesDia número médio de cafés por dia
     */
    public void setNumMedCafesDia (double numMedCafesDia) {this.numMedCafesDia = numMedCafesDia;}
    /**
     * Metodo para obter o valor médio de faturação de cafés por dia
     * @return número médio de cafés por dia
     */
    public double getValMedFatCafeDia () {return valMedFatCafeDia; }
    /**
     * Metodo para definir o valor médio de faturação de cafés por dia
     * @param valMedFatCafeDia valor médio de faturação de cafés por dia
     */
    public void setValMedFatCafeDia (double valMedFatCafeDia) {this.valMedFatCafeDia = valMedFatCafeDia;}

    /**
     * Metodo para obter o indice da empresa com maior receita anual
     * @return indice da empresa com maior receita anual
     */
    public static int getIndiceMRA() {
        return indiceMRA;
    }
    /**
     * Metodo para definir o indice da empresa com maior receita anual
     * @param indiceMRA indice da empresa com maior receita anual
     */
    public static void setIndiceMRA(int indiceMRA) {
        indiceMRA = indiceMRA;
    }
    /**
     * Metodo para obter o indice da empresa com menor custoEmpregadosMesa anual
     * @return indice da empresa com menor custoEmpregadosMesa anual
     */
    public static int getIndicemDA() {
        return indicemDA;
    }
    /**
     * Metodo para definir o indice da empresa com menor custoEmpregadosMesa anual
     * @param indicemDA indice da empresa com menor custoEmpregadosMesa anual
     */
    public static void setIndicemDA(int indicemDA) {
        indicemDA = indicemDA;
    }
    /**
     * Metodo para obter o indice da empresa com maior lucro anual
     * @return indice da empresa com maior lucro anual
     */
    public static int getIndiceMLA() {
        return indiceMLA;
    }
    /**
     * Metodo para definir o indice da empresa com maior lucro anual
     * @param indiceMLA indice da empresa com maior lucro anual
     */
    public static void setIndiceMLA(int indiceMLA) {
        indiceMLA = indiceMLA;
    }

    /**
     * Metodo para calcular e devolver a despesa anual da empresa
     * @return despesa anual
     */
    @Override
    double despesaAnual() {
        return this.numEmpregados * this.salarioMedioAnual;
    }
    /**
     * Metodo para calcular e devolver a receita anual da empresa
     * @return receita anual
     */
    @Override
    double receitaAnual(){
        return this.numMedCafesDia*this.valMedFatCafeDia;
    }
    /**
     * Metodo para atualizar o indice da empresa com maior receita anual
     */
    @Override
    void alteraIndiceReceita(int i) {
        indiceMRA=i;
    }
    /**
     * Metodo para atualizar o indice da empresa com menor despesa anual
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
     * Imprime os atributos especificos do Cafe e os atributos comuns a todas as empresas
     * @return string com a impressao de todos os atributos do cafe
     */
    @Override
    public String toString(){

        return super.toString()+ ", " + "Cafe"+ ", "+ this.despesaAnual() + ", "+this.receitaAnual()+", "+escreveLucro();

    }
}
