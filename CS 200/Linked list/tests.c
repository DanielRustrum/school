#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "linked_list.h"

static List *list = NULL;
char *test_val1 = "test_val1 data";
char *test_val2 = "test_val2 data";
char *test_val3 = "test_val3 data";
char *invalidStr = "T";
ListNode* temp = NULL;

void do_test(bool test, char *success_msg, char *failure_msg) {
  if(test) {
    printf("%s\n", success_msg);
  } else {
    printf("%s\n", failure_msg);
    exit(EXIT_FAILURE);
  }
}

// The following test functions are all executed in main() in the order they are defined here

void test_create(void) {
  list = list_create();
  do_test(list != NULL,
	  "List creation succeeded",
	  "List creation failed; list_create() returned NULL");
  do_test(list->first == NULL,
	  "list->first set to NULL on creation (as it should be)",
	  "List creation failed; list->first was not NULL");
  do_test(list->last == NULL,
	  "list->last set to NULL on creation (as it should be)",
	  "List creation failed; list->last was not NULL");
}

void test_create_node(void) {
  temp = list_create_node(test_val1);
  do_test(temp != NULL,
	  "Node creation succeeded",
	  "Node creation failed; list_create_node() returned NULL");
  do_test(temp->value == test_val1,
	  "Node creation succeeded",
	  "Node creation failed; node->value not set to passed parameter");
}

void test_insert_after(void) {
  list_insert_after(list, list_create_node(test_val1),  invalidStr);
  do_test(list->first->value == test_val1,
	  "list->first set correctly after first call to list_insert_after()",
	  "list->first set incorrectly after first call to list_insert_after()");
  do_test(list->last->value == test_val1,
	  "list->last set correctly after first call to list_insert_after()",
	  "list->last set incorreclty after first call to list_insert_after()");
  do_test(list->count == 1,
	  "list->count set to 1 after first call to list_insert_after()",
	  "list->count set incorreclty after first call to list_insert_after()");
}

void test_insert_after2(void) {
  list_insert_after(list, list_create_node(test_val3),  NULL);
  do_test(list->first->value == test_val1,
	  "list->first set correctly after second call to list_insert_after()",
	  "list->first set incorrectly after second call to list_insert_after()");
  do_test(list->first->next->value == test_val3,
	  "list->first->next set correctly after second call to list_insert_after()",
	  "list->first->next set incorrectly after second call to list_insert_after()");
  do_test(list->last->value == test_val3,
	  "list->last->value set correctly after second call to list_insert_after()",
	  "list->last->value set incorrectly after second call to list_insert_after()");
  do_test(list->last->prev->value == test_val1,
	  "list->last->prev set correctly after second call to list_insert_after()",
	  "list->last->prev set incorrectly after second call to list_insert_after()");
  do_test(list->count == 2,
	  "list->count set correctly after second call to list_insert_after()",
	  "list->count set incorrectly after second call to list_insert_after()");
}

void test_insert_after3(void) {
  list_insert_after(list, list_create_node(test_val2),  test_val1);
  do_test(list->first->value == test_val1,
	  "list->first set correctly after third call to list_insert_after()",
	  "list->first set incorrectly after third call to list_insert_after()");
  do_test(list->first->next->value == test_val2,
	  "list->first->next set correctly after third call to list_insert_after()",
	  "list->first->next set incorrectly after third call to list_insert_after()");
  do_test(list->first->next->next->value == test_val3,
	  "list->first->next->next set correctly after third call to list_insert_after()",
	  "list->first->next->next set incorrectly after third call to list_insert_after()");
  do_test(list->first->next->prev->value == test_val1,
	  "list->first->next->prev set correctly after third call to list_insert_after()",
	  "list->first->next->prev set incorrectly after third call to list_insert_after()");
  do_test(list->last->value == test_val3,
	  "list->last set correctly after third call to list_insert_after()",
	  "list->last set incorrectly after third call to list_insert_after()");
  do_test(list->last->prev->value == test_val2,
	  "list->last->prev set correctly after third call to list_insert_after()",
	  "list->last->prev set incorrectly after third call to list_insert_after()");
  do_test(list->count == 3,
	  "list->count set correctly after third call to list_insert_after()",
	  "list->count set incorrectly after third call to list_insert_after()");
}

void test_getters(void) {
  do_test(list_count(list) == list->count,
	  "list_count() correctly returns list->count",
	  "list_count() does not return list->count");
  do_test(list_first(list) == list->first,
	  "list_first() correctly returns list->first",
	  "list_first() does not return list->first");
  do_test(list_last(list) == list->last,
	  "list_last() correctly returns list->last",
	  "list_last() does not return list->last");
  do_test(list_find(list, invalidStr) == NULL,
	  "list_find() returns NULL when called with a value not in the list",
	  "list_find() does not return NULL when called with a value not in the list");
  do_test(list_find(list, test_val2)->value == test_val2,
	  "list_find() returns the appropriate node when called with a value present in the list",
	  "list_find() does not correctly find the requested value's node");
}

void test_remove(void) {
  temp = list_find(list, test_val2);
  do_test(list_remove_node(list, temp) == test_val2,
	  "list_remove_node() returns the value of the deleted node",
	  "list_remove_node() does not return the value of the deleted node");
  do_test(list->first->next->value == test_val3,
	  "list->first->next set correctly after first call to list_remove_node()",
	  "list->first->next set incorrectly after first call to list_remove_node()");
  do_test(list->last->prev->value == test_val1,
	  "list->last->prev set correctly after first call to list_remove_node()",
	  "list->last->prev set incorrectly after first call to list_remove_node()");
  do_test(list->count == 2,
	  "list->count set correctly after first call to list_remove_node()",
	  "list->count set incorrectly after first call to list_remove_node()");
}

