#include <stdio.h>
#include <stdlib.h>

enum couleur {TREFLE, CARREAU, PIQUE, COEUR};
enum valeur {SEPT = 7 , HUIT = 8, NEUF = 9, DIX = 10, VALET, DAME, ROI, AS};

typedef struct carte {
	enum couleur c;
	enum valeur v;
} Carte;


void initjeu(Carte jeu[]) /* remplit le tableau avec les 32 cartes */
{
	int i=0, j=0, n=0;
	Carte carteInit;

	for (i=0; i <= COEUR ; i++){
		for (j=0; j <= AS; j++){
			carteInit.c = i;
			carteInit.v = j;
			jeu[n]=carteInit;
			n+=1;}	
	}	
}


int alea32()/* genere un entier aleatoire compris entre 0 et 31 */
{
	int indice=0;
	indice = (rand() % 32);
	return indice;
}


void permute(Carte *carte1, Carte *carte2) /* permute 2 cartes */
{ 
	int couleur = carte1->c, valeur = carte1->v;
	carte1->c = carte2->c;
	carte2->c = couleur;
	carte1->v = carte2->v;
	carte2->v = valeur;
}
	
	


void melange(Carte jeu[]) /* melange les cartes */
{
	initjeu(jeu);
	int i=0;
	while (i<=500){	
		Carte *carte1 = &jeu[alea32()];
		Carte *carte2 = &jeu[alea32()];
		permute(carte1, carte2);
		i++;}
}


void affiche_carte(Carte X) /* affiche une carte (valeur, couleur)*/
{	
	char* couleur;
	char* valeur;
	switch (X.c){
		case 0:
			couleur = "TREFLE";
			break;
		case 1:
			couleur = "CARREAU";
			break;
		case 2:
			couleur = "PIQUE";
			break;
		case 3:
			couleur = "COEUR";
			break;
		default:
			printf("WARNING INVALID CARD");
			break;}
	
	switch (X.v){
		case 7:
			valeur = "SEPT";
			break;
		case 8:
			valeur = "HUIT";
			break;
		case 9:
			valeur = "NEUF";
			break;
		case 10:
			valeur = "DIX";
			break;
		case 11:
			valeur = "VALET";
			break;
		case 12:
			valeur = "DAME";
			break;
		case 13:
			valeur = "ROI";
			break;
		case 14:
			valeur = "AS";
			break;
		default:
			printf("WARNING INVALID CARD");
			break;}
	
	printf("%s de %s", valeur, couleur);		
}


void affiche(Carte jeu[],int N) /* affiche N cartes */
{
	int i;
	for (i=0; i<N; i++){
		affiche_carte(jeu[i]);}
}


void distribue(Carte jeu[], Carte jeu1[], Carte jeu2[]) /* distribue les cartes aux deux joueurs */
{
	int i;
	for (i=0; i<31; i++){
		jeu1[i] = jeu[i];
		jeu2[i] = jeu[i+1];
		i += 2;	}	
}


void joue1coup( Carte jeu1[], Carte jeu2[], int*N1, int*N2) /* gere le resultat d’une bataille (1 coup) */
{

}


int main() {
	Carte jeu[32];
	Carte jeu1[32]; /* cartes du joueur 1 */
	Carte jeu2[32];
	int N1=15; /* indice de la derniere carte joueur 1 */
	int N2=15;

	initjeu(jeu);
	srand(12500); /* initialisation du générateur aléatoire */
	melange(jeu);
	distribue(jeu,jeu1,jeu2);

	while () { /* tant que la partie n’est pas terminee */
		joue1coup(jeu1,jeu2,&N1,&N2);
	}
	/* afficher qui gagne et en combien de coups */
	return 0;
}
