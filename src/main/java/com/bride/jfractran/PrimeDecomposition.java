package com.bride.jfractran;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * Représente la décomposition en produits de facteurs premiers d'un entier.
 * C'est une table de hachage dont les clés sont les facteurs premiers et les
 * valeurs leurs exposants. Autrement dit, chaque entrée de clé <code>p</code>
 * et de valeur <code>e</code> de la table est la valuation p-adique de l'entier
 * décomposé <code>a</code> : <code>v<sub>p</sub>(a) = e</code>.
 * On ne fait pas hériter la classe de HashTable pour avoir le contrôle total
 * sur les valuations afin notamment d'interdir des valeurs négatives pour les
 * exposants des facteurs.
 * @author Maxime BRIDE
 * @link http://fr.wikipedia.org/wiki/Nombre_p-adique#Approche_analytique
 */
public class PrimeDecomposition {
	private static Hashtable<Long, PrimeDecomposition> CACHE =
			new Hashtable<Long, PrimeDecomposition>();
	
	private Hashtable<Long, Long> _valuations;

	/**
	 * Constructeur par défaut.
	 * Ne contient aucune valuation.
	 * Equivaut à <code>PrimeDecomposition.decompose(1)</code>.
	 * @see PrimeDecomposition#decompose(long)
	 */
	public PrimeDecomposition() {		
		_valuations = new Hashtable<Long, Long>();
	}

	/**
	 * Constructeur de recopie.
	 * Initialise avec les valuations de la décomposition <code>p</code>.
	 */
	protected PrimeDecomposition(PrimeDecomposition p) {		
		_valuations = new Hashtable<Long, Long>(p._valuations);
	}
	
	/**
	 * Décompose l'entier <code>n</code> en produits de facteurs premiers.
	 * L'algorithme utilisé n'est pas très efficace mais il n'est pas censé
	 * être utilisé sur de grands entiers (seulement sur les entiers des
	 * fractions).
	 * On utilise un système de cache pour ne pas décomposer un nombre qui
	 * l'avait déjà été.
	 * @param n L'entier à décomposer en produits de facteurs premiers.
	 * @throws IllegalArgumentException Si <code>n</code> est négatif ou nul.
	 * @link http://6clistefransois.free.fr/Algo/Div.html
	 */
	public static PrimeDecomposition decompose(long n) {
		PrimeDecomposition res = CACHE.get(n);
		long d;
		double n2 = n;
		double nd, root;
		
		if(n <= 0) {
			throw new IllegalArgumentException();
		}
		
		if(res == null) {
			res = new PrimeDecomposition();
			
			d = 2L;
			root = Math.sqrt(n2);

			while(d <= root) {
				nd = n2 / d;
				
				while(Math.floor(nd) == nd) {
					res.put(d, res.get(d) + 1);
					n2 = n2 / d;
					nd = n2 / d;
				}
				d++;
			}
			
			if(n2 > 1) {
				res.put((long)n2, 1L);
			}
			
			CACHE.put(n, res);
		} else {
			/* On copie la décomposition du cache pour ne pas que l'originale
			 * puisse être modifiée.
			 */
			res = new PrimeDecomposition(res);
		}
		
		return res;
	}
	
	/**
	 * Retourne l'exposant du facteur <code>factor</code>.
	 * @param factor Le facteur dont on veut l'exposant.
	 * @return l'exposant du facteur <code>key</code> ou 0 si l'exposant n'est
	 * pas dans la table.
	 */
	public long get(long factor) {
		Long value = _valuations.get(factor);
		
		return value == null ? 0 : value;
	}
	
	/**
	 * Spécifie la valeur de l'exposant du facteur <code>factor</code>.
	 * @param factor Le facteur dont on modifie l'exposant.
	 * @param exponent L'exposant.
	 * @return L'ancien exposant du facteur <code>factor</code>.
	 * @throws IllegalArgumentException Si l'exposant est négatif ou nul.
	 */
	public long put(long factor, long exponent) {
		Long ret;
		
		if(exponent <= 0) {
			throw new IllegalArgumentException();
		}
		
		ret = _valuations.put(factor, exponent);
		
		return ret == null ? 0L : ret;
	}
	
