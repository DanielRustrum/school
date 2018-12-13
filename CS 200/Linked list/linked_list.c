#include <stdlib.h>
#include "linked_list.h"

// Just initializes the list structure (the node pointers are NULL and
// the count = 0).
List *list_create(void) {
    List *list = malloc(sizeof(List));
    list->count = 0;
    list->first = NULL;
    list->last = NULL;
    return list;
}

// Just initializes a ListNode structure (the node pointers are NULL and
// the pointer to the data is set to payload.
ListNode *list_create_node(void *payload) {
    ListNode *node = malloc(sizeof(ListNode));
    node->next = NULL;
    node->prev = NULL;
    node->value = payload;
    return node;
}

// Frees any nodes in the list and then frees the list structure.
List *list_destroy(List *list) {
    list_clear(list);
    free(list)
    return NULL;
}

// Frees any nodes in the list but leaves the list structure.
void list_clear(List *list) {
    list->count = 0;
}

// Returns the count in the list structure.
int list_count(List *list) {
    return list->count;
}

// Returns the first node in the list.
ListNode *list_first(List *list) {
    return list->first;
}

// Returns the last node in the list.
ListNode *list_last(List *list) {
    return list->last;
}

// Finds a node in the list by value and returns the pointer to the node.
// If no matching node is found, returns NULL.
ListNode *list_find(List* list, void* value) {
    ListNode *currentNode = list->first;
    while (currentNode != NULL)
    {
        if (currentNode->value == value)
        {
            return currentNode;
        }
        currentNode = currentNode->next;
    }
    return NULL;
}

// Inserts a node in the list after the node containing value.  If no node
// has the passed value or if value == NULL, insert at the end of the list.
void list_insert_after(List *list, ListNode *node, void *value) {
    ListNode *wantedList = list_find(list, value);
    list_create_node(wantedList);
    list->count++;
}

// Inserts a node in the list before the node containing value.  If no node
// has the passed value or if value == NULL, insert at the beginning of the
// list.
void list_insert_before(List *list, ListNode *node, void *value) {
    ListNode *wantedList = list_find(list, value-1);
    list_create_node(wantedList);
    list->count++;
}

// Removes the specified node from the list and frees it.  The node's value
// is saved and returned.
void *list_remove_node(List *list, ListNode* node) {
    node->prev->next = node->next;
    node->next->prev = node->prev;

    void *value = node->value;
    free(node);
    list->count--;
    return value;
}

// Removes the node with the specified value from the list.  The node's value
// is saved and returned.  If a node with the value is not found in the list,
// return NULL
void *list_remove_value(List* list, void* value) {
  ListNode *currentNode = list->first;
  int found = 0;
  for(int i; i<list->count;i++) {
    if(currentNode->value == value){
        found = 1;
        break;
    }
    else {
        currentNode = currentNode->next;
    }
  }
  if(found == 1){
    return currentNode->value = value;
  }
  else {
      return NULL;
  }
}
