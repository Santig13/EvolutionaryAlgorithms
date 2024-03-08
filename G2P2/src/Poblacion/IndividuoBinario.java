package Poblacion;

import java.util.Random;

public abstract class IndividuoBinario extends Individuo<Boolean> {

	protected double getFenotipo(int i) {
		// TODO Auto-generated method stub
		return min[i]+this.bin2dec(i)*((max[i]-min[i])/(Math.pow(2,this.tamGen[i])-1)) ;
	}

	protected double bin2dec(int v) {
		int decimal=0;
		for(int i=inicioGen[v]+this.tamGen[v]-1;i>=inicioGen[v];i--) {
			int posicion=(inicioGen[v]+this.tamGen[v]-1)-i;
			if(this.cromosoma[i]) {
				decimal+=Math.pow(2, posicion);
			}
		}
		return decimal;
	}

	@Override
	public void cruzarMonopunto(int i, Individuo<?> padre2) {
		// TODO Auto-generated method stub
		Boolean[] cromosomaPadre=(Boolean[]) padre2.getCromosoma();
		for(int x=i;x<cromosoma.length;x++) {
			cromosoma[x]=cromosomaPadre[x];
		}

	}
	@Override
	public void cruzarUniforme(Boolean[] cruzar, Individuo<?> padre2) {
		// TODO Auto-generated method stub
		Boolean[] cromosomaPadre=(Boolean[]) padre2.getCromosoma();
		for(int i=0;i<cromosoma.length;i++) {
			if(cruzar[i]) {
				cromosoma[i]=cromosomaPadre[i];
			}
		}
	}

	@Override
	public void mutarBasico(double probMutac) {
		// TODO Auto-generated method stub
		Random r=new Random();
		for(int i=0;i<cromosoma.length;i++) {
			double p=r.nextDouble();
			if(p<probMutac) {
				cromosoma[i]=!cromosoma[i];
			}
		}
	}

}