void test_remove2(void) {
  do_test(list_remove_value(list, test_val3) == test_val3,
	  "list_remove_node() returns the value of the deleted node (2nd call)",
	  "list_remove_node() does not return the value of the deleted node (2nd call)");
  do_test(list->first->next == NULL,
	  "list->first set correctly after second call to list_remove_node()",
	  "list->first set incorrectly after second call to list_remove_node()");
  do_test(list->last->value == test_val1,
	  "list->last set correctly after second call to list_remove_node()",
	  "list->last set incorrectly after second call to list_remove_node()");
  do_test(list->count == 1,
	  "list->count set correctly after second call to list_remove_node()",
	  "list->count set incorrectly after second call to list_remove_node()");
}

void test_remove3(void) {
  do_test(list_remove_value(list, test_val1) == test_val1,
	  "list_remove_node() returns the value of the deleted node (3rd call)",
	  "list_remove_node() does not return the value of the deleted node (3rd call)");
  do_test(list->first == NULL,
	  "list->first set correctly after third call to list_remove_node()",
	  "list->first set incorrectly after third call to list_remove_node()");
  do_test(list->last == NULL,
	  "list->last set correctly after third call to list_remove_node()",
	  "list->last set incorrectly after third call to list_remove_node()");
  do_test(list->count == 0,
	  "list->count set correctly after third call to list_remove_node()",
	  "list->count set incorrectly after third call to list_remove_node()");
}

void test_insert_before(void) {
  list_insert_before(list, list_create_node(test_val3),  invalidStr);
  do_test(list->first->value == test_val3,
	  "list->first set correctly after first call to list_insert_before()",
	  "list->first set incorrectly after first call to list_insert_before()");
  do_test(list->last->value == test_val3,
	  "list->last set correctly after first call to list_insert_before()",
	  "list->last set incorrectly after first call to list_insert_before()");
  do_test(list->count == 1,
	  "list->count set correctly after first call to list_insert_before()",
	  "list->count set incorrectly after first call to list_insert_before()");
}

void test_insert_before2(void) {
  list_insert_before(list, list_create_node(test_val1),  NULL);
  do_test(list->first->value == test_val1,
	  "list->first set correctly after second call to list_insert_before()",
	  "list->first set incorrectly after second call to list_insert_before()");
  do_test(list->first->next->value == test_val3,
	  "list->first->next set correctly after second call to list_insert_before()",
	  "list->first->next set incorrectly after second call to list_insert_before()");
  do_test(list->last->value == test_val3,
	  "list->last set correctly after second call to list_insert_before()",
	  "list->last set incorrectly after second call to list_insert_before()");
  do_test(list->last->prev->value == test_val1,
	  "list->last->prev set correctly after second call to list_insert_before()",
	  "list->last->prev set incorrectly after second call to list_insert_before()");
  do_test(list->count == 2,
	  "list->count set correctly after second call to list_insert_before()",
	  "list->count set incorrectly after second call to list_insert_before()");
}

void test_insert_before3(void) {
  list_insert_before(list, list_create_node(test_val2),  test_val3);
  do_test(list->first->value == test_val1,
	  "list->first set correctly after second call to list_insert_before()",
	  "list->first set incorrectly after second call to list_insert_before()");
  do_test(list->first->next->value == test_val2,
	  "list->first->next set correctly after second call to list_insert_before()",
	  "list->first->next set incorrectly after second call to list_insert_before()");
  do_test(list->first->next->next->value == test_val3,
	  "list->first->next->next set correctly after second call to list_insert_before()",
	  "list->first->next->next set incorrectly after second call to list_insert_before()");
  do_test(list->first->next->prev->value == test_val1,
	  "list->first->next->prev set correctly after second call to list_insert_before()",
	  "list->first->next->prev set incorrectly after second call to list_insert_before()");
  do_test(list->last->value == test_val3,
	  "list->last set correctly after second call to list_insert_before()",
	  "list->last set incorrectly after second call to list_insert_before()");
  do_test(list->last->prev->value == test_val2,
	  "list->last->prev set correctly after second call to list_insert_before()",
	  "list->last->prev set incorrectly after second call to list_insert_before()");
  do_test(list->count == 3,
	  "list->count set correctly after second call to list_insert_before()",
	  "list->count set incorrectly after second call to list_insert_before()");
}

void test_list_clear(void) {
  list_clear(list);
  do_test(list->first == NULL,
	  "list->first set to null after calling list_clear()",
	  "list->first not set to null after calling list_clear()");
  do_test(list->last == NULL,
	  "list->last set to null after calling list_clear()",
	  "list->last not set to null after calling list_clear()");
  do_test(list->count == 0,
	  "list->count set to zero after calling list_clear()",
	  "list->count not set to zero after calling list_clear()");
}

void test_list_destroy(void) {
  // Put things back in the list before destroying it.
  list_insert_before(list, list_create_node(test_val3),  NULL);
  list_insert_before(list, list_create_node(test_val2),  NULL);
  list_insert_before(list, list_create_node(test_val1),  NULL);

  list = list_destroy(list);
  do_test(list == NULL,
	  "list is null after calling list_destroy()",
	  "list is not null after calling list_destroy()");
}

int main(void)
{
  test_create();
  test_create_node();
  test_insert_after();
  test_insert_after2();
  test_insert_after3();
  test_getters();
  test_remove();
  test_remove2();
  test_remove3();
  test_insert_before();
  test_insert_before2();
  test_insert_before3();
  test_list_clear();
  test_list_destroy();
  printf("\nYay, your implementation passed all the tests!\n");

  return 0;
}
