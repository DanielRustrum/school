#ifndef __libllist_llist_h__
#define __libllist_llist_h__

#include <stdlib.h>

// ----- List and list node declarations ----------------------------------- //
struct ListNode;

typedef struct ListNode {
	struct ListNode *next;
	struct ListNode *prev;
	void *value;
} ListNode;

typedef struct List {
	int count;
	ListNode *first;
	ListNode *last;
} List;

// ----- Function prototypes ----------------------------------------------- //
/*
  Just initializes the List structure (the node pointers are NULL and
  the count = 0.
*/
List *list_create();

/*
  Just initializes a ListNode structure (the node pointers are NULL and
  the pointer to the data is set to payload.
*/
ListNode *list_create_node(void *payload);

/*
  Frees any nodes in the list and then frees the list structure.
*/
List *list_destroy(List *list);

/*
  Frees any nodes in the list but leaves the list structure.
*/
void list_clear(List *list);

/*
  Returns the count in the list structure.
*/
int list_count(List *list);

/*
  Returns the first node in the list.
*/
ListNode *list_first(List *list);

/*
  Returns the last node in the list.
*/
ListNode *list_last(List *list);

/*
  Finds a node in the list by value and returns the pointer to the node.
  If no matching node is found, returns NULL.
*/
ListNode *list_find(List *list, void *value);

/*
  Inserts a node in the list after the node containing value.  If no node
  has the passed value or if value == NULL, insert at the end of the list.
*/
void list_insert_after(List *list, ListNode *node, void *value);

/*
  Inserts a node in the list before the node containing value.  If no node has
  the passed value or if value == NULL, insert at the beginning of the list.
*/
void list_insert_before(List *list, ListNode *node, void *value);

/*
  Removes the specified node from the list and frees it.  The node's value
  is saved and returned.
*/
void *list_remove_node(List *list, ListNode *node);

/*
  Removes the node with the specified value from the list.  The node's value
  is saved and returned.  If a node with the value is not found in the list,
  return NULL
*/
void *list_remove_value(List *list, void *value);
#endif
