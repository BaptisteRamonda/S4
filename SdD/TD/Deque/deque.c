#include <stdio.h>
#include <stdlib.h>
#include "deque.h"

/*
DEFINITION DES STRUCTURES
*/
//Structure explicite d'un élément de la liste
struct s_element{
    int item;
    struct s_element* next;
    struct s_element* previous;
};

//Structure explicite de la liste
struct s_list{
    Element head;
    Element tail;
    int size;
};

/*
DEFINITION DES FONCTIONS
*/

List push_front(List l, int e){
    //On crée un élément
    Element elem = (Element) malloc(sizeof(Element));
    //On remplit la structure
    elem->item = e;
    elem->next = l->head;
    elem->previous = NULL;
    //On modifie l'ancienne tête si elle existe
    if (l->head != NULL)
        l->head->previous = elem;
    else //Liste vide
        l->tail = e;
    //On met à jour la liste
    l->head = elem;
    l->size ++;
    return l;
}