# JFRACTRAN #
 
## Théorie ##

[FRACTRAN](http://fr.wikipedia.org/wiki/FRACTRAN) est un langage de programmation basé sur des fractions d'entiers naturels.
Il permet de représenter toute fonction opérant sur de tels entiers.
Un programme FRACTRAN prend donc un entier en entrée et en produit un, plusieurs ou une infinité en sortie.

### Principes ###

Le FRACTRAN s'appuie sur la décomposition en produits de facteurs premiers des entiers et sur la notion de valuation p-adique.

Une valuation est notée <code>v<sub>p</sub>(a)</code> où  :

* `p` est le facteur premier
* `a` est l'entier à décomposer

Par exemple, si `a` vaut `126`, nous avons :

* <code>v<sub>2</sub>(a) = 1</code>
* <code>v<sub>3</sub>(a) = 2</code>
* <code>v<sub>7</sub>(a) = 1</code>

En effet, `2`, `3`, et `7` sont bien premiers et `2 * 3 * 3 * 7 = 126`.

Si `p` n'est pas un facteur premier de la décomposition d'un entier `a`, alors <code>v<sub>p</sub>(a) = 0</code>.

Effectuer des multiplications ou des divisons revient alors à additionner ou soustraire des valuations.

#### Multiplication #####

Soient `a` et `b` valant respectivement `14` et `10`. Nous avons alors :

* <code>v<sub>2</sub>(a) = 1</code>
* <code>v<sub>7</sub>(a) = 1</code>
* <code>v<sub>2</sub>(b) = 1</code>
* <code>v<sub>5</sub>(b) = 1</code>

Si `c` vaut `a * b`, alors :

* <code>v<sub>2</sub>(c) = 2</code>
* <code>v<sub>5</sub>(c) = 1</code>
* <code>v<sub>7</sub>(c) = 1</code>

`c` est donc égal à `2 * 2 * 5 * 7 = 140`.

#### Division ####

Un entier n'est pas toujours divisible par un autre.
`a` divise `b` si et seulement si, pour tout nombre premier `p`, <code>v<sub>p</sub>(a) < v<sub>p</sub>(b)</code>.

Soient `a` et `b` valant respectivement `20` et `10`. Nous avons alors :

* <code>v<sub>2</sub>(a) = 2</code>
* <code>v<sub>5</sub>(a) = 1</code>
* <code>v<sub>2</sub>(b) = 1</code>
* <code>v<sub>5</sub>(b) = 1</code>

Si `c` vaut `a / b`, alors :

* <code>v<sub>2</sub>(c) = 1</code>

`c` est donc égal à `2`.

### Algorithme ###

Soient :

* `f` une fraction (le numérateur `fn` et le dénominateur `fd` ont été décomposés en produits de facteurs premiers)
* `p` et `a` des entiers décomposés en produits de facteurs premiers

Alors :

 1. `f` devient la première fraction de la liste.
 2. `p` devient le produit de `f` et de `a`.
  * Si `p` est un entier (donc si `fd` divise `fn * a`), alors `a` devient `p` et on retourne à l'étape 1.
  * Sinon, s'il y a une fraction suivante, `f` devient cette fraction et on retourne à l'étape 2, sinon l'algorithme se termine.

L'algorithme retourne la liste de tous les entiers issus des multiplications de fractions.

## Implémentation ##

### Généralités ###

JFRACTRAN est un interpréteur FRACTRAN écrit en Java.

Dans JFRACTRAN, une décomposition est une table de valuations où :

* chaque clé est un facteur
* chaque valeur est un exposant

### Programmes FRACTRAN ###

Pour écrire un programme FRACTRAN, il faut créer une classe héritant de `FractranProgram` et y spécifier :

* une liste de fractions
* une valeur de base injectée dans la liste des fractions
* une méthode de transformation (`process`) de chaque décomposition retournée par l'algorithme en un ou plusieurs entiers
* éventuellement une limite pour le nombre de résultats à calculer (pour éviter les calculs à l'infini)
* éventuellement une méthode de filtrage (`accept`) pour filtrer les résultats (notamment pour les programmes générant des termes de suites)

Quelques programmes d'exemple tirés de la [page Wikipédia](http://fr.wikipedia.org/wiki/FRACTRAN) ont été écrits :

* l'addition
* la soustraction
* la multiplication
* la division (le programme renvoie le quotient et le reste)
* le programme de génération des nombres premiers de Conway
* le programme de génération des termes de la suite de Fibonacci
* le programme de génération des termes de la suite de Syracuse (compressée)

### Autres détails techniques ###

Le projet JFRACTRAN a été construit en tant que projet [Maven](http://maven.apache.org/) avec les plugins suivants :

* [Cobertura](http://mojo.codehaus.org/cobertura-maven-plugin/)
* [Javadoc](http://maven.apache.org/plugins/maven-javadoc-plugin/)
* [JUnit](http://maven.apache.org/surefire/maven-surefire-plugin/examples/junit.html)

Le code est bien documenté et testé (couverture à 100 %). Ce projet peut donc servir, dans une certaine mesure, à s'initier à Maven et à JUnit.