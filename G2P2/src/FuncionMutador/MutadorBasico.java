/**
 *
 */
package FuncionMutador;

import Poblacion.Individuo;

/**
 * @author sagog
 *
 */
public class MutadorBasico extends Mutador {

	@Override
	protected void mutar(Individuo<?> individuo, double probMutac) {
		// TODO Auto-generated method stub
		individuo.mutarBasico(probMutac);
	}

}
