/**
 * Classe para construir as empresas do tipo Pastelaria
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
class Pastelaria extends Restauracao{
    /**
     * Número médio de bolos vendidos por dia
     */
    private int numBolosDia;
    /**
     * valor médio de faturação anual por bolo vendido por dia
     */
    private double valMedFatBoloDia;
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
     * Construtor vazio para a pastelaria
     */
    Pastelaria(){}

    /**
     * Construtor da Classe pastelaria
     * @param nome nome da empresa
     * @param distrito distrito da empresa
     * @param localizacao localização da empresa
     * @param numEmpregados número de empregados
     * @param numMedClientesDiario número médio de clientes diário
     * @param salarioMedioAnual salário médio anual
     * @param numBolosDia numero de bolos que vendem por dia
     * @param valMedFatBoloDia valor medio de faturação de bolos por dia
     */
    Pastelaria(String nome,String distrito,String localizacao,int numEmpregados,double numMedClientesDiario,double salarioMedioAnual,int numBolosDia,double valMedFatBoloDia){
        super(nome,distrito,localizacao,numEmpregados,salarioMedioAnual,numMedClientesDiario);
        this.numBolosDia=numBolosDia;
        this.valMedFatBoloDia=valMedFatBoloDia;

    }
    /**
     * Metodo para obter o número de bolos que vendem por dia
     * @return número de bolos que vendem por dia
     */
    public int getNumBolosDia() {return numBolosDia;}
    /**
     * Metodo para definir o número de bolos que vendem por dia
     * @param numBolosDia número médio de cafés por dia
     */
    public void setNumBolosDia(int numBolosDia) {this.numBolosDia = numBolosDia;}
    /**
     * Metodo para obter o valor médio de faturação de bolos por dia
     * @return valor médio de faturação de bolos por dia
     */
    public double getValMedFatBoloDia() {return valMedFatBoloDia;}
    /**
     * Metodo para definir o valor médio de faturação de bolos por dia
     * @param valMedFatBoloDia valor médio de faturação de bolos por dia
     */
    public void setValMedFatBoloDia(double valMedFatBoloDia) {this.valMedFatBoloDia = valMedFatBoloDia;}
    /**
     * Método para obter o indice da maior receita anual
     * @return indice da maior receita anual
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
     * Metodo para calcular a despesa anual da empresa
     * @return despesa anual
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
        return this.numBolosDia*this.valMedFatBoloDia;
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
     * Imprime os atributos especificos da Pastelaria e os atributos comuns a todas as aulas
     * @return string com a impressao de todos os atributos da pastelaria
     */
    @Override
    public String toString(){

        return super.toString()+", " +"Pastelaria"+", " + this.despesaAnual() + ", "+this.receitaAnual()+", "+escreveLucro();

    }


}