	/**
	 * Supprime le vateur des valuations de l'entier courant.
	 * @param factor Le facteur à supprimer.
	 * @return L'exposant du facteur supprimé ou 0 s'il n'existait pas.
	 */
	public long remove(long factor) {
		Long ret = _valuations.remove(factor);
		
		return ret == null ? 0L : ret;
	}
	
	/**
	 * Retourne le nombre de valuations de la décomposition.
	 * @return Le nombre de valuations.
	 */
	public int size() {
		return _valuations.size();
	}
	
	/**
	 * Indique si la décomposition contient le facteur <code>factor</code>.
	 * @param factor Le facteur dont on teste l'existance.
	 * @return true si le facteur existe, false sinon.
	 */
	public boolean containsFactor(long factor) {
		return _valuations.containsKey(factor);
	}
	
	/**
	 * Calcule la valeur entière de la décomposition. On effectue donc une
	 * "recomposition".
	 * @return La valeur entière issue de la recomposition.
	 */
	public long compute() {
		Set<Map.Entry<Long, Long>> entries = _valuations.entrySet();
		long res = 1;
		
		for(Map.Entry<Long, Long> entry : entries) {
			res *= (long)Math.pow(entry.getKey(), entry.getValue());
		}
		
		return res;
	}
	
	/**
	 * Multiplie la décomposition courante par la décomposition <code>pd</code>.
	 * Cela consiste à calculer <code>v<sub>p</sub>(a) + v<sub>p</sub>(b)</code>
	 * avec <code>a</code> l'entier dont la décomposition est <code>this</code>, 
	 * <code>b</code> l'entier dont la décomposition est <code>pd</code> et
	 * <code>p</code> un facteur premier présent dans la décomposition de
	 * <code>a</code> ou de <code>b</code> ou dans les deux.
	 * @param pd La décomposition à utiliser pour la multiplication.
	 * @return La décomposition issue de la multiplication.
	 */
	public PrimeDecomposition multiply(PrimeDecomposition pd) {
		PrimeDecomposition res = new PrimeDecomposition(this);
		Set<Map.Entry<Long, Long>> entries = pd._valuations.entrySet();
		
		for(Map.Entry<Long, Long> entry : entries) {
			long factor = entry.getKey();
			long exp1 = entry.getValue();
			long exp2 = get(factor);
			
			res.put(factor, exp1 + exp2);
		}
		
		return res;
	}
	
	/**
	 * Divise la décomposition courante par la décomposition <code>pd</code>.
	 * Cela consiste à calculer <code>v<sub>p</sub>(a) - v<sub>p</sub>(b)</code>
	 * avec  <code>a</code> l'entier dont la décomposition est
	 * <code>this</code>,  <code>b</code> l'entier dont la décomposition est
	 * <code>pd</code> et<code>p</code> un facteur premier présent dans la
	 * décomposition de <code>a</code> et de <code>b</code>.
	 * <code>b</code> divise <code>a</code> si et seulement si, pour tout
	 * nombre premier <code>p</code>, <code>v<sub>p</sub>(b) < v<sub>p</sub>(a)</code>.
	 * @param pd La décomposition à utiliser pour la division.
	 * @return La décomposition issue de la division ou nul si le résultat
	 * n'est pas un entier.
	 * @link http://fr.wikipedia.org/wiki/D%C3%A9composition_en_produit_de_facteurs_premiers#D.C3.A9composition_et_valuation
	 */
	public PrimeDecomposition divide(PrimeDecomposition pd) {
		PrimeDecomposition res = new PrimeDecomposition(this);
		Set<Map.Entry<Long, Long>> entries = pd._valuations.entrySet();
		
		for(Map.Entry<Long, Long> entry : entries) {
			long factor = entry.getKey();
			long exponent = get(factor) - entry.getValue();
			
			if(exponent < 0) {
				return null; //pd ne divise pas la décomposition courante.
			}
			
			if(exponent == 0) {
				res.remove(factor);
			} else {
				res.put(factor, exponent);
			}
		}
		
		return res;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof PrimeDecomposition)) {
			return false;
		}
		
		if(o == this) {
			return true;
		}
		
		return _valuations.equals(((PrimeDecomposition)o)._valuations);
	}
}
